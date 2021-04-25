package ru.kpfu.itis.kutyavina.styleweb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.kutyavina.styleweb.models.Capsule;

public interface CapsuleRepository extends JpaRepository<Capsule, Long> {
}
