package ru.kpfu.itis.kutyavina.styleweb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.kutyavina.styleweb.models.Appointment;
import ru.kpfu.itis.kutyavina.styleweb.models.User;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findAllByDate(String date);
    List<Appointment> findAllByClient(User clien);
    void deleteByDateAndTime(String data, String time);
}
