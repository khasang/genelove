package io.khasang.genelove.service;

import io.khasang.genelove.controller.testControllers.DBServiceController;
import io.khasang.genelove.entity.entity_training.Table;
import io.khasang.genelove.model.TableMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DBLoader {
    private JdbcTemplate jdbcTemplate;

    public DBLoader(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public DBLoader() { }


    public String addUsersIntoDB () {
        ArrayList<String> sql = new ArrayList<>();
        int index = 8;

        String user1 = "INSERT INTO users (id, login, name, password, role_id, " +
                "account_status, email, first_name, last_name, gender) VALUES (" +
                index + ", 'admin', 'admin', " +
                "'$2a$10$X8CUSvrFViVMvP6k0pftF.4vtxjIfVaEy04JcImj95lOPGdgXhZZq',\n" +
                "3, 'NEW', 'elena.ilyukhina@hotmail.com', 'Robert', 'Stivenson', 'male');";
        index++;
        String user2 = "INSERT INTO users (id, login, name, password, role_id, " +
                "account_status, email, first_name, last_name, gender) VALUES (" +
                index + ", 'db', 'db', " +
                "'$2a$10$ZRH9JMqGryNJS2JG4BNXNugFpHqb/6rrMxwcAScd0yb98jtHCcLie',\n" +
                "3, 'NEW', 'python239@mail.ru', 'Linda', 'Sikorsky', 'female');";
        index++;
        String user3 = "INSERT INTO users (id, login, name, password, role_id, " +
                "account_status, email, first_name, last_name, gender) VALUES (" +
                index + ", 'user', 'user', " +
                "'$2a$10$mCzZ1rk9BQfiYwAlyPZ1Gu8h.aWd13zbj1S0SjfJIQpkaqIYD4wwK',\n" +
                "3, 'NEW', 'elena.ilyukhina@hotmail.com', 'Oskar', 'Li', 'male');";
        index++;
        String user4 = "INSERT INTO users (id, login, name, password, role_id, " +
                "account_status, email, first_name, last_name, gender) VALUES (" +
                index + ", 'john', 'jonny', " +
                "'$2a$10$lF8zJ8UTZV4tqL/Mtp//ZuoRns4KeIYL/fcAPaddQTpW2HgiAjUpS',\n" +
                "3, 'NEW', 'elena.ilyukhina@hotmail.com', 'John', 'White', 'male');";
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
                "3, 'NEW', 'dendrito@list.ru', 'Linda', 'Sikorsky', 'male');";
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
                "3, 'NEW', 'dendrito@list.ru', 'Linda', 'Sikorsky', 'male');";
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
                "3, 'NEW', 'dendrito@list.ru', 'Linda', 'Sikorsky', 'male');";
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
                "3, 'NEW', 'dendrito@list.ru', 'Sidnay', 'Sikorsky', 'male');";
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
            String msg = executeRequest(user);
            if (!msg.equals("Ok")) {
                return "Error: " + msg;
            }
        }
        return "Ok";
    }

    public String executeRequest (String sql) {
        try {
            jdbcTemplate.execute (sql);
            return "Ok";
        }
        catch (Exception e) {
            return "Data insert into users failed: " + e;
        }
    }

    public void getInfoAboutFile (File datafile) {
        System.out.println("File get Name: " + datafile.getName());
        System.out.println("File get Path: " + datafile.getPath());
        System.out.println("File get Absolute Path: " + datafile.getAbsolutePath());
        System.out.println("File get Parent: " + datafile.getParent());
        System.out.println("File exists: " + datafile.exists());
        System.out.println("File can Write: " + datafile.canWrite());
        System.out.println("File can Read: " + datafile.canRead());
        System.out.println("File can Execute: " + datafile.canExecute());
        System.out.println("File is Directory: " + datafile.isDirectory());
        System.out.println("File is File: " + datafile.isFile());
        System.out.println("File  s Absolute: " + datafile.isAbsolute());
        System.out.println("File last Modified: " + datafile.lastModified());
        System.out.println("File length: " + datafile.length());
    }

    public String clearTable (String table) {
        String request = "DELETE FROM " + table + ";";
        return executeRequest(request);
    }

    public String deleteTable (String table) {
        String request = "DROP TABLE " + table + ";";
        return executeRequest(request);
    }

    public String saveTable (String table) {
        String request = "SELECT * FROM " + table + ";";
        List<Map<String, Object>> response = jdbcTemplate.queryForList(request);
        boolean first = true;
        String data = "";
        for (Map<String, Object> map: response) {
            if (first) {
                for (String key : map.keySet()) {
                    first = false;
                    data += key + ";";
                }
                data = data.substring(0, data.length()-1) + "\n";
            }
            for (String key: map.keySet()) {
                data += map.get(key) + ";";
            }
            data = data.substring(0, data.length()-1) + "\n";
        }

        //System.out.println("************************");
        //System.out.println(data);
        //System.out.println("************************");

        String filename = DBServiceController.getPath() + table + ".csv";

        File file = new File(filename);
        try(FileWriter writer = new FileWriter(file))
        {
            writer.write(data);
            writer.flush();
        }
        catch(IOException exception){
            System.out.println(exception.getMessage());
            exception.printStackTrace();
        }
        getInfoAboutFile(file);
        return "Data saved into file '" + table + ".csv'<br>" +
                "Absolute path is: " + file.getAbsolutePath();
    }

    public String loadTable (String table) {
        if (getAmountRecordsInTable(table) != 0) {
            return "This table '" + table + "' is NOT empty";
        }
        String filename = DBServiceController.getPath() + table + ".csv";
        File file = new File (filename);
        System.out.println(file.exists() && file.length() != 0);
        if (!file.exists())
            return "This file '" + file.getName() + "' is NOT found in " + DBServiceController.getPath();
        if (file.exists() && file.length() ==0)
            return "This file '" + file.getName() + "' is EMPTY";
        else
            return insertFromFile(loadFromFile(file));
  /*      String response = "";
        String filename = DBServiceController.getPath() + table + ".csv";
        File file = new File (filename);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()){
                String str = scanner.nextLine();
                response += str + "\n";
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("************************");
        System.out.println(response);
        System.out.println("************************");*/
    }

    public String addRecord (String table) {

        return "";
    }

    public String updateRecord (String table, int id) {

        return "";
    }

    public String deleteRecord (String table, int id) {

        return "";
    }

    public String reloadTable (String table) {
        clearTable(table);
        return loadTable(table);
    }

    public int getAmountRecordsInTable (String table) {
        String request = "SELECT count(*) FROM " + table + ";";
        Integer count = jdbcTemplate.queryForObject(request, Integer.class);
        return count;
    }

    public List<Table> getTablesList () {
        String request = "SELECT table_name FROM information_schema.tables " +
                "WHERE table_schema='public' ORDER BY table_name ASC;";
        return jdbcTemplate.query(request, new TableMapper());
    }

/*    public List<Map<String, Object>> getTableHeaderList (String table) {
        String request = "SELECT column_name FROM INFORMATION_SCHEMA.COLUMNS " +
                "WHERE table_name = '" + table + "';";
        return jdbcTemplate.queryForList(request);
    }*/

    public List<Map<String, Object>> getTableDataList (String table) {
        String request = "SELECT * FROM " + table;
        return jdbcTemplate.queryForList(request);
    }

    public String insertFromFile (ArrayList<String> request) {
        boolean status = true;
        String buf = null;
        for (String str: request) {
            String response = executeRequest(str);
            if (!response.equals("Ok")) {
                status = false;
                buf += response + " ";
            }
        }
        if (status) return "Ok";
        else return buf;
    }

    public ArrayList<String> loadFromFile (File file) {
        ArrayList<String> answer = new ArrayList<>();
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> fields = new ArrayList<>();
        ArrayList<String> params;
        ArrayList<ArrayList<String>> parameters = new ArrayList<>();

        try {
            list = this.openFile(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String separator = ";";
        Scanner scanner = new Scanner(list.get(0)).useDelimiter(separator);
        while(scanner.hasNext()) {
            fields.add(scanner.next());
        }
        list.remove(0);
        scanner.close();

        for (String line: list) {
            params = new ArrayList<>();
            scanner = new Scanner(line).useDelimiter(separator);
            while(scanner.hasNext()) {
                params.add(scanner.next());
            }
            parameters.add(params);
            String table = file.getName().substring(0, file.getName().length()-4);
            String request = ("INSERT INTO " + table + " (");
            for (String s: fields) request += s + ", ";
            request = request.substring(0, request.length()-2);
            request += ") VALUES ('";
            for (String s: params) request += s + "', '";
            request = request.substring(0, request.length()-3);
            request += ");";
            answer.add(request);
        }
        System.out.println(">>>: " + answer);
        return answer;
    }

    public ArrayList<String> openFile (File datafile) throws FileNotFoundException {
        ArrayList<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(datafile), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e){
            System.out.println("Sorry, IOException occurred: " + e);
            list = null;
        }
        return list;
    }
}