package com.baitap.quan.phototexteditor;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
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
//				Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                FragmentManager fragmentManager = getFragmentManager();
                EdittextFragment hello = new EdittextFragment();
                addFragmentOnlyOnce(fragmentManager, hello, "HELLO");
			}
		});

        btnSave = findViewById(R.id.btnSave_ActionBar);
        btnCancel = findViewById(R.id.btnCancel_ActionBar);
        btnSave.setEnabled(false);
    }

	public static void addFragmentOnlyOnce(FragmentManager fragmentManager, EdittextFragment fragment, String tag) {
        // Make sure the current transaction finishes first
        fragmentManager.executePendingTransactions();

        // If there is no fragment yet with this tag...
        if (fragmentManager.findFragmentByTag(tag) == null) {
            // Add it
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.add(R.id.container_main_screen, fragment, "HELLO");
            transaction.addToBackStack("HELLO");
            transaction.commit();
        }
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() == 0) {
            this.finish();
        } else {
            getFragmentManager().popBackStack();
            EdittextFragment.hideKeyboard(MainActivity.this);
        }
    }
}
