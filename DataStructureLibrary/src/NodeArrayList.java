package com.L12BinaryTrees;

public class NodeArrayList<T extends Comparable<T>> {

    // variables:
    private T[] data;
    private int nextIndex;

    // constructor:
    public NodeArrayList(){
        data = (T[]) new Comparable[1];
        nextIndex = 0;
    }

    // methods:

    public T[] toArray(){ return data; }

    public int size() { return data.length; }

    public boolean add(T element) {
        if(element == null){
            return false;
        }

        if(nextIndex >= size()){
            T[] newData = (T[]) new Comparable[size() + 1];
            for(int i=0;i<data.length;i++){
                newData[i] = data[i];
            }
            data = newData;
        }

        data[nextIndex] = element;
        nextIndex += 1;
        return true;
    }

    public void sort() {
        T temp;

        for(int i=0; i < size() - 1;i++){
            for(int n = 0; n < size() - 1 - i; n++){
                if(data[n].compareTo(data[n + 1]) > 0){
                    temp = data[n];
                    data[n] = data[n+1];
                    data[n+1] = temp;
                }
            }
        }
    }
}

