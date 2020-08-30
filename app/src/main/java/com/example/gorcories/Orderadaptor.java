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


/**
 *This class acts as adapter class for Order list view.
 * This class extends FirestoreRecyclerAdapter
 */
public class Orderadaptor extends FirestoreRecyclerAdapter<orderpojo, Orderadaptor.OrderHolder>  {
    public Orderadaptor(@NonNull FirestoreRecyclerOptions<orderpojo> options){
        super(options);
        }
    /**
     *
     * @param holder The Viewholder that to be updated with Orders at given position
     * @param Position The position of the holder with respect to this adapter
     * @param model model file for orderpojo
     */
        @Override
    protected void onBindViewHolder(@NonNull OrderHolder holder,int Position , @NonNull orderpojo model){
        holder.Name.setText(model.getName());
        holder.Price.setText(model.getPrice());
        }
    /**
     *
     * @param parent The ViewGroup into which the new View will be added
     * @param viewType The view type of the new View.
     * @return returns orderHolder class instance with created view object
     */
        @NonNull
        @Override
        public OrderHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_item,
        parent, false);
        return new OrderHolder(v);
        }


    /**
     * This class deals with Order data and their instances
     */
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
