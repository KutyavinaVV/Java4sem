package ru.kpfu.itis.kutyavina.styleweb.servise;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeServiceImpl implements TimeService{
    @Override
    public String getTodayDay() {
        Date today = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(today);
    }

    @Override
    public String getMaxDate() throws ParseException {
        Date today = new Date();
        String format = "yyyy-MM-dd" ;
        SimpleDateFormat sdf = new SimpleDateFormat(format) ;
        String dateS = sdf.format(today);
        Date dateAsObj = sdf.parse(dateS);
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateAsObj);
        cal.add(Calendar.MONTH, 2);
        Date dateAsObjAfterAMonth = cal.getTime() ;
        return sdf.format(dateAsObjAfterAMonth) ;
    }
}
