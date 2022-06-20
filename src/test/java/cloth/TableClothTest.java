package cloth;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TableClothTest {

    @Test
    void getSide() {
        assertEquals(15, new TableCloth(15).getSide());
    }

    @Test
    void testGetNumberOfSides(){
        assertEquals(4, new TableCloth(15).getNumberOfSides());
    }

    @Test
    void testGetPerimeter(){
        assertEquals(20, new TableCloth(5).getPerimeter());
    }

    @Test
    void testGetArea(){
        assertEquals(25, new TableCloth(5).getArea());
    }
}