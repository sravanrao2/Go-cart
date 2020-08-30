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

/**
 * This fragrment mainly aims at zooming in and zooming out of the imageView
 */

public class ZoomImage extends ScaleGestureDetector.SimpleOnScaleGestureListener {
    private final static String zooming="Zoominng";
    private ImageView srcImageView=null;
    private Context context=null;

    /**
     * This method is a constructor of the class
     * @param context it provides services like obtaining access to databases and Preferences
     * @param srcImageView this is used for displaying the images
     */
    public ZoomImage(Context context,ImageView srcImageView){
        this.context=context;
        this.srcImageView=srcImageView;
    }

    /**
     * This method helps in detecting the scale size
     * depending on that it gives us the boolean type true or false
     * @param detector  detects scaling transformation gestures using the supplied MotionEvent
     * @return this would return the boolean type true or fals for the given detected scale
     */
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

    /**
     * This method sets the dimensions to the imageView given
     * @param xScale this defines value of image on the x-axs
     * @param yScale this defines the value of image on the y-axis
     */
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
