package com.company.queue;

public class QueueApp {
    public static void main(String[] args) {
        Queue theQueue = new Queue(5);

        theQueue.insert(10);
//        theQueue.insert(20);
//        theQueue.insert(30);
//        theQueue.insert(40);

        theQueue.remove();
//        theQueue.remove();
//        theQueue.remove();
//
        theQueue.insert(50);
        theQueue.insert(60);
        theQueue.insert(70);
        theQueue.insert(80);
        theQueue.insert(90);
        System.out.println(theQueue.peekFrontIndex());
        System.out.println(theQueue.peekRearIndex());
        while (!theQueue.isEmply()) {
            long n = theQueue.remove();
            System.out.print(n);
            System.out.print(" ");
        }
        System.out.println("");


    }
}
