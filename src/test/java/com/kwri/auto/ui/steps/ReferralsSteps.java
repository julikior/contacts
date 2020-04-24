package com.kwri.auto.ui.steps;

import com.google.inject.Inject;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class ReferralsSteps {


    @Inject
    com.kwri.auto.ui.pages.ReferralsPage ReferralsPage;


    @Given("I open referrals page")
    public void NavigateToRefPage() {
        ReferralsPage.clickHomeReferrals("Click Referrals tab");
    }

    @Then("I open My Referrals")
    public void ISelectMyMeferralsTab () {
        ReferralsPage.clickMyReferrals("Click My referrals tab");
    }

    @Then("I open Map tab")
    public void ISelectMapTab () {
        ReferralsPage.clickMap("Click Map tab");
    }

    @Then("I select My Network tab")
    public void ISelectMyNetowrkTab () {
        ReferralsPage.clickMyNetwork("Click My Network tab");
    }

    @Then("I click Track Referral button")
    public void IClickTrackReferralsButton () {
        ReferralsPage.clickTrackReferrals("Click Track Referral");
    }

    @Then("I click Grow My Network button")
    public void IClickGrowMyNetworkButton () {
        ReferralsPage.clickGrowMyNetwork("Click Grow My Network");
    }

    @Then("I close modal popup")
    public void IClickCloseButton () {
        ReferralsPage.clickCloseModal("Click Close at the modal popup");
    }

    @Then("I click Dashboard tab")
    public void IClickDashboardTab () {
        ReferralsPage.clickDashboard("Click Dashboard tab");
    }

    @Then("I click Sorting drop-down")
    public void IClickSortingDropdown () {
        ReferralsPage.clickSortDropDown("Click Sorting drop-down");
    }

    @Then("I select Search field")
    public void ISelectSearchAgentField () {
        ReferralsPage.clickSearchAgent("Click Search field");
    }

    @Then("I enter name of agent into the Search field like {string}")
    public void IEnterAgentNameInTheSearch (String searchName) {
        ReferralsPage.enterAgentName("QA Agent");
    }

    @Then("I click Favorite filter")
    public void IClickFavoriteFilter () {
        ReferralsPage.clickFavorite("Click Favorite filter");
    }

}
