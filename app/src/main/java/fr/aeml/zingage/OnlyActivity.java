package fr.aeml.zingage;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class OnlyActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToogle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_only);

        //declare DrawerLayout
        DrawerLayout mDrawerLayout = (DrawerLayout) findViewById(R.id.mDrawerLayout);
        mToogle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(mToogle);
        mToogle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        /******************Webview*********************/
        WebView zoneWeb = (WebView) findViewById(R.id.zoneWeb);
        zoneWeb.setWebViewClient(new WebViewClient());

        //Declare Web View Setting
        WebSettings webSettings = zoneWeb.getSettings();

        //Alter settings Web View
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAppCacheEnabled(true);
        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
        webSettings.setDomStorageEnabled(true);
        webSettings.setBuiltInZoomControls(false);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);


        zoneWeb.loadUrl("http://192.168.25.1/zingage/");

        CookieManager.getInstance().setAcceptCookie(true);
        CookieSyncManager.createInstance(zoneWeb.getContext());

        /******************Side Bar*********************/

        NavigationView mNavigationView = (NavigationView) findViewById(R.id.menuView);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem){
                DrawerLayout mDrawerLayout = (DrawerLayout) findViewById(R.id.mDrawerLayout);
                WebView zoneWeb = (WebView) findViewById(R.id.zoneWeb);
                switch (menuItem.getItemId()){
                    case(R.id.accueil):
                        zoneWeb.loadUrl("http://192.168.25.1/zingage/");
                        break;
                    case(R.id.depart):
                        zoneWeb.loadUrl("http://192.168.25.1/zingage/depart");
                        break;
                    case(R.id.retour):
                        zoneWeb.loadUrl("http://192.168.25.1/zingage/retour");
                        break;
                    case(R.id.historique):
                        zoneWeb.loadUrl("http://192.168.25.1/zingage/scan");
                        break;
                    case(R.id.article):
                        zoneWeb.loadUrl("http://192.168.25.1/zingage/article");
                        break;
                    case(R.id.profil):
                        zoneWeb.loadUrl("http://192.168.25.1/zingage/profil");
                        break;
                    case(R.id.administration):
                        zoneWeb.loadUrl("http://192.168.25.1/zingage/administration");
                        break;
                    case(R.id.deconnexion):
                        zoneWeb.loadUrl("http://192.168.25.1/zingage/deconnexion");
                        break;
                }
                mDrawerLayout.closeDrawer(Gravity.START);
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        if(mToogle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}



