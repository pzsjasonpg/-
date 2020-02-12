package com.company.tree.two;

import com.sun.org.apache.xerces.internal.impl.dv.dtd.IDDatatypeValidator;

/**
 * 二叉树中节点类
 */
public class Node {
    int iData;              // data item (key)
    double fData;           // data item
    Node leftChild;         // this node's left child
    Node rightChild;        // this node's right child

    public void displayNode() {
        System.out.print("{");
        System.out.print(iData);
        System.out.print(", ");
        System.out.print(fData);
        System.out.print("} ");
    }
}
