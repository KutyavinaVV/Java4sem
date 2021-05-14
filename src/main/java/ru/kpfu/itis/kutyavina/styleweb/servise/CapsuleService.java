package ru.kpfu.itis.kutyavina.styleweb.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.kutyavina.styleweb.dao.CapsuleRepository;
import ru.kpfu.itis.kutyavina.styleweb.dao.ProductRepository;
import ru.kpfu.itis.kutyavina.styleweb.dao.UsersRepository;
import ru.kpfu.itis.kutyavina.styleweb.dto.CapsuleDto;
import ru.kpfu.itis.kutyavina.styleweb.dto.CapsuleForm;
import ru.kpfu.itis.kutyavina.styleweb.models.Capsule;
import ru.kpfu.itis.kutyavina.styleweb.models.User;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CapsuleService {

    @Autowired
    CapsuleRepository capsuleRepository;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    UserService userService;

    @Autowired
    ProductRepository productRepository;

    public Capsule createCapsule(CapsuleForm capsuleForm, Long userId) {
        User user = usersRepository.findById(userId).orElseThrow(IllegalAccessError::new);
        Capsule capsule = Capsule.builder().name(capsuleForm.getName()).owner(user).build();
        return capsuleRepository.save(capsule);
    }

    public void removeCapsule(Long id, String say) {
        if(!say.toLowerCase().equals("yes")) return;
        Capsule capsule = capsuleRepository.findById(id).orElseThrow(IllegalAccessError::new);
        capsuleRepository.delete(capsule);
    }

    public void delete(Long id) {
        removeCapsule(id, "yes");
    }

    public Capsule updateName(String name, Long id) {
        Capsule capsule = capsuleRepository.findById(id).orElseThrow(IllegalAccessError::new);
        capsule.setName(name);
        capsuleRepository.save(capsule);
        return capsule;
    }

    public List<Capsule> getCapsules(Long id) {
        return capsuleRepository.findCapsulesByOwner(userService.findUser(id));
    }

    public Capsule updateCapsule(CapsuleDto capsuleDto) {
        Capsule c = capsuleRepository.findById(capsuleDto.getId()).orElseThrow(IllegalArgumentException::new);
        c.setName(capsuleDto.getName());
        c.setOwner(userService.findUser(capsuleDto.getOwner().getId()));
        capsuleRepository.save(c);
        return c;
    }

    public Capsule createCapsule(CapsuleDto capsuleDto) {
        Capsule capsule = Capsule.builder()
                .name(capsuleDto.getName())
                .owner(userService.findUser(capsuleDto.getOwner().getId()))
                .productList(capsuleDto.getProductList().stream().map(product -> productRepository.findByName(product)).collect(Collectors.toList())).build();
        capsuleRepository.save(capsule);
        return capsule;
    }

    public Capsule getCapsule(Long capsuleId) {
        return capsuleRepository.findById(capsuleId).orElseThrow(IllegalArgumentException::new);
    }
}
