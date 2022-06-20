package lambda;

@FunctionalInterface
interface QueryCriteria {
    boolean match(Employee employee);

    static QueryCriteria byName(String name){
        return new NameQueryCriteria(name);
    }

    static QueryCriteria byAge(int age){
        return new YearOfBirthQueryCriteria(age);
    }



}
