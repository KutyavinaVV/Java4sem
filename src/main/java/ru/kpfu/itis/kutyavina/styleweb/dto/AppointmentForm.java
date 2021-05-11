package ru.kpfu.itis.kutyavina.styleweb.dto;

import lombok.Data;

@Data
public class AppointmentForm {

    private String date;
    private String time;
    private String name;
    private String phone;
}

