package co.chepito.seguros.seguroschepitoapiprocesador.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilDate {

    private UtilDate() {
        throw new IllegalStateException("Utility class");
    }
    private static final String DEFAULT_VALUE_DATE_AS_STRING = "01/01/0001 00:00:00";
    private static final String FORMAT_VALUE_DATE = "dd/MM/yyyy HH:mm:ss";
    private static final String FORMAT_VALUE_DATE_TO_STRING = "yyyy-MM-dd";
    private static final Date DEFAULT_VALUE_DATE;

    static {
        try {
            DEFAULT_VALUE_DATE = fromStringToDate(DEFAULT_VALUE_DATE_AS_STRING);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }


    public static Date fromStringToDate(final String dateValue) throws ParseException {
        DateFormat format = new SimpleDateFormat(FORMAT_VALUE_DATE);
        Date dateTime;
        try {
            dateTime = format.parse(dateValue);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        return dateTime;
    }

    public static Date getDefaultValueDate(){
        return DEFAULT_VALUE_DATE;
    }

    public static String formatDateToString(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(FORMAT_VALUE_DATE_TO_STRING);
        return dateFormat.format(date);
    }
}
