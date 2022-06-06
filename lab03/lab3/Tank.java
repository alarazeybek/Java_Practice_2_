public class Tank extends EnemyVehicle{
    public Tank(int minX, int maxX, int y){
        super(minX,maxX,y);
    }

    @Override
    public void takeDamage(double damage) { 
        this.damage+=damage/2;
    }

    @Override
    String getType() {
        return "Tank";
    }
    @Override
    public String toString(){
        String str="A "+getType()+" is at location " + CoordinateToString(this.getLocation()) + ". It has "+getDistanceToBorder() * 5.0 +" points left."+this.damage;
        return str;
    }

} 