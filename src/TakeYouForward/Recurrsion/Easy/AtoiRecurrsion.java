import java.util.*;

class Atoi {
    public static void main(String[] args) {
        System.out.println(myAtoi1("-433"));
    }

    public static int myAtoi1(String s) {
        s = s.trim();
        int sign = 1, total = 0, i = 0;
        if (s.length() > 0) {
            if (s.charAt(0) == '-' || s.charAt(0) == '+') {
                sign = s.charAt(0) == '+' ? 1 : -1;
                i++;
            }
        }
        total = callRecursionAtoi(s, i, sign, total);
        return total * sign;
    }

    public static int callRecursionAtoi(String s, int i, int sign, int total) {
        int digit = 0;
        if (i < s.length() && Character.isDigit(s.charAt(i))) {
            digit = s.charAt(i) - '0';
            if (Integer.MAX_VALUE / 10 < total || Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            total = 10 * total + digit;
            return callRecursionAtoi(s, ++i, sign, total);
        }
        return total;
    }

    public static int myAtoi(String s) {
        int total = 0, sign = 1, digit = 0;
        s = s.trim();
        if (s.length() > 0) {
            int i = 0;
            if (s.charAt(0) == '-' || s.charAt(0) == '+') {
                sign = s.charAt(0) == '+' ? 1 : -1;
                i++;
            }
            for (int j = i; j < s.length(); j++) {
                if (Character.isDigit(s.charAt(j))) {
                    digit = s.charAt(j) - '0';
                } else {
                    break;
                }

                //check if total will be overflow after 10 times and add digit
                if (Integer.MAX_VALUE / 10 < total || Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit)
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                total = 10 * total + digit;
            }

            total = total * sign;
        }
        return total;
    }

}