import java.util.ArrayList;
import java.util.List;

class PowerImpl2323sd {
    public static void main(String[] args) {

        System.out.println(subset(new int[]{1,2,3,3}));
    }

    public static List<List<Integer>> subset(int[] arr) {
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>());
        int previousIndex=0;
        for(int i=0;i<arr.length;i++){
                if(i>0 && arr[i]!=arr[i-1]){
                    previousIndex=0;
                }
            int n=answer.size();
            for(int j=previousIndex;j<n;j++){
                List<Integer> subList= new ArrayList<>(answer.get(j));
                subList.add(arr[i]);
                answer.add(subList);
            }
            previousIndex=n;
        }
        return answer;
    }

}