import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.Scanner;

public class IntegerArrayTester {
    public static void main(String[] args) {
        IntegerArray test = new IntegerArray("999");
        IntegerArray test2 = new IntegerArray("2");
        System.out.println("Number of digits:" + test.numberOfDigits());
        System.out.println(test.toString());
        System.out.println(test2.toString());
        System.out.println("Max digit:" + test2.LID());
        System.out.println("Min digit:" + test2.MID());
        System.out.println(test.compareTo(test2));
        System.out.println(test.add(test2)); 
        System.out.println((test.subtract(test2)).toString()); 
      /*  System.out.println("Please enter the filename:");
        Scanner in = new Scanner(System.in);
        String text = in.nextLine();
        IntegerArrayList text1 = readIntegerArraysFromFile(text);
        System.out.println("Start index : 0");
        int middle = (int)(text1.getSize()-1)/2;
        System.out.println("Middle index : "+ middle);
        System.out.println("End index : "+(text1.getSize()-1));
        System.out.println();
        System.out.println("Minimum of all the numbers:" + text1.min(0, text1.getSize()-1).toString());
        System.out.println("Minimum of the first half:"+ text1.min(0, middle).toString());
        System.out.println("Minimum of the second half:" + text1.min(middle+1, text1.getSize()-1).toString()); */

    }
    public static IntegerArrayList readIntegerArraysFromFile(String text){
        ArrayList<String> data = new ArrayList<>();
        try {
            File myObj = new File(text);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              data.add(myReader.nextLine());
            }
            IntegerArrayList dataList = new IntegerArrayList(data);
            myReader.close();
            return dataList;
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
          return new IntegerArrayList(); 
    }
}