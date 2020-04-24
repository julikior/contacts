package com.kwri.auto.ui.steps;

import com.kwri.auto.ui.pages.ContactsDetailPage;
import com.kwri.auto.ui.pages.ContactsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.inject.Inject;
import com.kwri.auto.ui.di.World;
import com.kwri.auto.ui.methods.Common;
import com.kwri.auto.ui.pages.BasePage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EditContactSteps extends BasePage {
    private ContactsDetailPage contactsDetailPage;

    @Inject
    public EditContactSteps(World world) {
        super(world);
    }

    Common common = new Common(world.driver);
    WebDriverWait wait = new WebDriverWait(world.driver, 15);
    JavascriptExecutor jsExecutor;

    @Inject
    com.kwri.auto.ui.pages.ContactsPage contactsHome;


    @When("I click on edit icon")
    public void IClickOnEditIcon() {
        wait.until(ExpectedConditions.visibilityOf(contactsDetailPage.getspan_EditIcon()));
        contactsDetailPage.getspan_EditIcon().click();
    }









}
