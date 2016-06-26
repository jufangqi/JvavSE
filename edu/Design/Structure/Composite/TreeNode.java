package edu.Design.Structure.Composite;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by 存 on 2016/6/11.
 */
public class TreeNode {

    private String name;
    private TreeNode parent;
    private Vector<TreeNode> chilren = new Vector<TreeNode>();

    public void add(TreeNode node){
        chilren.add(node);
    }

    public Enumeration<TreeNode> get(){
        return chilren.elements();
    }

    public void remove(TreeNode node){
        chilren.remove(node);
    }

    public TreeNode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

}
