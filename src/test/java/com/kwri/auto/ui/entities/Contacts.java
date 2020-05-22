package com.kwri.auto.ui.entities;

import com.kwri.auto.ui.di.World;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Random;


public class Contacts {

    private String nameValue = "AutoUser " + RandomStringUtils.random(5, true, false);
    private String email = "testtest" + RandomStringUtils.random(5, true, false) + "@test.com";


    public String getNameValue() {
        return nameValue;
    }

    public String getEmail() {
        return email;
    }

}
