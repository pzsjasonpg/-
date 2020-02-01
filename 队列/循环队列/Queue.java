package com.company.queue;

/**
 * 循环队列
 */
public class Queue {
    private int maxSize;        //队列大小
    private long[] queArray;
    private int front;          //队列头指针
    private int rear;           //队列尾指针
    private int nItems;         //队列数据个数

    public Queue(int s) {
        maxSize = s;
        queArray = new long[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    /**
     * 向队列中插入数据
     * @param j
     */
    public void insert(long j) {
        if (rear == maxSize - 1) {
            rear = -1;
        }
        queArray[++rear] = j;
        nItems++;
    }

    /**
     * 从队列中移除队列头的数据
     * @return
     */
    public long remove() {
        long temp = queArray[front++];
        if (front == maxSize) {
            front = 0;
        }
        nItems--;
        return temp;
    }

    /**
     * 查看队列头的数据
     * @return
     */
    public long peekFront() {
        return queArray[front];
    }

    public int peekFrontIndex() {
        return front;
    }

    public int peekRearIndex() {
        return rear;
    }

    public boolean isEmply() {
        return (nItems == 0);
    }

    public boolean isFull() {
        return (nItems == maxSize);
    }

    public int size() {
        return nItems;
    }
}
