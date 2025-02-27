package SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private SQLiteOpenHelper1 dbhelper;
    private SQLiteDatabase db;
    private Context context;

    public ProductDAO(Context context) {
        this.context = context;
        dbhelper=new SQLiteOpenHelper1(context);
        db=dbhelper.getWritableDatabase();
    }
    //insert
    public  int inserProduct(Product p) {
        ContentValues values = new ContentValues();
        values.put("id", p.getId());
        values.put("name", p.getName());
        values.put("price", p.getPrice());
        if (db.insert("PRODUCT", null, values) < 0) {
            return -1;
        }
        return 1;
    }
    //get data
    public List<Product> getAll(){
        List<Product> list = new ArrayList<>();
        //cursor read data
        Cursor c =db.query("Product",null,null,null,null,null,null);
        c.moveToFirst();
        while(c.isAfterLast()==false){
            Product product =new Product();
            product.setId((c.getString(0)));
            product.setName((c.getString(1)));
            product.setPrice((c.getString(2)));
            list.add(product);
            c.moveToNext();
        }
        c.close();
        return list;
    }
}
