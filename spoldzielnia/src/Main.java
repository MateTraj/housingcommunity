import login.SystemLoginService;
import database.HousingCommunityDbService;
import operation.OperationService;
import utils.printer.SystemPrinter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Copyright: Mateusz Trajdos, ID: 123806");
        System.out.println();

        //uzupelnienie bazy danych
        HousingCommunityDbService.initializeDb();
        //wydruk na konsole informacji wstepnych
        printWelcomeInformation();
        //zalogowanie do aplikacji - przy sukcesie zwrocenie customer id - aby miec kontekst w obrebie dalszych zmian(kto sie zalogowal)
        final long loggedCustomerId = SystemLoginService.loginToApp();
        if(loggedCustomerId != 0L){
            int chosenOperation = 0;
            while(chosenOperation != -1){
                chosenOperation = getOperationFromuser();
                switch (chosenOperation){
                    case 1:
                        OperationService.printAllMonthToPay();
                        break;
                    case 2:
                        OperationService.printAllCustomerPayment(loggedCustomerId);
                        break;
                    case 3:
                        OperationService.payForMont(loggedCustomerId);
                        break;
                    case -1:
                        System.out.println("Wylogowanie powiodło się!");
                        break;
                    default: {
                        System.out.println("Błąd! Nieporządany numer operacji");
                    }
                }
            }
        } else {
            System.out.println("Logowanie nie udany - kończę prace");
        }
    }

    private static void printWelcomeInformation() {
        System.out.println("Witaj w naszej wspólnocie mieszkaniowej!");
        SystemPrinter.printActualPayMont();
        SystemPrinter.printCustomersFromDb();
        System.out.println("Wybierz login i zaloguj sie!");
    }

    private static int getOperationFromuser() {
        SystemPrinter.printOperationToChose();
        return new Scanner(System.in).nextInt();
    }
}
