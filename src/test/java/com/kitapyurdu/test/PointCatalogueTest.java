package com.kitapyurdu.test;

import com.kitapyurdu.driver.BaseTest;
import com.kitapyurdu.pages.PointCataloguePage;
import org.junit.Test;

public class PointCatalogueTest extends BaseTest {

    @Test
    public void pointTest(){
        PointCataloguePage pointCataloguePage = new PointCataloguePage();
        pointCataloguePage.point();
        pointCataloguePage.addRandomItem();
    }

}
