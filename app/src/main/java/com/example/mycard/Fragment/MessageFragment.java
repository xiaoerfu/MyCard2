package com.example.mycard.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


import com.example.mycard.MainActivity;
import com.example.mycard.R;
import com.example.mycard.adapter.CardAdapter;
import com.example.mycard.adapter.ListViewAdapter;
import com.example.mycard.application.MyApplication;
import com.example.mycard.bean.Card;
import com.example.mycard.gen.CardDao;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends Fragment implements View.OnClickListener{

    private View view;

    private Button findAll;

    private Button deleteAll;

    private Button singleQuery;

    private Button singleDelete;

    private EditText getName;

    private ListView listView;

    private List<Card>cardList = new ArrayList<>();

    Card card = new Card();

    private CardDao cardDao;

    public MessageFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        cardDao = MyApplication.getInstance().getSession().getCardDao();  //创建Card数据库表

        view = inflater.inflate(R.layout.fragment_message, container, false);
        initView();
        return view;
    }

    /*初始化组件*/
    private void initView(){

        findAll = (Button)view.findViewById(R.id.query_all);
        deleteAll = (Button)view.findViewById(R.id.delete_all);
        getName = (EditText) view.findViewById(R.id.editQuery);
        singleQuery = (Button) view.findViewById(R.id.single_query);
        singleDelete = (Button)view.findViewById(R.id.single_delete);
        listView = (ListView) view.findViewById(R.id.show_message);

        findAll.setOnClickListener(this);
        deleteAll.setOnClickListener(this);
        singleQuery.setOnClickListener(this);
        singleDelete.setOnClickListener(this);
    }

    /*监听控件事件*/

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.query_all:
                showAll();
                break;
            case R.id.delete_all:
                deleteAll();
                clear();
                break;
            case R.id.single_query:
                singleQueryByName(getName.getText().toString());
                getName.setText("");
                break;
            case R.id.single_delete:
                singleDelete(getName.getText().toString());
                clear();
                break;
            default:
                break;
        }
    }

    /*查询全部信息*/
    private void showAll(){
        List<Card> cards = cardDao.loadAll();
        try{
            card = cards.get(cards.size() - 1);
            if (card != null) {
                for (int i = 0; i < cards.size(); i++) {
                    Log.i("查询的数据：", cards.get(i).toString());
                }
                ListViewAdapter listViewAdapter = new ListViewAdapter(getActivity(), R.layout.user_message, cards);
                listView.setAdapter(listViewAdapter);
            }
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(getActivity(),"没有数据",Toast.LENGTH_SHORT).show();
        }
    }

    /*删除全部信息*/
    private void deleteAll(){
        cardDao.deleteAll();
//        clear();
        Log.i("删除数据完成：",card.toString());
        Toast.makeText(getActivity(),"删除数据成功",Toast.LENGTH_SHORT).show();
    }

    /*指定删除*/
    private void singleDelete(String ownerName){
        /**
         * 根据名字删除某用户
         *
         * @param name
         */
            card = cardDao.queryBuilder().where(CardDao.Properties.CardOwner.eq(ownerName)).build().unique();
            if (card != null) {
                cardDao.deleteByKey(card.getId());
                listView.setAdapter(null);
                Toast.makeText(getActivity(),"你成功删除:"+ card.getCardOwner(),Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getActivity(),"持卡人不存在",Toast.LENGTH_SHORT).show();
            }
    }

    /*指定查询*/
    private void singleQueryByName(String ownerName){
        try {
            if (card != null) {
                List<Card> cards = cardDao.queryBuilder()
                        .where(CardDao.Properties.CardOwner.eq(ownerName))
                        .build().list();
                card = cards.get(cards.size()-1);
                ListViewAdapter listViewAdapter = new ListViewAdapter(getActivity(), R.layout.user_message, cards);
                listView.setAdapter(listViewAdapter);
                Log.i("查询的数据：" , cards.toString());
            }
        }catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getActivity(), "请重新输入", Toast.LENGTH_SHORT).show();
        }
    }

    /*清除文本框*/
    private void clear(){
        getName.setText("");
        listView.setAdapter(null);
    }
}
