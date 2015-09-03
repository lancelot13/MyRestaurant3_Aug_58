package nsru.isaranontakul.danuwat.myrestaurant;

import android.database.sqlite.SQLiteDatabase;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    //Explicit
    private UserTable objUserTable;
    private FoodTable objFoodTable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ////////Create and Connect DB
        CreateConnectDB();

        ////////Test Insert Record
        //TestInsertDB();

        ////////Delete All Data
        deleteAllData();

        ///////Synchronize JSON to SQLlite
        synJSON2SQLite();

    }

    private void synJSON2SQLite() {
        ///////Change Policy google ตั้งไว้ว่า ไม่ให้ android ติดต่อกับ http ftp ได้ ต้องเปลี่ยน policy เป็น permit all
        StrictMode.ThreadPolicy objThreadPolicy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        

    }

    private void deleteAllData() {
        //mode.private จะให้ลบเฉพาะข้อมูล ห้าม drop
        SQLiteDatabase objSqLiteDatabase = openOrCreateDatabase("Restaurant.db",MODE_PRIVATE,null);
        objSqLiteDatabase.delete("userTable", null, null);
        objSqLiteDatabase.delete("foodTable", null, null);
    }

    private void TestInsertDB() {
        objUserTable.addNewUser("test", "123456", "lancelotแรก");
        objFoodTable.addNewFood("Hambergur", "testSource", "250");
    }

    private void CreateConnectDB() {
        objUserTable = new UserTable(this);
        objFoodTable = new FoodTable(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //public void setObjFoodTable(FoodTable objFoodTable) {
    //    this.objFoodTable = objFoodTable;
    //}
}
