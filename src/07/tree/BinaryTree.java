package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    Node head;
    int size;

    public BinaryTree(){
        head = null;
        size = 0;
    }

    /**
     * 노트를 트리에 추가하는 함수
     * */
    public void push(Node nd){
        if(size == 0){
            Node node = nd;
            head = node;
        }else{
            Node node = head;

            Queue<Node> q = new LinkedList<Node>();
            q.add(node);

            while(!q.isEmpty()){
                Node temp = q.poll();

                if(temp.left == null){
                    temp.left = nd;
                    break;
                }else{
                    q.add(temp.left);
                }

                if(temp.right == null){
                    temp.right = nd;
                    break;
                }else{
                    q.add(temp.right);
                }
            }
        }
        size ++;
    }

    /**
     * 노드를 트리에서 제거하는 함수
     * */
//    public int pop(Node node){
//        if(contain(node)){
//            Node lastNode = remove
//        }
//    }

    /**
     * 노드가 트리에 포함되어있는지 확인하는 함수
     * */
    public boolean contain(Node node){
        boolean check = false;

        if(size != 0){
            Queue<Node> q = new LinkedList<>();
            q.add(head);

            while (!q.isEmpty()){
                Node temp = q.poll();

                if(isSame(temp, node)){
                    check = true;
                    break;
                }

                if(temp.left != null){
                    q.add(temp.left);
                }

                if(temp.right != null){
                    q.add(temp.right);
                }
            }
        }
        return check;
    }

    /**
     * 트리에서 마지막 노드를 제거하는 함수
     * */
    private Node removeLastNode(){
        Node last = head;

        if(size == 1){
            head = null;
        }else{
            Queue<Node> q = new LinkedList<>();
            q.add(last);

            while(!q.isEmpty()){
                Node temp = q.poll();
                last = temp;

                if(temp.left != null){
                    q.add(temp.left);
                }

                if(temp.right != null){
                    q.add(temp.right);
                }
            }

            q.add(head);

            while (!q.isEmpty()){
                Node temp = q.poll();

                if(temp.left != null){
                    if(isSame(temp.left, last)){
                        temp.left = null;
                        break;
                    }else{
                        q.add(temp.left);
                    }
                }

                if(temp.right != null){
                    if(isSame(temp.right, last)){
                        temp.right = null;
                        break;
                    }else {
                        q.add(temp.right);
                    }
                }
            }
        }
        return last;
    }

    /**
     * 두 개의 노드가 같은 노드인지 확인하는 함수
     * */
    private boolean isSame(Node a, Node b) {
        if (a.value == b.value && a.left == b.left && a.right == b.right) {
            return true;
        }
        return false;
    }


    /**
     * BFS -> 루트 노드에서부터 시작하여 가까운 노드부터 먼저 탐색
     * */
    public void printBFS(Node node) {

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            System.out.println(temp.value);

            if (temp.left != null) {
                queue.add(temp.left);
            }

            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
    }

    public void printDFS(Node node) {

        if(node.left == null && node.right == null){
            System.out.println(node.value);
        }else{
            if(node.left != null){
                printDFS(node.left);
            }
            System.out.println(node.value);
            if(node.right != null){
                printDFS(node.right);
            }
        }
    }
}
