package com.sdl.selenium.bootstrap.form;

import com.sdl.selenium.web.By;
import com.sdl.selenium.web.WebLocator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FormTest {
    public static WebLocator container = new WebLocator("container");

    @DataProvider
    public static Object[][] testConstructorPathDataProvider() {
        return new Object[][]{
                {new Form(),                      "//form"},
                {new Form().setId("ID"),          "//form[@id='ID']"},
                {new Form(container),             "//*[contains(concat(' ', @class, ' '), ' container ')]//form"},
                {new Form(container, "TitleForm"),"//*[contains(concat(' ', @class, ' '), ' container ')]//form[count(.//legend[text()='TitleForm']) > 0]"},
                {new Form(container).setTitle("TitleForm"),"//*[contains(concat(' ', @class, ' '), ' container ')]//form[count(.//legend[text()='TitleForm']) > 0]"},
                {new Form(container, "TitleForm").setId("ID"), "//*[contains(concat(' ', @class, ' '), ' container ')]//form[@id='ID' and count(.//legend[text()='TitleForm']) > 0]"},

                {new Form(By.id("ID")),          "//form[@id='ID']"},
                {new Form(container),             "//*[contains(concat(' ', @class, ' '), ' container ')]//form"},
                {new Form(container, By.title("TitleForm")),"//*[contains(concat(' ', @class, ' '), ' container ')]//form[count(.//legend[text()='TitleForm']) > 0]"},
                {new Form(container, By.title("TitleForm"), By.id("ID")), "//*[contains(concat(' ', @class, ' '), ' container ')]//form[@id='ID' and count(.//legend[text()='TitleForm']) > 0]"},

        };
    }

    @Test(dataProvider = "testConstructorPathDataProvider")
    public void getPathSelectorCorrectlyFromConstructors(Form form, String expectedXpath) {
        Assert.assertEquals(form.getPathBuilder().getPath(), expectedXpath);
    }
}