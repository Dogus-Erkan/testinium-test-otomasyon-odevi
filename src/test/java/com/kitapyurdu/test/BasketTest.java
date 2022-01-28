package com.kitapyurdu.test;

import com.kitapyurdu.driver.BaseTest;
import com.kitapyurdu.pages.BasketPage;
import com.kitapyurdu.pages.LoginPage;
import org.junit.Test;

public class BasketTest extends BaseTest {
    @Test
    public void basketTest(){
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        BasketPage basketPage=new BasketPage();
        basketPage.basket();
        basketPage.submitForm();
        basketPage.logout();
    }
}
