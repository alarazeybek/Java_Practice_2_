import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
public class Game implements Difficulty {
    private int difficulty;
    public final int STARTING_DISTANCE;
    public final int MAX_NO_OF_PASSING_ENEMIES;
    protected ArrayList<EnemyVehicle> evArraylist;
    Scanner in = new Scanner(System.in);
   // public static boolean isOver = false;
    Player player;

    //Enemy Vehicle
    public Game(int difficulty){
        this.STARTING_DISTANCE = 20;
        this.MAX_NO_OF_PASSING_ENEMIES=10;
        this.setDifficulty(difficulty);
        this.evArraylist = new ArrayList<>();
        player = new Player();
        
        getRandomVehiclesForTheFirstTime();
        
    }
    public void play(){
            enemiesTurn();
            System.out.println("Enter the coordinates of the bomb:");
            this.player.attack(in.nextInt(), in.nextInt(), this.evArraylist); 
            for(int i=0;i<evArraylist.size();i++){
                if(evArraylist.get(i).isDestroyed()){
                    Player.score++;
                    this.evArraylist.remove(i);
                    Player.destroyedVehiclesPerRound++;
                    this.getNewRandomVehicle();
                }
            }
            printGameState();
    }
    public ArrayList<EnemyVehicle> getEnemies(){
        return this.evArraylist;
    }

    public EnemyVehicle getNewRandomVehicle(){
        EnemyVehicle ev_1;
        Random rd = new Random();
        int tank_or_heli = rd.nextInt(0, 2);
        if(tank_or_heli==0){
            if(this.getDifficulty()==1){ //easy
                ev_1 =  new Tank(0,5,STARTING_DISTANCE);
                this.evArraylist.add(ev_1);
            }
            else if(this.getDifficulty()==2){ //medium
                ev_1 = new Tank(0,10,STARTING_DISTANCE);
                this.evArraylist.add(ev_1);
            }
            else { //hard
                ev_1 = new Tank(0,15,STARTING_DISTANCE);
                this.evArraylist.add(ev_1);
            }
        }
        else {
            if(this.getDifficulty()==1){ //easy
                ev_1 =  new Helicopter(0,5,STARTING_DISTANCE);
                this.evArraylist.add(ev_1);
            }
            else if(this.getDifficulty()==2){ //medium
                ev_1 = new Helicopter(0,10,STARTING_DISTANCE);
                this.evArraylist.add(ev_1);
            }
            else { //hard
                ev_1 = new Helicopter(0,15,STARTING_DISTANCE);
                this.evArraylist.add(ev_1);
            }
        }
        return ev_1;
    }
    private void getRandomVehiclesForTheFirstTime(){
        if(this.getDifficulty()==1){ //easy
            for(Byte b = 0 ; b<2; b++){
                getNewRandomVehicle();
            }
        }
        else if(this.getDifficulty()==2){ //medium
            for(Byte b = 0 ; b<4; b++){
                getNewRandomVehicle();
            }
        }
        else { //hard
            for(Byte b = 0 ; b<6; b++){
                getNewRandomVehicle();
            }
        }
    }
    @Override
    public int getDifficulty() {
        return this.difficulty;
    }
    
    private void enemiesTurn(){
        for(int i=0;i<evArraylist.size();i++){
            evArraylist.get(i).move();
            if(evArraylist.get(i).getLocation().getY()<=0.0){
                Player.vehiclesCrossedTheBound++;
                Player.numberOfEnemiesPassing++;
                evArraylist.remove(i);
                this.getNewRandomVehicle();
            } 
        }
    }
    public void printGameState(){
        System.out.println("Current Score: " + Player.score);
        System.out.println("Number of enemies passing border: " + Player.numberOfEnemiesPassing);
        for(EnemyVehicle e : this.evArraylist){
            if(e.getType().equals("Tank")){
                System.out.println(e.toString());
            }
        }
        for(EnemyVehicle e : this.evArraylist){
            if(e.getType().equals("Helicopter")){
                System.out.println(e.toString());
            }
        }
        
    }

    @Override
    public void setDifficulty(int difficulty) {
        this.difficulty=difficulty;
    }
}
