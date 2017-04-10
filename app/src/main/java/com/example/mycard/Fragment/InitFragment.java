package com.example.mycard.Fragment;


import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mycard.R;
import com.example.mycard.bean.Card;

import org.litepal.tablemanager.Connector;

/**
 * A simple {@link Fragment} subclass.
 */
public class InitFragment extends Fragment {

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

        final Card card = new Card();
        init = (Button)view.findViewById(R.id.init);

        showCard = (TextView)view.findViewById(R.id.cardNum);
        ownerNum = (EditText)view.findViewById(R.id.ownerId);
        ownerName = (EditText)view.findViewById(R.id.cardOwner);

        showCard.setText("123465798");
        init.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = Connector.getDatabase();
                if (ownerNum.getText() == null && ownerName.getText() == null){
                    Toast.makeText(getActivity(),"请输入正确的数值",Toast.LENGTH_SHORT).show();
                }else {
                    card.setOwnerNum(Integer.parseInt(ownerNum.getText().toString()));
                    card.setCardOwner(ownerName.getText().toString());
                    card.save();
                    Toast.makeText(getActivity(), "你点击的初始化按钮", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }

}
