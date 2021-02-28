package edu.pingpong;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Before;

public class UfosParkTest {
    UfosPark ufos = null;
    String[] ovnis = { "unx", "dox", "trex" };

    @Before
    public void setupUfosPark() {
        ufos = new UfosPark();
        for (String ovni : ovnis) {
			ufos.add(ovni);
        }
    }
    @Test
    public void dispatchTest(){
        CreditCard creditCard = new CreditCard("Carlos", "123456789");
        ufos.dispatch(creditCard);
        List<String> list = ufos.cardNumbers().stream().filter(n -> n == creditCard.number()).collect(Collectors.toList());
        assertEquals(1, list.size(), 0);
        assertEquals(true, ufos.containsCard(creditCard.number()));
    }
    @Test
    public void getUfoOfTest(){
        CreditCard creditCard = new CreditCard("Carlos", "123456789");

        ufos.dispatch(creditCard);

        assertTrue(ufos.toString().contains(ufos.getUfoOf(creditCard.number())));
        
    }
}
