public class GeneralizedMergeSortAnalyzer extends SortAnalyzer {

   /* @Override
    public Comparable[] sort(Comparable[] arr) {
        k=2;
        if(isSorted(arr)){return arr;}
        if(arr.length<=k){
            for(int i = 0; i<k;i++){
                for(int j = 1;j<k;j++){
                    if(compare(arr[i], arr[j])==1){
                        if(arr[i] instanceof Integer && arr[j] instanceof Integer){
                        Integer arr_2 = (Integer)arr[i];
                        arr[i] = arr[j];
                        arr[j] = arr_2;
                        } 
                    }
                }
            }
            return sort(arr);
        }
        while(arr.length>k){
            Comparable[] arr_2 = new Comparable[arr.length-k];
            for(int i = 0; i<arr_2.length;i++){
                arr_2[i] = arr[i];
            }
            sort(arr_2);
            GeneralizedMerge(c1, c2);
        }
        return arr;
    } 
    


    public Comparable[] GeneralizedMerge(Comparable[] c1, Comparable[] c2){
        int i = 0;
        int j = 0;
        int k=0;
        Comparable[] c = new Comparable[c1.length+c2.length];
        while(i<c1.length && j<c2.length){
            if(compare(c1[i], c2[j])==1){
                c[k]=c1[i];
                i++;
                k++;
            }
            else{ 
                c[k]=c2[j];
                j++;
                k++;
            }
        }
        if(i==c1.length){
            while(j<c2.length){
                c[k]=c2[j];
                j++;
            }
        }
        else{
            while(i<c1.length){
                c[k]=c1[i];
                i++;
            }
        }
        return c;
    }

    @Override
    public Comparable[] sort(Comparable[] arr) {
        if(isSorted(arr)){return arr;}
        if(arr.length<=k){
            for(int i = 0; i<k;i++){
                for(int j = 1;j<k;j++){
                    if(compare(arr[i], arr[j])==1){
                        if(arr[i] instanceof Integer && arr[j] instanceof Integer){
                        Integer arr_2 = (Integer)arr[i];
                        arr[i] = arr[j];
                        arr[j] = arr_2;
                        } 
                    }
                }
            }
            return arr;
        }
        else{
            int a = arr.length ;
            while(a>=k){
                a=(int) arr.length/k;
                Comparable[] arr_22 = new Comparable[a];
                Comparable[] arr_21 = new Comparable[a];
                for(int i = 0 ; i<a;i++){
                    arr_21[i] = arr[i];
                    arr_22[i]= arr[a+i];
                }
                
                return GeneralizedMerge(sort(arr_21),sort(arr_22));
            }
        }
        return sort(arr);
    } */
    public Comparable[] sort(Comparable[] arr){
        if(arr instanceof Integer[]){
            if(isSorted(arr)){
                return arr;
            }
            Msort((Integer[])arr, 0, arr.length, k);
        }
        return arr;
    }
    private void Msort(Integer[] arr, int low, int last, int k){
        if(k<=2){Comparable[] arr_2 = new Comparable[arr.length];
            if(low<last){ 
                int middle = (int) (low+last)/2;
                Msort(arr, low, middle,k);
                Msort(arr, middle+1, last,k);
                merge2(arr,arr_2,low,middle,last);
            }
        }
        if(last <= low + 1) {
            return;
        }
        else if(last - low + 1 <= k){
            int i = 0;
            while(i < arr.length - 1){
                Integer z = i;
                    for(int j = i + 1; j < arr.length; j++){
                        if(compare(arr[j] , arr[z]) < 0)
                            z = j;
                    }
                swap(arr, z, i);
                i++;
            }
            return;
        }
        Msort(arr, low + k , last, k);
        Msort(arr, low, low + k - 1, k);
        Comparable[] arr_2 = new Comparable[arr.length];
        merge2((Comparable[])arr, arr_2, low, low + k -1, last);
    }
    
    public void merge2(Comparable[] o1, Comparable[] o2, int low, int mid, int last)
    {
        //int r=ri-1;
        int k1 = low;
        while(k1 < last){ 
        o2[k1] = o1[k1]; k1++;
        }
        int i = low, j = mid;
        int c = low;
        while (c < last){
            if (i >= mid){
                o1[c] = o2[j++];
            }
            else if (j >= last){ 
                o1[c] = o2[i++];
            }
            else if (compare(o2[j], o2[i]) < 0){ 
                o1[c] = o2[j++];
            }
            else{ 
                o1[c] = o2[i++];
            }
            c++;
        }
    }
}
