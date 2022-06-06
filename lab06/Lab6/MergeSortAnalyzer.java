public class MergeSortAnalyzer extends SortAnalyzer {

    @Override
    public Comparable[] sort(Comparable[] arr) {
        if(arr instanceof Integer[]){
            if(!isSorted(arr)){
                mergeSort(arr,0,arr.length-1);
            }
            return arr;
        }
        return arr;
    }
    public void mergeSort(Comparable[] arr, int low, int high){ //original merge sort
        if(arr instanceof Integer[]){
            if(low<high){
                int middle = (int) (low+high)/2;
                mergeSort(arr, low, middle);
                mergeSort(arr, middle+1, high);
                merge(arr,low,middle,high);
            }
        }
    } 
    public void merge(Comparable[] arr,int low,int middle,int high){
        if(arr instanceof Integer[]){ 
            if(high>=middle){

            int part1Length = (middle-low)+1;
            int part2Length = high-middle;
            Integer[] arr1 = (Integer[]) arr;
            Integer[] part1 = new Integer[part1Length];
            for(int i = 0 ; i<part1Length ; i++){
                part1[i]=arr1[low+i];
            }
            Integer[] part2 = new Integer[part2Length];
            for(int i = 0 ; i<part2Length ; i++){
                part2[i]=arr1[middle+1+i];
            }

            int k = low; //main array index
            int i=0, j = 0; //subarrays indexes

            while( i<part1Length && j<part2Length){
                if(compare(part1[i], part2[j])<0){
                    arr1[k] = part1[i];
                    i++;
                }
                else{
                    arr1[k] = part2[j];
                    j++;
                }
                k++;
            }
            //copying the rest
            while (j < part2Length) {
                arr1[k] = part2[j];
                k++;
                j++;
            }
            while (i < part1Length) {
                arr1[k] = part1[i];
                k++;
                i++;   
            }
        }
    }}
}
