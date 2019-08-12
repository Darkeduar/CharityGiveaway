package pl.coderslab.charity.user;

public class UserDto {

    private String email;
    private String password;

    public UserDto() {
    }

    public UserDto(User that) {
        this.email = that.getEmail();
        this.password = that.getPassword();

    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
