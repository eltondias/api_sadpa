package org.sadpa.utils;

import java.util.Calendar;
import java.util.TimeZone;

public class DataHora {
		
	public static Calendar dataHora = Calendar.getInstance();
	
	public DataHora() {
		dataHora.setTimeZone(TimeZone.getTimeZone("America/Belem"));
	}

	public static Calendar getDataHora() {
		return dataHora;
	}

}
