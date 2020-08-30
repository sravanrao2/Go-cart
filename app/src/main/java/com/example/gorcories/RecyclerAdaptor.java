package com.example.gorcories;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * This class acts as adapter class for cart, items view
 * This class extends RecyclerView
 */
public class RecyclerAdaptor extends RecyclerView.Adapter<RecyclerAdaptor.ViewHolder> {

    List<Ingredients> ingredients;
    Cart mcontext;
    ItemsView vcontext;
    /**
     * This Recycleradapter class for cart view
     *
     */

    public RecyclerAdaptor(List<Ingredients> ingredients, Cart cart) {
        this.ingredients = ingredients;
        this.mcontext = cart;
    }
    /**
     * This Recycleradapter class for Items view
     *
     */

    public RecyclerAdaptor(List<Ingredients> ingredients, ItemsView items) {
        this.ingredients = ingredients;
        this.vcontext = items;
    }

    /**
     *
     * @param parent The ViewGroup into which the new View will be added
     * @param viewType The view type of the new View.
     * @return returns ViwHolder instance
     */
    @NonNull
    @Override

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View cartitems= layoutInflater.inflate(R.layout.cart, parent, false);
        ViewHolder viewHolder = new ViewHolder(cartitems);
        return viewHolder;
    }

    /**
     *
     * @param holder The Viewholder that to be updated with cart items at given position
     * @param position The position of the holder with respect to this adapter
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(ingredients.get(position).getName());
    }

    /**
     * This method is used to get count of ingredients
     * @return Ingredients size
     */
    @Override
    public int getItemCount() {
        return ingredients.size();
    }

    /**
     * This class deals with cart item data and their instances
     */
    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textView = (TextView)itemView.findViewById(R.id.receipe);
        }
    }
}
