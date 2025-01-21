package operation;

import community.Customer;
import database.HousingCommunityDbService;
import payments.CustomerPayment;
import rent.MonthRent;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Zadaniem klasy jest odpowiedzialność za wszelkie operacji - po zalogowaniu
 */
public class OperationService {

    public static void printAllMonthToPay(){
        HousingCommunityDbService.MONTH_RENTS_DB.forEach(MonthRent::printInformation);
    }
// wyświetla historię płatności użytkowników
    public static void printAllCustomerPayment(long customerId){
        final Customer customer = HousingCommunityDbService.getCustomer(customerId);
        System.out.println("History of payments for customer: " + customer);
        customer.getCustomerPayments()
                .stream().sorted(Comparator.comparing(p -> p.getMonthRent().getMonth()))
                .forEach(CustomerPayment::printPaymentDetails);
    }
    // metoda odpowiedzialna za wybieranie miesiąca do opłacenia
    public static void payForMont(long customerId){
        System.out.println("Który miesiąć chcesz opłacić?");
        int month = new Scanner(System.in).nextInt();
        final Customer customer = HousingCommunityDbService.getCustomer(customerId);
        final boolean paymentExist = customer.getCustomerPayments().stream().anyMatch(p -> p.getMonthRent().getMonth() == month);
        // jeżeli dany miesiąc jest opłacony, wypisz dany komunikat
        if(paymentExist){
            System.out.println("Bład operacji! Za ten miesiąc już zapłaciłeś! Przejdż do historii swoich płatności");
        } else {
            final MonthRent paymentForMonth = HousingCommunityDbService.getPaymentForMonth(month);
            customer.getCustomerPayments().add(new CustomerPayment(customerId, paymentForMonth));
            System.out.printf("Dziękuje za wpłatę za miesiac " + month + " na kwotę " + paymentForMonth.getAmount());
        }
    }
}
