import java.util.Scanner;
public class GameTester {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the game's difficulty:\n1-Easy 2-Medium 3-Hard");
        Game game = new Game(in.nextInt());
        GamePlotter gp = new GamePlotter(game);
        gp.plot();
        while(Player.numberOfEnemiesPassing < game.MAX_NO_OF_PASSING_ENEMIES){ 
            game.play();
            gp.plot();
        }
        System.out.println("Final Score: " + Player.score);
        System.out.println("Number of enemies passing border: " + Player.numberOfEnemiesPassing);
        
    }
    
}
