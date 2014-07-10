package vinicius.ferneda.tcc.certics.util;

import java.util.Calendar;
import java.util.Date;

public final class DateUtils {

	private DateUtils() {
		throw new UnsupportedOperationException();
	}
	
	public static Date getDataAtualSemHora() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	public static boolean dataMenorDataAtualSemHora(Date date) {
		return date.compareTo(getDataAtualSemHora()) < 0;
	}

}
