package com.freecrm.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

public class WebListener implements WebDriverListener {
	
    @Override
	public void beforeGet(WebDriver driver, String url) {
    	System.out.println("Before navigating to: " + url);
	}
    
	@Override
	public void afterGet(WebDriver driver, String url) {
		System.out.println("Navigated to: " + url);
	}

	@Override
	public void beforeGetCurrentUrl(WebDriver driver) {
		System.out.println("Before getting the current URL");
	}
	
	@Override
	public void afterGetCurrentUrl(WebDriver driver, String result) {
		System.out.println("Current URL: " + result);
	}

	@Override
	public void beforeGetTitle(WebDriver driver) {
		System.out.println("Before getting the title of the current page");
	}

	@Override
	public void afterGetTitle(WebDriver driver, String result) {
		System.out.println("Page Title: " + result);
	}

    @Override
    public void beforeFindElement(WebDriver driver, By locator) {
        System.out.println("Before finding element: " + locator.toString());
    }

    @Override
    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        System.out.println("Found element: " + locator.toString());
    }

    @Override
    public void beforeClick(WebElement element) {
        System.out.println("Before clicking on element: " + element.toString());
    }

    @Override
    public void afterClick(WebElement element) {
        System.out.println("Clicked on element: " + element.toString());
    }

    @Override
    public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
        System.out.println("Before sending keys to element: " + element.toString());
    }

    @Override
    public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
        System.out.println("Sent keys to element: " + element.toString());
    }

    @Override
    public void beforeBack(WebDriver.Navigation navigation) {
        System.out.println("Before navigating back");
    }

    @Override
    public void afterBack(WebDriver.Navigation navigation) {
        System.out.println("Navigated back");
    }

    @Override
    public void beforeForward(WebDriver.Navigation navigation) {
        System.out.println("Before navigating forward");
    }

    @Override
    public void afterForward(WebDriver.Navigation navigation) {
        System.out.println("Navigated forward");
    }

    @Override
    public void beforeRefresh(WebDriver.Navigation navigation) {
        System.out.println("Before refreshing the page");
    }

    @Override
    public void afterRefresh(WebDriver.Navigation navigation) {
        System.out.println("Refreshed the page");
    }

	@Override
	public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
		System.out.println("Error occurred during method execution");
	    System.out.println("Target: " + target.getClass().getName());
	    System.out.println("Method: " + method.getName());
	    System.out.println("Exception: " + e.getMessage());
	}
 
}

