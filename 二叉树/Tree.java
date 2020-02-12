package com.company.tree.two;

import javax.swing.text.StyledEditorKit;
import java.util.Stack;

/**
 * 二叉树中表示树本身的类
 */
public class Tree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public Node find(int key) {
        Node current = root;
        while (current.iData != key) {      // 找到匹配的key值为止
            if (key < current.iData) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    public void insert(int id, double dd) {
        Node newNode = new Node();
        newNode.iData = id;
        newNode.fData = dd;
        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (id < current.iData) {   // go left
                    current = current.leftChild;
                    if (current == null) {  //找到符合的叶子节点，插入左节点
                        parent.leftChild = newNode;
                        return;
                    }
                } else {                    // go right
                    current = current.rightChild;
                    if (current == null) {  //找到符合的叶子节点，插入右节点
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public boolean delete(int key) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;

        while (current.iData != key) {      // search for node
            parent = current;
            if (key < current.iData) {      // go left
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.leftChild;
            }
            if (current == null) {
                return false;
            }
        }
        //找到节点后，删除没有子节点的节点
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
            //删除有一个子节点的节点
        } else if (current.rightChild == null) {
            if (current == root) {      //判断要删除的节点是不是根节点
                root = current.leftChild;
            } else if (isLeftChild) {   //要删除的节点是父节点的左节点
                parent.leftChild = current.leftChild;
            } else {                    //要删除的节点是父节点的右节点
                parent.rightChild = current.leftChild;
            }
        } else if (current.leftChild == null) {
            if (current == root) {
                root = current.rightChild;
            } else if (isLeftChild) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
            //删除有两个子节点的节点
        } else {
            //查找到后继节点
            Node successor =getSuccessor(current);

            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;
        }
        return true;
    }

    // /删除有两个子节点的节点时，找到后继节点
    private Node getSuccessor(Node delNode) {
        Node successorParent = delNode;
        Node successor = delNode;       //后继节点
        Node current = delNode.rightChild;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if (successor != delNode.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }

    public void traverse(int tracerseType) {
        switch (tracerseType) {
            case 1:
                System.out.println("Preorder traversal: ");
                preOrder(root);
                break;
            case 2:
                System.out.println("Inorder traversal: ");
                inOrder(root);
                break;
            case 3:
                System.out.println("Postorder traversal: ");
                postOrder(root);
                break;
        }
        System.out.println();
    }

    /**
     * 中序遍历二叉树
     *
     * @param localRoot
     */
    public void inOrder(Node localRoot) {
        if (localRoot != null) {
            inOrder(localRoot.leftChild);
            System.out.println(localRoot.iData);
            inOrder(localRoot.rightChild);
        }
    }

    /**
     * 前序遍历二叉树
     * @param localRoot
     */
    public void preOrder(Node localRoot) {
        if (localRoot != null) {
            System.out.println(localRoot.iData + " ");
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }

    /**
     * 后序遍历二叉树
     * @param localRoot
     */
    public void postOrder(Node localRoot) {
        if (localRoot != null) {
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
            System.out.println(localRoot.iData + " ");
        }
    }

    /**
     * 最小值
     *
     * @return
     */
    public Node minimum() {
        Node current, last = null;
        current = root;
        while (current != null) {
            last = current;
            current = current.leftChild;
        }
        return last;
    }

    /**
     * 最大值
     *
     * @return
     */
    public Node maximum() {
        Node current, last = null;
        current = root;
        while (current != null) {
            last = current;
            current = current.rightChild;
        }
        return last;
    }

    public void displayTree() {
        Stack globalStack = new Stack();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println("-----------------------------------");
        while (isRowEmpty == false) {
            Stack localStack = new Stack();
            isRowEmpty = true;

            for (int j = 0; j < nBlanks; j++) {
                System.out.print(" ");
            }

            while (globalStack.isEmpty() == false) {
                Node temp = (Node)globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.iData);
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);

                    if (temp.leftChild != null || temp.rightChild != null) {
                        isRowEmpty = false;
                    } else {
                        System.out.print("--");
                        localStack.push(null);
                        localStack.push(null);
                    }
                    for (int j = 0; j < nBlanks * 2 - 2; j++) {
                        System.out.print(" ");
                    }
                    System.out.println();
                    nBlanks /= 2;
                    while (localStack.isEmpty() == false) {
                        globalStack.push(localStack.pop());
                    }
                    System.out.println("-----------------------------------");
                }
            }
        }

    }

}
