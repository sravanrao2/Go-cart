package com.example.gorcories;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.view.ScaleGestureDetector;
import android.widget.ImageView;
import android.widget.Toast;

public class ZoomImage extends ScaleGestureDetector.SimpleOnScaleGestureListener {
    private final static String zooming="Zoominng";
    private ImageView srcImageView=null;
    private Context context=null;
    public ZoomImage(Context context,ImageView srcImageView){
        this.context=context;
        this.srcImageView=srcImageView;
    }
    public boolean onScale(ScaleGestureDetector detector) {

        if(detector!=null) {

            float scaleFactor = detector.getScaleFactor();

            if (srcImageView != null) {
                scaleImage(scaleFactor, scaleFactor);

            } else {
                if (context != null) {
                    Toast.makeText(context, "context return", Toast.LENGTH_SHORT).show();
                } else {
                    Log.e(zooming, "context and image is null.");
                }
            }
        }else
        {
            Log.e(zooming, "zoom on scale params is null.");
        }

        return true;
    }
            public void scaleImage(float xScale,float yScale){
                BitmapDrawable srcBitmapDrawable=(BitmapDrawable) srcImageView.getDrawable();
                Bitmap srcBitmap=srcBitmapDrawable.getBitmap();
                int srcImageWith=srcBitmap.getWidth();
                int srcImageHeight=srcBitmap.getHeight();
                Bitmap.Config srcImageConfig=srcBitmap.getConfig();
                Bitmap scaleBitmap = Bitmap.createBitmap((int)(srcImageWith * xScale), (int)(srcImageHeight * yScale), srcImageConfig);
                Canvas scaleCanvas=new Canvas(scaleBitmap);
                Matrix scaleMatrix=new Matrix();
                scaleMatrix.setScale(xScale,yScale);
                Paint paint=new Paint();
                scaleCanvas.drawBitmap(srcBitmap,scaleMatrix,paint);
                srcImageView.setImageBitmap(scaleBitmap);

             }



}
