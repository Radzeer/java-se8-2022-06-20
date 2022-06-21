package stream;

import jdk.jfr.StackTrace;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;

class testTasks {

    @Test
    void testSum() {
        assertEquals(55, new Tasks().sum(IntStream.range(1, 11)));
    }

    @Test
    void testCount(){
        assertEquals(3,new Tasks().count(IntStream.of(1,2,3,4,-1,-2,-3,0,77,88)));
    }

    @Test
    void testSearchLongest(){
        assertEquals("aaaaaabbbbbb",new Tasks().searchLongest(List.of("egy","kettő","alma","aaaaaabbbbbb").stream()));
    }

    @Test
    void testEven(){
        assertEquals(true,  new Tasks().even(IntStream.of(2,4,6,8,10)));
        assertEquals(false,  new Tasks().even(IntStream.of(2,4,6,1,10)));
    }

    @Test
    void testEven2(){
        assertEquals(false,  new Tasks().even2(IntStream.of(2,5,7,9)));
        assertEquals(true,  new Tasks().even2(IntStream.of(2,10,20)));
    }

    @Test
    void testEmployeeNames(){
        List<Employee> employees =  new ArrayList(List.of(
                new Employee("Adam",1982,1000000),
                new Employee("West",1980,2000000),
                new Employee("Anna",1982,2100000)
        ));


    }

    @Test
    void testName(){
        List<String> names = List.of("John Doe","John Jack Doe");
        assertLinesMatch(List.of("John","Doe","Jack"),new Tasks().names(names));

    }
}
