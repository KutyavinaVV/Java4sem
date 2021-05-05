package ru.kpfu.itis.kutyavina.styleweb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.kutyavina.styleweb.models.Appointment;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findAllByDate(String date);
}
