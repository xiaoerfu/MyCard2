package com.example.mycard.model;

import android.content.ContentValues;
import android.content.Context;

/**
 * Created by lijianfu on 2017/4/7.
 */
public interface ICardModel {

    public void handler(int num, Context context, Class<?> modelClass, ContentValues values, long id);

}
