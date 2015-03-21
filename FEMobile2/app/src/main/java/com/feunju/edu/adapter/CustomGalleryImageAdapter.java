package com.feunju.edu.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.feunju.edu.R;
import com.feunju.edu.activity.FullScreenViewActivity;
import com.feunju.edu.json.GalleryImage;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import java.util.ArrayList;

/**
 * Created by David Garcia on 19/03/2015.
 */
public class CustomGalleryImageAdapter extends ArrayAdapter<GalleryImage> {

    private Activity _activity;
    private ArrayList<GalleryImage> listData = new ArrayList<GalleryImage>();
    Context myContext;
    DisplayImageOptions options;
    int resourceId;
    LayoutInflater layoutInflater;
    ArrayList<String> data;
    ImageLoader imageLoader;
    String[] imageUrls;



    public CustomGalleryImageAdapter(Context context, ImageLoader imageLoader,DisplayImageOptions options,ArrayList<GalleryImage> listData)
    {
        super(context,0,listData);

        imageUrls=new String[listData.size()];

        for(int i=0; i<listData.size();i++)
        {
            GalleryImage gallery=listData.get(i);
            imageUrls[i]=listData.get(i).getGALERIA_URL();
        }

        this.myContext=context;
        this.imageLoader=imageLoader;
        this.options=options;
        this.layoutInflater=LayoutInflater.from(this.myContext);
    }




    @Override
    public int getCount() {
        return imageUrls.length;
    }



    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final ViewHolder holder;
        View view = convertView;
        if (view == null) {
            view =layoutInflater.inflate(R.layout.gallery_image_single, parent, false);
            holder = new ViewHolder();
            assert view != null;
            holder.imageView = (ImageView) view.findViewById(R.id.image);
            holder.progressBar = (ProgressBar) view.findViewById(R.id.progress);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        System.out.println("imageUrls[positiont ]: "+imageUrls[position]);
        imageLoader.displayImage(imageUrls[position], holder.imageView, options, new SimpleImageLoadingListener() {
                    @Override
                    public void onLoadingStarted(String imageUri, View view) {
                        holder.progressBar.setProgress(0);
                        holder.progressBar.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onLoadingFailed(String imageUri, View view,
                                                FailReason failReason) {
                        holder.progressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                        holder.progressBar.setVisibility(View.GONE);
                        holder.imageView.setOnClickListener(new OnImageClickListener(position));
                    }
                }, new ImageLoadingProgressListener() {
                    @Override
                    public void onProgressUpdate(String imageUri, View view, int current,
                                                 int total) {
                        holder.progressBar.setProgress(Math.round(100.0f * current / total));
                    }
                }
        );


        System.out.println("position : "+position);
        holder.imageView.setOnClickListener(new OnImageClickListener(position));

        return view;

    }

    static class ViewHolder {
        ImageView imageView;
        ProgressBar progressBar;
    }

    class OnImageClickListener implements View.OnClickListener {

        int _postion;

        // constructor
        public OnImageClickListener(int position) {
            this._postion = position;
        }

        @Override
        public void onClick(View v) {
            // on selecting grid view image
            // launch full screen activity
            System.out.println("onClick  :"+_postion);
            Intent i = new Intent(getContext(), FullScreenViewActivity.class);
            i.putExtra("position", _postion);
            getContext().startActivity(i);
        }
    }

}







