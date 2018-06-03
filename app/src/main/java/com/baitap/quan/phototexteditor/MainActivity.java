package com.baitap.quan.phototexteditor;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.baitap.quan.photoeditor.OnPhotoEditorListener;
import com.baitap.quan.photoeditor.PhotoEditor;
import com.baitap.quan.photoeditor.PhotoEditorView;
import com.baitap.quan.photoeditor.ViewType;
import com.baitap.quan.photoeditor.ZoomLayout;

public class MainActivity extends AppCompatActivity implements OnPhotoEditorListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    private PhotoEditor mPhotoEditor;
    private PhotoEditorView mPhotoEditorView;
    private ZoomLayout zoomlayoutGit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setContentView(R.layout.activity_main);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        initViews();

        mPhotoEditor = new PhotoEditor.Builder(this, mPhotoEditorView)
                .setPinchTextScalable(true)
                .build();
        mPhotoEditorView.getSource().setImageDrawable(getResources().getDrawable(R.drawable.img_src));
        mPhotoEditor.setOnPhotoEditorListener(this);
        mPhotoEditor.addText("Hello Quan", ContextCompat.getColor(MainActivity.this, R.color.colorPrimary));
    }

    private void initViews() {

        TextView btnSave;
        TextView btnCancel;

        zoomlayoutGit = findViewById(R.id.zoomRelativeLayout);

        zoomlayoutGit.post(new Runnable() {
            @Override
            public void run() {
                int width = zoomlayoutGit.getMeasuredWidth();
                int height = zoomlayoutGit.getMeasuredHeight();
                zoomlayoutGit.setContentSize(width, height);
            }
        });
        mPhotoEditorView = (PhotoEditorView) findViewById(R.id.photoEditorView);

        btnSave = findViewById(R.id.btnSave_ActionBar);
        btnCancel = findViewById(R.id.btnCancel_ActionBar);
    }

    @Override
    public void onEditTextChangeListener(View rootView, String text, int colorCode) {

    }

    @Override
    public void onAddViewListener(ViewType viewType, int numberOfAddedViews) {

    }

    @Override
    public void onRemoveViewListener(int numberOfAddedViews) {

    }

    @Override
    public void onStartViewChangeListener(ViewType viewType) {

    }

    @Override
    public void onStopViewChangeListener(ViewType viewType) {

    }
}
