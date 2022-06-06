import java.util.*;
//Question 2
//game classın lab05_02GAMES
class test {

    private int size; // Size of superset.
    private int N_storage = 1000;
    private int maxScore = Integer.MIN_VALUE;
    private ArrayList<lab05_02GAMES> subset = new ArrayList<> (); 
    private ArrayList<lab05_02GAMES> gamesDownloaded ;
    //= new ArrayList<> ();

    test ( int s ) { 
        size = s;
    }   

    // Generating subsets / combinations using recursion.
    public void GenerateSubset ( int num , lab05_02GAMES[] gameArray) { 
        if(N_storage==0){
            maxScore=0;
            return ;}
        if ( num > size-1 ) { 

            for ( int i = 0; i < subset.size(); i++ ) { 
                if( gb_Sum(subset)<= N_storage ){  
                    if(score_Sum(subset) >= maxScore){
                        maxScore=score_Sum(subset);
                        gamesDownloaded= new ArrayList<>(subset);
                    }
                    //System.out.print ( subset.get(i) + " " );  //possible subsets
                }
            }
            //System.out.println();

        } else {

            subset.add (gameArray[num]);
            GenerateSubset ( num + 1 , gameArray);

            subset.remove ( subset.size() - 1 );
            GenerateSubset ( num + 1 ,gameArray);
        }
    }   

    public int gb_Sum(ArrayList<lab05_02GAMES> g){
        int sum = 0;
        for(lab05_02GAMES t : g){
            sum += t.space;
        }
        return sum;
    }
    public int score_Sum(ArrayList<lab05_02GAMES> g){
        int sum = 0;
        for(lab05_02GAMES t : g){
            sum += t.score;
        }
        return sum;
    }

    //getters
    public int GetSize() {
        return size;
    }   

    public int getMaxScore(){
        return maxScore;
    }
    public String getNamesOfGamesDownloaded(){
        String str = "";
        if(maxScore!=0){
            for(lab05_02GAMES temp : gamesDownloaded){
                str += temp.toString()+" ";
            }
        }
        
        return str;
    }
    public static void main(String[] args) {

        lab05_02GAMES g1 = new lab05_02GAMES(45, 50, "Game A");
        lab05_02GAMES g2 = new lab05_02GAMES(10,85, "Game B");
        lab05_02GAMES g3 = new lab05_02GAMES(15, 45,"Game C");
        lab05_02GAMES g4 = new lab05_02GAMES(20, 100,"Game D");
        lab05_02GAMES g5 = new lab05_02GAMES(25, 6,"Game E");
        lab05_02GAMES g6 = new lab05_02GAMES(100, 100,"Game F");

        lab05_02GAMES[] games = {g1,g2,g3,g4,g5,g6};

        test S1 = new test(games.length);
        //System.out.println( "All subsets within superset of size : " + S1.GetSize() );
        S1.GenerateSubset(0,games);
        System.out.println(S1.getMaxScore());
        System.out.println("the possible downloaded game/s is/are: " + S1.getNamesOfGamesDownloaded());


        
    }   
}