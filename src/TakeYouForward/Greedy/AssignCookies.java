package TakeYouForward.Greedy;

import java.util.Arrays;

//2147483647 - Int Max value
//-2147483647 - 1 int min value
class AssignCookies {

    public static void main(String[] args) {
        int s[] = {1, 3, 0, 5, 8, 5};
        int g[] = {1, 3, 0};
        System.out.println(findContentChildren(s, g));
    }

    public static int findContentChildren(int[] children, int[] cookies) {
        Arrays.sort(children);
        Arrays.sort(cookies);
        int child = 0;
        for (int cookie = 0; child < children.length && cookie < cookies.length; cookie ++) {
            if (cookies[cookie] >= children[child]) {
                child ++;
            }
        }

        return child;
    }

    public static int findContentChildren1(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        for (int j = 0; i < g.length && j < s.length; j++) {
            if (g[i] <= s[j]) i++;
        }
        return i;
    }
}