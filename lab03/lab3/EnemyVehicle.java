import java.util.Random;
import java.awt.*;

abstract class EnemyVehicle implements Destructible , Movable { //abstract yaz
    final int BASE_SPEED = 3;
    protected int xCoordinate;
    protected int yCoordinate;
    protected Point coordinatePoint;
    protected double damage ;
    
   
    EnemyVehicle(int minX, int maxX, int y){
        Random rd = new Random();
        this.xCoordinate= rd.nextInt(minX, maxX);
        //this.xCoordinate=(int) Math.random()*minX + maxX;
        this.yCoordinate=y;
        this.coordinatePoint=new Point(xCoordinate,yCoordinate);
        
    }
    public boolean isDestroyed(){
        return this.damage>=100.0; //100 olunca patlar
    }
    public void move(){
        this.coordinatePoint.move(this.xCoordinate, this.yCoordinate-BASE_SPEED); 
        this.yCoordinate= this.yCoordinate-BASE_SPEED;
    }
    public void takeDamage(double damage){
        this.damage += damage;
    }
    public Point getLocation(){
        return coordinatePoint;
    }
    public int getDistanceToBorder(){
        return (int)this.coordinatePoint.getY();
    }

    abstract String getType();

    public String CoordinateToString(Point p){
        return "("+(int)p.getX()+","+(int)p.getY()+")";
    }
}
