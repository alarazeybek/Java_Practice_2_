public class DecreasingArrayGenerator implements ArrayGenerator {

    @Override
    public Integer[] generate(Integer n) {
        Integer[] temp = new Integer[n];
        for(Integer i = n;i>0;i++){
            temp[i-1]=i;
        }
        return temp;
    }
    public String toString(Comparable[] comparables){
        String str = "";
        for(Comparable j :comparables){
            str = str+ j +" ";
        }
        return str;
    }
}
