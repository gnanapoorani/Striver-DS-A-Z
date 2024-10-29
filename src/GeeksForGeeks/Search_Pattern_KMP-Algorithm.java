package GeeksForGeeks;

import java.util.ArrayList;

class SearchPatterKMPAlgorithm {
    public static void main(String[] args) {
        String txt="aecececececec",pat="ecec";
        System.out.println(txt.indexOf(pat));
        System.out.println(search1("ecec",txt));
                System.out.println(search("ecec",txt));
        System.out.println(search("ecec","aececececececdececececbbececbbdececcececdcaaacbececececacaececbececececececececebeaeaeececeececbececececadacececbaececececbececceccaaebdececbeeececaaececdbacececeececececbaececeddececacbcececacbececececececececaebaececececececcaaececececececbddececaacdadeeececceaececcececececdececdececdbcebcececbaacececaececececececececcececdeececececececbacbececaececdeebabdececacbececececeececcececbcbdececdececececaececaececeececeabececececdeaececdcdececcbeadeaaaececaecececccececcececececdececeececdececececececccececccececabececadececeddececcaececdcececececeedaececaececbcdeececcbdcaececcececececdeaececeeececececececececececaeececececececececbddececbececececdbeececcbececbcbbdececeececececececdedbdcdbaaebececdececececececececdcececaececcececcbececdabaececbeebecececdcadececbbcdececbeececdcebeececececdbbcecececcebdbccaeaccacececececdecececececececddbaeececececaecececececdeececececececedececabcbecdebecececececececececccbeececcaececedbaabececaeabecaecececaececdececececececececccacabececececececececceececaba"));
        System.out.println(search1("ecec","aececececececdececececbbececbbdececcececdcaaacbececececacaececbececececececececebeaeaeececeececbececececadacececbaececececbececceccaaebdececbeeececaaececdbacececeececececbaececeddececacbcececacbececececececececaebaececececececcaaececececececbddececaacdadeeececceaececcececececdececdececdbcebcececbaacececaececececececececcececdeececececececbacbececaececdeebabdececacbececececeececcececbcbdececdececececaececaececeececeabececececdeaececdcdececcbeadeaaaececaecececccececcececececdececeececdececececececccececccececabececadececeddececcaececdcececececeedaececaececbcdeececcbdcaececcececececdeaececeeececececececececececaeececececececececbddececbececececdbeececcbececbcbbdececeececececececdedbdcdbaaebececdececececececececdcececaececcececcbececdabaececbeebecececdcadececbbcdececbeececdcebeececececdbbcecececcebdbccaeaccacececececdecececececececddbaeececececaecececececdeececececececedececabcbecdebecececececececececccbeececcaececedbaabececaeabecaecececaececdececececececececccacabececececececececceececaba"));
    }
    static ArrayList<Integer> search1(String pat, String txt)
    {
        ArrayList<Integer> result= new ArrayList<>();
        int found = txt.indexOf(pat);
        while(found!=-1){
            result.add(found+1);
            found= txt.indexOf(pat,found+1);
        }
        return result;
    }
    static ArrayList<Integer> search(String pat, String txt)
    {
        ArrayList<Integer> result= new ArrayList<>();
        int patternLength=pat.length();
        for(int i=0;i<txt.length();i++){
            if(txt.charAt(i)==pat.charAt(0)){
                if(i+patternLength>txt.length()){
                    return result;
                }
                String subPattern=txt.substring(i,i+patternLength);
                if(subPattern.equals(pat)){
                    result.add(i+1);
//                    i=i+patternLength-1;
                }
            }
        }
        return result;
    }
//    static ArrayList<Integer> search(String pat, String txt)
//    {
//        ArrayList<Integer> result= new ArrayList<>();
//        int j=0,index = 0;
//        for(int i=0;i<txt.length();i++){
//            if(txt.charAt(i)==pat.charAt(j)){
//                if(j==0){
//                    index=i+1;
//                }
//                j++;
//            }else if(txt.charAt(i)==pat.charAt(0)) {
//                index=i+1;
//                j=1;
//            }else {
//                j=0;
//                index=0;
//            }
//            if(j==pat.length()){
//                j=0;
//                result.add(index);
//            }
//        }
//        return result;
//    }
}
