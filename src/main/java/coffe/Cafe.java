package coffe;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;


public class Cafe {
    private final List<CoffeOrder> orders= new ArrayList<>();

    public Cafe(List<CoffeOrder> orders){
        this.orders.addAll(orders);
    }

    public void addOrder(CoffeOrder order){
        this.orders.add(order);
    }

    public long getTotalIncome(LocalDate date){
        BinaryOperator<Integer> addOperator = Integer::sum;
        return orders.stream()
                .filter(o -> o.getOrderDate().isEqual(date))
                .flatMap(co ->co.getCoffes().stream())
                .map(Coffee::getPrice)
                .reduce(0,addOperator,addOperator);
    }

    public static void main(String[] args) {

        var cafe = new Cafe(List.of(
                new CoffeOrder(List.of(
                        new Coffee(10),
                        new Coffee(12),
                        new Coffee(25)
                        )
                        ,LocalDate.of(2022, Month.JUNE,1)

                ),
                new CoffeOrder(List.of(
                        new Coffee(10),
                        new Coffee(25)
                        )
                        ,LocalDate.of(2022, Month.JUNE,10)

                ),
                new CoffeOrder(List.of(
                        new Coffee(10),
                        new Coffee(25),
                        new Coffee(9)
                        )
                        ,LocalDate.of(2022, Month.JUNE,10)

                )
        ));

        cafe.addOrder(new CoffeOrder(List.of(new Coffee(20)),LocalDate.of(2022, Month.JUNE,22)));

        var date = LocalDate.of(2022,Month.JUNE,10);

        System.out.printf("%s total income: %d%n",date,cafe.getTotalIncome(date));

    }
}
