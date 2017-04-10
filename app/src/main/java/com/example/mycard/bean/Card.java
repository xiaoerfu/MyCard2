package com.example.mycard.bean;

import org.litepal.crud.DataSupport;

/**
 * Created by lijianfu on 2017/4/7.
 * 建立card的实体类
 */
public class Card extends DataSupport {

    private int cardId;                                 //序号
    private int cardNum;                            //卡号
    private String cardOwner;                   //卡拥有者
    private int ownerNum;                        //拥有者ID
    private double cardBalance;                   //卡余额

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getCardOwner() {
        return cardOwner;
    }

    public void setCardOwner(String cardOwner) {
        this.cardOwner = cardOwner;
    }

    public int getCardNum() {
        return cardNum;
    }

    public void setCardNum(int cardNum) {
        this.cardNum = cardNum;
    }

    public int getOwnerNum() {
        return ownerNum;
    }

    public void setOwnerNum(int ownerNum) {
        this.ownerNum = ownerNum;
    }

    public double getCardBalance() {
        return cardBalance;
    }

    public void setCardBalance(double cardBalance) {
        this.cardBalance = cardBalance;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardId=" + cardId +
                ", cardNum=" + cardNum +
                ", cardOwner='" + cardOwner + '\'' +
                ", ownerNum=" + ownerNum +
                ", cardBalance=" + cardBalance +
                '}';
    }
}
