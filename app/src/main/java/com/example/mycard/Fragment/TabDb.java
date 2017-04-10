package com.example.mycard.Fragment;

import com.example.mycard.R;

/**
 * Created by lijianfu on 2017/4/6.
 * 导航栏的管理
 */
public class TabDb {

    public static String[] getTabsTxt(){
        String[] tabs={"初始化","信息中心","充值中心"};
        return tabs;
    }
    public static int[] getTabsImg(){
        int[] ids={R.drawable.news,R.drawable.news, R.drawable.news};
        return ids;
    }
    public static int[] getTabsImgLight(){
        int[] ids={R.drawable.news,R.drawable.news,R.drawable.news};
        return ids;
    }
    public static Class[] getFragments(){
        Class[] clz={InitFragment.class,MessageFragment.class,RechargeFragment.class};
        return clz;
    }
}
