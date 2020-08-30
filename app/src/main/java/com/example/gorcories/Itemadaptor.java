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

/**
 *This class acts as adapter class for items list
 * This class extends FirestoreRecyclerAdapter
 */
public class Itemadaptor  extends FirestoreRecyclerAdapter<orderpojo, Itemadaptor.ItemHolder> {

    ArrayList<orderpojo> cartitems = new ArrayList<>();
    View view;

    public Itemadaptor(@NonNull FirestoreRecyclerOptions<orderpojo> options) {
        super(options);
    }

    /**
     *
     * @param holder The Viewholder that to be updated with items at given position
     * @param position The position of the holder with respect to this adapter
     * @param model model file for orderpojo
     */
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

    /**
     *
     * @param parent The ViewGroup into which the new View will be added
     * @param viewType The view type of the new View.
     * @return returns ItemHolder clss instance with created view object
     */
    @NonNull
    @Override
    public Itemadaptor.ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,
                parent, false);
        return new ItemHolder(v);
    }

    /**
     * This class deals with item data and their instances
     */
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