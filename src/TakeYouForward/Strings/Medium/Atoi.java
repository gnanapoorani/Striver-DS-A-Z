import java.util.*;

class AtoiString {
    public static void main(String[] args) {
        System.out.println(myAtoi("+1"));
    }

    public int myAtoi1(String s) {
        s = s.trim();
        if (s.isEmpty()) {
            return 0;
        }

        int ans = 0, i = 0;
        boolean neg = s.charAt(0) == '-';
        boolean pos = s.charAt(0) == '+';

        if (neg || pos) {
            i++;
        }

        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            ans = ans * 10 + digit;
            i++;
        }

        return neg ? -ans : ans;
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