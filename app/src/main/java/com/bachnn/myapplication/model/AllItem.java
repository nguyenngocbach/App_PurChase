package com.bachnn.myapplication.model;

public class AllItem {
    private String mTitle;
    private String mImageOne;
    private String mImageTwo;
    private String mImageThree;
    private String mImageFour;
    private String mImageFive;

    public AllItem(String mTitle, String mImageOne, String mImageTwo, String mImageThree, String mImageFour, String mImageFive) {
        this.mTitle = mTitle;
        this.mImageOne = mImageOne;
        this.mImageTwo = mImageTwo;
        this.mImageThree = mImageThree;
        this.mImageFour = mImageFour;
        this.mImageFive = mImageFive;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmImageOne() {
        return mImageOne;
    }

    public void setmImageOne(String mImageOne) {
        this.mImageOne = mImageOne;
    }

    public String getmImageTwo() {
        return mImageTwo;
    }

    public void setmImageTwo(String mImageTwo) {
        this.mImageTwo = mImageTwo;
    }

    public String getmImageThree() {
        return mImageThree;
    }

    public void setmImageThree(String mImageThree) {
        this.mImageThree = mImageThree;
    }

    public String getmImageFour() {
        return mImageFour;
    }

    public void setmImageFour(String mImageFour) {
        this.mImageFour = mImageFour;
    }

    public String getmImageFive() {
        return mImageFive;
    }

    public void setmImageFive(String mImageFive) {
        this.mImageFive = mImageFive;
    }
}
