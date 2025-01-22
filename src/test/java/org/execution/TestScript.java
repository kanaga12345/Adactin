package org.execution;

import java.io.IOException;

import org.global.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestScript extends BaseClass {
	public static void main(String[] args) throws IOException, InterruptedException {
		BaseClass baseClass = new BaseClass();
		
		baseClass.getDriver(baseClass.readExcel(2, 2));
		
		baseClass.windowsMax();
		
		baseClass.getUrl(baseClass.readExcel(1, 3));
	
		baseClass.screenCapture();
		
		WebElement userName = driver.findElement(By.id("username"));
		userName.sendKeys(baseClass.readExcel(1, 0));
		
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys(baseClass.readExcel(1, 1));
		
		baseClass.screenCapture();
		
		WebElement loginButton = driver.findElement(By.id("login"));
		baseClass.clickButton(loginButton);
		
		baseClass.screenCapture();
		
		WebElement location = driver.findElement(By.name("location"));
		baseClass.selectByVisibleText(location, baseClass.readExcel(1, 4));
		
		WebElement hotels = driver.findElement(By.id("hotels"));
		baseClass.selectByVisibleText(hotels, baseClass.readExcel(1, 5));
		
		WebElement roomType = driver.findElement(By.id("room_type"));
		baseClass.selectByVisibleText(roomType, baseClass.readExcel(2, 6));
		
		WebElement numberofRooms = driver.findElement(By.id("room_nos"));
        baseClass.selectByVisibleText(numberofRooms, baseClass.readExcel(3, 7));
        
        WebElement date1 = driver.findElement(By.id("datepick_in"));
        date1.clear();
        date1.sendKeys(baseClass.readExcel(1, 8));
        
        WebElement date2 = driver.findElement(By.id("datepick_out"));
        date2.clear();
        date2.sendKeys(baseClass.readExcel(1, 9));
        
        WebElement adultRoom = driver.findElement(By.id("adult_room"));
        baseClass.selectByVisibleText(adultRoom, baseClass.readExcel(2, 10));
        
        WebElement childRooms = driver.findElement(By.id("child_room"));
        baseClass.selectByVisibleText(childRooms, baseClass.readExcel(2, 11));
        
        WebElement searchButton = driver.findElement(By.id("Submit"));
        baseClass.click(searchButton);
        
        baseClass.screenCapture();
        
        WebElement radioButton = driver.findElement(By.name("radiobutton_0"));
        baseClass.click(radioButton);
        
        WebElement continuButton = driver.findElement(By.id("continue"));
        baseClass.click(continuButton);
        
        baseClass.screenCapture();
        
        WebElement firstName = driver.findElement(By.name("first_name"));
        firstName.sendKeys(baseClass.readExcel(1, 12));
        
        WebElement lastName = driver.findElement(By.name("last_name"));
        lastName.sendKeys(baseClass.readExcel(1, 13));
        
        WebElement billingAddress = driver.findElement(By.name("address"));
        billingAddress.sendKeys(baseClass.readExcel(1, 14));
        
        WebElement creditCard = driver.findElement(By.id("cc_num"));
        creditCard.sendKeys(baseClass.readExcel(1, 15));
        
        WebElement creditCardType = driver.findElement(By.id("cc_type"));
        baseClass.selectByVisibleText(creditCardType, baseClass.readExcel(2, 16));
        
        WebElement expairyDate = driver.findElement(By.id("cc_exp_month"));
        baseClass.selectByVisibleText(expairyDate, baseClass.readExcel(3, 17));
        
        WebElement expairyYear = driver.findElement(By.id("cc_exp_year"));
        baseClass.selectByVisibleText(expairyYear, baseClass.readExcel(2, 18));
        
        WebElement cvvNumber = driver.findElement(By.id("cc_cvv"));
        cvvNumber.sendKeys(baseClass.readExcel(1, 19));
        
        WebElement bookNowButton = driver.findElement(By.id("book_now"));
        baseClass.click(bookNowButton);
        
        baseClass.screenCapture();
      
        WebElement ilitinerary = driver.findElement(By.xpath("//a[text()='Booked Itinerary']"));
        baseClass.click(ilitinerary);
        
        WebElement checkBok = driver.findElement(By.name("ids[]"));
        baseClass.clickButton(checkBok);
        
        WebElement cancelSelected = driver.findElement(By.name("cancelall"));
        baseClass.clickButton(cancelSelected);
        
        baseClass.confirmAlert("dismiss");
        
        WebElement logout = driver.findElement(By.id("logout"));
        baseClass.clickButton(logout);

        WebElement clickLogin = driver.findElement(By.xpath("//a[text()='Click here to login again']"));
        baseClass.clickButton(clickLogin);
        System.out.println("Hi Work Done by QA");
        System.out.println("QA Work");
        
        
        
        }
	

}
