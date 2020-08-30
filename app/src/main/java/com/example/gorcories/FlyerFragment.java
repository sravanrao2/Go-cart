package com.example.gorcories;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.Nullable;

/**
 * This fragrment is used for loading of the image in to the imageView
 */

public class FlyerFragment extends Fragment {

    View view;
    private ImageView imageView= null;
    private ScaleGestureDetector scaleGestureDetector= null;
    @Nullable
    @Override
    /**
     *This method takes the xml elements ,process them and returns the view
     @param inflater instantiates a layout xml into its corresponding view objects
     @param container is a special view that contains other views
     @Param savedInstanceState it is used to pass data between the aactivities
     @return returns the specified ImageView on the inflater
     */
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.flyer, container, false);
        imageView= view.findViewById(R.id.imageView3);
        if(scaleGestureDetector== null)
        {
            ZoomImage zoomImage= new ZoomImage(view.getContext(),imageView);
            scaleGestureDetector=new ScaleGestureDetector(view.getContext(),zoomImage);

        }
        return view;
    }
}
