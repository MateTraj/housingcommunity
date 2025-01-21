package database;

import community.Customer;
import ranom.RandomDataInitializer;
import rent.MonthRent;

import java.util.ArrayList;

public class HousingCommunityDbService {

    public static final ArrayList<MonthRent> MONTH_RENTS_DB = new ArrayList<>();
    public static ArrayList<Customer> CUSTOMERS_DB = new ArrayList<>();

    public static void initializeDb() {
        // generowanie danych do listy rachunków do oplaty - ile bylo czynszu w kazdym miesiacu do dzisiaj i ile zaplacil
        MONTH_RENTS_DB.addAll(RandomDataInitializer.generateMonthRateForYear());
        // lista klientow aplikacji "na start". Mozemy sie zalogowac na dowolnego z nich globalnych haslem
        CUSTOMERS_DB.addAll(RandomDataInitializer.generateCommunity());
    }

    //Metoda zwraca, na podstawie loginy, czy taki user istnieje
    public static boolean userLoginExist(String login){
        return CUSTOMERS_DB.stream().anyMatch(customer -> customer.getLogin().equals(login));
    }

    //Metoda zwraca obiekt Customer dla loginu
    public static Customer getCustomer(String login){
        return CUSTOMERS_DB.stream().filter(customer -> customer.getLogin().equals(login)).findFirst().get();
    }
    //Metoda zwraca obiekt Customer, wyszukujac pod id
    public static Customer getCustomer(Long customerId){
        return CUSTOMERS_DB.stream().filter(customer -> customer.getCustomerId().equals(customerId)).findFirst().get();
    }

    //Metoda zwraca informacje o wyliczonm czynszu - na podstawie numeru miesiaca
    public static MonthRent getPaymentForMonth(int month){
        return MONTH_RENTS_DB.stream().filter(m -> m.getMonth() == month).findFirst().get();
    }
}
