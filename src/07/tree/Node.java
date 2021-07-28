package tree;


/**
 * 이진트리 구현을 위한 Node  클래스
 * */
public class Node {
    int value;
    Node left;
    Node right;

    public Node(int value){
        this.value = value;
        left = null;
        right = null;
    }
}
