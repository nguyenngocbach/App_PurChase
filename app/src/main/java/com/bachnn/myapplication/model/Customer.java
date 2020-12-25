package com.bachnn.myapplication.model;

import java.io.Serializable;

public class Customer implements Serializable {
    private String ID;
    private String mNameCustomer;
    private String mAddressCustomer;
    private String mSDTCustomer;
    private String mEmailCustomer;

    public Customer(String ID, String mNameCustomer, String mAddressCustomer, String mSDTCustomer, String mEmailCustomer) {
        this.ID = ID;
        this.mNameCustomer = mNameCustomer;
        this.mAddressCustomer = mAddressCustomer;
        this.mSDTCustomer = mSDTCustomer;
        this.mEmailCustomer = mEmailCustomer;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getmNameCustomer() {
        return mNameCustomer;
    }

    public void setmNameCustomer(String mNameCustomer) {
        this.mNameCustomer = mNameCustomer;
    }

    public String getmAddressCustomer() {
        return mAddressCustomer;
    }

    public void setmAddressCustomer(String mAddressCustomer) {
        this.mAddressCustomer = mAddressCustomer;
    }

    public String getmSDTCustomer() {
        return mSDTCustomer;
    }

    public void setmSDTCustomer(String mSDTCustomer) {
        this.mSDTCustomer = mSDTCustomer;
    }

    public String getmEmailCustomer() {
        return mEmailCustomer;
    }

    public void setmEmailCustomer(String mEmailCustomer) {
        this.mEmailCustomer = mEmailCustomer;
    }
}
