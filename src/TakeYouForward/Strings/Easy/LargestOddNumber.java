
class LargestOddNumber {
    public static void main(String[] args) {

        System.out.println(largestOddNumber("7542351161"));
    }

    public static String largestOddNumber(String num) {
      for(int i=num.length()-1;i>=0;i--){
          int singleDigit=num.charAt(i);
          if(singleDigit%2==1){
              return num.substring(0,i+1);
          }
      }
      return "";
    }

}