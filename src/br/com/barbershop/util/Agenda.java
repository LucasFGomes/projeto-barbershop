package br.com.barbershop.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class Agenda {
	
	private static List<String> horarios;
 	private static List<String> listaDatas;
	
	public static List<String> getHorarios () {
		
		Calendar horario = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		horarios = new ArrayList<>();
		
		horario.set(Calendar.HOUR_OF_DAY, 8);
		horario.set(Calendar.MINUTE, 00);
		
		horarios.add(sdf.format(horario.getTime()));  //0
		
		for (int i = 1; i < 7; i++) {
			horario.add(Calendar.MINUTE, 40);	
			horarios.add(sdf.format(horario.getTime()));	
		}
		
		horario.set(Calendar.HOUR_OF_DAY, 13);
		horarios.add(sdf.format(horario.getTime()));  //7
		
		
		for (int i = 8; i < 14; i++) {
			horario.add(Calendar.MINUTE, 40);	
			horarios.add(sdf.format(horario.getTime()));
		}
		
		return horarios;	
	}
	
	public static List<String> getDatas() {
		
		Calendar data = Calendar.getInstance();
		listaDatas = new ArrayList<>();

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		listaDatas.add(sdf.format(data.getTime()));
		
		for (int i = 1; i < 10; i++) {
			data.add(Calendar.DAY_OF_MONTH, 1);
			listaDatas.add(sdf.format(data.getTime()));
		}
		
		return listaDatas;
		
	}
	

}
