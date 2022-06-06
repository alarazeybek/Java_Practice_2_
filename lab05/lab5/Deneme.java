public class Deneme {
    //Question 3
    private boolean firstRound = true;
    public int minValue = Integer.MAX_VALUE;
    public int result(String benzeyen, String benzetilen, int index, int count){
        if(benzeyen == null || benzetilen == null){return 0;}
        if(firstRound && benzeyen.length()<benzetilen.length()){
            String temp = benzeyen;
            benzeyen = benzetilen;
            benzetilen=temp;
        }
        firstRound=false;
        if(benzeyen.equals(benzetilen)){
            if(minValue > count){
                minValue = count;
            }
            return count;
        }
        while(index < benzeyen.length()-1 && index< benzetilen.length()-1 && benzeyen.charAt(index) == benzetilen.charAt(index)){
            index++;
        }
        if(index + 1 >benzeyen.length() && index+1 >benzetilen.length() && !benzeyen.equals(benzetilen)){
            return minValue;
        }
        if(benzeyen.length() < benzetilen.length()){
            return minValue;
        }  
        if(count > minValue){
            return minValue;
        } 
        String remove = benzeyen.substring(0, index) + benzeyen.substring(index + 1);
        String add =  benzeyen.substring(0, index) + String.valueOf(benzetilen.charAt(index)) + benzeyen.substring(index + 1);
        String subs = benzeyen.substring(0, index) + benzetilen.charAt(index) + benzeyen.substring(index);
        return Math.min(result(remove , benzetilen, index, count + 1), Math.min(result(add, benzetilen, index, count + 1),     result(subs, benzetilen, index, count + 1)));
    }
    public static void main(String[] args) {
        Deneme d = new Deneme();
        String benzeyen = new String("java");
        String benzetilen = new String("python");
        System.out.println(d.result(benzeyen, benzetilen, 0, 0));
    }
}