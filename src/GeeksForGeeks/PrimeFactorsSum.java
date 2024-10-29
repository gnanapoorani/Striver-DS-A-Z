package GeeksForGeeks;

class PrimeFactorsSum{
    public static void main(String[] args){
        System.out.println(sumOfPrimeFactors(1,10));
    }
    public static int sumOfPowerOfPrimeFactor(int number){
        System.out.println("sum of prime factor of "+number+"is");
        int count=0;
        for(int i=2;i<=Math.sqrt(number);i++){
            while(number%i==0){
                 count++;
                 number=number/i;
            }
        }
        if(number>2){
            count++;
        }
        System.out.println(count);
        return count;
    }
    public static int sumOfPrimeFactors(long a,long b){
        int answer=0;
        long i;
        for(i=a;i<=b;i++){
            answer=answer+sumOfPowerOfPrimeFactor((int)i);
        }
        return  answer;
    }
}