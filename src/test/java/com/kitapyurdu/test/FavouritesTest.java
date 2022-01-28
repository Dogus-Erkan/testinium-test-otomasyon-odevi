package com.kitapyurdu.test;

import com.kitapyurdu.driver.BaseTest;
import com.kitapyurdu.pages.FavouritesPage;
import com.kitapyurdu.pages.LoginPage;
import org.junit.Test;

public class FavouritesTest extends BaseTest {
    @Test
    public void favouriteTest(){
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        FavouritesPage favouritesPage = new FavouritesPage();
        favouritesPage.deleteFavourite();
    }
}
