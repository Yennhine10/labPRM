package SQLite;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.adapter.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    EditText txtid,txtname,txtprice;
    Button btnsert,btnview;
    Adapter adapter;
    List<Product> list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        listView=findViewById(R.id.listview);
        txtid=findViewById(R.id.id);
        txtname=findViewById(R.id.name);
        txtprice=findViewById(R.id.price);
        btnsert=findViewById(R.id.btnsert);
        btnview=findViewById(R.id.btnview);
        ProductDAO dao =new ProductDAO(this);
        btnsert.setOnClickListener(v->{
            Product p=new Product();
            p.setId(txtid.getText().toString());
            p.setName(txtname.getText().toString());
            p.setPrice(txtprice.getText().toString());
            int kq= dao.inserProduct(p);
            if (kq==-1) {
                Toast.makeText(getApplicationContext(), "Insert fail", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(getApplicationContext(), "Insert success", Toast.LENGTH_SHORT).show();

            }
        });
        btnview.setOnClickListener(v->{
            list=dao.getAll();
            adapter=new Adapter(list,this);
            listView.setAdapter(adapter);
        });
    }
}