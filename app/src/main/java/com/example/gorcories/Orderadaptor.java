package com.example.gorcories;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class Orderadaptor extends FirestoreRecyclerAdapter<orderpojo, Orderadaptor.OrderHolder>  {
    public Orderadaptor(@NonNull FirestoreRecyclerOptions<orderpojo> options){
        super(options);
        }

        @Override
    protected void onBindViewHolder(@NonNull OrderHolder holder,int Position , @NonNull orderpojo model){
        holder.Name.setText(model.getName());
        holder.Price.setText(model.getPrice());

        }

        @NonNull
        @Override
        public OrderHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_item,
        parent, false);
        return new OrderHolder(v);
        }

class OrderHolder extends RecyclerView.ViewHolder {
    TextView Name;
    TextView Price;
    public OrderHolder(View itemView) {
        super(itemView);
        Name = itemView.findViewById(R.id.Ordername);
        Price = itemView.findViewById(R.id.price);
    }
}
}
