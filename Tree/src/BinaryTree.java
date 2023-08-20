import java.util.*;

public class BinaryTree {
    public static TreeNode buildTree(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the root value or (-1 for null) :");
        int rootValue = sc.nextInt();

        if(rootValue==-1){
            return null;
        }

        TreeNode root = new TreeNode(rootValue);

        System.out.println("Enter the left subtree for "+rootValue);
        root.left = buildTree();

        System.out.println("Enter the right subtree for "+rootValue);
        root.right = buildTree();

        return root;
    }

    public static int findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.val;
    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // Node with one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Node with two children: get the inorder successor (smallest in the right subtree)
            root.val = findMin(root.right);

            // Delete the inorder successor
            root.right = deleteNode(root.right, root.val);
        }

        return root;
    }
    public static void inOrderTraversal(TreeNode root){
        if(root!=null){
            inOrderTraversal(root.left);
            System.out.print(root.val+" ");
            inOrderTraversal(root.right);
        }
    }

    public static void preOrderTraversal(TreeNode root){
        if(root!=null){
            System.out.print(root.val+" ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    public static void postOrderTraversal(TreeNode root){
        if(root!=null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.val + " ");
        }
    }

    public static void levelOrderTraversal(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        if(root==null){
            System.out.println("null");
            return;
        }
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> sub = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                assert curr != null;
                if(curr.left!=null){
                    q.offer(curr.left);
                }
                if(curr.right!=null){
                    q.offer(curr.right);
                }
                sub.add(curr.val);
            }
            list.add(sub);
        }
        for (List<Integer> sublist : list) {
            for (int value : sublist) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        System.out.println("Constructing a Binary Tree:");
        TreeNode root = buildTree();

        int deleteValue = 3;
        root = deleteNode(root, deleteValue);

        System.out.println("Binary tree Inorder Traversal");
        inOrderTraversal(root);
        System.out.println();

        System.out.println("Binary tree PreOrder Traversal");
        preOrderTraversal(root);
        System.out.println();

        System.out.println("Binary tree PostOrder Traversal");
        postOrderTraversal(root);
        System.out.println();

        System.out.println("Binary Tree LevelOrder Traversal");
        levelOrderTraversal(root);
    }
}
