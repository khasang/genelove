package io.khasang.genelove.model;

import io.khasang.genelove.entity.entity_training.Table;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TableMapper implements RowMapper<Table> {
public Table mapRow(ResultSet rs, int rowNum) throws SQLException {
        Table table = new Table();
        table.setName(rs.getString("table_name"));
        return table;
        }
}
