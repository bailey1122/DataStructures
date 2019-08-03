package com.datastructure.ds.stack;


public class RunnerS {
    public static void main(String[] args) {
        DStack dStack = new DStack();
        dStack.push(40);
        dStack.push(20);
        dStack.push(50);
        dStack.push(60);
        dStack.push(30);

        dStack.pop();
        dStack.pop();
        dStack.pop();

        dStack.show();

//        MyStack nums = new MyStack();
//        nums.push(20);
//        nums.push(10);
//        nums.push(25);
//        nums.push(1);
//        nums.push(21);
////        nums.push(80); // won't be put 'cause the stack size
//
//        System.out.println("The top element: " + + nums.peek());
//        System.out.println(nums.size());
//        System.out.println(nums.isEmpty());
//
//        nums.show();
////        System.out.println("The removed element: " + nums.pop());
////        nums.pop();
////        nums.pop();
////        nums.pop();
////        nums.pop();
////        nums.pop();
////        nums.pop();
//
//        nums.show();

    }
}
