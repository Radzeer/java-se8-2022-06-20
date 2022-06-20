package lambda;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.function.Predicate;

@AllArgsConstructor
public class EmployeeService {
    private List<Employee> employees;

    public Employee findEmployeeByName(String name){
        for (var employee: employees){
            if (employee.getName().equals(name)){
                return employee;
            }
        }
        throw new IllegalArgumentException("Not found with name: " + name);
    }

    public Employee findEmployee(QueryCriteria criteria){
        for (var employee: employees){
            if (criteria.match(employee)){
                return employee;
            }
        }
        throw new IllegalArgumentException("Not found with criteria: " + criteria.getClass().toString());
    }

    public Employee findEmployeeWithPredicate(Predicate<Employee> criteria){
        for (var employee: employees){
            if (criteria.test(employee)){
                return employee;
            }
        }
        throw new IllegalArgumentException("Not found with criteria: " + criteria.getClass().toString());
    }

    public static void main(String[] args) {
        var service = new EmployeeService(List.of(new Employee("John",33), new Employee("Jane",23)));
        Employee employee =service.findEmployee(QueryCriteria.byAge(22));
        System.out.println("Employee: " + employee.toString());

        System.out.println(service.findEmployee(employee1 -> employee1.getName().startsWith("J")));
        System.out.println(service.findEmployeeWithPredicate(employee1 -> employee1.getName().startsWith("Ja")));



    }


}
