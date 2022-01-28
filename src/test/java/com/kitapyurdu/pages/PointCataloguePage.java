package com.kitapyurdu.pages;

import com.kitapyurdu.methods.Methods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class PointCataloguePage {
    Methods methods;
    public PointCataloguePage(){
        methods=new Methods();
    }

    public void point(){
        methods.click(By.cssSelector(".logo-text"));
        methods.waitBySeconds(1);
        methods.click(By.cssSelector(".lvl1catalog"));
        methods.waitBySeconds(1);
        methods.click(By.xpath("//*[@title='Puan Kataloğundaki Türk Klasikleri']"));
        methods.waitBySeconds(1);
        methods.selectText(By.xpath("//*[@class='sort']/select"),"Yüksek Oylama");
        methods.waitBySeconds(1);
        methods.hover(By.xpath("//*[@class='mn-strong common-sprite' and contains(text(),'Tüm Kitaplar')]"));
        methods.waitBySeconds(1);
        methods.click(By.xpath("//*[@class='mn-icon icon-angleRight' and contains(text(),'Hobi')]"));
        methods.waitBySeconds(2);
    }
    public void addRandomItem(){
        methods.addToCart(By.cssSelector(".product-cr"),By.cssSelector(".add-to-cart"));
        methods.waitBySeconds(2);
    }
}
