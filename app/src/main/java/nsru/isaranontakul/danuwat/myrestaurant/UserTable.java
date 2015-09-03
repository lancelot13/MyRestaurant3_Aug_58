package nsru.isaranontakul.danuwat.myrestaurant;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.SimpleTimeZone;

/**
 * Created by Lancelot on 3/9/2558.
 */
// operator  class for user database
public class UserTable {
    private MySQLiteOpenHelper objMySQLiteOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase, readSqLiteDatabase;

    public static final String USER_TABLE ="userTable";
    public static final String COLUMN_ID_USER = "_id";
    public static final String COLUMN_USER = "user";
    public static final String COLUMN_PASS = "password";
    public static final String COLUMN_NAME = "name";


    //context is object...??? to connect class
    public UserTable(Context context) {
        objMySQLiteOpenHelper = new MySQLiteOpenHelper(context);
        writeSqLiteDatabase = objMySQLiteOpenHelper.getWritableDatabase();
        readSqLiteDatabase = objMySQLiteOpenHelper.getReadableDatabase();

    }//constructor

    //insert new record to database
    public long addNewUser(String strUser,String strPassword, String strName) {

        ContentValues objContentValues = new ContentValues();
        objContentValues.put(COLUMN_USER,strUser);
        objContentValues.put(COLUMN_PASS,strPassword);
        objContentValues.put(COLUMN_NAME,strName);
        return writeSqLiteDatabase.insert(USER_TABLE,null,objContentValues);
    }

}//main
