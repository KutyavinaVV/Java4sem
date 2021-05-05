package ru.kpfu.itis.kutyavina.styleweb.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.kutyavina.styleweb.dao.AppointmentRepository;
import ru.kpfu.itis.kutyavina.styleweb.dto.AppointmentForm;
import ru.kpfu.itis.kutyavina.styleweb.models.Appointment;
import ru.kpfu.itis.kutyavina.styleweb.models.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    TimeService timeService;

    @Autowired
    UserService userService;

    @Override
    public List<String> checkTime(String date, String service) throws IllegalArgumentException {
        List<String> answerTime = new ArrayList<>();

        if (date != null) {
            if (service != null) {
                if (timeService.checkData(date)) {
                    ArrayList<String> timeList = AppointmentList.getTime();
                    List<String> timeB = getTimeList(appointmentRepository.findAllByDate(date));
                    System.out.println(timeB);
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
                        throw new IllegalArgumentException("Ошибка: На выбранный день все места заняты, попробуйте выбрать другую дату");
                } else throw new IllegalArgumentException("Ошибка: Пожалуйста, выберет корректную дату для записи");
            } else throw new IllegalArgumentException("Ошибка: Пожалуйста, выберет услугу");

        }
        return answerTime;
    }

    @Override
    public void addAppointment(AppointmentForm appointmentForm, Long userId) {
        User user = userService.findUser(userId);
        System.out.println(appointmentForm);
        appointmentRepository.save(
                Appointment.builder().client(user)
                .name(appointmentForm.getName())
                .date(appointmentForm.getDate())
                .time(appointmentForm.getTime()).build()
        );
    }

    @Override
    public void removeAppointment(String data, String time) {

    }

    @Override
    public List<Appointment> getAllByUserId(Long userId) {
        return appointmentRepository.findAllByClient(userService.findUser(userId));
    }

    @Override
    @Transactional
    public void removeUnNeeded(Long userId) {
        List<Appointment> appointments = getAllByUserId(userId);
        for (Appointment a: appointments) {
            if (!timeService.checkData(a.getDate())) {
                appointmentRepository.deleteByDateAndTime(a.getDate(), a.getTime());
            }
        }
    }

    private static List<String> getTimeList(List<Appointment> appointments)  {
        List<String> timeList  = AppointmentList.getTime();
        List<String> answerList = new ArrayList<>();
        for (Appointment appointment: appointments) {

            String time = appointment.getTime();
            String name = appointment.getName();

            switch (name) {
                case "cons30":
                case  "cons60":
                    answerList.add(time);
                    break;
                case "analysis":
                    answerList.add(time);
                    answerList.add(timeList.get(timeList.indexOf(time) + 2));
                    answerList.add(timeList.get(timeList.indexOf(time) + 1));
                    break;
                case "newG":
                    answerList = timeList;
                    break;

            }
        }
        return answerList;
    }

}
