package ru.kpfu.itis.kutyavina.styleweb.servise;

import java.text.ParseException;

public interface TimeService {

    String getTodayDay ();
    String getMaxDate();
    boolean checkData (String date);

}
