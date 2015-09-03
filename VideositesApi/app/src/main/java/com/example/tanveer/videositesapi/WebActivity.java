package com.example.tanveer.videositesapi;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;


import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;


public class WebActivity extends Activity {
    private WebView webView;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        webView = (WebView) findViewById(R.id.webView1);

        webView.loadUrl(getIntent().getExtras().getString("uri"));
        webView.getSettings().setJavaScriptEnabled(true);

        webView.setWebViewClient(new webCont());


        backButton = (Button) findViewById(R.id.back_btn);
        backButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                webView.goBack();
            }
        });

        webView.requestFocus(View.FOCUS_DOWN);
        webView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                    case MotionEvent.ACTION_UP:
                        if (!v.hasFocus()) {
                            v.requestFocus();
                        }
                        break;
                }
                return false;
            }
        });
    }

    class webCont extends WebViewClient
    {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {

            super.onPageStarted(view, url, favicon);
            findViewById(R.id.progressBar).setVisibility(View.VISIBLE);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            findViewById(R.id.progressBar).setVisibility(View.GONE);
            view.getSettings().setBuiltInZoomControls(true);
            view.getSettings().setSupportZoom(true);
            view.getSettings().setUseWideViewPort(true);
            view.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

}