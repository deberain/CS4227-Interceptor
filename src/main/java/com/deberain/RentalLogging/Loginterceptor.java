package com.deberain.RentalLogging;

public class Loginterceptor implements ILogInterceptor{
    @Override
    public void onRentalAssignment(RentalLog log) {
        String formatted_log = String.format("%s: Customer %s rented %s for %d days, incurring a cost of %.2f",
                log.GetTimeOfLog(),
                log.GetCustomerName(),
                log.GetMovieTitle(),
                log.GetDaysRented(),
                log.GetRentalCharge()
        );
        System.out.println(formatted_log);
    }
}
