package com.deberain.fowlerRental;

import java.util.ArrayList;
import java.util.List;
import com.deberain.RentalLogging.LogDispatcher;
import com.deberain.RentalLogging.RentalLog;

public class Customer {

    private String name;
    private List<Rental> rentals = new ArrayList<Rental>();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
        RentalLog log = new RentalLog(this, rental);
        LogDispatcher.GetDispatcherInstance().onRentalAssignment(log);
    }

    public String statement() {
        String result = "Rental record for " + getName() + "\n";
        for (Rental rental : rentals)
            result += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(rental.getCharge()) + "\n";
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
        return result;
    }

    private double getTotalCharge() {
        double total = 0;
        for (Rental rental : rentals)
            total += rental.getCharge();
        return total;
    }

    private int getTotalFrequentRenterPoints() {
        int total = 0;
        for (Rental rental : rentals)
            total += rental.getFrequentRenterPoints();
        return total;
    }

}
