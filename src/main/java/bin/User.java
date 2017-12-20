package bin;

public class User {

    private int userid;
    private String login;
    private String password;

    public User(){

    }

    public User(String login, String password){
        this.login = login;
        this.password = password;
    }

    public int getUserid() {return userid;}

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "userid=" + userid +
                ", login='" + login + '\'' +
                ", password='" + password + '\'';
    }
}
