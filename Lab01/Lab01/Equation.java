public class Equation {
    private int a,b,c; //the coefficant
    //PART1
    public Equation(int a1,int b1,int c1){ //a=bx+c
        if(b1<0){
            a1=a1*-1;
            b1=b1*-1;
            c1=c1*-1;
        }
        this.a=a1;
        this.b=b1;
        this.c=c1;
        reduceEquation();
    }
    public int getA(){
        return this.a;
    }
    public int getB(){
        return this.b;
    }
    public int getC(){
        return this.c;
    }
    public void reduceEquation(){ //finding the simplest value for a, b and c
        int divisor = gcd3(this.a,this.b,this.c);
        this.a=this.a/divisor;
        this.b=this.b/divisor;
        this.c=this.c/divisor;
    }

    private int gcd(int x, int y){ //calculation gcd for two int
        int big;
        int small;
        if(x>y){
            big=x;
            small=y;
        }
        else{
            big=y;
            small=x;
        }
        int gcd=1;
        for(int i=1;i<=(int)big;i++){
            if(big%i==0){
                if(small%i==0){
                    gcd=i;
                }
            }
        }
        return gcd;
    }
    public int gcd3(int x,int y,int z){ //calculation for three int
        return gcd(gcd(x,y),z);
    }
    //PART2
    public Equation add(Equation eq2){ //add two equation
        int a_sum= this.a+eq2.getA();
        int b_sum=this.b+eq2.getB();
        int c_sum=this.c+eq2.getC();
        return new Equation(a_sum, b_sum, c_sum);
    }
    public Equation substract(Equation eq2){ //substract two equation
        return new Equation( (this.a-eq2.getA()), (this.b-eq2.getB()) , (this.c-eq2.getC()) );
    }
    public String toString(){ //formatting
        String str =this.a + " = ";
        if(this.b==1){
            str=str+"x";
        }
        else{
            str=str+ + this.b + "x";
        }
        if(this.c>0){
            return str + "+"+this.c;
        }
        else if(this.c<0){
            return str + this.c;
        }
        return str;
    }
    public boolean equals(Equation eq2){
        /*if(gcd3(this.a,this.b,this.c) == gcd3(eq2.getA(),eq2.getB(),eq2.getC())){
            if(gcd3(this.a,this.b,this.c) ==1 & this.getA()== eq2.getA()& this.getB()== eq2.getB() & this.getC()== eq2.getA())
        }
        return false; */
        int firstGCD=gcd3(this.a,this.b,this.c);
        int secondGCD=gcd3(eq2.getA(),eq2.getB(),eq2.getC());
        if(this.a/firstGCD==eq2.getA()/secondGCD && this.b/firstGCD==eq2.getB()/secondGCD &&this.c/firstGCD==eq2.getC()/secondGCD ){
            return true;
        }
        return false;
    }
}