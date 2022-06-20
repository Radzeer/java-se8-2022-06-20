package cloth;

public interface Square {

    double getSide();

    default int getNumberOfSides()
    {
        return 4;
    }

    default double getPerimeter(){
        return getNumberOfSides() * getSide();
    }

    default double  getArea(){
        return getSide()*getSide();
    }
}
