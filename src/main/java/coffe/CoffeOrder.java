package coffe;

import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
@AllArgsConstructor
public class CoffeOrder {

    private List<Coffe> coffes;
    private LocalDate orderDate;

    public List<Coffe> getCoffes() {
        return Collections.unmodifiableList(coffes);
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }
}
