package edu.pingpong;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class CreditCardTest {
    private CreditCard creditCard = null;

    @Before
    public void setUpCreditCard() {
        creditCard = new CreditCard("Carlos", "123456789");
    }

    @Test
    public void toStringTest() {
        assertEquals("owner: " + "Carlos" + "\n" + "number: " + "123456789" + "\n" + "credit: " + "3000.0" + "EZI",
                creditCard.toString());
    }

    @Test
    public void payTrueTest() {
        assertEquals(true, creditCard.pay(2500.0));
    }

    @Test
    public void payFalseTest() {
        assertEquals(false, creditCard.pay(3200.0d));
    }

    @Test
    public void creditTrueTest() {
        creditCard.pay(2000.0);
        assertEquals(1000.0, creditCard.credit(), 0);
    }

    @Test
    public void creditFalseTest() {
        creditCard.pay(4000.0);
        assertEquals(3000.0, creditCard.credit(), 0);
    }
}
