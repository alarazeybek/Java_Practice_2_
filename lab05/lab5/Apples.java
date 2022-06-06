import java.util.Scanner;

public class Apples {
    //N apples, can she have k apples at the day a
    //N,k,a
    //Basis: if(a==0 && N==k){return true;} else if(a==0 && N!=k){return false; }
    //recursion= N-3,k,a-1 || N-2,k,a-1

    public boolean eatApples(int N, int k, int a){
        if(a==0 && N==k){
            return true;
        }
        else if(a==0 && N!=k){
            return false;
        }
        else{
            return eatApples(N-3, k, a-1) || eatApples(N-2, k, a-1);
        }
    }
    public static void main(String[] args) {
        Apples test = new Apples();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter N,k and a:");
        boolean canEat = test.eatApples(in.nextInt(), in.nextInt(), in.nextInt());
        System.out.println("Can she eat? " + canEat);
    }
}
