package com.datastructure.ds.queue;

public class RunnerQ {
    public static void main(String[] args) {
        Queue queue = new Queue();
//        queue.enQueue(3);
//        queue.enQueue(6);
//        queue.enQueue(2);
//        queue.enQueue(7);

        queue.deQueue();
        queue.deQueue();

//        queue.enQueue(5);
//        queue.enQueue(8);

//        System.out.println(queue.isEmpty());
        System.out.println(queue.isFull());

//        queue.enQueue(9);
//        queue.enQueue(15);

        System.out.println("Size: " + queue.getSize());
        queue.show();
    }
}
