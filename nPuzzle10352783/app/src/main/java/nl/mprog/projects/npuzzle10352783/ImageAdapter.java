package nl.mprog.projects.npuzzle10352783;

/**
 * ImageAdapter.java
 * This class fills the grid view.
 *
 * Name: Julian Ruger
 * Student ID: 10352783
 * E-mail: julian.ruger@student.uva.nl
 *
 */
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;


public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    public Bitmap[] images;


    /* Constructor */
    public ImageAdapter(Context c, Bitmap[] image) {
        mContext = c;

        images = image;

    }

    public int getCount() {
        return images.length;
    }

    public Object getItem(int position) {
        return images[position];
    }

    public long getItemId(int position) {
        return 0;
    }

    /* create a new ImageView for each item referenced by the Adapter */
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(130, 130));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageBitmap(images[position]);
        return imageView;
    }

}
