package io.khasang.genelove.model;

import org.springframework.jdbc.core.JdbcTemplate;

public class TestTable {
    private JdbcTemplate jdbcTemplate;

    public TestTable(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public TestTable() {

    }

    private String insert() {
        try {
            jdbcTemplate.execute("INSERT INTO films (filmcode, title, date_prod, genre, len) " +
                    "values" +
                    "('1', 'Изгой-один: Звёздные войны', '10.12.16', 'фантастика','02:13')," +
                    "('2', 'Союзники', '13.11.16', 'боевик', '02:01')," +
                    "('4', 'Хоббит: Нежданное путешествие', '28.11.2012', 'фэнтези', '02:49')," +
                    "('3', 'Однажды в Америке', '17.02.84', 'драма', '03:49')");
            jdbcTemplate.execute("INSERT INTO roles (filmcode, person, role) " +
                    "values" +
                    "('1', 'Фелисити Джонс', 'Джин Эрсо')," +
                    "('1', 'Диего Луна', 'Кассиан Андор')," +
                    "('1', 'Риз Ахмед', 'Бодхи Рук')," +
                    "('1', 'Бен Мендельсон', 'адмирал Орсон Кренник')," +
                    "('1', 'Цзян Вэнь', 'Бейз Мальбус')," +
                    "('1', 'Донни Йен', 'Чиррут Имве')," +
                    "('2', 'Брэд Питт', 'Макс Ватан')," +
                    "('2', 'Марион Котийяр', 'Марианн Босежур')," +
                    "('2', 'Джаред Харрис', 'Фрэнк Хеслоп')," +
                    "('2', 'Мэттью Гуд', 'Гай Сэнгстер')," +
                    "('2', 'Лиззи Каплан', 'Бриджет Ватан')," +
                    "('3', 'Роберт Де Ниро', 'Дэвид Ааронсон («Лапша»)')," +
                    "('3', 'Джеймс Вудс', 'Максимилиан Беркович («Макс»)')," +
                    "('3', 'Элизабет Макговерн', 'Дебора Гелли')," +
                    "('3', 'Джеймс Хейден', 'Патрик Голдберг («Простак»)')," +
                    "('3', 'Уильям Форсайт', 'Филип Штайн («Косой»)')," +
                    "('3', 'Тьюсдей Уэлд', 'Кэрол')," +
                    "('3', 'Дарлэнн Флюгел', 'Эви')," +
                    "('3', 'Ларри Рэпп', 'Мо Гелли («Толстяк Мо»)')," +
                    "('3', 'Ольга Карлатос', 'женщина в китайском театре')");

            return "Tables filled";
        } catch (Exception e) {
            return "Table fill failed: " + e;
        }
    }

    private String joinInner() {
        try {
            jdbcTemplate.execute("SELECT * FROM films t1 INNER JOIN roles t2 ON (t1.filmcode = t2.filmcode);");
            return "Inner join done";
        } catch (Exception e) {
            return "Error: " + e;
        }
    }

    private String joinFullOuter() {
        try {
            jdbcTemplate.execute("SELECT * FROM films t1 FULL JOIN roles t2 ON (t1.filmcode = t2.filmcode);");
            return "Right outer join done";
        } catch (Exception e) {
            return "Error: " + e;
        }
    }

    private String joinRightOuter() {
        try {
            jdbcTemplate.execute("SELECT * FROM films t1 RIGHT JOIN roles t2 ON (t1.filmcode = t2.filmcode);");
            return "Right outer join done";
        } catch (Exception e) {
            return "Error: " + e;
        }
    }


    private String select() {
        try {
            jdbcTemplate.execute("SELECT * FROM films WHERE filmcode IN (SELECT filmcode FROM roles);");
            return "Select done";
        } catch (Exception e) {
            return "Error: " + e;
        }
    }

   private String caseTable() {
        try {
            jdbcTemplate.execute("SELECT title as Name,\n" +
                    "(CASE genre\n" +
                    "WHEN 'фантастика' THEN 'Фантастический'\n" +
                    "WHEN 'фэнтези' THEN 'Фэнтезийный'\n" +
                    "ELSE 'Прочее'\n" +
                    "END) as Genre\n" +
                    "FROM films;");
            return "Case done";
        } catch (Exception e) {
            return "Error: " + e;
        }
    }

    public String insertTableStatus () {
        return insert();
    }

    public String joinInnerStatus () {
        return joinInner();
    }

    public String joinFullOuterStatus () {
        return joinFullOuter();
    }

    public String joinRightOuterStatus () {
        return joinRightOuter();
    }


    public String caseTableStatus () {
        return caseTable();
    }

    public String selectTableStatus () {
        return select();
    }


}
