package com.baitap.quan.phototexteditor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.baitap.quan.photoeditor.CustomImageView.OnSingleTapListener;
import com.baitap.quan.photoeditor.CustomImageView.ZoomageView;
import com.baitap.quan.photoeditor.PhotoEditor;
import com.baitap.quan.photoeditor.PhotoEditorView;
import com.baitap.quan.photoeditor.ZoomLayout;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private PhotoEditor mPhotoEditor;
    private PhotoEditorView mPhotoEditorView;
    private ZoomLayout zoomlayoutGit;
    private ZoomageView zoomImageView;
    private View bottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_main_screen);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        initViews();
    }

    private void initViews() {

        TextView btnSave;
        TextView btnCancel;

        bottomBar = findViewById(R.id.constraintTools_first);

        zoomImageView = findViewById(R.id.zoomImageView_first);
        zoomImageView.setImageDrawable(getResources().getDrawable(R.drawable.img_src));

        zoomImageView.setOnSingleTapListener(new OnSingleTapListener() {
            @Override
            public void onSingleTap() {
                if(bottomBar.getVisibility() == View.VISIBLE){
                    bottomBar.setVisibility(View.GONE);
                } else {
                    bottomBar.setVisibility(View.VISIBLE);
                }
            }
        });

        btnSave = findViewById(R.id.btnSave_ActionBar);
        btnCancel = findViewById(R.id.btnCancel_ActionBar);
        btnSave.setEnabled(false);
    }
}
