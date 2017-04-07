package com.example.mycard;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

import com.example.mycard.Fragment.TabDb;

public class MainActivity extends AppCompatActivity implements TabHost.OnTabChangeListener {

    private DrawerLayout mDrawerLayout;                 //侧滑菜单
    private NavigationView navView;                           //侧滑菜单项目
    private FragmentTabHost tabHost;                        //导航栏

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*加载菜单主页图标*/
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        }

        /*初始化侧滑*/
        navView = (NavigationView)findViewById(R.id.nav_view);
        navView.setCheckedItem(R.id.nav_call);

        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                mDrawerLayout.closeDrawers();
                return true;
            }
        });

        /*初始化底部导航栏*/
        tabHost=(FragmentTabHost)super.findViewById(android.R.id.tabhost);
        tabHost.setup(this,super.getSupportFragmentManager()
                ,R.id.contentLayout);
        tabHost.getTabWidget().setDividerDrawable(null);
        tabHost.setOnTabChangedListener(this);
        initTab();
    }

    /*导航栏*/
    private void initTab(){
        String tabs[]= TabDb.getTabsTxt();
        for(int i=0;i<tabs.length;i++){
            TabHost.TabSpec tabSpec=tabHost.newTabSpec(tabs[i]).setIndicator(getTabView(i));
            tabHost.addTab(tabSpec,TabDb.getFragments()[i],null);
            tabHost.setTag(i);
        }
    }
    private View getTabView(int idx){
        View view= LayoutInflater.from(this).inflate(R.layout.fragment_tab,null);
        ((TextView)view.findViewById(R.id.tvTab)).setText(TabDb.getTabsTxt()[idx]);
        if(idx==0){
            ((TextView)view.findViewById(R.id.tvTab)).setTextColor(Color.argb(255,233,92,57));
            ((ImageView)view.findViewById(R.id.ivImg)).setImageResource(TabDb.getTabsImgLight()[idx]);
        }else{
            ((ImageView)view.findViewById(R.id.ivImg)).setImageResource(TabDb.getTabsImg()[idx]);
        }
        return view;
    }

    @Override
    public void onTabChanged(String tabId) {
        // TODO Auto-generated method stub
        updateTab();
    }
    private void updateTab(){
        TabWidget tabw=tabHost.getTabWidget();
        for(int i=0;i<tabw.getChildCount();i++){
            View view=tabw.getChildAt(i);
            ImageView iv=(ImageView)view.findViewById(R.id.ivImg);
            if(i==tabHost.getCurrentTab()){
                ((TextView)view.findViewById(R.id.tvTab)).setTextColor(Color.argb(255,233,92,57));
                iv.setImageResource(TabDb.getTabsImgLight()[i]);
            }else{        ((TextView)view.findViewById(R.id.tvTab)).setTextColor(getResources().getColor(R.color.colorPrimary));
                iv.setImageResource(TabDb.getTabsImg()[i]);
            }

        }
    }

    /*主菜单按钮的事件监听*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            default:
                break;
        }
        return true;
    }
}
