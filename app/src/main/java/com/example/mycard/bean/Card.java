package com.example.mycard.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by lijianfu on 2017/4/7.
 * 建立card的实体类
 */
@Entity
public class Card {

    @Id
    private Long id;                                         //序号
    private String cardNum;                      //卡号
    private String cardOwner;                   //卡拥有者
    private String ownerNum;                        //拥有者ID
    private double  cardBalance;                   //卡余额

    @Generated(hash = 1315895109)
    public Card(Long id, String cardNum, String cardOwner, String ownerNum,
            double cardBalance) {
        this.id = id;
        this.cardNum = cardNum;
        this.cardOwner = cardOwner;
        this.ownerNum = ownerNum;
        this.cardBalance = cardBalance;
    }

    @Generated(hash = 52700939)
    public Card() {
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", cardNum='" + cardNum + '\'' +
                ", cardOwner='" + cardOwner + '\'' +
                ", ownerNum='" + ownerNum + '\'' +
                ", cardBalance=" + cardBalance +
                '}';
    }

    public double getCardBalance() {
        return this.cardBalance;
    }

    public void setCardBalance(double cardBalance) {
        this.cardBalance = cardBalance;
    }

    public String getOwnerNum() {
        return this.ownerNum;
    }

    public void setOwnerNum(String ownerNum) {
        this.ownerNum = ownerNum;
    }

    public String getCardOwner() {
        return this.cardOwner;
    }

    public void setCardOwner(String cardOwner) {
        this.cardOwner = cardOwner;
    }

    public String getCardNum() {
        return this.cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
