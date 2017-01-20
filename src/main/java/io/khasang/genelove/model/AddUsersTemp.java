package io.khasang.genelove.model;

import io.khasang.genelove.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;

import static io.khasang.genelove.entity.User.AccountStatus.NEW;

public class AddUsersTemp {
    private JdbcTemplate jdbcTemplate;

    public AddUsersTemp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public AddUsersTemp() {
    }

    public String addUsersIntoDB () {
        ArrayList<String> sql = new ArrayList<>();
        int index = 8;

        String user1 = "INSERT INTO users (id, login, name, password, role_id, " +
                "account_status, email, first_name, last_name, gender) VALUES (" +
                index + ", 'robby', 'rob', " +
                "'$2a$10$lF8zJ8UTZV4tqL/Mtp//ZuoRns4KeIYL/fcAPaddQTpW2HgiAjUpS',\n" +
                "3, 'NEW', 'python239@mail.ru', 'Robert', 'Stivenson', 'male');";
        index++;
        String user2 = "INSERT INTO users (id, login, name, password, role_id, " +
                "account_status, email, first_name, last_name, gender) VALUES (" +
                index + ", 'linda', 'lin', " +
                "'$2a$10$lF8zJ8UTZV4tqL/Mtp//ZuoRns4KeIYL/fcAPaddQTpW2HgiAjUpS',\n" +
                "3, 'NEW', 'python239@mail.ru', 'Linda', 'Sikorsky', 'female');";
        index++;
        String user3 = "INSERT INTO users (id, login, name, password, role_id, " +
                "account_status, email, first_name, last_name, gender) VALUES (" +
                index + ", 'oskar', 'oskar', " +
                "'$2a$10$lF8zJ8UTZV4tqL/Mtp//ZuoRns4KeIYL/fcAPaddQTpW2HgiAjUpS',\n" +
                "3, 'NEW', 'python239@mail.ru', 'Oskar', 'Li', 'male');";
        index++;
        String user4 = "INSERT INTO users (id, login, name, password, role_id, " +
                "account_status, email, first_name, last_name, gender) VALUES (" +
                index + ", 'john', 'jonny', " +
                "'$2a$10$lF8zJ8UTZV4tqL/Mtp//ZuoRns4KeIYL/fcAPaddQTpW2HgiAjUpS',\n" +
                "3, 'NEW', 'python239@mail.ru', 'John', 'White', 'male');";
        index++;
        String user5 = "INSERT INTO users (id, login, name, password, role_id, " +
                "account_status, email, first_name, last_name, gender) VALUES (" +
                index + ", 'linda', 'lin', " +
                "'$2a$10$lF8zJ8UTZV4tqL/Mtp//ZuoRns4KeIYL/fcAPaddQTpW2HgiAjUpS',\n" +
                "3, 'NEW', 'python239@mail.ru', 'Linda', 'Sikorsky', 'male');";
        index++;
        String user6 = "INSERT INTO users (id, login, name, password, role_id, " +
                "account_status, email, first_name, last_name, gender) VALUES (" +
                index + ", 'linda', 'lin', " +
                "'$2a$10$lF8zJ8UTZV4tqL/Mtp//ZuoRns4KeIYL/fcAPaddQTpW2HgiAjUpS',\n" +
                "3, 'NEW', 'python239@mail.ru', 'Linda', 'Sikorsky', 'female');";
        index++;
        String user7 = "INSERT INTO users (id, login, name, password, role_id, " +
                "account_status, email, first_name, last_name, gender) VALUES (" +
                index + ", 'linda', 'lin', " +
                "'$2a$10$lF8zJ8UTZV4tqL/Mtp//ZuoRns4KeIYL/fcAPaddQTpW2HgiAjUpS',\n" +
                "3, 'NEW', 'python239@mail.ru', 'Linda', 'Sikorsky', 'male');";
        index++;
        String user8 = "INSERT INTO users (id, login, name, password, role_id, " +
                "account_status, email, first_name, last_name, gender) VALUES (" +
                index + ", 'linda', 'lin', " +
                "'$2a$10$lF8zJ8UTZV4tqL/Mtp//ZuoRns4KeIYL/fcAPaddQTpW2HgiAjUpS',\n" +
                "3, 'NEW', 'python239@mail.ru', 'Linda', 'Sikorsky', 'female');";
        index++;
        String user9 = "INSERT INTO users (id, login, name, password, role_id, " +
                "account_status, email, first_name, last_name, gender) VALUES (" +
                index + ", 'linda', 'lin', " +
                "'$2a$10$lF8zJ8UTZV4tqL/Mtp//ZuoRns4KeIYL/fcAPaddQTpW2HgiAjUpS',\n" +
                "3, 'NEW', 'python239@mail.ru', 'Linda', 'Sikorsky', 'male');";
        index++;
        String user10 = "INSERT INTO users (id, login, name, password, role_id, " +
                "account_status, email, first_name, last_name, gender) VALUES (" +
                index + ", 'linda', 'lin', " +
                "'$2a$10$lF8zJ8UTZV4tqL/Mtp//ZuoRns4KeIYL/fcAPaddQTpW2HgiAjUpS',\n" +
                "3, 'NEW', 'python239@mail.ru', 'Linda', 'Sikorsky', 'male');";
        index++;
        String user11 = "INSERT INTO users (id, login, name, password, role_id, " +
                "account_status, email, first_name, last_name, gender) VALUES (" +
                index + ", 'linda', 'lin', " +
                "'$2a$10$lF8zJ8UTZV4tqL/Mtp//ZuoRns4KeIYL/fcAPaddQTpW2HgiAjUpS',\n" +
                "3, 'NEW', 'python239@mail.ru', 'Linda', 'Sikorsky', 'female');";
        index++;
        String user12 = "INSERT INTO users (id, login, name, password, role_id, " +
                "account_status, email, first_name, last_name, gender) VALUES (" +
                index + ", 'linda', 'lin', " +
                "'$2a$10$lF8zJ8UTZV4tqL/Mtp//ZuoRns4KeIYL/fcAPaddQTpW2HgiAjUpS',\n" +
                "3, 'NEW', 'python239@mail.ru', 'Linda', 'Sikorsky', 'male');";
        index++;
        String user13 = "INSERT INTO users (id, login, name, password, role_id, " +
                "account_status, email, first_name, last_name, gender) VALUES (" +
                index + ", 'linda', 'lin', " +
                "'$2a$10$lF8zJ8UTZV4tqL/Mtp//ZuoRns4KeIYL/fcAPaddQTpW2HgiAjUpS',\n" +
                "3, 'NEW', 'python239@mail.ru', 'Linda', 'Sikorsky', 'female');";
        index++;
        String user14 = "INSERT INTO users (id, login, name, password, role_id, " +
                "account_status, email, first_name, last_name, gender) VALUES (" +
                index + ", 'linda', 'lin', " +
                "'$2a$10$lF8zJ8UTZV4tqL/Mtp//ZuoRns4KeIYL/fcAPaddQTpW2HgiAjUpS',\n" +
                "3, 'NEW', 'python239@mail.ru', 'Sidnay', 'Sikorsky', 'male');";
        index++;
        String user15 = "INSERT INTO users (id, login, name, password, role_id, " +
                "account_status, email, first_name, last_name, gender) VALUES (" +
                index + ", 'linda', 'lin', " +
                "'$2a$10$lF8zJ8UTZV4tqL/Mtp//ZuoRns4KeIYL/fcAPaddQTpW2HgiAjUpS',\n" +
                "3, 'NEW', 'python239@mail.ru', 'Linda', 'Sikorsky', 'female');";
        index++;
        String user16 = "INSERT INTO users (id, login, name, password, role_id, " +
                "account_status, email, first_name, last_name, gender) VALUES (" +
                index + ", 'linda', 'lin', " +
                "'$2a$10$lF8zJ8UTZV4tqL/Mtp//ZuoRns4KeIYL/fcAPaddQTpW2HgiAjUpS',\n" +
                "3, 'NEW', 'python239@mail.ru', 'Sindy', 'Sikorsky', 'female');";
        index++;
        String user17 = "INSERT INTO users (id, login, name, password, role_id, " +
                "account_status, email, first_name, last_name, gender) VALUES (" +
                index + ", 'linda', 'lin', " +
                "'$2a$10$lF8zJ8UTZV4tqL/Mtp//ZuoRns4KeIYL/fcAPaddQTpW2HgiAjUpS',\n" +
                "3, 'NEW', 'python239@mail.ru', 'Linda', 'Sikorsky', 'female');";
        index++;
        String user18 = "INSERT INTO users (id, login, name, password, role_id, " +
                "account_status, email, first_name, last_name, gender) VALUES (" +
                index + ", 'linda', 'lin', " +
                "'$2a$10$lF8zJ8UTZV4tqL/Mtp//ZuoRns4KeIYL/fcAPaddQTpW2HgiAjUpS',\n" +
                "3, 'NEW', 'python239@mail.ru', 'Linda', 'Sikorsky', 'male');";
        index++;
        String user19 = "INSERT INTO users (id, login, name, password, role_id, " +
                "account_status, email, first_name, last_name, gender) VALUES (" +
                index + ", 'linda', 'lin', " +
                "'$2a$10$lF8zJ8UTZV4tqL/Mtp//ZuoRns4KeIYL/fcAPaddQTpW2HgiAjUpS',\n" +
                "3, 'NEW', 'python239@mail.ru', 'Linda', 'Sikorsky', 'female');";
        index++;
        String user20 = "INSERT INTO users (id, login, name, password, role_id, " +
                "account_status, email, first_name, last_name, gender) VALUES (" +
                index + ", 'linda', 'lin', " +
                "'$2a$10$lF8zJ8UTZV4tqL/Mtp//ZuoRns4KeIYL/fcAPaddQTpW2HgiAjUpS',\n" +
                "3, 'NEW', 'python239@mail.ru', 'Linda', 'Sikorsky', 'female');";
        index++;
        String user21 = "INSERT INTO users (id, login, name, password, role_id, " +
                "account_status, email, first_name, last_name, gender) VALUES (" +
                index + ", 'linda', 'lin', " +
                "'$2a$10$lF8zJ8UTZV4tqL/Mtp//ZuoRns4KeIYL/fcAPaddQTpW2HgiAjUpS',\n" +
                "3, 'NEW', 'python239@mail.ru', 'Linda', 'Sikorsky', 'female');";
        index++;
        String user22 = "INSERT INTO users (id, login, name, password, role_id, " +
                "account_status, email, first_name, last_name, gender) VALUES (" +
                index + ", 'linda', 'lin', " +
                "'$2a$10$lF8zJ8UTZV4tqL/Mtp//ZuoRns4KeIYL/fcAPaddQTpW2HgiAjUpS',\n" +
                "3, 'NEW', 'python239@mail.ru', 'Linda', 'Sikorsky', 'female');";
        index++;
        String user23 = "INSERT INTO users (id, login, name, password, role_id, " +
                "account_status, email, first_name, last_name, gender) VALUES (" +
                index + ", 'linda', 'lin', " +
                "'$2a$10$lF8zJ8UTZV4tqL/Mtp//ZuoRns4KeIYL/fcAPaddQTpW2HgiAjUpS',\n" +
                "3, 'NEW', 'python239@mail.ru', 'Linda', 'Sikorsky', 'female');";
        index++;
        String user24 = "INSERT INTO users (id, login, name, password, role_id, " +
                "account_status, email, first_name, last_name, gender) VALUES (" +
                index + ", 'linda', 'lin', " +
                "'$2a$10$lF8zJ8UTZV4tqL/Mtp//ZuoRns4KeIYL/fcAPaddQTpW2HgiAjUpS',\n" +
                "3, 'NEW', 'python239@mail.ru', 'Linda', 'Sikorsky', 'female');";
        index++;
        String user25 = "INSERT INTO users (id, login, name, password, role_id, " +
                "account_status, email, first_name, last_name, gender) VALUES (" +
                index + ", 'linda', 'lin', " +
                "'$2a$10$lF8zJ8UTZV4tqL/Mtp//ZuoRns4KeIYL/fcAPaddQTpW2HgiAjUpS',\n" +
                "3, 'NEW', 'python239@mail.ru', 'Linda', 'Sikorsky', 'female');";
        index++;
        String user26 = "INSERT INTO users (id, login, name, password, role_id, " +
                "account_status, email, first_name, last_name, gender) VALUES (" +
                index + ", 'linda', 'lin', " +
                "'$2a$10$lF8zJ8UTZV4tqL/Mtp//ZuoRns4KeIYL/fcAPaddQTpW2HgiAjUpS',\n" +
                "3, 'NEW', 'python239@mail.ru', 'Linda', 'Sikorsky', 'female');";
        index++;
        String user27 = "INSERT INTO users (id, login, name, password, role_id, " +
                "account_status, email, first_name, last_name, gender) VALUES (" +
                index + ", 'linda', 'lin', " +
                "'$2a$10$lF8zJ8UTZV4tqL/Mtp//ZuoRns4KeIYL/fcAPaddQTpW2HgiAjUpS',\n" +
                "3, 'NEW', 'python239@mail.ru', 'Linda', 'Sikorsky', 'female');";
        index++;
        String user28 = "INSERT INTO users (id, login, name, password, role_id, " +
                "account_status, email, first_name, last_name, gender) VALUES (" +
                index + ", 'linda', 'lin', " +
                "'$2a$10$lF8zJ8UTZV4tqL/Mtp//ZuoRns4KeIYL/fcAPaddQTpW2HgiAjUpS',\n" +
                "3, 'NEW', 'python239@mail.ru', 'Linda', 'Sikorsky', 'female');";
        index++;
        String user29 = "INSERT INTO users (id, login, name, password, role_id, " +
                "account_status, email, first_name, last_name, gender) VALUES (" +
                index + ", 'linda', 'lin', " +
                "'$2a$10$lF8zJ8UTZV4tqL/Mtp//ZuoRns4KeIYL/fcAPaddQTpW2HgiAjUpS',\n" +
                "3, 'NEW', 'python239@mail.ru', 'Linda', 'Sikorsky', 'female');";
        index++;
        String user30 = "INSERT INTO users (id, login, name, password, role_id, " +
                "account_status, email, first_name, last_name, gender) VALUES (" +
                index + ", 'linda', 'lin', " +
                "'$2a$10$lF8zJ8UTZV4tqL/Mtp//ZuoRns4KeIYL/fcAPaddQTpW2HgiAjUpS',\n" +
                "3, 'NEW', 'python239@mail.ru', 'Linda', 'Sikorsky', 'female');";
        index++;
        String user31 = "INSERT INTO users (id, login, name, password, role_id, " +
                "account_status, email, first_name, last_name, gender) VALUES (" +
                index + ", 'linda', 'lin', " +
                "'$2a$10$lF8zJ8UTZV4tqL/Mtp//ZuoRns4KeIYL/fcAPaddQTpW2HgiAjUpS',\n" +
                "3, 'NEW', 'python239@mail.ru', 'Linda', 'Sikorsky', 'female');";
        index++;
        String user32 = "INSERT INTO users (id, login, name, password, role_id, " +
                "account_status, email, first_name, last_name, gender) VALUES (" +
                index + ", 'linda', 'lin', " +
                "'$2a$10$lF8zJ8UTZV4tqL/Mtp//ZuoRns4KeIYL/fcAPaddQTpW2HgiAjUpS',\n" +
                "3, 'NEW', 'python239@mail.ru', 'Linda', 'Sikorsky', 'female');";
        index++;
        String user33 = "INSERT INTO users (id, login, name, password, role_id, " +
                "account_status, email, first_name, last_name, gender) VALUES (" +
                index + ", 'linda', 'lin', " +
                "'$2a$10$lF8zJ8UTZV4tqL/Mtp//ZuoRns4KeIYL/fcAPaddQTpW2HgiAjUpS',\n" +
                "3, 'NEW', 'python239@mail.ru', 'Linda', 'Sikorsky', 'female');";
        index++;
        String user34 = "INSERT INTO users (id, login, name, password, role_id, " +
                "account_status, email, first_name, last_name, gender) VALUES (" +
                index + ", 'linda', 'lin', " +
                "'$2a$10$lF8zJ8UTZV4tqL/Mtp//ZuoRns4KeIYL/fcAPaddQTpW2HgiAjUpS',\n" +
                "3, 'NEW', 'python239@mail.ru', 'Linda', 'Sikorsky', 'female');";
        index++;
        String user35 = "INSERT INTO users (id, login, name, password, role_id, " +
                "account_status, email, first_name, last_name, gender) VALUES (" +
                index + ", 'linda', 'lin', " +
                "'$2a$10$lF8zJ8UTZV4tqL/Mtp//ZuoRns4KeIYL/fcAPaddQTpW2HgiAjUpS',\n" +
                "3, 'NEW', 'python239@mail.ru', 'Linda', 'Sikorsky', 'female');";
        index++;
        String user36 = "INSERT INTO users (id, login, name, password, role_id, " +
                "account_status, email, first_name, last_name, gender) VALUES (" +
                index + ", 'linda', 'lin', " +
                "'$2a$10$lF8zJ8UTZV4tqL/Mtp//ZuoRns4KeIYL/fcAPaddQTpW2HgiAjUpS',\n" +
                "3, 'NEW', 'python239@mail.ru', 'Linda', 'Sikorsky', 'female');";
        index++;
        String user37 = "INSERT INTO users (id, login, name, password, role_id, " +
                "account_status, email, first_name, last_name, gender) VALUES (" +
                index + ", 'linda', 'lin', " +
                "'$2a$10$lF8zJ8UTZV4tqL/Mtp//ZuoRns4KeIYL/fcAPaddQTpW2HgiAjUpS',\n" +
                "3, 'NEW', 'python239@mail.ru', 'Linda', 'Sikorsky', 'female');";
        index++;
        String user38 = "INSERT INTO users (id, login, name, password, role_id, " +
                "account_status, email, first_name, last_name, gender) VALUES (" +
                index + ", 'linda', 'lin', " +
                "'$2a$10$lF8zJ8UTZV4tqL/Mtp//ZuoRns4KeIYL/fcAPaddQTpW2HgiAjUpS',\n" +
                "3, 'NEW', 'python239@mail.ru', 'Linda', 'Sikorsky', 'female');";
        index++;
        String user39 = "INSERT INTO users (id, login, name, password, role_id, " +
                "account_status, email, first_name, last_name, gender) VALUES (" +
                index + ", 'linda', 'lin', " +
                "'$2a$10$lF8zJ8UTZV4tqL/Mtp//ZuoRns4KeIYL/fcAPaddQTpW2HgiAjUpS',\n" +
                "3, 'NEW', 'python239@mail.ru', 'Linda', 'Sikorsky', 'female');";
        index++;
        String user40 = "INSERT INTO users (id, login, name, password, role_id, " +
                "account_status, email, first_name, last_name, gender) VALUES (" +
                index + ", 'linda', 'lin', " +
                "'$2a$10$lF8zJ8UTZV4tqL/Mtp//ZuoRns4KeIYL/fcAPaddQTpW2HgiAjUpS',\n" +
                "3, 'NEW', 'python239@mail.ru', 'Linda', 'Sikorsky', 'female');";

        sql.add(user1);
        sql.add(user2);
        sql.add(user3);
        sql.add(user4);
        sql.add(user5);
        sql.add(user6);
        sql.add(user7);
        sql.add(user8);
        sql.add(user9);
        sql.add(user10);
        sql.add(user11);
        sql.add(user12);
        sql.add(user13);
        sql.add(user14);
        sql.add(user15);
        sql.add(user16);
        sql.add(user17);
        sql.add(user18);
        sql.add(user19);
        sql.add(user20);
        sql.add(user21);
        sql.add(user22);
        sql.add(user23);
        sql.add(user24);
        sql.add(user25);
        sql.add(user26);
        sql.add(user27);
        sql.add(user28);
        sql.add(user29);
        sql.add(user30);
        sql.add(user31);
        sql.add(user32);
        sql.add(user33);
        sql.add(user34);
        sql.add(user35);
        sql.add(user36);
        sql.add(user37);
        sql.add(user38);
        sql.add(user39);
        sql.add(user40);

        for (String user: sql) {
            String msg = insert(user);
            if (!msg.equals("Ok")) {
                return "Error: " + msg;
            }
        }
        return "Ok";
    }
    public String insert (String sql) {
        try {
            jdbcTemplate.execute (sql);
            return "Ok";
        }
        catch (Exception e) {
            return "Data insert into users failed: " + e;
        }

    }
}