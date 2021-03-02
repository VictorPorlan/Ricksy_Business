package edu.pingpong;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CrystalExpenderTest {

    @Test
    public void dispatchTest() {

        CreditCard creditCard = new CreditCard("Carlos", "123456789");
        CrystalExpender crystalExpender = new CrystalExpender(10, 10.90);

        crystalExpender.dispatch(creditCard);

        assertEquals(9, crystalExpender.stock());
    }
}
