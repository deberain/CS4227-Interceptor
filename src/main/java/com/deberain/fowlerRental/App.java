package com.deberain.fowlerRental;

import com.deberain.RentalLogging.*;

public class App
{
    public static void main( String[] args )
    {
        LogInterceptor logInterceptor = new LogInterceptor();
        LogDispatcher.GetDispatcherInstance().RegisterLogInterceptor(logInterceptor);

        final String NAME = "John";
        final Movie THE_HULK = new Movie("The Hulk", Movie.CHILDREN);
        final Movie IRON_MAN = new Movie("Iron Man 4", Movie.NEW_RELEASE);
        final Movie SPIDER_MAN = new Movie("Spiderman", Movie.REGULAR);

        Customer customer = new Customer(NAME);

        customer.addRental(new Rental(SPIDER_MAN, 1));
        customer.addRental(new Rental(IRON_MAN, 2));
        
        System.out.println("\n" + customer.statement());

        System.out.println("\nRemove Interceptor and assign another Rental to customer.");

        LogDispatcher.GetDispatcherInstance().RemoveLogInterceptor(logInterceptor);

        customer.addRental(new Rental(THE_HULK, 3));

        System.out.println("\n" + customer.statement());

        System.out.println("\nLogging service was successfully disabled");
    }
}
