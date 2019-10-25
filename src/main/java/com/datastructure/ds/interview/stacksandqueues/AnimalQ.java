package com.datastructure.ds.interview.stacksandqueues;

import java.util.LinkedList;

abstract class AnimalQ {
    private int order;
    protected String name;

    public AnimalQ(String n) {
        name = n;
    }

    public void setOrder(int ord) {
        order = ord;
    }

    public int getOrder() {
        return order;
    }

    public boolean isOlderThan(AnimalQ a) {
        return this.order < a.getOrder();
    }
}

class AnimalQueue {
    LinkedList<DogQ> dogs = new LinkedList<DogQ>();
    LinkedList<CatQ> cats = new LinkedList<CatQ>();
    private int order = 0;

    public void enqueue(AnimalQ a) {
        a.setOrder(order);
        order++;

        if (a instanceof DogQ) dogs.addLast((DogQ) a);
        else if (a instanceof CatQ) cats.addLast((CatQ) a);
    }

    public AnimalQ dequeueAny() {
        if (dogs.size() == 0) {
            return dequeueCats();
        } else if (cats.size() == 0) {
            return dequeueDogs();
        }

        DogQ dog = dogs.peek();
        CatQ cat = cats.peek();
        if (dog.isOlderThan(cat)) {
            return dequeueDogs();
        } else {
            dequeueCats();
        }
        return null;
    }

    public CatQ dequeueCats() {
        return cats.poll();
    }

    public DogQ dequeueDogs() {
        return dogs.poll();
    }
}

class DogQ extends AnimalQ { // it must be public
    public DogQ(String n) {
        super(n);
    }
}

class CatQ extends AnimalQ { // it must be public
    public CatQ(String n) {
        super(n);
    }
}
