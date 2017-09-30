package skies.blue.liberty.com.blueskies.models;

/**
 * Created by simthembile on 2017/09/30.
 */

public class ProfileModel {
    private String fullName;
    private String age;
    private String proffesion;
    private String annualIncome;
    private String email;
    private boolean car;
    private boolean owningHouse;
    private boolean permanent;

    public ProfileModel() {
    }

    public ProfileModel(String fullName, String age, String proffesion, String annualIncome, String email) {
        this.fullName = fullName;
        this.age = age;
        this.proffesion = proffesion;
        this.annualIncome = annualIncome;
        this.email = email;
    }

    public ProfileModel(String fullName, String age, String proffesion, String annualIncome, String email, boolean car, boolean owningHouse, boolean permanent) {
        this.fullName = fullName;
        this.age = age;
        this.proffesion = proffesion;
        this.annualIncome = annualIncome;
        this.email = email;
        this.car = car;
        this.owningHouse = owningHouse;
        this.permanent = permanent;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getProffesion() {
        return proffesion;
    }

    public void setProffesion(String proffesion) {
        this.proffesion = proffesion;
    }

    public String getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(String annualIncome) {
        this.annualIncome = annualIncome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getCar() {
        return car;
    }

    public void setCar(boolean car) {
        this.car = car;
    }

    public boolean getOwningHouse() {
        return owningHouse;
    }

    public void setOwningHouse(boolean owningHouse) {
        this.owningHouse = owningHouse;
    }

    public boolean getPermanent() {
        return permanent;
    }

    public void setPermanent(boolean permanent) {
        this.permanent = permanent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProfileModel profile = (ProfileModel) o;

        if (!getFullName().equals(profile.getFullName())) return false;
        if (getAge() != null ? !getAge().equals(profile.getAge()) : profile.getAge() != null)
            return false;
        if (getProffesion() != null ? !getProffesion().equals(profile.getProffesion()) : profile.getProffesion() != null)
            return false;
        return getAnnualIncome() != null ? getAnnualIncome().equals(profile.getAnnualIncome()) : profile.getAnnualIncome() == null;

    }

    @Override
    public int hashCode() {
        int result = getFullName().hashCode();
        result = 31 * result + (getAge() != null ? getAge().hashCode() : 0);
        result = 31 * result + (getProffesion() != null ? getProffesion().hashCode() : 0);
        result = 31 * result + (getAnnualIncome() != null ? getAnnualIncome().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ProfileModel{" +
                "fullName='" + fullName + '\'' +
                ", age='" + age + '\'' +
                ", proffesion='" + proffesion + '\'' +
                ", annualIncome='" + annualIncome + '\'' +
                ", email='" + email + '\'' +
                ", car='" + car + '\'' +
                ", owningHouse='" + owningHouse + '\'' +
                ", permanent='" + permanent + '\'' +
                '}';
    }
}
