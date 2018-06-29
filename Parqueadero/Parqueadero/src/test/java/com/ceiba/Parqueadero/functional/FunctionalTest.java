package com.ceiba.Parqueadero.functional;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class FunctionalTest {

	private static WebDriver driver = null;
	
	
	@BeforeClass
	public static void inicializarDriver() {
		driver = new ChromeDriver();
	}
	
	
	
	@Test
	public void ComprobarRegistroDeVehiculo() {
		driver.get("http://localhost:4200/");
		
		WebElement placaElement = driver.findElement(By.id("placa"));
		placaElement.sendKeys("MNZ784");
		
		WebElement botonElement = driver.findElement(By.id("boton1"));
		botonElement.click();
		
		WebDriverWait wait = new WebDriverWait(driver,5);
		WebElement successElement = driver.findElement(By.id("success"));
		wait.until(ExpectedConditions.visibilityOf(successElement));
		
		Assert.assertTrue(true);
	}
}
