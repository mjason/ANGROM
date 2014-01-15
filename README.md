ANGROM
======

一个简单的android dsl, 用来创建数据, 查询, 以及数据库版本控制

[下载地址](https://raw.github.com/mjason/ANGROM/master/out/artifacts/ANGROM_jar/ANGROM.jar)

## 使用入门

1. 下载并导入jar包
2. 创建MyApplication类

```java
public class MyApplication extends Application {

  @Override
  public void onCreate() {
      super.onCreate();

  }

}
```
3. 修改AndroidManifest.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
  package="xx.xx.xx"
  android:versionCode="1"
  android:versionName="1.0" >

  <application
      android:name=".MyApplication"
      android:allowBackup="true"
      android:icon="@drawable/ic_launcher"
      android:label="@string/app_name"
      android:theme="@style/AppTheme" >

  </application>

</manifest>
```
4. 创建数据库
```java
public class MyApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    MigrationManager migrationManager = new MigrationManager();
    Migration user = new CreateTable("users")
               .addAutoIncrementPrimaryKey("id")
               .addColumn(Genre.STRING, "name");
    migrationManager.addMigration(1, user); // 添加数据库1的迁移, 可以添加很多个
    SQLHelper sqlHelper = new SQLHelper(getContext(), migrationManager, "test.db", 1);
    sqlHelper.getWritableDatabase();
  }

}
```
5.修改版本
```java
public class MyApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    MigrationManager migrationManager = new MigrationManager();
    Migration user = new CreateTable("users")
               .addAutoIncrementPrimaryKey("id")
               .addColumn(Genre.STRING, "name");
    migrationManager.addMigration(1, user); // 添加数据库1的迁移, 可以添加很多个

    Migration person = new CreateTable("person")
                .addAutoIncrementPrimaryKey("id")
                .addColumn(Genre.STRING, "age");
    migrationManager.addMigration(2, person);

    Migration test1 = new CreateTable("test1")
            .addAutoIncrementPrimaryKey("id")
            .addColumn(Genre.INTEGER, "age");
    migrationManager.addMigration(3, test1);

    Migration test2 = new CreateTable("test2")
            .addAutoIncrementPrimaryKey("id")
            .addColumn(Genre.INTEGER, "age");
    migrationManager.addMigration(4, test2);

    SQLHelper sqlHelper = new SQLHelper(getContext(), migrationManager, "test.db", 4);
    sqlHelper.getWritableDatabase();
  }

}
```
6. 使用查询
```java
Cursor cursor = new Select("id, name")
                .from("users")
                .where(String.format("id=%s", id_.toString()))
                .query(sqlHelper.getReadableDatabase());
if (cursor.moveToNext()) {
    Assert.assertEquals(cursor.getString(1), "ngdkSelect");
} else {
    Assert.fail("测试失败");
}

Cursor cursor = new Select("id, name")
                .from("users")
                .where("id=?")
                .query(sqlHelper.getReadableDatabase(), new String[] {id.toString()});
if (cursor.moveToNext()) {
    Assert.assertEquals(cursor.getString(1), "ngdkSelect");
} else {
    Assert.fail("测试失败");
}

```