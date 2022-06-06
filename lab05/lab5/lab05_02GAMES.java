//Question 2
public class lab05_02GAMES {

    public int space;
    public int score;
    public String name;

    lab05_02GAMES(int A_space, int B_score , String game){
        this.space = A_space;
        this.score = B_score;
        name = game;
    }
    @Override
    public String toString() {
       String str = name;
       return str;
    }
}
