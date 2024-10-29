package TakeYouForward.Recurrsion.Easy;

class PowerImpl1 {
    public static void main(String[] args) {

        System.out.println(SkipA("baccaaaaad"));
    }

    public static String SkipA(String S) {
        if(S.isEmpty()){
            return "";
        }
        String answer = "";

        if (S.charAt(0) != 'a') {
            answer += S.charAt(0);
        }
        return answer + SkipA(S.substring(1));
    }

}