package jp.mixi.banana;

import android.os.Bundle;
import android.webkit.HttpAuthHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import android.app.Activity;


public class WebViewActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.web_view);
		
		String iyada1, iyada2;
		Bundle extra = getIntent().getExtras();
		if(extra != null) {
			iyada1 = extra.getString("iyada1");
			iyada2 = extra.getString("iyada2");
		}
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

}
