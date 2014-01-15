package cn.glassx.ngdk.db;

/**
 * Created by mj on 14-1-14.
 */
public class CreateTable extends Base {
    private String tableName;

    public CreateTable(String tableName) {
        this.tableName = tableName;
    }

    protected String createTableFormat = "CREATE TABLE %s (%s)";

    @Override
    public String toSql() {
        return String.format(createTableFormat, tableName, super.toSql());
    }
}
