package io.khasang.genelove.model;

//import javax.persistence.*;
import java.io.Serializable;

public class UserWrapper implements Serializable{

    public UserWrapper() {
    }
    /*    public enum AccountStatus {
        NEW, ACTIVE, SUSPENDED
    }
    public enum InspectionStatus {
        NEW, NEGATIVE, POSITIVE
    }*/

    private long id;

    private String login;

//    private String password;

    private String firstName;

    private String lastName;

    private String email;

    private String inspectionStatus;

//    private boolean receiveNotifications = false;

    private String accountStatus;

//    private List<Role> roles = new ArrayList<>();

    /*public UserWrapper() {
        this.accountStatus = AccountStatus.NEW;
        this.inspectionStatus = InspectionStatus.NEW;
    }*/

    /*public static Map<AccountStatus, String> getAccountStatusList() {
        Map<AccountStatus, String> accountStatusList = new HashMap<>();
        for (AccountStatus status : AccountStatus.values()) {
            accountStatusList.put(status, status.toString());
        }
        return accountStatusList;
    }*/

    @Override
    public String toString() {
        return "Order [id=" + id + ", login=" + login + ", firstName=" + firstName + ", lastName="
                + lastName + ", email=" + email + ", inspectionStatus=" + inspectionStatus + ", accountStatus=" + accountStatus + "]";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

/*    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }*/

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

/*    public boolean isReceiveNotifications() {
        return receiveNotifications;
    }
    public void setReceiveNotifications(boolean receiveNotifications) {
        this.receiveNotifications = receiveNotifications;
    }*/

    public String getInspectionStatus() {
        return inspectionStatus;
    }

    public void setInspectionStatus(String inspectionStatus) {
        this.inspectionStatus = inspectionStatus;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }
}