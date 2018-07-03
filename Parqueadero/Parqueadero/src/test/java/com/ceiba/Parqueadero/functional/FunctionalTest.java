package com.ceiba.Parqueadero.functional;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class FunctionalTest {

	private static WebDriver driver = null;
/*	
	
	@BeforeClass
	public static void inicializarDriver() {
		
		System.setProperty("webdriver.chrome.driver","\\Estacionamiento\\Parqueadero\\Parqueadero\\Driver\\chromedriver.exe");
		
		driver = new ChromeDriver();
	}
	
	@AfterClass
	public static void destroy() {
		driver.quit();
	}
	
	@Test
	public void ComprobarRegistroDeVehiculo() throws InterruptedException {
		
		//Arrange
		driver.get("http://localhost:4200/");
		
		WebElement placaElement = driver.findElement(By.id("placa"));
		placaElement.sendKeys("MNZ784");
		//Act
		WebElement botonElement = driver.findElement(By.id("boton1"));
		botonElement.click();
		
		Thread.sleep(1000);
		
		WebElement botonSalirElement = driver.findElement(By.id("MNZ784"));
		botonSalirElement.click();
		
		WebElement totalElement = driver.findElement(By.id("Total"));
		String value = totalElement.getText();
		System.out.println(value);
		
		//Assert
		Assert.assertEquals("Total a pagar: $1000", value);;
	}
	
	@Test
	public void consultar() throws InterruptedException {
		//Arrange
		driver.get("http://localhost:4200/");
		
		WebElement placaElement = driver.findElement(By.id("placa2"));
		placaElement.sendKeys("MNZ784");
		
		//Act
		WebElement botonBuscarElement = driver.findElement(By.id("buscar"));
		botonBuscarElement.click();
		
		Thread.sleep(1000);

		WebElement 	valueConsultaElement = driver.findElement(By.id("consulta-placa"));
		String resultado = valueConsultaElement.getText();
		
		//Assert
		Assert.assertEquals("MNZ784", resultado);
	}*/
}
