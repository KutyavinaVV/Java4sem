package ru.kpfu.itis.kutyavina.styleweb.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.kutyavina.styleweb.dao.AppointmentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    TimeService timeService;

    @Override
    public List<String> checkTime(String date, String service) throws IllegalArgumentException {
        List<String> answerTime = new ArrayList<>();

        if (date != null) {
            if (service != null) {
                if (timeService.checkData(date)) {
                    ArrayList<String> timeList = AppointmentList.getTime();
                    List<String> timeB = appointmentRepository.findAllByDate(date);
                    for (String time : timeB) {
                        timeList.set(timeList.indexOf(time), null);
                    }

                    if ((service.equals("cons30")) || (service.equals("cons60"))) {
                        for (String time : timeList) {
                            if (time != null) {
                                answerTime.add(time);
                            }
                        }
                    }

                    if (service.equals("analysis")) {
                        for (String time : timeList) {
                            int k = timeList.indexOf(time);
                            if ((time != null)) {
                                if ((k + 1 < timeList.size()) && (timeList.get(timeList.indexOf(time) + 1) != null)) {
                                    if ((k + 2 < timeList.size()) && (timeList.get(timeList.indexOf(time) + 2) != null)) {
                                        answerTime.add(time);
                                    }
                                }
                            }
                        }
                    }

                    if (service.equals("newG")) {
                        if (!timeList.contains(null)) answerTime.add("9:00");
                    }
                    if (answerTime.size() == 0)
                        throw new IllegalArgumentException("На выбранный день все места заняты, попробуйте выбрать другую дату");
                } else throw new IllegalArgumentException("Пожалуйста, выберет корректную дату для записи");
            } else throw new IllegalArgumentException("Пожалуйста, выберет услугу");

        }
        return answerTime;
    }

}
