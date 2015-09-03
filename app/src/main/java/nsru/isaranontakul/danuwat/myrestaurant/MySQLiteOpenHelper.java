package nsru.isaranontakul.danuwat.myrestaurant;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Lancelot on 3/9/2558.
 */

//extend sqliteonpenhelper and implement method (Alt + Enter)
public class MySQLiteOpenHelper extends SQLiteOpenHelper{

    //Explicit
    //Create Atribute
    private static final String DATABASE_NAME = "Restaurant.db";
    //flag operator for sqlite
    private static final int DATABASE_VERSION = 1;
    // first colunm in table can't use id;
    private static final String CREATE_USER_TABLE = "CREATE TABLE userTable (_id integer primary key,user text,password text,name text);";
    private static final String CREATE_FOOD_TABLE = "CREATE TABLE foodTable (_id interger primary key,food,source,price text);";
    //private static final String CREATE_ORDER_TABLE = "CREATE TABLE (_id integer primary,officeid ,desk,food,item text);";

    //ALt+Enter to complete super constructor to superclass (sqlitopenhelper)
    public MySQLiteOpenHelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }//Constructor

    //method for create table
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
        db.execSQL(CREATE_FOOD_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
