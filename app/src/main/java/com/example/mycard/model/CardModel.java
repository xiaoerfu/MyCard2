package com.example.mycard.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.mycard.R;
import com.example.mycard.bean.Card;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

/**
 * Created by lijianfu on 2017/4/7.
 */
public class CardModel implements ICardModel{

    private Context context;

    SQLiteDatabase cardDb = Connector.getDatabase();

    @Override
    public void handler(int num, Context context, Class<?> modelClass, ContentValues values,long id) {
            this.context = context;
        if (cardDb == null){
            cardDb = Connector.getDatabase();
        }

        switch (num){
            case R.id.init:
//                DataSupport.update(Card.class,values,id);
                showMake("初始化成功");
                break;
            case R.id.queryAll:
                showMake("查询完成");
                break;
            case R.id.singleQuery:
                showMake("查询完成");
                break;
            case R.id.singleDelete:
                DataSupport.delete(Card.class,id);
                showMake("删除单个");
                break;
            case R.id.recharge:
                DataSupport.update(Card.class,values,id);
                showMake("充值成功");
                break;
            default:
                break;
        }
    }

    /*显示提示内容*/
    private void showMake(String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}
