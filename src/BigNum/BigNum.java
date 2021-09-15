package BigNum;

public class BigNum {

    String value;

    public BigNum(String num){
        value = num;
    }

    public String toString(){
        //method that returns a String representing the number
        return this.value;
    }
    public static BigNum plus(BigNum numTwo){
        //method that takes a second BigNum and returns the sum of the two numbers
        //value of a is this.value
        //value of b is numTwo.value
        BigNum output = new BigNum("0");
        return output;

    }
    public static BigNum times(BigNum numTwo){
        //method that takes a second BigNum and returns the product of the two numbers.

        BigNum output = new BigNum("0");
        return output;

    }
}