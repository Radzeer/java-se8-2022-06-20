package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectMain{





    public static void main(String[] args) {
        List<Integer> numbers = List.of(1,2,3,4,5,6,-1,5,0,0);
        System.out.println(numbers.stream().reduce(0,(x,y)-> x+y,(x,y)->x+y));

        String s="xxXyyxXXyzz";

        //Melyik karakter hányszor szerepel?

        System.out.println(s.chars().mapToObj(c-> Character.toLowerCase((char)c)).collect(Collectors.groupingBy(c -> c,Collectors.counting())));

        System.out.println(Arrays.stream(s.split("")).map(String::toLowerCase).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));


        System.out.println(numbers.stream().collect(Counts::new, Counts::classify, Counts::addAll));
        System.out.println(numbers.stream().collect(Counts.count()));




    }
}
