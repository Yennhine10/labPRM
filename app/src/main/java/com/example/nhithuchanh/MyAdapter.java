package com.example.nhithuchanh;


import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.nhithuchanh.model.Book;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<Book> myList;
    private Context context;

    public MyAdapter(List<Book> myList) {
        this.myList = myList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        // R.layout.item tham chiếu đến item muốn load ra
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Book item = myList.get(position);
        holder.txtfield1.setText(item.getName()); // trùng với input 1
        holder.txtfield2.setText(String.valueOf(item.getQuantity())); // trùng với input 2
        holder.txtfield3.setText(String.valueOf(item.getPrice()));
        holder.txtfield4.setText(item.getDescription());
        holder.txtfield5.setText(item.getLocation());

        holder.btnEdit.setOnClickListener(v -> {
            // Handle edit action
//            Toast.makeText(context, "Edit: " + item.getName(), Toast.LENGTH_SHORT).show();

//            Intent intent = new Intent(context, EditActivity.class); //AddActivity là màn hình cần chuyển sang
//            intent.putExtra("dulieu", item);
//            context.startActivity(intent);
            showEditDialog(position);
        });

        // Set up Delete button click listener with confirmation
        holder.btnDelete.setOnClickListener(v -> {
            showDeleteConfirmationDialog(position);
        });
    }
    private void showEditDialog(int position) {
        Book item = myList.get(position);

        // Tạo dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Edit Item");

        // Ánh xạ layout
        View dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_edit_item, null);
        builder.setView(dialogView);

        // Lấy thông tin từ dialog gửi qua
        EditText editField1 = dialogView.findViewById(R.id.tx_name);
        EditText editField2 = dialogView.findViewById(R.id.tx_price);
        EditText editField3 = dialogView.findViewById(R.id.tx_quantity);
        EditText editField4 = dialogView.findViewById(R.id.tx_description);
        EditText editField5 = dialogView.findViewById(R.id.tx_location);

        // đưa thông tin vào input
        editField1.setText(item.getName());
        editField2.setText(String.valueOf(item.getPrice()));
        editField3.setText(String.valueOf(item.getQuantity()));
        editField4.setText(item.getDescription());
        editField5.setText(item.getLocation());

        //xử lý nút nhấn
        builder.setPositiveButton("Save", (dialog, which) -> {
            notifyItemChanged(position);
            Toast.makeText(context, "Updated " + item.getName(), Toast.LENGTH_SHORT).show();
            Book item2 = myList.get(position);
            String t1 = editField1.getText().toString().trim();
            String t2 = editField2.getText().toString().trim();
            String t3 = editField3.getText().toString().trim();
            String t4 = editField4.getText().toString().trim();
            String t5 = editField5.getText().toString().trim();

            item2.setName(t1);
            item2.setPrice(Double.parseDouble(t2));
            item2.setQuantity(Integer.parseInt(t3));
            item2.setDescription(t4);
            item2.setLocation(t5);

            AppDatabase database = AppDatabase.getInstance(context);
            database.bookDao().update(item2);
            Toast.makeText(context, "Update thanh cong", Toast.LENGTH_SHORT).show();
        });

        builder.setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss());

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void showDeleteConfirmationDialog(int position) {
        Book item = myList.get(position);

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Confirm delete");
        builder.setMessage("Delete " + item.getName() + "?");

        // Add the buttons
        builder.setPositiveButton("Yes", (dialog, id) -> {
            // User confirmed the delete operation
            deleteItem(position);
            Toast.makeText(context, "Deleted " + item.getName(), Toast.LENGTH_SHORT).show();
        });

        builder.setNegativeButton("Cancel", (dialog, id) -> {
            // User cancelled the dialog
            dialog.dismiss();
        });

        // Create and show the AlertDialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void deleteItem(int position) {
        Book item = myList.get(position);

        myList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, myList.size());

        AppDatabase database = AppDatabase.getInstance(context);
        database.bookDao().delete(item);

    }

    @Override
    public int getItemCount() {
        if (myList == null) {
            return 0;
        }
        return myList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtfield1, txtfield2, txtfield3,txtfield4,txtfield5;
        Button btnEdit, btnDelete;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtfield1 = itemView.findViewById(R.id.tv_field1); // tv_field1 là id textinput của layout R.layout.item
            txtfield2 = itemView.findViewById(R.id.tv_field2); // tv_field2 là id textinput của layout R.layout.item
            txtfield3 = itemView.findViewById(R.id.tv_field3);
            txtfield4 = itemView.findViewById(R.id.tv_field4);
            txtfield5 = itemView.findViewById(R.id.tv_field5);

            btnEdit = itemView.findViewById(R.id.btn_action1);
            btnDelete = itemView.findViewById(R.id.btn_action2);
        }
    }
}
