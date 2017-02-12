package io.khasang.genelove.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/** Class that is used by Hibernate to create table "users" in the Database.
 * Table is used to store list of users and technical information about theirs accounts.
 *
 * Класс, используя который, Hibernate создаёт таблицу в Базе данных.
 * В таблице хранится список пользователей, а также техническая информация об их аккаунте.*/

@Entity(name = "users")
public class User implements Serializable{
    public enum AccountStatus {
        NEW, ACTIVE, SUSPENDED
    }

    public enum InspectionStatus {
        NEW, NEGATIVE, POSITIVE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(length = 255, unique = true)
    private String login;

    @Column(length = 255)
    private String password;

    @Column(name = "first_name", length = 255)
    private String firstName;

    @Column(name = "last_name", length = 255)
    private String lastName;

    @Column(length = 255)
    private String email;

    @Column
    @Enumerated(EnumType.STRING)
    private InspectionStatus inspectionStatus;

    @Column(name = "receive_notifications")
    private boolean receiveNotifications = false;

    @Column(name = "account_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "authorisations", joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "role_id") })
    private List<Role> roles = new ArrayList<>();

    public User() {
        this.accountStatus = AccountStatus.NEW;
        this.inspectionStatus = InspectionStatus.NEW;
    }

    public User(String login, String password, String firstName, String lastName,
                String email, InspectionStatus inspectionStatus, boolean receiveNotifications,
                AccountStatus accountStatus, List<Role> roles) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.inspectionStatus = inspectionStatus;
        this.receiveNotifications = receiveNotifications;
        this.accountStatus = accountStatus;
        this.roles = roles;
    }

    public User(User user) {
        this.login = user.login;
        this.password = user.password;
        this.firstName = user.firstName;
        this.lastName = user.lastName;
        this.email = user.email;
        this.inspectionStatus = user.inspectionStatus;
        this.receiveNotifications = user.receiveNotifications;
        this.accountStatus = user.accountStatus;
        this.roles = user.roles;
    }

    public void setUser(User user) {
        this.login = user.login;
        this.password = user.password;
        this.firstName = user.firstName;
        this.lastName = user.lastName;
        this.email = user.email;
        this.inspectionStatus = user.inspectionStatus;
        this.receiveNotifications = user.receiveNotifications;
        this.accountStatus = user.accountStatus;
        this.roles = user.roles;
    }

    public static Map<AccountStatus, String> getAccountStatusList() {
        Map<AccountStatus, String> accountStatusList = new HashMap<>();
        for (AccountStatus status : AccountStatus.values()) {
            accountStatusList.put(status, status.toString());
        }
        return accountStatusList;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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

    public InspectionStatus getInspectionStatus() {
        return inspectionStatus;
    }

    public void setInspectionStatus(InspectionStatus inspection) {
        this.inspectionStatus = inspection;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public boolean isReceiveNotifications() {
        return receiveNotifications;
    }

    public void setReceiveNotifications(boolean receiveNotifications) {
        this.receiveNotifications = receiveNotifications;
    }

}