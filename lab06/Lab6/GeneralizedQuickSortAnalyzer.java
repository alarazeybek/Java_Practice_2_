public class GeneralizedQuickSortAnalyzer extends SortAnalyzer {
    @Override
    public Comparable[] sort(Comparable[] arr) {
        if(arr instanceof Integer[]){
            Integer[] arr1 = (Integer[]) arr;
            if(!isSorted(arr1)){
                quickSort_k(arr1, 0, arr1.length-1,k);
            }
            return arr1;
        }
        return arr;
    }

    public void quickSort_k(Integer[] arr, int f, int l, int K){
        if(f<l){
                int pivot = partition(arr, f, l, K); // sol baştan gelen değişim int i
                quickSort_k(arr, pivot+1, l, K); //after
                quickSort_k(arr, f, pivot-1,K); //before
            
        }
    }
    public int partition(Integer[] arr, int f, int l, int K){
        int pivot= arr[l];
        int i = f;
        for(int a = 0; a<K-1; a++){ 
            i=f;
            pivot= arr[l];
            for (int j=f; j<l; j++){ // küçük element ile arr[f] değiştir f indexini bir ilerlt
                if(compare(arr[j],pivot)<0){
                    swap(arr,i,j);
                    i++;
                }
            }
            // pivot ile f indexini değiştir
            swap(arr, i, l);
        }
        return i;
    }
}
