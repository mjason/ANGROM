package cn.glassx.ngdk.db;

/**
 * Created by mj on 14-1-15.
 */
public class Genre {
    public static final String STRING = "TEXT";
    public static final String INTEGER = "INTEGER";
    public static final String REAL = "REAL";
    public static final String BLOB = "BLOB";
    public static final String SMALLINT = "SMALLINT";
    public static final String FLOAT = "FLOAT";
    public static final String DOUBLE = "DOUBLE";
    public static final String DATE = "DATE";
    public static final String TIME = "TIME";
    public static final String TIMESTAMP = "TIMESTAMP";
    public static final String DATETIME = "DATETIME";

    public static final String CHAR(Integer length) {
        return String.format("CHAR(%s)", length.toString());
    }

    public static final String VARCHAR(Integer length) {
        return String.format("VARCHAR(%s)", length.toString());
    }

    public static final String GRAPHIC(Integer length) {
        return String.format("GRAPHIC(%s)", length.toString());
    }

    public static final String VARGRAPHIC(Integer length) {
        return String.format("VARGRAPHIC(%s)", length.toString());
    }


}
