package com.kwri.auto.ui.entities;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;


public class Contacts {

    private String nameValue;
    private String email;
    private String description;
    private String phoneNumber;
    private String addEmail;
    private String addPhone;
    private String primaryAddress;
    private String apartmentNum;
    private String legalName;
    private String select_MonthOfBirthday;
    private String select_DayOfBirthday;
    private String select_YearOfBirthday;
    private String select_MonthOfAnniversary;
    private String select_DayOfAnniversary;
    private String select_YearOfAnniversary;

    public void setNameValue(String nameValue) {
        this.nameValue = nameValue;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddEmail(String addEmail) {
        this.addEmail = addEmail;
    }

    public void setAddPhone(String addPhone) {
        this.addPhone = addPhone;
    }

    public void setPrimaryAddress(String primaryAddress) {
        this.primaryAddress = primaryAddress;
    }

    public void setApartmentNum(String apartmentNum) {
        this.apartmentNum = apartmentNum;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public void setSelect_MonthOfBirthday(String select_MonthOfBirthday) {
        this.select_MonthOfBirthday = select_MonthOfBirthday;
    }

    public void setSelect_DayOfBirthday(String select_DayOfBirthday) {
        this.select_DayOfBirthday = select_DayOfBirthday;
    }

    public void setSelect_YearOfBirthday(String select_YearOfBirthday) {
        this.select_YearOfBirthday = select_YearOfBirthday;
    }

    public void setSelect_MonthOfAnniversary(String select_MonthOfAnniversary) {
        this.select_MonthOfAnniversary = select_MonthOfAnniversary;
    }

    public void setSelect_DayOfAnniversary(String select_DayOfAnniversary) {
        this.select_DayOfAnniversary = select_DayOfAnniversary;
    }

    public void setSelect_YearOfAnniversary(String select_YearOfAnniversary) {
        this.select_YearOfAnniversary = select_YearOfAnniversary;
    }

    public String getDescription() {
        return description;
    }

    public String getNameValue() {
        return nameValue;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddEmail() {
        return addEmail;
    }

    public String getAddPhone() {
        return addPhone;
    }

    public String getPrimaryAddress() {
        return primaryAddress;
    }

    public String getApartmentNum() {
        return apartmentNum;
    }

    public String getLegalName() {
        return legalName;
    }

    public String getSelect_MonthOfBirthday() {
        return select_MonthOfBirthday;
    }

    public String getSelect_DayOfBirthday() {
        return select_DayOfBirthday;
    }

    public String getSelect_YearOfBirthday() {
        return select_YearOfBirthday;
    }

    public String getSelect_MonthOfAnniversary() {
        return select_MonthOfAnniversary;
    }

    public String getSelect_DayOfAnniversary() {
        return select_DayOfAnniversary;
    }

    public String getSelect_YearOfAnniversary() {
        return select_YearOfAnniversary;
    }
}
