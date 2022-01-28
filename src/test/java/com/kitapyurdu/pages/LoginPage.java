package com.kitapyurdu.pages;

import com.kitapyurdu.methods.Methods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginPage {
    Methods methods;
    Logger logger= LogManager.getLogger(LoginPage.class);
    public LoginPage(){
        methods=new Methods();
    }

    public void login(){
        methods.click(By.cssSelector(".menu-top-button.login"));
        methods.waitBySeconds(1);
        methods.sendKeys(By.id("login-email"),"doguscan.erkan@testinium.com");
        methods.waitBySeconds(1);
        methods.sendKeys(By.id("login-password"),"1q2w3e4r5t");
        methods.waitBySeconds(1);
        methods.click(By.cssSelector(".ky-btn.ky-btn-orange.w-100.ky-login-btn"));
        String name=methods.getText(By.xpath("//*[@class='common-sprite']/b"));
        logger.info("Alınan İsim: "+name);
        Assert.assertEquals(name,"Doğuş Erkan");
    }
}
