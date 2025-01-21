package rent;

public class MonthRent {
    private double amount;
    private int month;
    private int year;

    public MonthRent(double amount, int month, int year) {
        this.amount = amount;
        this.month = month;
        this.year = year;
    }

    public double getAmount() {
        return amount;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void printInformation(){
        System.out.println("Month Rent: " + month + " Year: " + year + "ammount: " + amount);
    }

    public String getInformation(){
        return ("Month Rent: " + month + " Year: " + year + " ammount: " + amount);
    }
}
