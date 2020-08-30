package com.example.gorcories;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.ArrayList;
import java.util.List;
/**
 *ItemsView class displays the items in the fragment when item button is clicked
 *Initializes firebasefirestore and database reference
 */

public class ItemsView extends Fragment {
    View view;
    Button btn;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference notebookRef = db.collection("weekdays");

    //provide a reference to the views for each data item
    private Itemadaptor adapter;
    /**
     * OnCreateView inflates the items_list layout and uses RecyclerView by giving Id of the recyclerView through findViewBYId
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return returns the view
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.items_list, container, false);
        Query query = notebookRef.orderBy("name", Query.Direction.ASCENDING);
        FirestoreRecyclerOptions<orderpojo> options = new FirestoreRecyclerOptions.Builder<orderpojo>()
                .setQuery(query, orderpojo.class)
                .build();
        adapter = new Itemadaptor(options);
        RecyclerView recyclerView = view.findViewById(R.id.recycleritems);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(adapter);
        return view;
    }
    /**
     * onStart invokes two methods they are onStart and startListening
     */
    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }
    /**
     * onStop invokes two methods they are onStop and stopListening
     */
    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}

