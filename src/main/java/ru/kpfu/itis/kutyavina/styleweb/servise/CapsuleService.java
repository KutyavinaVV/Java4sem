package ru.kpfu.itis.kutyavina.styleweb.servise;

import ru.kpfu.itis.kutyavina.styleweb.dto.CapsuleForm;
import ru.kpfu.itis.kutyavina.styleweb.models.Capsule;

public interface CapsuleService {

    Capsule createCapsule(CapsuleForm capsuleForm, Long userId);
    Capsule removeCapsule(Long id);
}
