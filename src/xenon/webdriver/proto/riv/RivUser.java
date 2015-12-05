package xenon.webdriver.proto.riv;

/**
 * Created by xenon on 29.11.2015.
 */
public class RivUser {
    private String login;
    private String nickname;
    private String password;

    public RivUser(String login, String nickname, String password) {
        this.login = login;
        this.nickname = nickname;
        this.password = password;
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
}
