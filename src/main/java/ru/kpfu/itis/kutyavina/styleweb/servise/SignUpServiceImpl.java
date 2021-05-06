package ru.kpfu.itis.kutyavina.styleweb.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.kutyavina.styleweb.dao.UsersRepository;
import ru.kpfu.itis.kutyavina.styleweb.dto.UserForm;
import ru.kpfu.itis.kutyavina.styleweb.models.User;

import java.util.regex.Pattern;

@Service
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private UsersRepository ur;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    APIService apiService;

    @Override
    public void SignUp(UserForm userForm) {
        System.out.println(userForm);
        User user = User.builder()
                .email(userForm.getEmail())
                .password(passwordEncoder.encode(userForm.getPassword()))
                .name(userForm.getName()).build();
        ur.save(user);
    }

    @Override
    public void CheckData(UserForm userForm) throws IllegalArgumentException {
        throwNewException(checkEmail(userForm.getEmail()), "Please, enter correct email");
        throwNewException(checkPassword(userForm.getPassword(), userForm.getPasswordr()), "Please, enter equals passwords");
        throwNewException(checkName(userForm.getName()), "Please, enter correct name");
    }

    private boolean checkEmail(String email){
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        if(pattern.matcher(email).matches()) {
            return apiService.checkEmail(email);
        }
        return pattern.matcher(email).matches();
    }

    private boolean checkPassword (String password, String password_repeat) {
        return password.equals(password_repeat);
    }

    private boolean checkName (String name) {
        return !(name.isEmpty());
    }

    private void throwNewException(Boolean is, String message) throws IllegalArgumentException {
        if(!is) throw new IllegalArgumentException(message);
    }

    public boolean checkPhone(String phone) {
        return apiService.checkPhone(phone);
    }

}
