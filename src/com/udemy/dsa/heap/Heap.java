package com.udemy.dsa.heap;

import java.util.ArrayList;
import java.util.List;

public class Heap {
    private List<Integer> heap;

    public Heap(){
        this.heap = new java.util.ArrayList<>();
    }
    public List<Integer> getHeap() {
        return new ArrayList<>(heap);
    }
    private int leftChild(int index) {
        return 2 * index + 1;
    }
    private int rightChild(int index) {
        return 2 * index + 2;
    }
    private int parent(int index) {
        return (index - 1) / 2;
    }
    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public void insert(int value) {
        heap.add(value);
        int index = heap.size() - 1;
        while (index > 0 && heap.get(parent(index)) < heap.get(index)) {
            swap(parent(index), index);
            index = parent(index);
        }
    }

    public void printHeap() {
        System.out.println(heap);
    }

//    public Integer remove() {
//        if (heap.isEmpty()) {
//            return null;
//        }
//        int rootValue = heap.get(0);
//        int lastIndex = heap.size() - 1;
//        heap.set(0, heap.get(lastIndex));
//        heap.remove(lastIndex);
//        heapify(0);
//        return rootValue;
//    }

    public Integer remove() {
        if (heap.isEmpty())
            return null;

        int maxValue = heap.get(0);
        int lastIndex = heap.size() - 1;

        heap.set(0, heap.get(lastIndex));
        heap.remove(lastIndex);

        if (!heap.isEmpty()) {
            sinkDown(0);
        }

        return maxValue;
    }

    // ✅ Recursive version of heapify
    private void heapify(int i) {
        int largest = i;
        int left = leftChild(i);
        int right = rightChild(i);

        if (left < heap.size() && heap.get(left) > heap.get(largest)) {
            largest = left;
        }
        if (right < heap.size() && heap.get(right) > heap.get(largest)) {
            largest = right;
        }
        if (largest != i) {
            swap(i, largest);
            heapify(largest);
        }
    }

    // ✅ Iterative version of heapify
    private void sinkDown(int index) {
        int size = heap.size();

        while (true) {
            int left = leftChild(index);
            int right = rightChild(index);
            int largest = index;

            if (left < size && heap.get(left) > heap.get(largest)) {
                largest = left;
            }

            if (right < size && heap.get(right) > heap.get(largest)) {
                largest = right;
            }

            if (largest == index) {
                break; // no more sinking needed
            }

            swap(index, largest);
            index = largest; // continue sinking down
        }
    }
}
