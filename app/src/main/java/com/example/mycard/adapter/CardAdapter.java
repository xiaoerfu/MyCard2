package com.example.mycard.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mycard.R;
import com.example.mycard.bean.Card;

import java.util.List;

/**
 * Created by lijianfu on 2017/4/13.
 * 创建卡用户信息管理的adapter
 */
public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder>{
    private List<Card>mCardList;
    static  class ViewHolder extends RecyclerView.ViewHolder{
        TextView card_id;
        TextView card_balance;
        TextView owner_id;
        TextView owner_name;

        public ViewHolder(View view){
            super(view);
            card_id = (TextView)view.findViewById(R.id.card_id);
            card_balance = (TextView)view.findViewById(R.id.card_balance);
            owner_id = (TextView)view.findViewById(R.id.owner_id);
            owner_name = (TextView)view.findViewById(R.id.owner_name);
        }
    }

    public CardAdapter(List<Card>cardList){
        mCardList = cardList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_message,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Card card = mCardList.get(position);
        holder.card_id.setText(card.getCardNum());
        holder.card_balance.setText(String.valueOf(card.getCardBalance()));
        holder.owner_id.setText(card.getOwnerNum());
        holder.owner_name.setText(card.getCardOwner());
    }

    @Override
    public int getItemCount() {
        return mCardList.size();
    }
}
