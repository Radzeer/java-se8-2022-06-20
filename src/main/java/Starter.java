import cloth.TableCloth;
import schoolchild.PrimarySchoolChild;

public class Starter {

    public static void main(String[] args) {
        //TableCloth tableCloth = new TableCloth(2);
        //System.out.println(tableCloth.getPerimeter());

        PrimarySchoolChild primarySchoolChild = PrimarySchoolChild.of(16);
        System.out.println(primarySchoolChild.getClass().toString());

    }
}
