//Haley Rovner, Aleksa Belic, Kendall Malone
package BigNum;

public class BigNum {

    int value[];
    int length;
    long number;

    public BigNum(String num){
        if(num.equals("")){
            num="0";
        }
        length = num.length();
        value = new int[length];
        for(int i = 0; i < length; i++) {
            value[i] = (num.charAt(i)) - 48;
            number *= 10;
            number += value[i];
        }
    }
    public String toString(){
        //method that returns a String representing the number
        String output = "";
        for(int i = 0; i < this.length; i++){
            output += (char)(value[i]+48);
        }
        return output;
    }

    public BigNum plus(BigNum numTwo){
        //method that takes a second BigNum and returns the sum of the two numbers
        //value of a is this.value
        //value of b is numTwo.value

        long result = this.number + numTwo.number;
        String out = String.format("%d", result);
        BigNum output = new BigNum(out);
        return output;

    }
    public BigNum times(BigNum numTwo){
        //method that takes a second BigNum and returns the product of the two numbers.
        long result = this.number * numTwo.number;
        String out = String.format("%d", result);
        BigNum output = new BigNum(out);
        return output;
    }

}
