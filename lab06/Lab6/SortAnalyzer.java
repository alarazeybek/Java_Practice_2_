public abstract class SortAnalyzer {
    private  int numberOfComparisons=0;
    protected int k;

    public void set_k(int new_k){
        this.k=new_k;
    }
    protected Integer compare(Comparable o1, Comparable o2){
        if( o1 instanceof Integer && o2 instanceof Integer){
            Integer i1 = (Integer) o1;
            Integer i2 = (Integer) o2;
            numberOfComparisons++;
            return i1.compareTo(i2); //if i1>i2 = 1 else if i1<i2 = -1
        }
        else{
            return -1;
        }
    }
    /*public boolean isSorted(Comparable[] arr){ 
        boolean b = true;
        if(arr instanceof Integer[]){

            if((Integer) arr[0] <= (Integer) arr[arr.length-1]){ //kucukten buyuye sort bakıyor
                for(int index2 = 0; index2<arr.length;index2++){
                    for(int index1 = 1; index1<arr.length; index1++){
                        if(compare(arr[index1], arr[index2])<0){
                            b=false;
                            index1 = arr.length; //looptan çıkmak için
                            index2 = arr.length;
                        }
                    }
                }
            }     
            else{                                                      //buyukten kucuge sort bakıyor
                for(int index2 = 0; index2<arr.length;index2++){
                    for(int index1 = 1; index1<arr.length; index1++){
                        if(compare(arr[index1], arr[index2])>1){
                            b=false;
                            index1 = arr.length; //looptan çıkmak için
                            index2 = arr.length;
                        }
                    }
                }
            }

        }
        return b;
    } */
    public boolean isSorted(Comparable[] arr){ 
        boolean ascending = true;
        boolean descending = true;
        
        if(compare(arr[0], arr[1]) > 0){
            descending = false;
        }
        else if(compare(arr[0], arr[1]) < 0){
            ascending = false;
        }
        
        for(int i = 0; i < arr.length - 1; i++){
            if(ascending && compare(arr[i], arr[i+1]) < 0){
                return false;
            }
            else if(descending && compare(arr[i], arr[i+1]) > 0 ){
                return false;
            }
        }
        return true; }

    public abstract Comparable[] sort(Comparable[] arr);

    //Helper methods

    public int getNumberOfComparisons(){
        return this.numberOfComparisons;
    }

    public void swap(Integer[] arr, int low, int high){
        Integer temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }
}
