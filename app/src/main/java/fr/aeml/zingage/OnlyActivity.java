package fr.aeml.zingage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class OnlyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_only);
        WebView zoneWeb = (WebView) findViewById(R.id.zoneWeb);
        zoneWeb .setWebViewClient(new WebViewClient());
        zoneWeb.getSettings().setLoadWithOverviewMode(true);
        zoneWeb.getSettings().setUseWideViewPort(true);
        WebSettings webSettings = zoneWeb.getSettings();
        webSettings.setJavaScriptEnabled(true);
        zoneWeb.loadUrl("http://192.168.0.20/zingage/");
    }
}
