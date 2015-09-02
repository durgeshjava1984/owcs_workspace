package com.owcs.test.base;

import org.jbehave.core.embedder.Embedder;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass extends Embedder{

    protected static WebDriver driver;
    
    public static WebDriver start(String url){
    	//System.setProperty("webdriver.chrome.driver", "G:/software/chromedriver_win32/chromedriver_win32/chromedriver.exe");
        driver = new FirefoxDriver();
        driver.get(url);
        try {
            Thread.sleep(4000);
            } catch (InterruptedException e) {
            System.out.println("entered into the catch block");
            e.printStackTrace();
            }
            driver.manage().window().maximize();
            return driver;
    }
    
    public void waitForElement(By element) throws InterruptedException {
        int time =0;
        for (int i = 0; i < 60; i++) {
        System.out.println("Waiting for locator " + element);
        if (driver.findElements(element).size() != 0) {
        System.out.println("Element is present in..." + i
        + " position");
        break;
        }
        Thread.sleep(1000);
        time++;
        }
        if (time>60) {
        throw new NoSuchElementException("Element is not present after 1min");
        }
        }
    
}