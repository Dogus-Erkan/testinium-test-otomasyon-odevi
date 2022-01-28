package com.kitapyurdu.test;

import com.kitapyurdu.driver.BaseTest;
import com.kitapyurdu.pages.*;
import org.junit.Test;

public class MainTest extends BaseTest {

    @Test
    public void mainTest(){
        LoginPage loginPage = new LoginPage();
        loginPage.login();

        ProductPage productPage = new ProductPage();
        productPage.searchAndScroll();

        PointCataloguePage pointCataloguePage = new PointCataloguePage();
        pointCataloguePage.point();
        pointCataloguePage.addRandomItem();

        FavouritesPage favouritesPage = new FavouritesPage();
        favouritesPage.deleteFavourite();

        BasketPage basketPage=new BasketPage();
        basketPage.basket();
        basketPage.submitForm();
        basketPage.logout();
    }

}
