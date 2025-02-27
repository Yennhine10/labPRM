package SQLite;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SQLiteOpenHelper1 extends SQLiteOpenHelper {
    public static final String DB_NAME = "PRODUCT";
    public static final String SQL_CREATE_PRODUCT="CREATE TABLE PRODUCT(\n" +
            "  id text PRIMARY Key,\n" +
            "  name text,\n" +
            "  price text,\n" +
            "  image real\n" +
            "  );";
    //tao csdl
    public SQLiteOpenHelper1(Context context) {
        super(context, DB_NAME, null, 1);
    }
    //tao bang du lieu
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_PRODUCT);

    }
    //nang cap
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS PRODUCT");
    }
}
