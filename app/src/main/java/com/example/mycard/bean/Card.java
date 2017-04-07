package com.example.mycard.bean;

/**
 * Created by lijianfu on 2017/4/7.
 * 建立card的实体类
 */
public class Card {

    private int cardId;                                 //序号
    private int cardNum;                            //卡号
    private String cardOwner;                   //卡拥有者
    private int ownerNum;                        //拥有者ID
    private long cardBalance;                   //卡余额

    public Card(int cardId, int cardNum, String cardOwner, long cardBalance, int ownerNum) {
        this.cardId = cardId;
        this.cardNum = cardNum;
        this.cardOwner = cardOwner;
        this.cardBalance = cardBalance;
        this.ownerNum = ownerNum;
    }

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

    public long getCardBalance() {
        return cardBalance;
    }

    public void setCardBalance(long cardBalance) {
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
