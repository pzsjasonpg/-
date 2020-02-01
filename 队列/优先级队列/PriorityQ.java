package com.company.queue;

/**
 * 优先级队列
 * 注意在优先级队列的实现没有使用指针回绕
 * 队列尾部指针总是指向数组索引为0的位置
 */
public class PriorityQ {
    private int maxSize;
    private long[] queArray;
    private int nItems;

    public PriorityQ(int s) {
        maxSize = s;
        queArray = new long[maxSize];
        nItems = 0;
    }

    /**
     * 在队列尾部插入数据（从小到大）。
     * 如果要插入的数据比队列头的数据大，遍历队列，将队列向数组前进一步
     * @param item
     */
    public void insert(long item) {
        int j;
        if (nItems == 0) {                          //如果为空队列
            queArray[nItems++] = item;              //插入 at 0
        } else {
            for (j = nItems - 1; j >= 0; j--) {     //从队列头遍历
                if (item > queArray[j]) {           //如果item更大
                    queArray[j + 1] = queArray[j];  //队列中数据向前移动
                } else {
                    break;
                }
            }
            queArray[j+1] = item;                   //插入
            nItems++;
        }
    }

    public long remove() {
        return queArray[--nItems];
    }

    public long peekMin() {
        return queArray[nItems-1];
    }

    public boolean isEmpty() {
        return (nItems==0);
    }

    public boolean isFull() {
        return (nItems==maxSize);
    }
}
