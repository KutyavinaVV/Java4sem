package ru.kpfu.itis.kutyavina.styleweb.servise;

import ru.kpfu.itis.kutyavina.styleweb.dto.UserForm;

public interface SignUpService {

    void SignUp(UserForm userForm);
    void CheckData(UserForm userForm) throws IllegalArgumentException;

}
