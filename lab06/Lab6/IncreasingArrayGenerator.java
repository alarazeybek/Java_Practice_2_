public class IncreasingArrayGenerator implements ArrayGenerator {

    @Override
    public Integer[] generate(Integer n) {
        Integer[] temp = new Integer[n];
        for(Integer i = 0; i<n;i++){
            temp[i]=i+1;
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
