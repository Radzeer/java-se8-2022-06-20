package cloth;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SquareTest {

    static class Dummy implements Square{

        @Override
        public double getSide() {
            return 4;
        }
    }

    @Test
    void testGetArea()
    {
        assertEquals(4, new Dummy().getSide());
    }
}
