package com.kitapyurdu.pages;

import com.kitapyurdu.methods.Methods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class FavouritesPage {
    Methods methods;
    Logger logger= LogManager.getLogger(LoginPage.class);
    public FavouritesPage() {
        methods = new Methods();
    }

    public void deleteFavourite() {
        methods.hover(By.xpath("//*[@class='common-sprite' and contains(text(),'Listelerim')]"));
        methods.waitBySeconds(2);
        methods.click(By.xpath("//li/a[contains(text(),'Favorilerim')]"));
        methods.waitBySeconds(2);
        String unique = methods.getAttribute(By.xpath("//*[@class='product-cr'][3]"), "id");
        logger.info("3. ürünün unique id değeri: "+ unique);
        String newUnique = methods.splitId(unique);
        logger.info("3. ürünün yeni unique id değeri: "+newUnique);
        methods.waitBySeconds(1);
        methods.click(By.xpath("//*[@onclick='removeFromFavorites("+newUnique+");' and @data-title='Favorilerimden Sil']"));
        methods.waitBySeconds(1);
    }
}
