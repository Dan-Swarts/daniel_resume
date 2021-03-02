public class Queue<T extends Comparable<T>> {

    // variables:
    private LinkedList data;

    // constructors:
    public Queue(){
        data = new LinkedList();
    }

    // methods:
    public void enqueue(T element){
        data.add(element);
    }

    public T dequeue(){
        T output = (T) data.get(0);
        data.remove(0);
        return output;
    }

    public T peek(){
        return (T) data.get(0);
    }

    public String toString(){
        return data.toString();
    }

    public int getSize(){
        return data.size();
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }

    public static void main(String args[]){
        Queue<String> myQueue = new Queue<String>();
        myQueue.enqueue("Dave");
        myQueue.enqueue("John");


        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
    }
}
