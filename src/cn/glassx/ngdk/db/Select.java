package cn.glassx.ngdk.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by mj on 14-1-14.
 */
public class Select {

    private String fields;
    private StringBuffer sql;

    public Select(String fields) {
        this.fields = fields;
        sql = new StringBuffer();
    }

    public Select from(String tableName) {
        sql.append(String.format("SELECT %s FROM %s", fields, tableName));
        return this;
    }

    public Select where(String criteria) {
        sql.append(String.format(" WHERE %s", criteria));
        return this;
    }

    public Select syntax(String criteria) {
        sql.append(String.format(" %s", criteria));
        return this;
    }

    public String toSql() {
        return sql.toString();
    }

    public Cursor query(SQLiteDatabase sqLiteDatabase) {
        return sqLiteDatabase.rawQuery(this.toSql(), null);
    }

    public Cursor query(SQLiteDatabase sqLiteDatabase, String[] params) {
        return sqLiteDatabase.rawQuery(this.toSql(), params);
    }

}
