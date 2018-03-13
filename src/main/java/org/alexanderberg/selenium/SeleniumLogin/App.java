package org.alexanderberg.selenium.SeleniumLogin;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Hello world!
 *
 */
public class App {
	
    public static void main( String[] args ) {
    	
    	System.setProperty("webdriver.gecko.driver", "p:\\selenium\\drivers\\geckodriver.exe");
    	System.setProperty("webdriver.chrome.driver", "p:\\selenium\\drivers\\chromedriver.exe");
    	System.setProperty("webdriver.edge.driver", "p:\\selenium\\drivers\\MicrosoftWebDriver.exe");

    	SeleniumLogin firefoxThread = new SeleniumLogin(new FirefoxDriver(),false);
    	SeleniumLogin chromeThread = new SeleniumLogin(new ChromeDriver(),false);
    	SeleniumLogin edgeThread = new SeleniumLogin(new EdgeDriver(),true);
    	
    	firefoxThread.start();
    	chromeThread.start();
    	edgeThread.start();
    }
}
