package io.khasang.genelove.model;

import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;

public class MultipleSelect {
    private JdbcTemplate jdbcTemplate;

    public MultipleSelect(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public MultipleSelect() {
    }

    private List multipleSelect () {
        List list = jdbcTemplate.queryForList ("select * from films");
        return list;
    }

    public List multipleSelectTableStatus () {
        return multipleSelect();
    }
}

