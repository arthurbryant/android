package com.example.activitytest;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {
	private final static String TAG = MainActivity.class.getSimpleName();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Intent intent = new Intent(MainActivity.this, ToastActivity.class);
		intent.putExtra("name", "arthur");
		intent.putExtra("age", 28);
		startActivity(intent);
	}

	@Override
	protected void onStart() {
		Log.e(TAG, "onStart");
		super.onStart();
	}
	@Override
	protected void onPause() {
		Log.e(TAG, "onPause");
		super.onPause();
	}
	@Override
	protected void onResume() {
		Log.e(TAG, "onResume");
		super.onResume();
	}
	@Override
	protected void onStop() {
		Log.e(TAG, "onStop");
		super.onStop();
	}
	@Override
	protected void onDestroy() {
		Log.e(TAG, "onDestory");
		super.onDestroy();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
