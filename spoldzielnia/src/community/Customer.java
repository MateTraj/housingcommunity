package community;

import payments.CustomerPayment;

import java.util.List;

public class Customer {

    private Long customerId;
    private String firstName;
    private String lastName;
    private String login;
    private Address billingAddress;
    private Address flatAddress;
    private List<CustomerPayment> customerPayments;

    public Customer(Long customerId, String firstName,
            String lastName, String login,
            Address billingAddress, Address flatAddress,
            List<CustomerPayment> customerPayments) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.billingAddress = billingAddress;
        this.flatAddress = flatAddress;
        this.customerPayments = customerPayments;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLogin() {
        return login;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public Address getFlatAddress() {
        return flatAddress;
    }

    public List<CustomerPayment> getCustomerPayments() {
        return customerPayments;
    }

    public void printData() {
        System.out.println( "Customer{" +
                "customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", login='" + login + '\'' +
                ", billingAddress=" + billingAddress +
                ", flatAddress=" + flatAddress +
                '}');
    }
}
