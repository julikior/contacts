package com.kwri.auto.ui.entities;

import org.apache.commons.lang3.RandomStringUtils;


public class Contacts {

    private String nameValue = "AutoUser " + RandomStringUtils.random(5, true, false);
    private String email = "testtest" + RandomStringUtils.random(5, true, false) + "@test.com";
    private String contactData;
    private String description;
    private String phoneNumber;
    private String addEmail;
    private String addPhone;
    private String primaryAddress;
    private String apartmentNum;
    private String legalName;

    public void setNameValue(String nameValue) {
        this.nameValue = nameValue;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContactData(String contactData) {
        this.contactData = contactData;
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

    public String getDescription() {
        return description;
    }

    public String getNameValue() {
        return nameValue;
    }

    public String getEmail() {
        return email;
    }

    public String getContactData() {
        return contactData;
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

    public String selectRandomCreatedContact(String Contact){
        return nameValue;

    }
}
