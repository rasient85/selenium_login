package org.alexanderberg.selenium.SeleniumLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumLogin extends Thread {
	
	public static final String LOGIN_PAGE = "http://testing-ground.scraping.pro/login";
	
	private WebDriver webDriver;
	private boolean isEdge;

	public SeleniumLogin (WebDriver webDriver, boolean isEdge) {
		super();
		this.webDriver = webDriver;
		this.isEdge = isEdge;
	}
	
	public void run() {
        webDriver.get(LOGIN_PAGE);
        element(By.id("usr")).sendKeys("admin");
        element(By.id("pwd")).sendKeys("12345");
        click(By.xpath("//*[@id=\"case_login\"]/form/input[3]"), isEdge);
    }
    
    public WebElement element(By locator){
    	Integer timeoutLimitSeconds = 60;
        WebDriverWait wait = new WebDriverWait(webDriver, timeoutLimitSeconds);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        WebElement element = webDriver.findElement(locator);
        return element;
    }
    
    public void click(By locator, boolean isEdge) {
    	WebElement element = element(locator);
    	if (isEdge) {
    		((JavascriptExecutor)webDriver).executeScript("arguments[0].click();", element);
    	} else {
    		element(locator).click();
    	}
    }
	
}