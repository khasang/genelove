package io.khasang.genelove.model;

import org.springframework.jdbc.core.JdbcTemplate;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DBLoader {
    private JdbcTemplate jdbcTemplate;

    public DBLoader() { }
    public DBLoader(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

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

    public String insertFromFile (ArrayList<String> request) {
        boolean status = true;
        String buf = null;
        for (String str: request) {
            String responce = executeRequest(str);
            if (!responce.equals("Ok")) {
                status = false;
                buf += responce + " ";
            }
        }
        if (status) return "Ok";
        else return buf;
    }

    public ArrayList<String> loadFromFile (String fileName) {
        File file = new File (fileName);
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
            String requestSQL = ("INSERT INTO " + table + " (");
            for (String s: fields) requestSQL += s + ", ";
            requestSQL = requestSQL.substring(0, requestSQL.length()-2);
            requestSQL += ") VALUES ('";
            for (String s: params) requestSQL += s + "', '";
            requestSQL = requestSQL.substring(0, requestSQL.length()-3);
            requestSQL += ");";
            answer.add(requestSQL);
        }
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