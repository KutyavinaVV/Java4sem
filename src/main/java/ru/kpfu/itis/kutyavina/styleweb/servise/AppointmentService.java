package ru.kpfu.itis.kutyavina.styleweb.servise;

import java.util.List;

public interface AppointmentService {

    List<String> checkTime(String data, String service) throws IllegalArgumentException;
}
