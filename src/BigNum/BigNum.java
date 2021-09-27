//Haley Rovner, Aleksa Belic, Kendall Malone

package bignum;

public class BigNum {

    int value[];
    int length;
    String stringVal;

    public BigNum(String num){
        if(num.equals("")){
            num="0";
        }
        length = num.length();
        value = new int[length];
        stringVal = num;
        for(int i = 0; i < length; i++) {
            value[i] = (num.charAt(i)) - 48;
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
        String newNum = "";

        String smaller, bigger;

        int runLength = 0;

        if(this.length == numTwo.length) {
            runLength = this.length;
            bigger = this.stringVal;
            smaller = numTwo.stringVal;
        }

        else if(this.length > numTwo.length){
            runLength = this.length;
            smaller = "";
            bigger = this.stringVal;
            for(int i = 0; i < runLength - numTwo.length; i++){
                smaller += "0";
            }
            smaller += numTwo.stringVal;
        }
        else{
            runLength = numTwo.length;
            smaller = "";
            bigger = numTwo.stringVal;
            for(int i = 0; i < runLength - this.length; i++){
                smaller += "0";
            }
            smaller += this.stringVal;
        }
        char temp[] = new char[runLength + 1];
        int over = 0;

        for(int i = runLength - 1; i >= 0; i--){
            int first = (int)(smaller.charAt(i) - 48);
            int second = (int)(bigger.charAt(i) - 48);
            int added = first + second + over;

            if(added >= 10 && i == 0){
                over = added / 10;
                added = added % 10;
                temp[0] = (char)(over + 48);

            }
            else if(added >= 10){
                over = added / 10;
                added = added % 10;
            }
            else{
                over = 0;
            }

            temp[i + 1] = (char)(added + 48);
        }

        for(int i = 0; i <= runLength; i++){
            if(i == 0 && temp[i] == '\0'){
                continue;
            }
            newNum += temp[i];
        }

        BigNum out = new BigNum(newNum);
        return out;
    }
    public BigNum times(BigNum numTwo) {
        //method that takes a second BigNum and returns the product of the two numbers.
        int[] temp = new int[this.length + numTwo.length];

        String reversedOne = "";
        String reversedTwo = "";

        for(int i = this.length - 1; i >= 0; i--){
            reversedOne += this.stringVal.charAt(i);
        }
        for(int i = numTwo.length - 1; i >= 0; i--){
            reversedTwo += numTwo.stringVal.charAt(i);
        }
        for(int i = 0; i < this.length; i++){
            for(int j = 0; j < numTwo.length; j++){
                temp[i + j] += (reversedOne.charAt(i) - 48) * (reversedTwo.charAt(j) - 48);
            }
        }
        String out = new String();
        for(int i = 0; i < temp.length; i++){
            int num = temp[i] % 10;
            int over = temp[i] / 10;
            if(i + 1 < temp.length){
                temp[i + 1] += over;
            }
            out += num;
        }
        while(out.length() > 1 && out.charAt(out.length()-1) == '0'){
            out = out.substring(0, out.length()-1);
        }
        String res = "";
        for(int i = out.length() - 1; i >= 0; i--){
            res += out.charAt(i);
        }
        BigNum output = new BigNum(res);
        return output;
    }
}
