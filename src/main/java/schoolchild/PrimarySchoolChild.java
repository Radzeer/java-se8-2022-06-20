package schoolchild;

public interface PrimarySchoolChild {
    static PrimarySchoolChild of(int age) {
        if (5 < age && 11 > age) {
            return new LowerClassSchoolChild(age);
        } else if (10 < age && 15 > age) {
            return new UpperClassSchoolChild(age);
        } else throw new IllegalArgumentException("Age is not in expected range!");
    }
}
