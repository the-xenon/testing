package xenon.webdriver.proto.riv;

import java.util.Date;

/**
 * Created by xenon on 29.11.2015.
 */
public class RivUser {
    private String login;
    private String nickname;
    private String password;
    private String email;
    private Date birthday;

    public RivUser(String login, String nickname, String password) {
        this.login = login;
        this.nickname = nickname;
        this.password = password;
    }

    public RivUser(String login, String nickname, String password, String email, Date birthday) {
        this.login = login;
        this.nickname = nickname;
        this.password = password;
        this.email = email;
        this.birthday = birthday;
    }

    public String getLogin() {
        return login;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public Date getBirthday() {
        return birthday;
    }
}
