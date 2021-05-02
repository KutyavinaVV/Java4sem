package ru.kpfu.itis.kutyavina.styleweb.servise;

import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

@Service
public class TimeServiceImpl implements TimeService{

    @Override
    public String getTodayDay() {
        Date today = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(today);
    }

    @Override
    public String getMaxDate() {
        Date today = new Date();
        String format = "yyyy-MM-dd" ;
        SimpleDateFormat sdf = new SimpleDateFormat(format) ;
        String dateS = sdf.format(today);
        Date dateAsObj = null;
        try {
            dateAsObj = sdf.parse(dateS);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateAsObj);
        cal.add(Calendar.MONTH, 2);
        Date dateAsObjAfterAMonth = cal.getTime() ;
        return sdf.format(dateAsObjAfterAMonth) ;
    }

    @Override
    public boolean checkData(String date) {
        Date dateNow = new Date();
        Date d = null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        String dateInString = date;
        try {
            d = formatter.parse(dateInString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateNow.compareTo(d) < 0;
    }
}
