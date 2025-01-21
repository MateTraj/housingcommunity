package payments;

import rent.MonthRent;

public class CustomerPayment {

    private Long customerId;
    private MonthRent monthRent;


    public CustomerPayment(Long customerId, MonthRent monthRent) {
        this.customerId = customerId;
        this.monthRent = monthRent;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public MonthRent getMonthRent() {
        return monthRent;
    }

    public void printPaymentDetails() {
        System.out.println(customerId + "\t" + monthRent.getInformation());
    }
}
