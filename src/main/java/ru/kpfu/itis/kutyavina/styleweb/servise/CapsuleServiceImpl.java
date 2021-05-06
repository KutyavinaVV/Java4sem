package ru.kpfu.itis.kutyavina.styleweb.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.kutyavina.styleweb.dao.CapsuleRepository;
import ru.kpfu.itis.kutyavina.styleweb.dao.UsersRepository;
import ru.kpfu.itis.kutyavina.styleweb.dto.CapsuleForm;
import ru.kpfu.itis.kutyavina.styleweb.models.Capsule;
import ru.kpfu.itis.kutyavina.styleweb.models.User;

import java.util.List;

@Service
public class CapsuleServiceImpl implements CapsuleService {

    @Autowired
    CapsuleRepository capsuleRepository;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    UserService userService;

    @Override
    public Capsule createCapsule(CapsuleForm capsuleForm, Long userId) {
        User user = usersRepository.findById(userId).orElseThrow(IllegalAccessError::new);
        Capsule capsule = Capsule.builder().name(capsuleForm.getName()).owner(user).build();
        return capsuleRepository.save(capsule);
    }

    @Override
    public void removeCapsule(Long id, String say) {
        if(!say.toLowerCase().equals("yes")) return;
        Capsule capsule = capsuleRepository.findById(id).orElseThrow(IllegalAccessError::new);
        capsuleRepository.delete(capsule);
    }

    @Override
    public Capsule updateName(String name, Long id) {
        Capsule capsule = capsuleRepository.findById(id).orElseThrow(IllegalAccessError::new);
        capsule.setName(name);
        capsuleRepository.save(capsule);
        return capsule;
    }

    @Override
    public List<Capsule> getCapsules(Long id) {
        return capsuleRepository.findCapsulesByOwner(userService.findUser(id));
    }
}
