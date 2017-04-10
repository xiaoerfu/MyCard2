package com.example.mycard;

import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.mycard.Fragment.MessageFragment;

public class NavigationActivity extends FragmentActivity {

    private MessageFragment messageFragment;

    private TextView showMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

//        messageFragment = new MessageFragment();
//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.fragment_message,messageFragment).commit();
//        messageFragment.changeText();
    }

//    public void onAttachFragment(Fragment fragment) {
//        super.onAttachFragment(fragment);
//    }
}
