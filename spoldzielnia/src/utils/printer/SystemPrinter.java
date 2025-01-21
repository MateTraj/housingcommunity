package utils.printer;

import community.Customer;
import database.HousingCommunityDbService;
import utils.data.ActualDateUtils;
/**
 * Zadaniem klasy jest wyświetlanie danych na konsole - tekstowe zebranie startowych informacji
 */
public class SystemPrinter {

    public static void printOperationToChose() {
        System.out.println("Wybierz operacje:");
        System.out.println("1 - Wyświetl płatnośći do zapłacenia w tym roku");
        System.out.println("2 - Wyświetl historie moich płatności:");
        System.out.println("3 - Opłać miesiąc");
        System.out.println("-1 - Wyloguj sie");
    }

    public static void printActualPayMont() {
        System.out.println("Aktualny czas rozliczeniowy " + ActualDateUtils.getMonth() + " " + ActualDateUtils.getYear());
    }

    public static void printCustomersFromDb(){
        System.out.println("Aktualnie członkowie naszej wspólnoty!");
        HousingCommunityDbService.CUSTOMERS_DB.forEach(Customer::printData);
    }
}
