// Stack1Gen.java
// The StackGen Interface is implemented using a linked list
// The linked list used is a simple generic node class called NGen.  (See NGen.java)

public class Stack<T extends Comparable<T>> implements MyStack<T> {

    // instance variables

    private Node<T> start = null;

    // constructor

    public Stack() {}
    
    // selectors

    public void push(T o) {
        start = new Node<T>(o, start);
    }

    public T pop() {
        if (start == null)
          throw new RuntimeException("Tried to pop an empty stack");
        else {
          T data = start.getData();
          start = start.getNext();
          return data;
        }
    }

    public T peek() {
        if (start == null)
          return null;
        else return start.getData();
    }

    public boolean isEmpty() {
        if (start == null)
          return true;
        else return false;
    }

}  // Stack1Gen class
