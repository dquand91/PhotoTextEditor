package com.baitap.quan.phototexteditor;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import com.baitap.quan.photoeditor.PhotoEditor;
import com.baitap.quan.photoeditor.PhotoEditorView;

public class EdittextFragment extends Fragment {

	private View view;
	private PhotoEditor mPhotoEditor;
	private PhotoEditorView mPhotoEditorView;
	private TextView btnSave_edit;
	private TextView btnCancel_edit;


	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

		view = inflater.inflate(R.layout.editext_fragment, container, false);
		btnSave_edit = view.findViewById(R.id.btnSave_ActionBar);
		btnCancel_edit = view.findViewById(R.id.btnCancel_ActionBar);

		btnCancel_edit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				getFragmentManager().popBackStack();
				hideKeyboard(getActivity());

			}
		});

		mPhotoEditorView = view.findViewById(R.id.photoEditorView);
		mPhotoEditor = new PhotoEditor.Builder(getActivity().getBaseContext(), mPhotoEditorView)
				.setPinchTextScalable(true) // set flag to make text scalable when pinch
				//.setDefaultTextTypeface(mTextRobotoTf)
				//.setDefaultEmojiTypeface(mEmojiTypeFace)
				.build(); // build photo editor sdk
		mPhotoEditor.addText("Double tap to edit", getResources().getColor(R.color.red_color_picker));

		view.setFocusableInTouchMode(true);
		if(mPhotoEditor.getTextInputTv().requestFocus()) {
			getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
		}
		return view;
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		showKeyboard(getActivity().getBaseContext());
	}

	public static void hideKeyboard(Context context) {
		try {
			((Activity) context).getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
			if ((((Activity) context).getCurrentFocus() != null) && (((Activity) context).getCurrentFocus().getWindowToken() != null)) {
				((InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(((Activity) context).getCurrentFocus().getWindowToken(), 0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void showKeyboard(Context context) {
		((InputMethodManager) (context).getSystemService(Context.INPUT_METHOD_SERVICE)).toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
	}
}
