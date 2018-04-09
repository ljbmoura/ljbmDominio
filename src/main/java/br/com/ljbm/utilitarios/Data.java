package br.com.ljbm.utilitarios;

import java.util.Calendar;
import java.util.Date;

/**
 * Metodos utilitarios para manipulacao de datas.
 * 
 * @author agazo
 *
 */
public class Data {
	  
	/**
	 * A partir da data especificada, retorna a mesma data com hora igual a
	 * 00:00:00:0
	 * 
	 * @param data
	 * @return
	 */
	public static Calendar obterDataDDMMAAAA(int dia, int mes, int ano) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DATE, dia);
		calendar.set(Calendar.MONTH, mes-1);
		calendar.set(Calendar.YEAR, ano);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar;
	}
	
	/**
	 * A partir da data especificada, retorna a mesma data com hora igual a
	 * 00:00:00:0
	 * 
	 * @param data
	 * @return
	 */
	public static Date obterDataComHoraZerada(Date data) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}
	
	/**
	 * A partir da data especificada, retorna a mesma data com hora igual a
	 * 23:59:59:59
	 * 
	 * @param data
	 * @return
	 */
	public static Date obterDataComHoraMaxima(Date data) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 59);
		return calendar.getTime();
	}
	
	/**
	 * Retorna o primeiro dia do m�s especificado.
	 * 
	 * @param mes
	 * @return
	 */
	public static Date obterPrimeiroDiaDoMes(Date mes) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(obterDataComHoraZerada(mes));
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		return calendar.getTime();
	}

	/**
	 * Retorna o �ltimo dia do m�s especificado.
	 * 
	 * @param mes
	 * @return
	 */
	public static Date obterUltimoDiaDoMes(Date mes) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(obterDataComHoraMaxima(mes));
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		return calendar.getTime();
	}
	
	/**
	 * Retorna o �ltimo dia do m�s anterior ao m�s especificado. Retorna com hora igual  00:00:00:0
	 * 
	 * @param mes
	 * @return
	 */
	public static Date obterUltimoDiaDoMesAnterior(Date mes) {
		Calendar mesAnterior = Calendar.getInstance();
		mesAnterior.setTime(mes);
		mesAnterior.add(Calendar.MONTH, -1);
				
		return obterDataComHoraZerada(obterUltimoDiaDoMes(mesAnterior.getTime()));
	}
}
