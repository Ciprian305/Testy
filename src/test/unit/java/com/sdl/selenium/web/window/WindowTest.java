package com.sdl.selenium.web.window;

import com.sdl.selenium.web.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WindowTest {

    @DataProvider
    public static Object[][] testConstructorPathDataProvider() {
        return new Object[][]{
                {new Window(), "//*[contains(concat(' ', @class, ' '), ' ui-dialog ui-widget ui-widget-content ') and contains(@style ,'display: block;')]"},
                {new Window("text"), "//*[contains(concat(' ', @class, ' '), ' ui-dialog ui-widget ui-widget-content ') and count(.//*[text()='text']) > 0 and contains(@style ,'display: block;')]"},
                {new Window("text").setId("ID"), "//*[@id='ID' and contains(concat(' ', @class, ' '), ' ui-dialog ui-widget ui-widget-content ') and count(.//*[text()='text']) > 0 and contains(@style ,'display: block;')]"},

                {new Window(By.title("text")), "//*[contains(concat(' ', @class, ' '), ' ui-dialog ui-widget ui-widget-content ') and count(.//*[text()='text']) > 0 and contains(@style ,'display: block;')]"},
                {new Window(By.title("text"), By.id("ID")), "//*[@id='ID' and contains(concat(' ', @class, ' '), ' ui-dialog ui-widget ui-widget-content ') and count(.//*[text()='text']) > 0 and contains(@style ,'display: block;')]"},

        };
    }

    @Test(dataProvider = "testConstructorPathDataProvider")
    public void getPathSelectorCorrectlyFromConstructors(Window window, String expectedXpath) {
        Assert.assertEquals(window.getPathBuilder().getPath(), expectedXpath);
    }
}