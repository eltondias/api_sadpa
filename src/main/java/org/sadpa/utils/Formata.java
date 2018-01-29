package org.sadpa.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Formata {
		
	public static String DataTime(Calendar DataTime ){				
		if(DataTime!=null){
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-dd-MM HH:mm:ss");				
			return formato.format(DataTime.getTime());	
		}else return null;		
	}
 
	
	public static String Data(Date Data){				
		if(Data!=null){
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-dd-MM HH:mm:ss");				
			return formato.format(Data.getTime());	
		}else return null;		
	}
	
}
