package edu.pingpong;

import org.junit.Before;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ReceptivoTest {

    private UfosParkTest ufosPark = null;
    private CrystalExpender crystalExpender = null;
    private Receptivo receptivo = null;

    @Before
    public void setupTest() {

        ufosPark = new UfosParkTest();
        ufosPark.setupUfosPark();

        crystalExpender = new CrystalExpender(10, 50);

        receptivo = new Receptivo();

        receptivo.registra(ufosPark.ufos);
        receptivo.registra(crystalExpender);
    }

    @Test
    public void dispatchTest() {
        CreditCard creditCard = new CreditCard("Carlos", "123456789");
        receptivo.dispatch(creditCard);
        assertEquals(2450, creditCard.credit(), 0);
        assertEquals(9, crystalExpender.stock());
    }
}
