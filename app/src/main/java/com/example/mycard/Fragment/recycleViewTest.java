//package com.example.mycard.Fragment;
//
//import android.support.v7.widget.DefaultItemAnimator;
//import android.support.v7.widget.DividerItemDecoration;
//import android.support.v7.widget.LinearLayoutManager;
//import android.util.Log;
//import android.widget.Toast;
//
//import com.example.mycard.R;
//import com.example.mycard.adapter.CardAdapter;
//import com.example.mycard.adapter.ListViewAdapter;
//import com.example.mycard.bean.Card;
//import com.example.mycard.gen.CardDao;
//
//import java.util.List;
//
///**
// * Created by lijianfu on 2017/4/17.
// */
//public class recycleViewTest {
//    /*查询全部信息*/
//    private void showAll(){
////        try {
////            List<Card> cards = cardDao.loadAll();
////            card = cards.get(cards.size() - 1);
////            if (card != null) {
////                cardList.addAll(cards);
////                LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
////                recyclerView.setLayoutManager(layoutManager);
////                CardAdapter adapter = new CardAdapter(cardList);
////                recyclerView.setAdapter(adapter);
////                recyclerView.removeAllViews();
////
////                Log.i("全部数据：", "--------------------" + cardList);
////                //设置Item增加、移除动画
////                recyclerView.setItemAnimator(new DefaultItemAnimator());
////                //添加分割线
////                recyclerView.addItemDecoration(new DividerItemDecoration(
////                        getActivity(), DividerItemDecoration.VERTICAL));
////            }
////        }catch (Exception e){
////            e.printStackTrace();
////            Toast.makeText(getActivity(),"没有数据",Toast.LENGTH_SHORT).show();
////        }
//        List<Card> cards = cardDao.loadAll();
//        try{
//            card = cards.get(cards.size() - 1);
//            if (card != null) {
//                for (int i = 0; i < cards.size(); i++) {
//                    Log.i("查询的数据：", cards.get(i).toString());
////                    show.setText(users.toString());
////                    user.getId();
////                    user.getName();
////                    user.getPassword();
////                    users.add(user);
//                }
//                ListViewAdapter listViewAdapter = new ListViewAdapter(getActivity(), R.layout.user_message, cards);
//                lv.setAdapter(userAdapter);
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//            Toast.makeText(getApplicationContext(),"没有数据",Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    /*删除全部信息*/
//    private void deleteAll(){
//        cardDao.deleteAll();
//        recyclerView.setAdapter(null);
//        Log.i("删除数据完成：",card.toString());
//        Toast.makeText(getActivity(),"删除数据成功",Toast.LENGTH_SHORT).show();
//    }
//
//    /*指定删除*/
//    private void singleDelete(String ownerName){
//        /**
//         * 根据名字删除某用户
//         *
//         * @param name
//         */
//        card = cardDao.queryBuilder().where(CardDao.Properties.CardOwner.eq(ownerName)).build().unique();
//        if (card != null) {
//            cardDao.deleteByKey(card.getId());
//            recyclerView.setAdapter(null);
//            Toast.makeText(getActivity(),"你成功删除:"+ card.getCardOwner(),Toast.LENGTH_SHORT).show();
//        }else{
//            Toast.makeText(getActivity(),"持卡人不存在",Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    /*指定查询*/
//    private void singleQueryByName(String ownerName){
//        try {
//            List<Card> cards = cardDao.queryBuilder()
//                    .where(CardDao.Properties.CardOwner.eq(ownerName))
//                    .build().list();
//            card = cards.get(cards.size() - 1);
//            if (card != null) {
//                cardList.addAll(cards);
//                LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
//                recyclerView.setLayoutManager(layoutManager);
//                CardAdapter adapter = new CardAdapter(cardList);
//                recyclerView.setAdapter(adapter);
//                for (int i = 0;i < cards.size(); i++ ){
//                    adapter.remove(i);
//                }
//
//                recyclerView.removeAllViews();
//
//                Log.i("指定查询的数据：", "--------------------" + cardList);
//                //设置Item增加、移除动画
//                recyclerView.setItemAnimator(new DefaultItemAnimator());
//                //添加分割线
//                recyclerView.addItemDecoration(new DividerItemDecoration(
//                        getActivity(), DividerItemDecoration.VERTICAL));
//            }
//        }catch(Exception e) {
//            e.printStackTrace();
//            Toast.makeText(getActivity(),"请重新输入",Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    /*指定查询*/
//    private void singleQueryById(){
//
//        List<Card> cards = cardDao.queryBuilder()
//                .where(CardDao.Properties.CardOwner.eq("xiaobai"))
//                .build().list();
//        if (cards != null) {
//            cardList.addAll(cards);
//            LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
//            recyclerView.setLayoutManager(layoutManager);
//            CardAdapter adapter = new CardAdapter(cardList);
//            recyclerView.setAdapter(adapter);
//            Log.i("指定查询的数据：", "--------------------" + cardList);
//            //设置Item增加、移除动画
//            recyclerView.setItemAnimator(new DefaultItemAnimator());
//            //添加分割线
//            recyclerView.addItemDecoration(new DividerItemDecoration(
//                    getActivity(), DividerItemDecoration.VERTICAL));
//        }else {
//            Toast.makeText(getActivity(),"查询不到数据",Toast.LENGTH_SHORT).show();
//        }
//    }
//}
