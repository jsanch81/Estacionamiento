package com.ceiba.Parqueadero.classes;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CobrarTest {

	@Autowired
	private Cobrar cobrar;
	
	@Mock
	private Tiempo tiempo;
	
	@Mock
	private Salida salida;
	
	@Mock
	private Parqueadero parqueadero;
	
	@Test
	public void genCobroTestCarro() {
		
		//Arrage
		String placa = "EHG44B";
		cobrar.setSalida(salida);
		int[] dayHoursMils = new int[3];
		dayHoursMils[0]=1;
		dayHoursMils[1]=3;
		dayHoursMils[2]=0;
		Calendar calendar = Calendar.getInstance();
		
		//Act
		Mockito.when(salida.genSalida(placa, parqueadero)).thenReturn(calendar.getTimeInMillis());
		Mockito.when(salida.tipoVehiculo(placa)).thenReturn("carro");
		Mockito.when(salida.getCilindraje(placa)).thenReturn((short)0);
		Mockito.when(tiempo.calculateDaysHoursMils(Mockito.anyLong(), Mockito.anyLong())).thenReturn(dayHoursMils);
		Mockito.when(tiempo.getTimestamp()).thenReturn(calendar.getTimeInMillis());
		int valor = cobrar.genCobro(placa, tiempo, parqueadero);
		System.out.println(valor);

		int esperado = dayHoursMils[0]*8000;
		esperado += (dayHoursMils[1]<9)?dayHoursMils[1]*1000:8000;
		esperado += (dayHoursMils[2]>0)?1000:0;
		
		//Assert
		Assert.assertEquals(esperado, valor);
		
	}
	
	@Test
	public void genCobroTestMoto() {
		
		//Arrage
		String placa = "EHG44B";
		cobrar.setSalida(salida);
		int[] dayHoursMils = new int[3];
		dayHoursMils[0]=0;
		dayHoursMils[1]=10;
		dayHoursMils[2]=0;
		Calendar calendar = Calendar.getInstance();
		short cilindraje = 650;
		//Act
		Mockito.when(salida.genSalida(placa, parqueadero)).thenReturn(calendar.getTimeInMillis());
		Mockito.when(salida.tipoVehiculo(placa)).thenReturn("moto");
		Mockito.when(salida.getCilindraje(placa)).thenReturn(cilindraje);
		Mockito.when(tiempo.calculateDaysHoursMils(Mockito.anyLong(), Mockito.anyLong())).thenReturn(dayHoursMils);
		Mockito.when(tiempo.getTimestamp()).thenReturn(calendar.getTimeInMillis());
		
		int valor = cobrar.genCobro(placa, tiempo, parqueadero);
		System.out.println(valor);
		int esperado = dayHoursMils[0]*4000;
		esperado += (dayHoursMils[1]<9)?dayHoursMils[1]*500:4000;
		esperado += (dayHoursMils[2]>0)?500:0;
		esperado += (cilindraje>500)?2000:0;
		//Assert
		
		
		Assert.assertEquals(esperado, valor);
		
	}
	
	@Test
	public void genCobroTestMoto2() {
		
		//Arrage
		String placa = "EHG44B";
		cobrar.setSalida(salida);
		int[] dayHoursMils = new int[3];
		dayHoursMils[0]=0;
		dayHoursMils[1]=10;
		dayHoursMils[2]=0;
		Calendar calendar = Calendar.getInstance();
		short cilindraje = 250;
		//Act
		Mockito.when(salida.genSalida(placa, parqueadero)).thenReturn(calendar.getTimeInMillis());
		Mockito.when(salida.tipoVehiculo(placa)).thenReturn("moto");
		Mockito.when(salida.getCilindraje(placa)).thenReturn(cilindraje);
		Mockito.when(tiempo.calculateDaysHoursMils(Mockito.anyLong(), Mockito.anyLong())).thenReturn(dayHoursMils);
		Mockito.when(tiempo.getTimestamp()).thenReturn(calendar.getTimeInMillis());
		
		int valor = cobrar.genCobro(placa, tiempo, parqueadero);
		System.out.println(valor);
		int esperado = dayHoursMils[0]*4000;
		esperado += (dayHoursMils[1]<9)?dayHoursMils[1]*500:4000;
		esperado += (dayHoursMils[2]>0)?500:0;
		esperado += (cilindraje>500)?2000:0;
		//Assert
		
		
		Assert.assertEquals(esperado, valor);
		
	}
}
