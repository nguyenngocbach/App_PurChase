package com.bachnn.myapplication.model;

import java.io.Serializable;

public class Item implements Serializable {
    private String mID;
    private String mName;
    private String mDescription;
    private String mImage;
    private String mPrice;
    private String mSale;
    private boolean mIsSale;
    private int mType;

    public Item(String mID, String mName, String mDescription, String mImage, String mPrice, String mSale, boolean mIsSale, int mType) {
        this.mID = mID;
        this.mName = mName;
        this.mDescription = mDescription;
        this.mImage = mImage;
        this.mPrice = mPrice;
        this.mSale = mSale;
        this.mIsSale = mIsSale;
        this.mType = mType;
    }

    public String getmImage() {
        return mImage;
    }

    public void setmImage(String mImage) {
        this.mImage = mImage;
    }

    public boolean ismIsSale() {
        return mIsSale;
    }

    public void setmIsSale(boolean mIsSale) {
        this.mIsSale = mIsSale;
    }

    public String getmID() {
        return mID;
    }

    public void setmID(String mID) {
        this.mID = mID;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getmPrice() {
        return mPrice;
    }

    public void setmPrice(String mPrice) {
        this.mPrice = mPrice;
    }

    public String getmSale() {
        return mSale;
    }

    public void setmSale(String mSale) {
        this.mSale = mSale;
    }

    public int getmType() {
        return mType;
    }

    public void setmType(int mType) {
        this.mType = mType;
    }
}
