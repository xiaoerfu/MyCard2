package com.example.mycard.adapter;

/**
 * Created by lijianfu on 2017/4/14.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.mycard.R;
import com.example.mycard.bean.Card;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by lijianfu on 2017/4/12.
 * 用户适配器
 */
public class ListViewAdapter extends ArrayAdapter<Card> {

    private int resourceId;

    public ListViewAdapter (Context context, int textViewResourceId,
                        List<Card> cards){
        super(context,textViewResourceId,cards);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Card card = getItem(position);
        View view;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        }else {
            view = convertView;
        }
        TextView cardId = (TextView)view.findViewById(R.id.card_id);
        TextView cardBalance = (TextView)view.findViewById(R.id.card_balance);
        TextView ownerId = (TextView)view.findViewById(R.id.owner_id);
        TextView ownerName = (TextView)view.findViewById(R.id.owner_name);
        cardId.setText(card.getCardNum());
        cardBalance.setText(String.valueOf(card.getCardBalance()));
        ownerId.setText(card.getOwnerNum());
        ownerName.setText(card.getCardOwner());
        return view;
    }
}

