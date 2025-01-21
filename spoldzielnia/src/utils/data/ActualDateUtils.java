package utils.data;

import java.time.LocalDate;

/**
 * Zadaniem klasy jest zwrócenie aktualnego miesiąca oraz roku - jedna logika pobierania dla całego kodu i całej aplikacji
 */
public class ActualDateUtils {

    public static int getMonth() {
        return LocalDate.now().getMonthValue();
    }

    public static int getYear() {
        return LocalDate.now().getYear();
    }
}
