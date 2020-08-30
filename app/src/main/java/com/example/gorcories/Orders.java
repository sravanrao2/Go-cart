package com.example.gorcories;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

/**
 *Orders class displays the orders in the fragment when orders button is clicked.
 *Initializes firebasefirestore and database reference
 */

public class Orders extends AppCompatActivity {
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference notebookRef = db.collection("Orders");

    //provides reference to the views for each data item
    private Orderadaptor adapter;

    @Override
    /**
     * OnCreateView inflates the order_view layout and uses RecyclerView by giving Id of the recyclerView through findViewBYId
     * @param inflater used to inflate any views in the fragment
     * @param container the parent view to which the fragment UI is attached
     * @param savedInstanceState previously saved state
     * @return returns the view
     */
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_view);
        Query query = notebookRef.orderBy("name", Query.Direction.ASCENDING);
        FirestoreRecyclerOptions<orderpojo> options = new FirestoreRecyclerOptions.Builder<orderpojo>()
                .setQuery(query, orderpojo.class)
                .build();
        adapter = new Orderadaptor(options);
        RecyclerView recyclerView= findViewById(R.id.orderrecycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);




//        Query query = db.collection("Orders");
//        FirebaseFirestore db = FirebaseFirestore.getInstance();



//        FirestoreRecyclerOptions<orderpojo> orders = new FirestoreRecyclerOptions.Builder<orderpojo>()
//                .setQuery(query, orderpojo.class)
//                .build();
//        FirestoreRecyclerAdapter adapter = new FirestoreRecyclerAdapter<orderpojo, OrdersViewHolder>(orders) {
//            @Override
//            public void onBindViewHolder(OrdersViewHolder holder, int position, orderpojo model) {
//                holder.name.setText(model.getName());
//                Log.v("dilip","into"+model.getName());
//                holder.price.setText(model.getPrice());
//            }
//            @Override
//            public OrdersViewHolder onCreateViewHolder(ViewGroup group, int i) {
//                View view = LayoutInflater.from(group.getContext())
//                        .inflate(R.layout.order_item, group, false);
//                return new OrdersViewHolder(view);
//            }
//        };
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setAdapter(adapter);
//    }
//
//    private class OrdersViewHolder extends RecyclerView.ViewHolder{
//        private TextView name;
//        private TextView price;
//        public OrdersViewHolder(@NonNull View itemView) {
//            super(itemView);
//            name = itemView.findViewById(R.id.Ordername);
//            price = itemView.findViewById(R.id.price);
//        }
//    }
    }
    /**
     * onStart invokes two methods they are onStart and startListening.
     */
    @Override
    protected void onStart(){
        super.onStart();
        adapter.startListening();
    }
    /**
     * onStop invokes two methods they are onStop and stopListening.
     */
    @Override
    protected void onStop()
    {
        super.onStop();
        adapter.stopListening();
    }

}
