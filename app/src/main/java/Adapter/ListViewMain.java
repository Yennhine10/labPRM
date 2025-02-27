package Adapter;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.adapter.R;

import java.util.ArrayList;
import java.util.List;

public class ListViewMain extends AppCompatActivity {
    ListView listView;
    private Adapter adapter;
    private List<Student> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        listView=findViewById(R.id.list);
        list.add(new Student("Ton Hao Nhi","22",R.drawable.thn,"dth"));
        list.add(new Student("Wean le","32",R.drawable.wle,"deptrai"));
        list.add(new Student("Rhyder","20",R.drawable.ryder1,"rap hay"));
        list.add(new Student("Negav","28",R.drawable.negav1,"baby"));

        adapter=new Adapter(this,list);
        listView.setAdapter(adapter);

    }
}