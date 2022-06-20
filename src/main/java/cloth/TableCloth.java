package cloth;

public class TableCloth implements Square{

    private int side;

    public TableCloth(int side) {
        this.side = side;
    }

    @Override
    public double getSide() {
        return side;
    }
}
