package lambda;

import lombok.ToString;

@ToString
public class YearOfBirthQueryCriteria implements  QueryCriteria{
    private int yearOfBirth;

    public YearOfBirthQueryCriteria(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }


    @Override
    public boolean match(Employee employee) {
        return employee.getYearOfBirth() == yearOfBirth;
    }
}
