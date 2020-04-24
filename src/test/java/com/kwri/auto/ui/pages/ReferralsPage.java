package com.kwri.auto.ui.pages;

import com.google.inject.Inject;
import com.kwri.auto.ui.di.World;
import com.kwri.auto.ui.methods.Common;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReferralsPage extends BasePage {
    public static final Integer TIME_TO_PAGE_LOAD = 30;

    @Inject
    public ReferralsPage(World world) {
        super(world);
    }

        Common common = new Common(world.driver);
        public static Logger LOG = LoggerFactory.getLogger(ReferralsPage.class);

        private static final String clickHomeReferrals = "//a[contains(@href, '/command/referrals')]";
        @FindBy(xpath = clickHomeReferrals)
        public WebElement link_Referrals;

        private static final String clickSearch = "//input[@placeholder='Search']";
        @FindBy(xpath = clickSearch)
        private WebElement txt_searchInput;

        private static final String clickDashboard = "//a[contains(@href, '/command/referrals')]/img";
        @FindBy(xpath = clickDashboard)
        private WebElement link_Dashboard;

        private static final String clickMyReferrals = "//a [contains(@href, 'all')]";
        @FindBy(xpath = clickMyReferrals)
        private WebElement link_MyReferrals;

        private static final String clickMap = "//a [contains(@href, 'grow-my-network')]";
        @FindBy(xpath = clickMap)
        private WebElement link_Map;

        private static final String clickMyNetwork = "//a [contains(@href, 'referrals/network')]";
        @FindBy(xpath = clickMyNetwork)
        private WebElement link_MyNetwork;

        private static final String clickTrackReferrals = "//button[text()='Track Referrals']";
        @FindBy(xpath = clickTrackReferrals)
        private WebElement btn_TrackReferrals;

        private static final String clickGrowMyNetwork = "//button[text()='Grow My Network']";
        @FindBy(xpath = clickGrowMyNetwork)
        private WebElement btn_GrowMyNetwork;

        private static final String clickSortDropDown = "//*[contains(text(),'First Name')]";
        @FindBy(xpath = clickSortDropDown)
        public WebElement drpdn_SortDropDown;

        private static final String clickFilterFavorite = "//div[@class='d-flex']";
        @FindBy(xpath = clickFilterFavorite)
        public WebElement btn_FilterFavorite;

        private static final String clickCloseModal = "//span[@class='icon icon--close icon--medium modal__close']";
        @FindBy(xpath = clickCloseModal)
        public WebElement btn_CloseModal;

        public static final String AgentsLoad = "//div[@class = 'all-search-results']";
        @FindBy(xpath = AgentsLoad)
        public WebElement agentsLoad;

        public WebElement getTxt_contactsSearch() {
        return txt_searchInput;
    }


        public void clickHomeReferrals (String HomeReferrals){
            LOG.info("Navigation to Referrals tab");
            common.waitAndClick(30000, link_Referrals);
        }

        public void clickMyReferrals (String MyReferrals){
            common.waitAndClick(300, link_MyReferrals);
        }

        public void clickMap (String Map){
            common.waitAndClick(30, link_Map);
        }

        public void clickMyNetwork (String MyNetwork){
            common.waitAndClick(30, link_MyNetwork);
        }

        public void clickTrackReferrals (String TrackReferrals){
            common.waitAndClick(30, btn_TrackReferrals);
        }

        public void clickGrowMyNetwork (String GrowMyNetwork){
            common.waitAndClick(30, btn_GrowMyNetwork);
        }

        public void clickCloseModal (String CloseModal){
            common.waitAndClick(30, btn_CloseModal);
        }

        public void clickDashboard (String Dashboard){
            common.waitAndClick(30, link_Dashboard);
        }

        public void clickSortDropDown (String SortDropdown){
            common.waitAndClick(30, drpdn_SortDropDown);
        }

        public void clickSearchAgent (String Search){
            common.waitAndClick(30, txt_searchInput);
        }

        public void clickFavorite (String Favorite){
            common.waitAndClick(30, btn_FilterFavorite);
        }

        public void enterAgentName(String searchName) {
            //search for an agent
            common.waitAndSendText(30, txt_searchInput, searchName);
        }
}
