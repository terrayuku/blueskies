package skies.blue.liberty.com.blueskies.models;

/**
 * Created by simthembile on 2017/09/30.
 */

public class DesignYourBestLifeModel {

    private String home;
    private String health;
    private String finance;
    private String email;

    public DesignYourBestLifeModel() {
    }

    public DesignYourBestLifeModel(String home, String health, String finance, String email) {
        this.home = home;
        this.health = health;
        this.finance = finance;
        this.email = email;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getFinance() {
        return finance;
    }

    public void setFinance(String finance) {
        this.finance = finance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DesignYourBestLifeModel that = (DesignYourBestLifeModel) o;

        if (getHome() != null ? !getHome().equals(that.getHome()) : that.getHome() != null)
            return false;
        if (getHealth() != null ? !getHealth().equals(that.getHealth()) : that.getHealth() != null)
            return false;
        return getFinance() != null ? getFinance().equals(that.getFinance()) : that.getFinance() == null;

    }

    @Override
    public int hashCode() {
        int result = getHome() != null ? getHome().hashCode() : 0;
        result = 31 * result + (getHealth() != null ? getHealth().hashCode() : 0);
        result = 31 * result + (getFinance() != null ? getFinance().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DesignYourBestLifeModel{" +
                "home='" + home + '\'' +
                ", health='" + health + '\'' +
                ", finance='" + finance + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
