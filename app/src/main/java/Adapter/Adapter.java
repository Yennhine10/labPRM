package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.adapter.R;

import java.util.List;

public class Adapter extends BaseAdapter {
    private Context context;
    private List<Student> list;
    //ham khoi tai
    public Adapter(Context context,List<Student> list) {
        this.context = context;
        this.list = list;
    }
    //tong so iteam
    @Override
    public int getCount() {
        return list.size();
    }
    // lay ve item hien tai
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }
    //lay ve id cua item
    @Override
    public long getItemId(int position) {
        return position;
    }
    //create a blank view and refer to view holder
    //set data for view
    @Override
    public View getView(int posiion, View convertView, ViewGroup parent) {
        //create view
        ViewHolder holder;
        if (convertView == null)//not exist view,create a new view
        {
            //create a blank view
            convertView = LayoutInflater.from(context).inflate(R.layout.item_view, parent, false);
            //refer to view holder
            holder = new ViewHolder();
            holder.img_hinh = convertView.findViewById(R.id.img);
            holder.txtage = convertView.findViewById(R.id.txt2);
            holder.txtname = convertView.findViewById(R.id.txt1);
            holder.txtdes=convertView.findViewById(R.id.txt3);
            //create a template for late
            convertView.setTag(holder);
        } else {//exist view,get old holder
            holder = (ViewHolder) convertView.getTag();
        }
        //2.setdata
        Student student = list.get(posiion);//get a object
        holder.img_hinh.setImageResource(student.getImage());
        holder.txtname.setText(student.getName());
        holder.txtage.setText(student.getAge());
        holder.txtdes.setText(student.getDes());
        return convertView;

    }
    //create a class for refer to components of item view
    static class ViewHolder {
        ImageView img_hinh;
        TextView txtname,txtage,txtdes;
    }

}
