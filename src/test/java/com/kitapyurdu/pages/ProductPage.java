package com.kitapyurdu.pages;

import com.kitapyurdu.methods.Methods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.Random;

public class ProductPage {

    Methods methods;
    Logger logger= LogManager.getLogger(LoginPage.class);
    public ProductPage(){
        methods=new Methods();
    }

    public void searchAndScroll(){
        methods.sendKeys(By.id("search-input"),"Oyuncak");
        methods.waitBySeconds(2);
        methods.click(By.cssSelector(".common-sprite.button-search"));
        methods.waitBySeconds(2);
        methods.scrollWithAction(By.xpath("//*[@class='product-cr'][7]"));
        methods.waitBySeconds(3);
        methods.selectRandomFavourite(By.xpath("//a[@class='add-to-favorites']"));
        methods.waitBySeconds(2);
        methods.hover(By.xpath("//*[@class='common-sprite' and contains(text(),'Listelerim')]"));
        methods.waitBySeconds(1);
        methods.click(By.xpath("//li/a[contains(text(),'Favorilerim')]"));
        methods.waitBySeconds(1);
        Assert.assertEquals("4",methods.getText(By.xpath("//*[@class='favorite-tag active']/span")));
        logger.info("Favorilerde bulunan ürün sayısı: "+methods.getText(By.xpath("//*[@class='favorite-tag active']/span")));
        methods.waitBySeconds(2);

    }
}
