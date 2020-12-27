package com.bachnn.myapplication.model;

public class USERNAME {
    private String ID;
    private String mUsername;
    private String mPassword;
    private String mUserImage;
    private String mName;

    public USERNAME(String ID, String mUsername, String mPassword, String mUserImage, String mName) {
        this.ID = ID;
        this.mUsername = mUsername;
        this.mPassword = mPassword;
        this.mUserImage = mUserImage;
        this.mName = mName;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getmUsername() {
        return mUsername;
    }

    public void setmUsername(String mUsername) {
        this.mUsername = mUsername;
    }

    public String getmPassword() {
        return mPassword;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }

    public String getmUserImage() {
        return mUserImage;
    }

    public void setmUserImage(String mUserImage) {
        this.mUserImage = mUserImage;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }
}
