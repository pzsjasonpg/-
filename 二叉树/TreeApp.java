package com.company.tree.two;

import jdk.nashorn.internal.ir.CallNode;

/**
 * 操作二叉树的类
 */
public class TreeApp {
    public static void main(String[] args) {
        Tree theTree = new Tree();

        theTree.insert(50, 1.5);
        theTree.insert(25, 1.2);
        theTree.insert(75, 1.9);
        theTree.insert(12, 1.5);
        theTree.insert(37, 1.2);
        theTree.insert(43, 1.7);
        theTree.insert(30, 1.5);
        theTree.insert(33, 1.2);
        theTree.insert(87, 1.7);
        theTree.insert(93, 1.5);
        theTree.insert(97, 1.5);

//        // 中序遍历
//        theTree.inOrder(theTree.getRoot());

        theTree.preOrder(theTree.getRoot());
        theTree.delete(50);
        System.out.println();
        theTree.preOrder(theTree.getRoot());



//        System.out.println("最小值：");
//        System.out.println(theTree.minimum().iData);
//
//        System.out.println("最大值：");
//        System.out.println(theTree.maximum().iData);
//
//        // 查找节点
//        Node found = theTree.find(25);
//        if (found != null) {
//            System.out.println("Found the node eith key 25");
//        } else {
//            System.out.println("Could not find node with key 25");
//        }


//        theTree.displayTree();

    }
}
