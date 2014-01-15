package cn.glassx.ngdk.db;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mj on 14-1-15.
 */
public class MigrationManager {

    protected  List<MigrationArray> migrations = new ArrayList<MigrationArray>();

    public void initMigrationArray(Integer version) {
        if (migrations.size() == version) {
            migrations.add(version, new MigrationArray());
        }
    }

    public void addMigration(Integer version, Migration migration) {
        version -= 1;
        initMigrationArray(version);
        migrations.get(version).add(migration.toSql());
    }

    public void addMigration(Integer version, Migration... migrations) {
        version -= 1;
        initMigrationArray(version);
        for (Migration migration : migrations) {
            this.migrations.get(version).add(migration.toSql());
        }
    }

    private class MigrationArray extends ArrayList<String> {
        @Override
        public String toString() {
            return TextUtils.join(";", this);
        }
    }

    public MigrationArray toInitMigration() {
        return migrations.get(0);
    }

    public List<MigrationArray> toMigration(int oldVersion, int newVersion) {
        List<MigrationArray> migrationList = migrations.subList(oldVersion, newVersion);
        return migrationList;
    }
}