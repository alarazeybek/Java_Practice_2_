public class Helicopter extends EnemyVehicle{
    protected int yCoordinateHeli;
    protected int xCoordinateHeli;
    protected EnemyVehicle heli;
    protected int HeliSpeed;
    Helicopter(int minX, int maxX, int y){
        super(minX,maxX,y);
        this.HeliSpeed=BASE_SPEED;
    }

    @Override
    public void move() { 
        this.coordinatePoint.move((int)this.coordinatePoint.getX(), (int)this.coordinatePoint.getY() - this.HeliSpeed);
       // this.yCoordinateHeli = this.yCoordinate - this.HeliSpeed;
        this.HeliSpeed++;
    }

    @Override
    String getType() {
        return "Helicopter";
    }

    public String toString(){
        String str="A "+getType()+" is at location " + CoordinateToString(this.getLocation()) + ". It's speed modifier is "+this.HeliSpeed+". It has "+getDistanceToBorder()*5.0 +" points left."+this.damage;
        return str;
    }

    @Override
    public void takeDamage(double damage) {
        super.takeDamage(damage);
    }


}