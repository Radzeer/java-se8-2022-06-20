package lambda;

import lombok.ToString;

@ToString
public class NameQueryCriteria implements QueryCriteria {


    private String name;

    public NameQueryCriteria(String name) {
        this.name = name;
    }

    @Override
    public boolean match(Employee employee) {
        return employee.getName().equals(name);
    }
}
