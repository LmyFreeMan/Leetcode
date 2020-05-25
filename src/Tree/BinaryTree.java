package Tree;

public class BinaryTree {

    private Node root;
    private Node temp;

    public BinaryTree() {
        root = new Node();
        temp = root;

    }

    public void insertTree(Node child) {
        if (child == null)
            return;
        //如果传入节点的值小于根节点
        if (child.getData() < temp.getData()) {
            //如果根节点的左子节点为null
            if (temp.getLeft() == null) {
                temp.setLeft(child);
                temp = root;
            }
            //递归左子树
            else {
                temp = temp.getLeft();
                insertTree(child);
            }
        }
        //如果传入节点的值大于根节点
        if (child.getData() > temp.getData()) {
            //如果根节点的右子节点为null
            if (temp.getRight() == null) {
                temp.setRight(child);
                temp = root;
            }
            //递归左子树
            else {
                temp = temp.getRight();
                insertTree(child);
            }
        }

    }

    //前序遍历
    public void preOder(Node root) {
        if (root == null) {
            return;
        } else {
            System.out.print(root.getData());
            preOder(root.getLeft());
            preOder(root.getRight());
        }
    }

    //中序遍历
    public void midOder(Node root) {
        if (root == null) {
            return;
        } else {
            midOder(root.getLeft());
            System.out.print(root.getData());
            midOder(root.getRight());
        }
    }

    //后序遍历
    public void lastOder(Node root) {
        if (root == null) {
            return;
        } else {
            lastOder(root.getLeft());
            lastOder(root.getRight());
            System.out.print(root.getData());
        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insertTree(new Node(1));
        binaryTree.insertTree(new Node(6));
        binaryTree.insertTree(new Node(8));
        binaryTree.insertTree(new Node(2));
        binaryTree.insertTree(new Node(5));
        System.out.print("先序遍历的结果:");
        binaryTree.preOder(binaryTree.root);
        System.out.println();
        System.out.print("中序遍历的结果:");
        binaryTree.midOder(binaryTree.root);
        System.out.println();
        System.out.print("后序遍历的结果:");
        binaryTree.lastOder(binaryTree.root);
    }

}
