package ranom;

import community.Address;
import community.AddressType;
import community.Customer;
import config.SystemConfig;
import database.HousingCommunityDbService;
import payments.CustomerPayment;
import rent.MonthRent;
import utils.data.ActualDateUtils;
import utils.random.RandomDataUtil;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Zadaniem klasy jest wygenerowanie losowych danych do "bazy danych". Danych wejśćiowych dla aplikacji
 */

public class RandomDataInitializer {

    public static List<MonthRent> generateMonthRateForYear() {
        final List<MonthRent> result = new ArrayList<MonthRent>();
        for (int i = 1; i <= ActualDateUtils.getMonth(); i++) {
            final double amount = RandomDataUtil.randomDouble(500, 600);
            final MonthRent monthRent = new MonthRent(amount, i, ActualDateUtils.getYear());
            result.add(monthRent);
        }
        return result;
    }

    public static List<Customer> generateCommunity() {
        final List<Customer> customers = new ArrayList<>();
        for(int i = 0; i< SystemConfig.NUMBER_OF_CUSTOMERS; i++){
            customers.add(createRandomCustomer(i));
        }
        return customers;
    }

    private static Customer createRandomCustomer(int flat) {
        final Long customerId = RandomDataUtil.randomCustomerId(599, 12414444);
        final String firstName = RandomDataUtil.randomAlphaNumericString(5);
        final String lastName = RandomDataUtil.randomAlphaNumericString(5);
        final String street = RandomDataUtil.randomAlphaNumericString(15);
        final Long streetNumber = RandomDataUtil.randomCustomerId(1, 90);
        final String login = generateLogin(firstName, lastName);
        final Address addressBilling = new Address(AddressType.BILLING, street, streetNumber.intValue(), flat);
        final Address addressFlat = new Address(AddressType.FLAT, street, streetNumber.intValue(), flat);
        final List<CustomerPayment> randomPayments = randomPaymentForCustomer(customerId);
        return new Customer(customerId, firstName, lastName, login, addressBilling, addressFlat, randomPayments);
    }

    private static String generateLogin(String firstName, String lastName) {
        return firstName.charAt(0) + lastName.substring(0, 4);
    }

    private static List<CustomerPayment> randomPaymentForCustomer(Long customerId) {
        final List<CustomerPayment> randomPayments = new ArrayList<>();
        int paymentToRandom = RandomDataUtil.randomInt(1, LocalDateTime.now().getMonthValue());
        for(int i = 1; i <= paymentToRandom; i++) {
            randomPayments.add(new CustomerPayment(customerId, HousingCommunityDbService.getPaymentForMonth(i)));
        }
        return randomPayments;
    }
}
