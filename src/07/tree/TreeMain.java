package tree;

public class TreeMain {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();

        Node node = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);

        /*노드 삽입*/
        bt.push(node);
        bt.push(node1);
        bt.push(node2);
        bt.push(node3);
        bt.push(node4);

        /*노드 탑색 시작*/
        System.out.println("노드 탐색 시작 --> BFS");
        bt.printBFS(node);

        System.out.println("노드 탐색 시작 --> DFS");
        bt.printDFS(node);
    }
}
