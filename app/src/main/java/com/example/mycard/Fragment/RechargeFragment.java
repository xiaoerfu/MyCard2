package com.example.mycard.Fragment;


import android.content.ContentValues;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mycard.R;
import com.example.mycard.adapter.CardAdapter;
import com.example.mycard.application.MyApplication;
import com.example.mycard.bean.Card;
import com.example.mycard.gen.CardDao;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class RechargeFragment extends Fragment {

    private CardDao cardDao;

    Card card = new Card();

    private List<Card> cardList = new ArrayList<>();

    private EditText rechargeObject;
    private EditText editMoney;
    private EditText editOwnerId;
    private Button recharge;
    private Button value_chains;

    public RechargeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recharge, container, false);

        cardDao = MyApplication.getInstance().getSession().getCardDao();  //创建Card数据库表

        rechargeObject = (EditText) view.findViewById(R.id.card_owner);
        editMoney = (EditText) view.findViewById(R.id.recharge_money);
        editOwnerId = (EditText) view.findViewById(R.id.ownerId);

        recharge = (Button) view.findViewById(R.id.recharge);
        value_chains = (Button)view.findViewById(R.id.value_chains);


        recharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateCard(rechargeObject.getText().toString(),editOwnerId.getText().toString());
            }
        });

        value_chains.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update_Card(rechargeObject.getText().toString(),editOwnerId.getText().toString());
            }
        });
        return view;
    }

    /*更新数据表格充值哦*/
    private void updateCard(String ownerName,String ownerId) {
            /*指定更新*/
        Card card=cardDao.queryBuilder()
                .where(CardDao.Properties.CardOwner.eq(ownerName),CardDao.Properties.OwnerNum.eq(ownerId))
                .build().unique();
            if(card != null){
                card.setCardBalance(card.getCardBalance() + Double.parseDouble(editMoney.getText().toString()));
                cardDao.update(card);
                clear();
                Toast.makeText(getActivity(),"充值成功",Toast.LENGTH_SHORT).show();
                Log.i("数据库内容", "" + card.toString());
            }else{
                Toast.makeText(getActivity(),"充值失败",Toast.LENGTH_SHORT).show();
            }
    }

    /*更新数据表格扣值哦*/
    private void update_Card(String ownerName,String ownerId) {
            /*指定更新*/
        Card card=cardDao.queryBuilder()
                .where(CardDao.Properties.CardOwner.eq(ownerName),CardDao.Properties.OwnerNum.eq(ownerId))
                .build().unique();
        if(card != null){
            Double dou = card.getCardBalance() - Double.parseDouble(editMoney.getText().toString());
            dou = (double)Math.round(dou*100)/100;
            card.setCardBalance(dou);
            cardDao.update(card);
            clear();
            Toast.makeText(getActivity(),"扣值成功",Toast.LENGTH_SHORT).show();
            Log.i("数据库内容", "" + card.toString());
        }else{
            Toast.makeText(getActivity(),"扣值失败",Toast.LENGTH_SHORT).show();
        }
    }

    /*清除输入的信息*/
    private void clear(){
        rechargeObject.setText("");
        editMoney.setText("");
        editOwnerId.setText("");
    }
}
