package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {
    public TreeNode root;
    public TreeNode temp;

    public BinaryTree(TreeNode node) {
        root = node;
        temp = root;
    }

    public void insertTree(TreeNode child) {
        if (child == null)
            return;
        //如果传入节点的值小于根节点
        if (child.val < temp.val) {
            //如果根节点的左子节点为null
            if (temp.left == null) {
                temp.left = child;
                temp = root;
            }
            //递归左子树
            else {
                temp = temp.left;
                insertTree(child);
            }
        }
        //如果传入节点的值大于根节点
        if (child.val > temp.val) {
            //如果根节点的右子节点为null
            if (temp.right == null) {
                temp.right = child;
                temp = root;
            }
            //递归左子树
            else {
                temp = temp.right;
                insertTree(child);
            }
        }
    }

    //    //前序遍历
    public void preOder(TreeNode root) {
        if (root == null) {
            return;
        } else {
            System.out.print(root.val);
            preOder(root.left);
            preOder(root.right);
        }
    }

    //    //中序遍历
    public void midOder(TreeNode root) {
        if (root == null) {
            return;
        } else {
            midOder(root.left);
            System.out.print(root.val);
            midOder(root.right);
        }
    }

    //查找公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else {
                break;
            }
        }
        return root;
    }

    //后序遍历
    public void lastOder(TreeNode root) {
        if (root == null) {
            return;
        } else {
            lastOder(root.right);
            lastOder(root.left);
            System.out.print(root.val);
        }
    }

    //按层遍历节点
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }

    //计算树的深度
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }

    //    public void delNode(int index){
//        TreeNode treeNode =get(index);
//        //没有左右子节点时
//        if(treeNode.getRight()==null&& treeNode.getLeft()==null){
//            TreeNode parent=getParent(index);
//            if(parent.getLeft()== treeNode)
//                parent.setLeft(null);
//            else
//                parent.setRight(null);
//        }else if(treeNode.getLeft()!=null){
//            TreeNode parent=getParent(index);
//
//        }
//    }
    //得到父节点的值
    public TreeNode getParent(TreeNode child) {
        TreeNode temp = root;
        if (temp == null)
            return null;
        while (temp != null) {
            if (child.val > temp.val) {
                if (temp.right.val == child.val) {
                    return temp;
                }
                temp = temp.right;
            } else if (child.val < temp.val) {
                if (temp.left.val == child.val) {
                    return temp;
                }
                temp = temp.left;
            } else {
                return temp;
            }
        }
        return null;
    }

    //找到指定节点
    public TreeNode get(TreeNode node) {
        TreeNode temp = root;
        if (temp == null)
            return null;
        while (temp != null) {
            if (node.val > temp.val) {
                temp = temp.right;
            } else if (node.val < temp.val) {
                temp = temp.left;
            } else
                return temp;
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        BinaryTree binaryTree = new BinaryTree(root);
        binaryTree.insertTree(new TreeNode(3));
        binaryTree.insertTree(new TreeNode(6));
        binaryTree.insertTree(new TreeNode(2));
        binaryTree.insertTree(new TreeNode(4));
        binaryTree.insertTree(new TreeNode(1));
        System.out.println(55);
        System.out.print("先序遍历的结果:");
        binaryTree.preOder(root);
        System.out.println();
        System.out.print("中序遍历的结果:");
        binaryTree.midOder(root);
        System.out.println();
        System.out.print("后序遍历的结果:");
        binaryTree.lastOder(root);
        int m = binaryTree.maxDepth(root);
        System.out.println();
        System.out.println("该二叉树的深度为:" + m);
        TreeNode p = new TreeNode(1);
        TreeNode t = binaryTree.get(p);
        TreeNode parent = binaryTree.getParent(p);
        System.out.println(parent);
        List list = binaryTree.levelOrder(root);
        System.out.println(list);
//        int count = binaryTree.maxDepth(binaryTree.root.getRight());
//        System.out.println();
//        System.out.println(count);
    }
}