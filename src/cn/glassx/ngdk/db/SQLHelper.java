package cn.glassx.ngdk.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.List;

/**
 * Created by mj on 14-1-14.
 */
public class SQLHelper extends SQLiteOpenHelper {
    private MigrationManager migration;
    protected Context context;
    public String test;

    public SQLHelper(Context context, MigrationManager migration, String DataBaseName, int version) {
        super(context, DataBaseName, null, version);
        this.migration = migration;
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        for (String migration1 : migration.toInitMigration()) {
            sqLiteDatabase.execSQL(migration1);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        for (List<String> migrations : migration.toMigration(oldVersion, newVersion)) {
            for (String migrate : migrations) {
                sqLiteDatabase.execSQL(migrate);
            }
        }
    }
}
