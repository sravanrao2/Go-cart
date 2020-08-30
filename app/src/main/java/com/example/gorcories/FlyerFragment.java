package com.example.gorcories;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.Nullable;

public class FlyerFragment extends Fragment {

    View view;
    private ImageView imageView= null;
    private ScaleGestureDetector scaleGestureDetector= null;
    @Nullable
    @Override
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
