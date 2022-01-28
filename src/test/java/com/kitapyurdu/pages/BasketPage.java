package com.kitapyurdu.pages;

import com.kitapyurdu.methods.Methods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

public class BasketPage {
    Methods methods;
    Logger logger = LogManager.getLogger(LoginPage.class);

    public BasketPage() {
        methods = new Methods();
    }

    public void basket() {
        methods.click(By.id("cart"));
        methods.waitBySeconds(1);
        methods.click(By.id("js-cart"));
        methods.waitBySeconds(1);
        String quantity = methods.getAttribute(By.xpath("//*[@name='quantity']"),"value");
        logger.info("Değişimden önceki ürün adeti: " + quantity);
        methods.clearInputArea(By.xpath("//*[@name='quantity']"));
        methods.waitBySeconds(1);
        methods.sendKeys(By.xpath("//*[@name='quantity']"), "2");
        methods.waitBySeconds(1);
        methods.click(By.cssSelector(".fa.fa-refresh.green-icon"));
        methods.waitBySeconds(2);
        methods.click(By.xpath("//div[@class='right']/a"));
        methods.waitBySeconds(2);
    }

    public void submitForm() {
        methods.click(By.xpath("//*[contains(text(),'Yeni bir adres kullanmak istiyorum.')]"));
        methods.waitBySeconds(2);
        methods.sendKeys(By.id("address-firstname-companyname"), "Ali Doğuşcan");
        methods.waitBySeconds(1);
        methods.sendKeys(By.id("address-lastname-title"), "Erkan");
        methods.waitBySeconds(1);
        methods.selectText(By.id("address-zone-id"), "İstanbul");
        methods.waitBySeconds(1);
        methods.selectText(By.id("address-county-id"), "MALTEPE");
        methods.waitBySeconds(1);
        methods.sendKeys(By.id("district"), "YALI MAH");
        methods.waitBySeconds(1);
        methods.sendKeys(By.id("address-address-text"), "Piri Reis Cd. No:3,");
        methods.waitBySeconds(1);
        methods.sendKeys(By.id("address-postcode"), "34844");
        methods.waitBySeconds(1);
        methods.sendKeys(By.id("address-telephone"), "0216416160");
        methods.waitBySeconds(1);
        methods.sendKeys(By.id("address-tax-id"), "12148839152");
        methods.waitBySeconds(2);
        methods.click(By.id("button-checkout-continue"));
        methods.waitBySeconds(2);
        methods.click(By.id("button-checkout-continue"));
        methods.waitBySeconds(2);
        methods.click(By.id("button-checkout-continue"));
        methods.waitBySeconds(1);
        //Bakiyesiz kartla alışveriş kısmını bu şekilde anladığım için böyle yaptım.
        Assert.assertTrue(methods.isElementVisible(By.cssSelector(".error")));
        String cardNameError = methods.getText(By.xpath("//span[@class='error' and contains(text(),'Kart sahibinin adı boş bırakılamaz!')]"));
        String cardNumberError = methods.getText(By.xpath("//span[@class='error' and contains(text(),'Kart numarası alanı 16 karakter olmalı!')]"));
        String cardValidateError = methods.getText(By.xpath("//span[@class='error' and contains(text(),'Kartınızın son kullanım tarihini (ay/yıl) seçiniz!')]"));
        String cardCvvError = methods.getText(By.xpath("//span[@class='error' and contains(text(),'Güvenlik kodu boş bırakılamaz!')]"));
        logger.info("Kart Girilmeden Alınan Hata Mesajları: " + cardNameError + "\n" + cardNumberError + "\n" + cardValidateError + "\n" + cardCvvError);
        methods.waitBySeconds(1);
    }

    public void logout() {
        methods.click(By.cssSelector(".checkout-logo"));
        methods.waitBySeconds(1);
        methods.hover(By.cssSelector(".common-sprite"));
        methods.waitBySeconds(1);
        methods.click(By.xpath("//*[contains(text(),'Çıkış')]"));
        methods.waitBySeconds(3);
    }
}
