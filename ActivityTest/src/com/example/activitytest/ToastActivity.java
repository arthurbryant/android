package com.example.activitytest;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

public class ToastActivity extends Activity {
	protected void onCreate() {
		Intent intent = getIntent();
		String name = intent.getStringExtra("name");
		int age = intent.getIntExtra("age", 20);
		Toast.makeText(getApplicationContext(), name, Toast.LENGTH_SHORT).show();
		Toast.makeText(getApplicationContext(), Integer.toString(age), Toast.LENGTH_SHORT).show();
	}
}
