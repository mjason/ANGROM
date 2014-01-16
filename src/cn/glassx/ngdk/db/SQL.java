package cn.glassx.ngdk.db;

/**
 * Created by mj on 14-1-16.
 */
public class SQL {

    /**
     * AVG 函数返回数值列的平均值。NULL 值不包括在计算中
     * The AVG() function returns the average value of a numeric column.
     * @param field
     * @return
     */
    public static String avg(String field) {
        return String.format("AVG(%s)", field);
    }

    /**
     * COUNT() 函数返回匹配指定条件的行数。
     * The COUNT() function returns the number of rows that matches a specified criteria.
     * @param field
     * @return
     */
    public static String count(String field) {
        return String.format("COUNT(%s)", field);
    }

    /**
     * FIRST() 函数返回指定的字段中第一个记录的值。
     * The FIRST() function returns the first value of the selected column.
     * @param field
     * @return
     */
    public static String first(String field) {
        return String.format("FIRST(%s)", field);
    }

    /**
     * LAST() 函数返回指定的字段中最后一个记录的值。
     * The LAST() function returns the last value of the selected column.
     * @param field
     * @return
     */
    public static String last(String field) {
        return String.format("LAST(%s)", field);
    }

    /**
     * MAX 函数返回一列中的最大值。NULL 值不包括在计算中。
     * The MAX() function returns the largest value of the selected column.
     * @param field
     * @return
     */
    public static String max(String field) {
        return String.format("MAX(%s)", field);
    }

    /**
     * MIN 函数返回一列中的最小值。NULL 值不包括在计算中。
     * The MIN() function returns the smallest value of the selected column.
     * @param field
     * @return
     */
    public static String min(String field) {
        return String.format("MIN(%s)", field);
    }

    /**
     * SUM 函数返回数值列的总数（总额）。
     * The SUM() function returns the total sum of a numeric column.
     * @param field
     * @return
     */
    public static String sum(String field) {
        return String.format("SUM(%s)", field);
    }

    /**
     * GROUP BY 语句用于结合合计函数，根据一个或多个列对结果集进行分组。
     * The GROUP BY statement is used in conjunction with the aggregate functions to group the result-set by one or more columns.
     * @param field
     * @return
     */
    public static String groupBy(String field) {
        return String.format("GROUP BY %s", field);
    }

    /**
     * UCASE 函数把字段的值转换为大写。
     * The UCASE() function converts the value of a field to uppercase.
     * @param field
     * @return
     */
    public static String ucase(String field) {
        return String.format("UCASE(%s)", field);
    }

    /**
     * LCASE 函数把字段的值转换为小写。
     * The LCASE() function converts the value of a field to lowercase.
     * @param field
     * @return
     */
    public static String lcase(String field) {
        return String.format("LCASE(%s)", field);
    }

    /**
     * MID 函数用于从文本字段中提取字符。
     * The MID() function is used to extract characters from a text field.
     * @param field
     * @param start
     * @return
     */
    public static String mid(String field, Integer start) {
        return String.format("MID(%s, %s)", field, start.toString());
    }

    /**
     * MID 函数用于从文本字段中提取字符。
     * The MID() function is used to extract characters from a text field.
     * @param field
     * @param start
     * @param end
     * @return
     */
    public static String mid(String field, Integer start, Integer end) {
        return String.format("MID(%s, %s, %s)", field, start.toString(), end.toString());
    }

    /**
     * LEN 函数返回文本字段中值的长度。
     * The LEN() function returns the length of the value in a text field.
     * @param field
     * @return
     */
    public static String len(String field) {
        return String.format("LEN(%s)", field);
    }

    /**
     * ROUND 函数用于把数值字段舍入为指定的小数位数。
     * The ROUND() function is used to round a numeric field to the number of decimals specified.
     * @param field
     * @param decimals
     * @return
     */
    public static String round(String field, Integer decimals) {
        return String.format("ROUND(%s, %i)", field, decimals);
    }

    /**
     * FORMAT 函数用于对字段的显示进行格式化。
     * The FORMAT() function is used to format how a field is to be displayed.
     * @param field now()
     * @param format_ 'YYYY-MM-DD'
     * @return
     */
    public static String format(String field, String format_) {
        return String.format("FORMAT(%s, %s)", field, format_);
    }

}