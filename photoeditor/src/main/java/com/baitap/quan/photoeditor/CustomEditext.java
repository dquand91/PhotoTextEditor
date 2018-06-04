package com.baitap.quan.photoeditor;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.EditText;

@SuppressLint("AppCompatCustomView")
public class CustomEditext extends EditText {

	public CustomEditext(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean onKeyPreIme(int keyCode, KeyEvent event) {
		// Do not hide keyboard when back pressed
//		Log.e("Log", "onKeyPreIme");
		return true;
		//return super.onKeyPreIme(keyCode, event);
	}
}
