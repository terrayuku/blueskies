package skies.blue.liberty.com.blueskies.models;

/**
 * Created by simthembile on 2017/09/30.
 */

public class UserRegistration {

    private String email = "";
    private String password = "";
    private String confirmPassword = "";

    public UserRegistration() {
    }

    public UserRegistration(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRegistration that = (UserRegistration) o;

        if (!getEmail().equals(that.getEmail())) return false;
        if (!getPassword().equals(that.getPassword())) return false;
        return getConfirmPassword().equals(that.getConfirmPassword());

    }

    @Override
    public int hashCode() {
        int result = getEmail().hashCode();
        result = 31 * result + getPassword().hashCode();
        result = 31 * result + getConfirmPassword().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "UserRegistration{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
