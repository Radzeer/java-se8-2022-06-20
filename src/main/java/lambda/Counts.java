package lambda;

import lombok.Data;

import java.util.stream.Collector;

@Data
public class Counts {

    private int numOfPositive;
    private int numOfNegative;
    private int numOfZero;

    public void classify(int number){
        if (number<0){
            numOfNegative++;
        }else if (number>0){
            numOfPositive++;
        }
        else{
            numOfZero++;
        }
    }

    public Counts addAll(Counts counts){
        this.numOfPositive+= counts.getNumOfPositive();;
        this.numOfNegative+=counts.getNumOfNegative();
        this.numOfZero+=counts.numOfZero;
        return this;

    }
    public static Collector<Integer,Counts,Counts> count(){
        return Collector.of(Counts::new,Counts::classify,Counts::addAll);
    }
}
