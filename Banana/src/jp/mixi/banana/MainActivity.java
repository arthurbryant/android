package jp.mixi.banana;

import android.os.Bundle;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import jp.mixi.banana.menu.MenuHandlerHelper;

public class MainActivity extends Activity {

	MenuHandlerHelper menuHandlerHelper = new MenuHandlerHelper();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu_recommends:
			//menuHandlerHelper.recommendHandler(getApplicationContext());
			Intent intent = new Intent(this, RecommendActivity.class);
			startActivity(intent);
			break;
		case R.id.menu_settings:
			Toast.makeText(getApplicationContext(), "settings", Toast.LENGTH_SHORT).show();
			break;
		case R.id.menu_test:
			Intent intentTest = new Intent(this, WebViewActivity.class);
			startActivity(intentTest);
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
	public void sendChoose(View view) {
		EditText editText1 = (EditText)findViewById(R.id.editText1);
		String iyada1 = editText1.getText().toString();
		EditText editText2 = (EditText)findViewById(R.id.editText2);
		String iyada2 = editText2.getText().toString();
		Intent intent = new Intent(this, WebViewActivity.class);
		intent.putExtra("iyada1", iyada1);
		intent.putExtra("iyada2", iyada2);
	}
}
