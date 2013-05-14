package jp.mixi.banana;

import android.os.Bundle;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.HttpAuthHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import jp.mixi.banana.menu.MenuHandlerHelper;

public class MainActivity extends Activity {

	MenuHandlerHelper menuHandlerHelper = new MenuHandlerHelper();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		WebView webView = (WebView) findViewById(R.id.webView);
		webView.setWebViewClient(new MyWebViewClient());
		webView.loadUrl("http://kakitasi.com:3877/");
		//webView.loadUrl("http://www.yahoo.co.jp");
	}

	private class MyWebViewClient extends WebViewClient {
		@Override
		public void onReceivedHttpAuthRequest(WebView view,
		    HttpAuthHandler handler, String host, String realm) {
		    	handler.proceed("guest", "bananana");
		}
		@Override
		public void onReceivedError(WebView webView, int errorCode, String description, String failingUrl) {
			System.out.println(errorCode);
		}
	};
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
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
