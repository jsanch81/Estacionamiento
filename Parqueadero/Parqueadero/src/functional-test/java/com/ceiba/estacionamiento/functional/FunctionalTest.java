package com.ceiba.estacionamiento.functional;

import java.io.File;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.DEFINED_PORT)
public class FunctionalTest {

	private static WebDriver driver = null;
	
	@BeforeClass
	public static void inicializarDriver() {
		
		String sSistemaOperativo = System.getProperty("os.name");
		if(sSistemaOperativo.indexOf("Windows")>=0) {
			File file = new File("Driver/chromedriver.exe");
			String path = file.getAbsolutePath();
			System.setProperty("webdriver.chrome.driver",path);
			System.out.println(path);

		}else {
			File file = new File("Driver/chromedriver.exe");
			String path = file.getAbsolutePath();
			System.out.println(path);
			System.setProperty("webdriver.chrome.driver","Driver/chromedriver");
		}
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		driver = new ChromeDriver(options);

	}

	@AfterClass
	public static void destroy() {
		driver.quit();
	}
	
	@Test
	public void ComprobarRegistroDeVehiculo() throws InterruptedException {
		
		//Arrange

		driver.get("http://localhost:8080/");
		
		Thread.sleep(10000);

		WebElement mySelectElement = driver.findElement(By.id("tipo"));
		Select dropdown= new Select(mySelectElement);
		
		dropdown.selectByVisibleText("carro");
		
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

		driver.get("http://localhost:8080/");
		Thread.sleep(10000);

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
	}
}
