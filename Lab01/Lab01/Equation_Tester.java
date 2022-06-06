import java.util.Scanner;
public class Equation_Tester{
    public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("Format : a=bx+c\nPlease enter the value of a,b and c for first equation:");
    Equation eq1 = new Equation(in.nextInt(),in.nextInt(),in.nextInt());
    System.out.println("Your equation:" + eq1.toString());
    System.out.println("Please enter the value of a,b and c for the second equation:");
    Equation eq2 = new Equation(in.nextInt(), in.nextInt(), in.nextInt());
    System.out.println("Your second equation:" + eq2.toString());
    System.out.println("\nSum of the equations:" + eq1.add(eq2).toString());
    System.out.println("----------------------------------");
    System.out.println("Subtraction of the equations:"+eq1.substract(eq2).toString());
        in.close();
    }
    
}