package stream;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Tasks {

    private static  IntStream inputForSum = IntStream.range(1,11);
    private IntStream inputForCount = IntStream.of(1,2,3,4,-1-2-3,0,77,88);
    private static Stream words = List.of("egy","kettő","alma","aaaaaabbbbbb").stream();

    private List<Employee> employees = new ArrayList(List.of(
            new Employee("Adam",1982,1000000),
            new Employee("West",1980,2000000),
            new Employee("Anna",1982,2100000)
    ));

    private static boolean test(String s) {
        return s.contains("Putyin");
    }

    public int sum(IntStream input){
        return input.sum();
    }

    public int count(IntStream input){
        return (int) input.filter(e -> (e < 0)).count();
    }

    public String searchLongest(Stream input){
        return input.max(Comparator.comparingInt(String::length)).get().toString();
    }

    public boolean even(IntStream input){
        return input.allMatch(e -> e % 2 ==0);
    }

    public boolean even2(IntStream input){
        return !input.anyMatch(e -> e % 2 != 0);
    }

    public List<String> employeeNames(List<Employee> employees){
        return employees.stream().map(e -> e.getName()).toList();
    }

    public List<String> employeeBySalary(List<Employee> employees){
        return employees.stream().filter( e -> e.getSalary() > 100000).map(e -> e.getName()).toList();
    }

    public List<String> names(List<String> input){
        return input.stream().flatMap(s -> Arrays.stream(s.split(" "))).distinct().toList();
    }

    public List<String> getMiddleNames(List<String> names){
        return names.stream().flatMap(name -> getMiddleName(name).stream()).toList();
    }

    public static Optional<String> getMiddleName(String name){
        String[] parts = name.split(" ");
        if (parts.length==3){
            return Optional.of(parts[1]);
        }else {
            return Optional.empty();
        }
    }

    public int countWord(){

        try  (var lines = Files.lines(Path.of("c:/idea_projects/index.html"))){
            return (int) lines.filter(Tasks::test).count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void paralell(){
        IntStream.range(0,100).mapToDouble(i -> Math.random()).mapToObj(d -> d).toList();
        DoubleStream.generate(() -> Math.random()).limit(100).mapToObj(d->d).toList();
        Stream.generate(Math::random).limit(100).toList();
    }



    public static void main(String[] args) {
        List<String> names= List.of("Aaaa Bbb Ccc","John Doe","Agre ee www");
        System.out.println(new Tasks().getMiddleNames(names));

        System.out.println(new Tasks().countWord());
    }

}
