package community;

public class Address {
    private AddressType addressType;
    private String street;
    private int streetNumber;
    private int flatNumber;

    public Address(AddressType addressType, String street, int streetNumber, int flatNumber) {
        this.addressType = addressType;
        this.street = street;
        this.streetNumber = streetNumber;
        this.flatNumber = flatNumber;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressType=" + addressType +
                ", street='" + street + '\'' +
                ", streetNumber=" + streetNumber +
                ", flatNumber=" + flatNumber +
                '}';
    }
}
