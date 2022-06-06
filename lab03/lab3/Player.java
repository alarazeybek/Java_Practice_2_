import java.util.ArrayList;
import java.awt.*;
//instance

public class Player {
    final double BOMB_RADIUS = 2.0;
    final double DAMAGE = 50.0;
    static int score = 0;
    static int numberOfEnemiesPassing=0;
    static int destroyedVehiclesPerRound = 0;
    static int vehiclesCrossedTheBound = 0;
    
    public Player(){}

    public void attack(int x, int y, ArrayList<EnemyVehicle> enemies){
        Point center = new Point(x,y);
        for(int i=0;i<enemies.size();i++){
            if(BOMB_RADIUS >= distanceBetweenTwoPoints(center, enemies.get(i).getLocation())){
                enemies.get(i).takeDamage(DAMAGE);
            }
        }
    }
    public double distanceBetweenTwoPoints(Point p1, Point p2){
        return (double) Math.sqrt(Math.pow(p1.getX()-p2.getX(), 2) + Math.pow(p1.getY()-p2.getY(), 2));
    }
}
