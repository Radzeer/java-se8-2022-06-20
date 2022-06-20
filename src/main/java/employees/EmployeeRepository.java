package employees;

public class EmployeeRepository {

    public long saveEmployee(String name){
        System.out.println("Save employee:" + name);
        return 1;
    }
}
