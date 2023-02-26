package com.deberain.fowlerRental;

import java.time.LocalDateTime;

public class RentalLog {
    private Customer _customer;
    private Rental _rental;
    private LocalDateTime _timeOfLog;

    public RentalLog(Customer customer, Rental rental) {
        _customer = customer;
        _rental = rental;
        _timeOfLog = LocalDateTime.now();
    }

    public String GetCustomerName() {
        return _customer.getName();
    }

    public String GetMovieTitle() {
        return _rental.getMovie().getTitle();
    }

    public int GetDaysRented() {
        return _rental.getDaysRented();
    }

    public double GetRentalCharge() {
        return _rental.getMovie().getCharge(_rental.getDaysRented());
    }

    public String GetTimeOfLog() {
        return _timeOfLog.toString();
    }


}
