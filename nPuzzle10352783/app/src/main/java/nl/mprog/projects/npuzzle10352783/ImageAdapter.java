package nl.mprog.projects.npuzzle10352783;

/**
 * ImageAdapter.java
 * This file fills the grid view.
 *
 * Name: Julian Ruger
 * Student ID: 10352783
 * E-mail: julian.ruger@student.uva.nl
 *
 */
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private List<Item> items = new ArrayList<Item>();
    private LayoutInflater inflater;
    public Bitmap[] images;


    // Constructor
    public ImageAdapter(Context c, Bitmap[] image) {
        mContext = c;
        inflater = LayoutInflater.from(c);

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

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        /*View v = convertView;
        ImageView picture;
        TextView name;

        if(v == null)
        {
            v = inflater.inflate(R.layout.gridview_item, parent, false);
            v.setTag(R.id.picture, v.findViewById(R.id.picture));

        }

        picture = (ImageView)v.getTag(R.id.picture);


        //Item item = (Item)getItem(position);
        picture.setImageBitmap(images[position]);


        return v;*/
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(130, 130));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setPadding(0, 0, 0, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageBitmap(images[position]);
        return imageView;
    }



    private class Item
    {
        final String name;
        final int drawableId;

        Item(String name, int drawableId)
        {
            this.name = name;
            this.drawableId = drawableId;
        }
    }
}
