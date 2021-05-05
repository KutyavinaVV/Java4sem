package ru.kpfu.itis.kutyavina.styleweb.servise;

import ru.kpfu.itis.kutyavina.styleweb.dto.AppointmentForm;
import ru.kpfu.itis.kutyavina.styleweb.models.Appointment;

import java.util.List;

public interface AppointmentService {

    List<String> checkTime(String data, String service) throws IllegalArgumentException;
    void addAppointment(AppointmentForm appointmentForm, Long userId);
    void removeAppointment(String data, String time);
    List<Appointment> getAllByUserId(Long userId);
    void removeUnNeeded(Long userId);
}
