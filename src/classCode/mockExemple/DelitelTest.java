package classCode.mockExemple;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DelitelTest {
    @Test
    void delit() {
        Kvadrator kvadrator = mock(Kvadrator.class);
        when(kvadrator.kvadrator(2)).thenReturn((4d));
        Delitel.kvadrator = kvadrator;
        double result = Delitel.delit(2);
        assertEquals( 4/5, result);
    }

}