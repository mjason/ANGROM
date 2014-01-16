package cn.glassx.ngdk.db;

/**
 * Created by mj on 14-1-16.
 */
public class DropTable extends Base {

    private String sql;

    public DropTable(String tableName) {
        this.sql = String.format("DROP TABLE IF EXISTS %s", tableName);
    }

    @Override
    public String toSql() {
        return this.sql;
    }
}
