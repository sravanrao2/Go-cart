package com.example.gorcories;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

/**
 * This Cart Extends Fragment which is used to load the cart view as a fragment .
 */


public class Cart extends Fragment {

    /**
     * This Method is a View where in it Helps to load the Cart Layout XML file by container.
     * @param returns view.
     */

    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.cart, container, false);
        return view;
    }
    
}
