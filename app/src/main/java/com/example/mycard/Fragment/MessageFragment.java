package com.example.mycard.Fragment;


import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.mycard.MainActivity;
import com.example.mycard.NavigationActivity;
import com.example.mycard.R;
import com.example.mycard.bean.Card;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends Fragment {

    private Button findAll;
    private TextView showMessage;

    Card card = new Card();

    public MessageFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_message, container, false);

        findAll = (Button)view.findViewById(R.id.queryAll);
        showMessage = (TextView)view.findViewById(R.id.showMessage);

//        List<Card> cards = DataSupport.findAll(Card.class);
        card.setCardOwner("李坚富");
        card.setOwnerNum(132);
        card.setCardBalance(1.1);
        showMessage.setText(card.toString());
        return view;
    }

//    public void changeText(){
//        showMessage.setText("1321321");
//    }

//    @Override
//    public void onAttach(Activity activity) {
//        super.onAttach(activity);
//    }
}
