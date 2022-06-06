public class IntegerArray implements Comparable {
    private int zeroIndex;
    private String strNumber;
    private int[] digitArray;
    static boolean negative;
    private boolean absolute=false;
    static boolean isFirstNeg;

    private boolean fN;
    IntegerArray(){}
    IntegerArray(String str){
        absolute =false;
        int counter = 0;
        fN=false;
        negative = false;
        this.strNumber=str;
        zeroIndex = 0;
        if(String.valueOf(strNumber.charAt(0)).equals("-")){
            strNumber=strNumber.substring(zeroIndex+1, strNumber.length());
            fN=true;
        }
        for(int i=0;i<strNumber.length();i++){
            if(String.valueOf(strNumber.charAt(i)).equals("0")){
                counter++;
            }
        }
        if(counter>=strNumber.length()){
            strNumber="0";
            digitArray=new int[1];
            digitArray[0]=0;
        }
        else{ 
            while(Character.getNumericValue(strNumber.charAt(zeroIndex))==0){ 
                strNumber=strNumber.substring(zeroIndex+1, strNumber.length());
            }
            if(fN){
                digitArray = new int[strNumber.length()]; //filling the array
            for(int i = 0; i<strNumber.length();i++){
                digitArray[i]=Integer.parseInt(String.valueOf(strNumber.charAt(i)))*-1;
            }
            }
            else{ 
            digitArray = new int[strNumber.length()]; //filling the array
            for(int i = 0; i<strNumber.length();i++){
                digitArray[i]=Integer.parseInt(String.valueOf(strNumber.charAt(i)));
            }
        }
        }
    }
    public int numberOfDigits(){
        return strNumber.length();
    }
    public int MID(){
        return digitArray[0];
    }
    public int LID(){
        return digitArray[strNumber.length()-1];
    }
    public int getDigit(int i){
        return digitArray[(strNumber.length()-1)-i];
    }

    public IntegerArray add(IntegerArray other){ 
        if(this.strNumber.equals("0")){
            return other;
        }
    int max_length = this.numberOfDigits();
    if(other.compareTo(this)!=-1){
        max_length=other.numberOfDigits();
    }
    int elde =0;
    int a;
    int[] sum = new int[max_length+1];
    for(int i = 0; i<max_length; i++){
        if(i<this.digitArray.length && i<other.digitArray.length){
            if(this.negative){
                a = this.digitArray[this.digitArray.length-i-1] - other.digitArray[other.digitArray.length-i-1] + elde;
                elde =(int) (a)/10;
                if(a<0){
                    a=a+10;
                    elde = -1;
                }
                sum[max_length-i] = a%10;
                isFirstNeg=false;
            }
            else if(!this.negative){ 
                a = this.digitArray[this.digitArray.length-i-1] + other.digitArray[other.digitArray.length-i-1] + elde;
                elde =(int) (a)/10;
                if(a<0){
                    a=a+10;
                    elde = -1;
                }
                sum[max_length-i] = a%10;
            }
        }
        else{
            if(this.numberOfDigits()> i){
                a = this.digitArray[this.digitArray.length-i-1] + elde;
                elde =(int) (a)/10;
                if(a<0){
                    a=a+10;
                    elde = -1;
                }
                sum[max_length-i] = a%10;
            }
            else {
                a = other.digitArray[other.digitArray.length-i-1] + elde;
                elde =(int) (a)/10;
                if(a<0){
                    a=a+10;
                    elde = -1;
                }
                sum[max_length-i] = a%10;
            }
        }
    }
    sum[0]=elde;
    this.negative=false;
    String str="";
    boolean sign = false;
    for(int i = 0; i <sum.length;i++){
        if(sum[i]<0){
            sign = true;
            sum[i]=sum[i]*-1;
        }
        str += ""+sum[i];
    }
      /*  while(Character.getNumericValue(str.charAt(0))==0){ 
            str=str.substring(zeroIndex+1, str.length());
        }
    */
    if(sign){
        str="-"+str;
    }
    if(absolute){
        str="-"+str;
    }
    return new IntegerArray(str);
    }
    
    public IntegerArray subtract(IntegerArray other){
        this.negative = true;
        if((this).compareTo(other)>0){
            absolute=false;
            return this.add(other);
        }
        else {
            absolute=true;
            return other.add(this);
        }
    }
    
    @Override
    public int compareTo(Object o) {
        IntegerArray integerArray = (IntegerArray) o;
        if(this.digitArray.length!=integerArray.digitArray.length){
            return ((Integer)this.digitArray.length).compareTo((Integer)integerArray.digitArray.length);
        }
        else if(this.strNumber.equals(integerArray.strNumber)){
            return 0;
        }
        else{
            for(int i=0;i<this.digitArray.length;i++){
                if(this.digitArray[i]>integerArray.digitArray[i]){
                    return 1;
               }
                else if(this.digitArray[i]<integerArray.digitArray[i]){
                    return -1;
                }
            }
        }
        return 0;
    }
    public String toString(){
        if(absolute==true){
            this.strNumber="-"+this.strNumber;
        }
        if(fN){
            this.strNumber="-"+this.strNumber;
        }
        return this.strNumber;
    }
}