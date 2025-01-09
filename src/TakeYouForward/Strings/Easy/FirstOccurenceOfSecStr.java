package TakeYouForward.Strings.Easy;

class FirstOccurenceOfSecStr {
    public static void main(String[] args) {

        System.out.println(strStr1("sadbutsad", "sad"));
    }

    /**
     * Return the index of the first occurrence of needle in haystack,
     * or -1 if needle is not part of haystack.
     */
    public static int strStr(String haystack, String needle) {

        int result = haystack.indexOf(needle);
        return result;
    }

    /**
     * Without using string functions
     */
    public static int strStr1(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
        }
    }
}