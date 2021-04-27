package ru.kpfu.itis.kutyavina.styleweb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.kutyavina.styleweb.models.Capsule;
import ru.kpfu.itis.kutyavina.styleweb.models.User;

import java.util.List;

public interface CapsuleRepository extends JpaRepository<Capsule, Long> {

    List<Capsule> findCapsulesByOwner(User use);
}
