package com.example.mycard;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mycard.Fragment.InitFragment;
import com.example.mycard.Fragment.MessageFragment;
import com.example.mycard.Fragment.RechargeFragment;
import static android.R.id.tabcontent;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;                 //侧滑菜单
    private NavigationView navView;                           //侧滑菜单项目

    //添加Fragment的数组,主要是为了动态的改变App,一级界面的个数,如果要添加新的模块,只需要在这里添加一个Fragment
    private Class[] fragments = new Class[]{InitFragment.class, MessageFragment.class, RechargeFragment.class};
    //为框架底部设置图片的状态选择器数组,如果需要添加新的模块,就需要添加状态选择器
    private int[] imgSelectors = new int[]{R.drawable.ic_menu, R.drawable.ic_backup, R.drawable.ic_comment};
    //为框架底部设置文本资源,如果要添加新的模块,还要在这里添加文本信息
    private String[] tabTitle = new String[]{"初始化", "信息中心", "充值中心"};


    ImageView tab_iv;
    TextView tab_tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*加载菜单主页图标*/
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
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

        //对控件初始化
        FragmentTabHost tabHost = (FragmentTabHost) findViewById(R.id.tabHost);
        //为FragmentTabHost来填充Fragment,1:上下文  2:fragment的管理器FragmentManager 3:官方要求写死的参数
        tabHost.setup(MainActivity.this, getSupportFragmentManager(),tabcontent);

        //使用FragmentTabHost去添加子标签,根据fragment集合里有多少个fragment,动态的进行添加.
        for (int x = 0; x < fragments.length; x++) {
            //把一个布局的XML资源转换为一个View的对象,第一个参数就是layout,第二个设置为空就行
            View inflate = getLayoutInflater().inflate(R.layout.nav_header, null);//注意,如果这个View对象下有子控件,就用这个控件对象去查找
            //进行控件查找
            tab_iv = (ImageView) inflate.findViewById(R.id.icon_image);
            tab_tv = (TextView) inflate.findViewById(R.id.textView);
            //为这些子控件设置图片文本资源,从对应的集合里拿
            tab_iv.setImageResource(imgSelectors[x]);
            tab_tv.setText(tabTitle[x]);
            //使用FragentTabHost去添加子标签核心代码,TabHost,newTabSpec(""+x)为每个字标签添加标识,并添加加载显示的底部view
            //第二参数为添加动态加载的fragment对象,从集合里动态的那fragment,第三个参数,给null即可;
            tabHost.addTab(tabHost.newTabSpec("" + x).setIndicator(inflate), fragments[x], null);
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
