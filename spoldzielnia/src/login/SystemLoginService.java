package login;

import config.SystemConfig;
import database.HousingCommunityDbService;

import java.util.Scanner;
/**
 * Zadaniem klasy jest przeprowadzanie logiki zalogowania się do aplikacji
 */
public class SystemLoginService {

    public static long loginToApp() {
        long customerId = 0L;
        int attempts = 0;
        while (customerId == 0) {
            customerId = SystemLoginService.tryToLog();
            if (customerId == 0) {
                System.out.println("Pozostało prób: " + (SystemConfig.MAX_LOGIN_ATTEMPTS - attempts));
                attempts++;
            }
            if (attempts > SystemConfig.MAX_LOGIN_ATTEMPTS) {
                System.out.println("Error! Max attempts reached. Program will exit!");
                return 0L;
            }
        }
        return customerId;
    }

    private static long tryToLog() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj Login:");
        final String login = scanner.nextLine();
        System.out.println("Podaj Hasło:");
        final String password = scanner.nextLine();
        if (HousingCommunityDbService.userLoginExist(login) && SystemConfig.GLOBAL_PASSOWRD.equals(password)) {
            System.out.println("Witaj " + login + "!" + "Logowanie powidodło się");
            return HousingCommunityDbService.getCustomer(login).getCustomerId();
        } else {
            System.out.println("Logowanie nie powiodło się - sprawdź login lub hasło!");
            return 0L;
        }
    }
}
