package cn.glassx.ngdk.db;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mj on 14-1-14.
 */
public class Base implements Migration {

    protected List<String> sqls = new ArrayList<String>();

    public Base addColumn(String dataType, String columnName) {
        sqls.add(String.format("%s %s", columnName, dataType));
        return this;
    }


    public Base addAutoIncrementPrimaryKey(String columnName) {
        sqls.add(String.format("%s INTEGER primary key autoincrement", columnName));
        return this;
    }

    public String toSql() {
        return TextUtils.join(",", sqls);
    }
}
