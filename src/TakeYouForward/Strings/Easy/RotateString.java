class RotateString {
    public static void main(String[] args) {

        System.out.println(rotateString("abcde" ,"cdeab"));
    }
    public static boolean rotateString1(String s, String goal) {
        int i=0;
        if(s.length()!=goal.length()){
            return  false;
        }
        while(i<s.length()){
            s=s.substring(1,s.length())+s.charAt(0);
            if(s.equals(goal)){
                return  true;
            }
            i++;
        }
        return  false;
    }
    public static boolean rotateString(String s, String goal) {
        int n1 = s.length();

        int n2 = goal.length();

        if(n1 != n2)
        {
            return false;
        }

        StringBuilder str = new StringBuilder(goal);

        str=str.append(str);
        return (str.indexOf(s)!=-1);
    }
}