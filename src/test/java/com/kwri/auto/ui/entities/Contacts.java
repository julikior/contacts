package com.kwri.auto.ui.entities;

import org.openqa.selenium.WebElement;

import java.util.List;

public class Contacts {
    private String txt_fullName;
    private String txt_address;

    public String getTxt_fullName() {
        return txt_fullName;
    }

    public void setTxt_fullName(String txt_fullName) {
        this.txt_fullName = txt_fullName;
    }

    public void setTxt_address(String txt_address) {
        this.txt_address = txt_address;
    }

    public void fillTxt_fullName(String txt_fullName) {
        this.txt_fullName = txt_fullName;
    }


    public void getTxt_address (String txt_address) {
        this.txt_address = txt_address;
    }
}
