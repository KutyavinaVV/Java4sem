package ru.kpfu.itis.kutyavina.styleweb.servise;

import java.util.ArrayList;
import java.util.HashMap;

public class AppointmentList {
    private HashMap <String, String> list = new HashMap<>();

    public AppointmentList() {
        list.put("cons30","Консультация (30 минут)");
        list.put("cons60", "Консультация (1 час)");
        list.put("analysis","Разбор гардероба (3 часа)");
        list.put("newG","Подбор нового гардероба (целый день)");
    }

    public String get(String  c) {
        return list.get(c);
    }

    public static ArrayList<String> getTime () {
        ArrayList<String> timeList = new ArrayList<>();
        timeList.add("9:00");
        timeList.add("10:00");
        timeList.add("11:00");
        timeList.add("12:00");
        timeList.add("13:00");
        timeList.add("14:00");
        timeList.add("15:00");
        timeList.add("16:00");
        timeList.add("17:00");
        timeList.add("18:00");
        return timeList;
    }

//    public String getAllName() {
//        AppointmentList al = new AppointmentList();
//        return al.get(name);
//    }
}
