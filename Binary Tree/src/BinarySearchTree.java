import java.util.Scanner;

public class BinarySearchTree {
    public static TreeNode insert(TreeNode root,int data){
        if(root==null){
            return new TreeNode(data);
        }

        if(data < root.val){
            root.left = insert(root.left,data);
        }else{
            root.right = insert(root.right,data);
        }

        return root;
    }

    public static TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public static TreeNode delete(TreeNode root, int value) {
        if (root == null) {
            return null;
        }

        if (value < root.val) {
            root.left = delete(root.left, value);
        } else if (value > root.val) {
            root.right = delete(root.right, value);
        } else {
            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Node with two children, get the inorder successor (smallest in the right subtree)
            root.val = findMin(root.right).val;

            // Delete the inorder successor
            root.right = delete(root.right, root.val);
        }

        return root;
    }
    public static void main(String[] args) {
        TreeNode root = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number of elements to insert in tree");
        int num = sc.nextInt();
        System.out.println("Enter the elements to insert");
        for(int i=0;i<num;i++){
            int data = sc.nextInt();
            root = insert(root,data);
        }

        int deleteValue = 5;
        root = delete(root, deleteValue);

        System.out.println("Binary tree Inorder Traversal");
        BinaryTree.inOrderTraversal(root);
        System.out.println();

        System.out.println("Binary tree PreOrder Traversal");
        BinaryTree.preOrderTraversal(root);
        System.out.println();

        System.out.println("Binary tree PostOrder Traversal");
        BinaryTree.postOrderTraversal(root);
        System.out.println();

        System.out.println("Binary Tree LevelOrder Traversal");
        BinaryTree.levelOrderTraversal(root);
    }
}
