package ru.kpfu.itis.kutyavina.styleweb.servise;

import ru.kpfu.itis.kutyavina.styleweb.dto.CapsuleDto;
import ru.kpfu.itis.kutyavina.styleweb.dto.CapsuleForm;
import ru.kpfu.itis.kutyavina.styleweb.models.Capsule;

import java.util.List;

public interface CapsuleService {

    Capsule createCapsule(CapsuleForm capsuleForm, Long userId);
    void removeCapsule(Long id, String say);
    void delete(Long id);
    Capsule updateName(String name, Long id);
    List<Capsule> getCapsules(Long id);
    Capsule updateCapsule(CapsuleDto capsule);
    Capsule createCapsule(CapsuleDto capsuleDto);
    Capsule getCapsule(Long capsuleId);
}
