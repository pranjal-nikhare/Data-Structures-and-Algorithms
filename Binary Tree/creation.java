import java.util.*;
public class magnet {
    static class Node {
        int key;
        Node left;
        Node right;

        public Node(int key) {
            this.key = key;
            left = right = null;
        }
    }

    static class BinaryTree {
        static int idx = -1;


        public static Node buildtree (int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildtree(nodes);
            newNode.right = buildtree(nodes);

            return newNode;
        }

        public static void levelOrder (Node root) {
            Queue<Node> q = new LinkedList<>();
            if (root == null) {
                return;
            }
            q.add(root);
            q.add(null);
            while (!q.isEmpty()) {
                Node currNode = q.poll();
                if (currNode == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        return;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(currNode.key + " ");
                    if (currNode.left != null) {
                        q.add(currNode.left);
                    } 
                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
            }

        }
        public static int height (Node root) {
            if (root == null) {
                return 0;
            } return (Math.max(height(root.left), height(root.right)) + 1);
        }
        // public static int height (Node root) {
        //     if (root == null) {
        //         return 0;
        //     }
        //     int leftHeight = height(root.left);
        //     int rightHeight = height(root.right);
        //     if (leftHeight > rightHeight) {
        //         return (leftHeight + 1);
        //     } else {
        //         return (rightHeight + 1);
        //     }
        // }
    }

    

    public static void main(String[] args) {
        int [] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        // int[] nodes = {5,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree bt = new BinaryTree();
        Node root = bt.buildtree(nodes);
        System.out.println(root.key);
        bt.levelOrder(root); 
        int ht = bt.height(root);
        System.out.println("Height is " + ht);
    }

}
