public class Tester {
    

    public static void main(String[] args) {
      
    GeneralizedMergeSortAnalyzer g = new GeneralizedMergeSortAnalyzer();
    RandomArrayGenerator r = new RandomArrayGenerator();
    //IncreasingArrayGenerator r = new IncreasingArrayGenerator();
    //QuickSortAnalyzer g = new QuickSortAnalyzer();
    //DecreasingArrayGenerator r = new DecreasingArrayGenerator();
    //GeneralizedQuickSortAnalyzer g = new GeneralizedQuickSortAnalyzer();
    //Tester g = new Tester();
    //MergeSortAnalyzer g = new MergeSortAnalyzer();

    g.set_k(2);
    Integer[] i = r.generate(10);
    System.out.println(r.toString(i));
    
    
    if(i instanceof Integer[]){
        
        System.out.println(r.toString(g.sort(i)));
        System.out.println(g.isSorted(g.sort(i)));
    }
    System.out.println(g.getNumberOfComparisons());
    
    }

}
