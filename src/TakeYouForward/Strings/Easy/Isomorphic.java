import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Isomorphic {
    public static void main(String[] args) {

        System.out.println(isIsomorphic("hello" ,"wokld"));
    }
    public static boolean isIsomorphic(String s, String t) {

        int map1[]=new int[200];
        int map2[]=new int[200];

        if(s.length()!=t.length())
            return false;


        for(int i=0;i<s.length();i++)
        {
            if(map1[s.charAt(i)]!=map2[t.charAt(i)])
                return false;

            map1[s.charAt(i)]=i+1;
            map2[t.charAt(i)]=i+1;
        }
        return true;
    }
//    bool isIsomorphic(string s, string t) {
//        unordered_map<char, char> mp, mp2;
//        for (int i=0; i<s.length(); ++i) {
//            if (mp[s[i]] && mp[s[i]]!=t[i]) return false;
//            if (mp2[t[i]] && mp2[t[i]]!=s[i]) return false;
//            mp[s[i]]=t[i];
//            mp2[t[i]]=s[i];
//        }
//        return true;
//    }
    public static boolean isIsomorphic1(String s, String t) {

        Map<Character,Character> map= new HashMap<>();
        if(s.length()!=t.length()){
            return false;
        }
        for(int i=0;i<s.length();i++){
            if(map.get(s.charAt(i))!=null){
              if(map.get(s.charAt(i))!=t.charAt(i)){
                  return  false;
              }
            }else{
                map.put(s.charAt(i),t.charAt(i));
            }
        }
        Set<Character> valueSet= new HashSet<>(map.values());
        if(valueSet.size()==map.values().size()){
            return true;
        }
        return  false;
    }

}