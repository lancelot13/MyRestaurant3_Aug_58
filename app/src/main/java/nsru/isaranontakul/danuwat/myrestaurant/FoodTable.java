package nsru.isaranontakul.danuwat.myrestaurant;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Lancelot on 3/9/2558.
 */
public class FoodTable {
    private MySQLiteOpenHelper objMySQLiteOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase, readSqLiteDatabase;

    public static final String FOOD_TABLE ="foodTable";
    public static final String COLUMN_ID_FOOD = "_id";
    public static final String COLUMN_FOOD = "food";
    public static final String COLUMN_SOURCE = "source";
    public static final String COLUMN_PRICE = "price";

    public FoodTable(Context context) {
        objMySQLiteOpenHelper = new MySQLiteOpenHelper(context);
        writeSqLiteDatabase = objMySQLiteOpenHelper.getWritableDatabase();
        readSqLiteDatabase = objMySQLiteOpenHelper.getReadableDatabase();
    }

    public long addNewFood(String strFood,String strSource, String strPrice) {

        ContentValues objContentValues = new ContentValues();
        objContentValues.put(COLUMN_FOOD,strFood);
        objContentValues.put(COLUMN_SOURCE,strSource);
        objContentValues.put(COLUMN_PRICE,strPrice);
        // ชื่อตาราง, null, ค่าที่ต้องการส่ง
        return writeSqLiteDatabase.insert(FOOD_TABLE,null,objContentValues);
    }


}
