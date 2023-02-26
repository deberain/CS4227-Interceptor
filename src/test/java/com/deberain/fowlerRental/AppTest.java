package com.deberain.fowlerRental;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.deberain.RentalLogging.LogDispatcher;
import com.deberain.RentalLogging.LogInterceptor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AppTest 
{
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;


    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void TestInterceptor()
    {
        LogInterceptor logInterceptor = new LogInterceptor();
        LogDispatcher.GetDispatcherInstance().RegisterLogInterceptor(logInterceptor);

        final String NAME = "Frank";
        final Movie AVENGERS = new Movie("Avengers: Endgame", Movie.CHILDREN);

        Customer customer = new Customer(NAME);
        customer.addRental(new Rental(AVENGERS, 1));

        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        String expected = String.format("%s: Customer Frank rented \"Avengers: Endgame\" for 1 days, incurring a cost of 1.50 euro",
                LocalDateTime.now().format(myFormatObj)
        );
        assertEquals(expected, outContent.toString().trim());
    }
}
