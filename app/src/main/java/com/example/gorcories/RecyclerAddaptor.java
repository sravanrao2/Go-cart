package com.example.gorcories;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdaptor extends RecyclerView.Adapter<RecyclerAdaptor.ViewHolder> {

    List<Ingredients> ingredients;
    Cart mcontext;
    ItemsView vcontext;
    public RecyclerAdaptor(List<Ingredients> ingredients, Cart cart) {
        this.ingredients = ingredients;
        this.mcontext = cart;
    }
    public RecyclerAdaptor(List<Ingredients> ingredients, ItemsView items) {
        this.ingredients = ingredients;
        this.vcontext = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View cartitems= layoutInflater.inflate(R.layout.cart, parent, false);
        ViewHolder viewHolder = new ViewHolder(cartitems);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(ingredients.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return ingredients.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textView = (TextView)itemView.findViewById(R.id.receipe);
        }
    }
}
