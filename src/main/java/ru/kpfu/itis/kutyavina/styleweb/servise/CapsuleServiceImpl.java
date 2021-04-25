package ru.kpfu.itis.kutyavina.styleweb.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.kutyavina.styleweb.dao.CapsuleRepository;
import ru.kpfu.itis.kutyavina.styleweb.dao.UsersRepository;
import ru.kpfu.itis.kutyavina.styleweb.dto.CapsuleForm;
import ru.kpfu.itis.kutyavina.styleweb.models.Capsule;
import ru.kpfu.itis.kutyavina.styleweb.models.User;

@Service
public class CapsuleServiceImpl implements CapsuleService {

    @Autowired
    CapsuleRepository capsuleRepository;

    @Autowired
    UsersRepository usersRepository;

    @Override
    public Capsule createCapsule(CapsuleForm capsuleForm, Long userId) {
        User user = usersRepository.findById(userId).orElseThrow(IllegalAccessError::new);
        Capsule capsule = Capsule.builder().name(capsuleForm.getName()).owner(user).build();
        return capsuleRepository.save(capsule);
    }

    @Override
    public Capsule removeCapsule(Long id) {
        return null;
    }
}
