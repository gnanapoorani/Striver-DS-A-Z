

class RomanToInteger {
    public static void main(String[] args) {

        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        int ans = 0, num = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            switch(s.charAt(i)) {
                case 'I': num = 1; break;
                case 'V': num = 5; break;
                case 'X': num = 10; break;
                case 'L': num = 50; break;
                case 'C': num = 100; break;
                case 'D': num = 500; break;
                case 'M': num = 1000; break;
            }
            if (4 * num < ans) ans -= num;
            else ans += num;
        }
        return ans;
    }

//    public int romanToInt1(String s) {
//
//        int answer = 0, number = 0, prev = 0;
//
//        for (int j = s.length() - 1; j >= 0; j--) {
//            switch (s.charAt(j)) {
//                case 'M' -> number = 1000;
//                case 'D' -> number = 500;
//                case 'C' -> number = 100;
//                case 'L' -> number = 50;
//                case 'X' -> number = 10;
//                case 'V' -> number = 5;
//                case 'I' -> number = 1;
//            }
//            if (number < prev) {
//                answer -= number;
//            }
//            else {
//                answer += number;
//            }
//            prev = number;
//        }
//        return answer;
//    }

}