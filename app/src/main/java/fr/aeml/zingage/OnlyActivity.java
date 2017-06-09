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

        //Declare Web View
        WebView zoneWeb = (WebView) findViewById(R.id.zoneWeb);
        zoneWeb .setWebViewClient(new WebViewClient());
        zoneWeb.getSettings().setLoadWithOverviewMode(true);
        zoneWeb.getSettings().setUseWideViewPort(true);

        //Change Web View setting
        WebSettings webSettings = zoneWeb.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        webSettings.setDomStorageEnabled(true);
        webSettings.setDatabaseEnabled(true);
        webSettings.setAppCacheEnabled(true);

        zoneWeb.loadUrl("http://192.168.0.20/zingage/");
    }
}
