import java.util.ArrayList;
import java.util.Collections;

public class IntegerArrayList{
    private ArrayList <IntegerArray> numbers;

    IntegerArrayList(){}
    IntegerArrayList(ArrayList<String> strArrayList ){
        numbers = new ArrayList<>();
        for(String str : strArrayList){
            numbers.add(new IntegerArray(str));
        }
    }
    public int getSize(){
        return numbers.size();
    }
    public IntegerArray getIntegerArrayAt(int index){
        return numbers.get(index);
    }
    public void setIntegerArrayAt(int index, IntegerArray intArr){
        numbers.set(index, intArr);
    }
    public void addIntegerArray(String number){
        numbers.add(new IntegerArray(number));
    }
    public void removeIntegerArray(int index){
        numbers.remove(index);
    }
    public void removeIntegerArray(IntegerArray intArr){
        numbers.remove(intArr);
    }
    public IntegerArray min(int start, int end){
        /*IntegerArray Min = numbers.get(start);
        for(int i = start+1;i<end;i++){
            if(numbers.get(i).compareTo(Min)<0){
                Min = numbers.get(i);
            }
        }
        return Min; */
        ArrayList<IntegerArray> n = new ArrayList<>() ;
        while(start<=end){
            n.add(numbers.get(start));
            start++;
        }
        Collections.sort(n);
        return n.get(0);
    }

}