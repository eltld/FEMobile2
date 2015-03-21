package com.feunju.edu.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.feunju.edu.R;
import com.feunju.edu.adapter.FullScreenImageAdapter;
import com.feunju.edu.util.UtilPage;

/**
 * Created by MITO on 20/03/2015.
 */
public class FullScreenViewActivity extends Activity {


    private UtilPage utils;
    private FullScreenImageAdapter adapter;
    private ViewPager viewPager;
    Button btnEdit;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery_image_fullscreen);

        viewPager = (ViewPager) findViewById(R.id.pager);
        utils = new UtilPage(getApplicationContext());
        Intent i = getIntent();
        int position = i.getIntExtra("position", 0);
        Uri imageFileUri = i.getData();
        adapter = new FullScreenImageAdapter(FullScreenViewActivity.this,
                utils.getFilePaths());
        viewPager.setAdapter(adapter);
      // displaying selected image first
        viewPager.setCurrentItem(position);
    }

    public boolean onTouch(View arg0, MotionEvent arg1) {
        return false;
    }
}
