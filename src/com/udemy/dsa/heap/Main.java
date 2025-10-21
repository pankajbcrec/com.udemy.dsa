package com.udemy.dsa.heap;

public class Main {
    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.insert(99);
        heap.insert(72);
        heap.insert(61);
        heap.insert(58);

        System.out.println("Max Heap:");
        heap.printHeap();

        heap.insert(100);
        heap.printHeap();

        heap.insert(75);
        heap.printHeap();

        heap.remove();
        heap.printHeap();

    }
}
