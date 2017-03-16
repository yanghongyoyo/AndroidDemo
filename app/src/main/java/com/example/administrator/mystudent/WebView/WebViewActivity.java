package com.example.administrator.mystudent.WebView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.administrator.mystudent.R;

public class WebViewActivity extends AppCompatActivity {
    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        setWebView();
    }

    private void setWebView() {
        mWebView= (WebView) findViewById(R.id.webView);
        mWebView.loadUrl("http://www.baidu.com");
        //覆盖WebView默认使用第三方或系统默认浏览器打开网页的行为，使网页用WebView打开
        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                view.loadUrl(url);
                return true;
            }
        });
        //设置可以可以使用JavaScript
        WebSettings webSet=mWebView.getSettings();
        webSet.setJavaScriptEnabled(true);

        //在webView中打开链接
        mWebView.setWebViewClient(new WebViewClient());
    }
}
