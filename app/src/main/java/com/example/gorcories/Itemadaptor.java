package com.example.gorcories;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import java.util.ArrayList;

public class Itemadaptor  extends FirestoreRecyclerAdapter<orderpojo, Itemadaptor.ItemHolder> {

    ArrayList<orderpojo> cartitems = new ArrayList<>();
    View view;

    public Itemadaptor(@NonNull FirestoreRecyclerOptions<orderpojo> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ItemHolder holder, int position, @NonNull final orderpojo model) {
        holder.Name.setText(model.getName());
        holder.Price.setText(model.getPrice());
        holder.addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cartitems.add(model);
            }
        });

    }

    @NonNull
    @Override
    public Itemadaptor.ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,
                parent, false);
        return new ItemHolder(v);
    }
    class ItemHolder extends RecyclerView.ViewHolder {
        TextView Name;
        TextView Price;
        Button addtocart;
        public ItemHolder(View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.receipe);
            Price = itemView.findViewById(R.id.priceitem);
            addtocart = itemView.findViewById(R.id.button3);
        }
    }

}