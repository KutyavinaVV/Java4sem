package ru.kpfu.itis.kutyavina.styleweb.models;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.kutyavina.styleweb.servise.AppointmentList;

import javax.persistence.*;

@Entity
@Table(name="appointment")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String date;
    private String time;
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User client;


    public String getFullName() {
        AppointmentList al = new AppointmentList();
        return al.get(name);
    }

}

