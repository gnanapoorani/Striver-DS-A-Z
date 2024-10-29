import java.util.*;

class Node{
    int key;
    Node left,right;
}

class BinaryTree {
    String name;
    String author;
    int id;

    public BinaryTree(String name, String author, int id){
        super();
        this.name=name;
        this.author=author;
        this.id=id;
    }

    public static void main(String[] args) {
        BinaryTree tree4 = new BinaryTree("BUSINESS","aura",4);
        BinaryTree tree = new BinaryTree("BUSINESS","aura",1);
        BinaryTree tree1 =new BinaryTree("PERSON","nike",2);
        BinaryTree tree2 =new BinaryTree("PERSON","biki",3);
        List<BinaryTree> binaryList = new ArrayList<BinaryTree>();
        binaryList.add(tree);
        binaryList.add(tree1);
        binaryList.add(tree2);
        binaryList.add(tree4);

//        List<BinaryTree> binaryListNew = sortBinaryTree(binaryList);
        Collections.sort(binaryList,(BinaryTree employee1,BinaryTree employee2)->
             employee2.name.compareTo(employee1.name)
        );

        System.out.println(constructCounterpartyFS("1","223rwe","","2"));
      //  String a=constructCounterpartyFS("1","2","","");
        System.out.println(constructCounterpartyFS("","",""));

        String b=constructCounterpartyFS("","","");
        b=b.matches(" :  : ")?"":b;
        boolean atleastOneAlpha = b.matches(".*[a-zA-Z]+.*");
        System.out.println(b);
//        System.out.println(atleasttwiAlpha);

    }
    public static List<BinaryTree> sortBinaryTree(List<BinaryTree> binaryTreeList){
        Collections.sort(binaryTreeList, new Comparator<BinaryTree>() {

            @Override
            public int compare(BinaryTree employee1, BinaryTree employee2) {
                return employee2.name.compareTo(employee1.name);
            }

        });

        return binaryTreeList;
    }

    public static String constructCounterpartyFS(String... args) {

        StringJoiner counterpartyFundingSource = new StringJoiner(" : ");
        for (String arg : args) {
            counterpartyFundingSource.add(arg == null ? "" : arg);
        }

        return counterpartyFundingSource.toString();
    }
}