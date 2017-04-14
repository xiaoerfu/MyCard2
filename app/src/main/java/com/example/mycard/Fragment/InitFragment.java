package com.example.mycard.Fragment;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mycard.R;
import com.example.mycard.application.MyApplication;
import com.example.mycard.bean.Card;
import com.example.mycard.bean.User;
import com.example.mycard.gen.CardDao;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class InitFragment extends Fragment {

    private List<Card> cardList = new ArrayList<>();

    public CardDao cardDao;

    private Card card;

    private Button init;

    private TextView showCard;

    private EditText ownerNum;

    private EditText ownerName;

    public InitFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_init, container, false);

        cardDao = MyApplication.getInstance().getSession().getCardDao();  //创建Card数据库表

        init = (Button)view.findViewById(R.id.init);

        showCard = (TextView)view.findViewById(R.id.cardNum);
        ownerNum = (EditText)view.findViewById(R.id.ownerId);
        ownerName = (EditText)view.findViewById(R.id.cardOwner);

        init.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertCard(ownerNum.getText().toString(),ownerName.getText().toString());
                Toast.makeText(getActivity(),"初始化成功",Toast.LENGTH_SHORT).show();
                showCard.setText(card.getCardNum());
                clear();
                }
        });
        return view;
    }

    private void insertCard(String ownerNum,String ownerName){
        card = new Card();
        card.setOwnerNum(ownerNum);
        card.setCardOwner(ownerName);
        cardDao.insert(card);
        Log.i("插入的数据为：","----------------"+ card.toString());
    }

    private void clear(){
        ownerName.setText("");
        ownerNum.setText("");
    }

}
