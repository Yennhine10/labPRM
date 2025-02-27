package SQLite;

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
    private List<Product> mlist;
    private Context context;

    public Adapter(List<Product> mlist, Context context) {
        this.mlist = mlist;
        this.context = context;
    }

    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public Object getItem(int position) {
        return mlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            convertView= LayoutInflater.from(context)
                    .inflate(R.layout.productview,parent,false);
            //reference
            holder =new ViewHolder();
            holder.img=convertView.findViewById(R.id.img);
            holder.txtid=convertView.findViewById(R.id.txtid);
            holder.txtname=convertView.findViewById(R.id.txtname);
            holder.txtprice=convertView.findViewById(R.id.txtprice);
            //create a template
            convertView.setTag(holder);
        }
        else{
            holder=(ViewHolder) convertView.getTag();
        }
        //set data
        Product product=mlist.get(position);
        if(product!=null){
            holder.img.setImageResource(R.drawable.negav1);
            holder.txtid.setText((product.getId()));
            holder.txtname.setText(product.getName());
            holder.txtprice.setText(product.getPrice());
        }
        return convertView;
    }
    static class ViewHolder{
        ImageView img;
        TextView txtid,txtname,txtprice;}

}
