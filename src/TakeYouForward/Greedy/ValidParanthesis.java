package TakeYouForward.Greedy;

import java.util.ArrayList;
import java.util.List;

//2147483647 - Int Max value
//-2147483647 - 1 int min value
class ValidParanthesis {


    public static void main(String[] args) {
        System.out.println(checkValidString(""));
    }

    public static boolean checkValidString(String s) {
        int openCount = 0;
        for (char c : s.toCharArray()) {

            if (c == '(') {
                openCount++;
            }
            if (c == ')') {
                openCount--;
            }
        }
        if (openCount == 0) {
            return true;
        }

        return false;
    }
}