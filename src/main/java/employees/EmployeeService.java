package employees;

import java.util.Locale;

public class EmployeeService {

    EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public long saveEmployee(String name){
        String  modifiedName= name.trim().toUpperCase();
        long id = employeeRepository.saveEmployee(modifiedName);
        return id;
    }
}
