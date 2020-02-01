package com.company.stack;

public class StackX {
    private int maxSize;        // 数组实现的栈的大小
    private long[] stackArray;
    private int top;            // 栈的顶部位置索引

    public StackX(int s) {
        maxSize = s;
        stackArray = new long[maxSize];
        top = -1;
    }

    /**
     * 将对象数据推入栈顶
     * @param j 对象数据
     */
    public void push(long j) {
        stackArray[++top] = j;
    }

    /**
     * 将栈顶数据推出栈
     * @return 栈顶数据
     */
    public long pop() {
        return stackArray[top--];
    }

    /**
     * 查看栈顶数据
     * @return 栈顶数据
     */
    public long peek() {
        return stackArray[top];
    }

    public boolean isEmply() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize-1);
    }
}
