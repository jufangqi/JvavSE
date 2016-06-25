package net.Design.Composite;

/**
 * Created by 存 on 2016/6/11.
 */
public class Tree {

    TreeNode root = null;

    public Tree(String name){
        this.root = new TreeNode(name);
    }

    public static void main(String[] args) {
        Tree tree = new Tree("1");
        TreeNode nodeB = new TreeNode("B");
        TreeNode nodeC = new TreeNode("c");
        nodeB.add(nodeC);
        tree.root.add(nodeB);
    }
}
