import java.util.ArrayList;
import java.util.Random;

public class RandomArrayGenerator implements ArrayGenerator {

    @Override
    public Integer[] generate(Integer n) {
        Random r = new Random();
        ArrayList<Integer> a = new ArrayList<>();
        Integer[] temp = new Integer[n];
        for(Integer i = 1;i<=n;i++){
            a.add(i);
        }
        for(Integer i = n-1 ; i>=0 ; i--){
            Integer c = r.nextInt(i+1);
            temp[i]=a.get(c);
            a.remove(temp[i]);
        }
        return temp;
    }

    //helper methods
    public String toString(Comparable[] comparables){
        String str = "";
        for(Comparable j :comparables){
            str = str+ j +" ";
        }
        return str;
    }
    
}
