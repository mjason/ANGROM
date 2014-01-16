package cn.glassx.ngdk.db;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mj on 14-1-16.
 */
public class ChangeTable implements Migration {

    private StringBuffer sql;
    private List<String> sqls;

    public ChangeTable(String tableName) {
        sql = new StringBuffer();
        sqls = new ArrayList<String>();
        sql.append(String.format("ALTER TABLE %s ( ", tableName));
    }

    public ChangeTable addColumn(String dataType, String field) {
        sqls.add(String.format("ADD %s %s", field, dataType));
        return this;
    }

    public ChangeTable renameColumn(String oldColumnName, String newColumnName) {
        sqls.add(String.format("RENAME COLUMN %s TO %s", oldColumnName, newColumnName));
        return this;
    }

    public ChangeTable renameTable(String newTableName) {
        sqls.add(String.format("RENAME TO %s", newTableName));
        return this;
    }

    public ChangeTable dropColumn(String columnName) {
        sqls.add(String.format("DROP COLUMN %s", columnName));
        return this;
    }

    public ChangeTable alterColumn(String dataType, String columnName) {
        sqls.add(String.format("ALTER COLUMN %s %s", columnName, dataType));
        return this;
    }

    @Override
    public String toSql() {
        sql.append(TextUtils.join(",", sqls));
        return sql.toString();
    }
}
