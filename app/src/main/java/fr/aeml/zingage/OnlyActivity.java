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
        zoneWeb.setWebViewClient(new WebViewClient());

        //Declare Web View Setting
        WebSettings webSettings = zoneWeb.getSettings();

        //Alter settings Web View
        webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webSettings.setAppCacheEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setBuiltInZoomControls(false);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);


        zoneWeb.loadUrl("http://192.168.0.20/zingage/");
    }
}
