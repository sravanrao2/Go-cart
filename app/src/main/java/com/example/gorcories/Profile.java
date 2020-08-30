package com.example.gorcories;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

/**
 * This Profile fragment extends Fragment is used for loading of the Profile View
 */

public class Profile extends Fragment {

    View view;

    /**
     *This method takes the xml elements ,process them and returns the view
     @param inflater instantiates a layout xml into its corresponding view objects
     @param container is a special view that contains other views
     @Param savedInstanceState it is used to pass data between the aactivities
     @return returns the specified View on the inflater
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.profile, container, false);
        return view;
    }
}
