package com.baitap.quan.phototexteditor;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
    private EdittextFragment edittextFragment;

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
        ImageView btnText_bottomBar;

        bottomBar = findViewById(R.id.constraintTools_first);
		btnText_bottomBar = bottomBar.findViewById(R.id.imgText);

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

        btnText_bottomBar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(MainActivity.this, "BBBB", Toast.LENGTH_SHORT).show();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                EdittextFragment hello = new EdittextFragment();
                fragmentTransaction.add(R.id.container_main_screen, hello, "HELLO");
                fragmentTransaction.addToBackStack("HELLO");
                fragmentTransaction.commit();
			}
		});

        btnSave = findViewById(R.id.btnSave_ActionBar);
        btnCancel = findViewById(R.id.btnCancel_ActionBar);
        btnSave.setEnabled(false);
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() == 0) {
            this.finish();
        } else {
            getFragmentManager().popBackStack();
        }
    }
}
