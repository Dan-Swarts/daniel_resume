public class LinkedList<T extends Comparable<T>> implements MyList<T> {

    // initialize variables:
    private Node head;
    private boolean isSorted;

    // constructor:
    public LinkedList() {
        this.head = new Node(null);
        isSorted = true;
    }

    public LinkedList extractGroupsOf(int n){

        LinkedList output = new LinkedList();

        if(n <= 0){
            return output;
        }

        if(n >= size()){
            return this;
        }

        Node currNode = head;
        int currIndex = 0;
        LinkedList subList = new LinkedList();

        while(currNode.getNext() != null){
            subList.add(currNode.getNext().getData());

            if(currIndex % n == 0){
                output.add((Comparable) subList);
                subList = new LinkedList();
            }

            currNode = currNode.getNext();
            currIndex += 1;
        }

        return output;
    }

    @Override
    public boolean add(T t) {

        if(t == null){
            return false;
        }

        Node currNode = head;
        while(currNode.getNext() != null){
            currNode = currNode.getNext();
        }
        currNode.setNext(new Node(t));

        if(size() != 1){
            isSorted = false;
        }
        return true;
    }

    @Override
    public boolean add(int index, T element) {

        if(isEmpty() || index < 0 || index >= size()){
            return false;
        }

        Node currNode = head;
        int currIndex = 0;
        while(currIndex < index){
            currNode = currNode.getNext();
            currIndex += 1;
        }
        currNode.setNext(new Node(element, currNode.getNext()));
        isSorted = false;
        return true;
    }

    @Override
    public void clear() {
        head.setNext(null);
        isSorted = true;
    }

    @Override
    public T get(int index) {

        if (index < 0 || index >= size() || isEmpty()){
            return null;
        }

        Node currNode = head.getNext();
        int currIndex = 0;

        while (currIndex < index){
            currNode = currNode.getNext();
            currIndex += 1;
        }
        return (T) currNode.getData();
    }

    @Override
    public int indexOf(T element) {

        if(isEmpty()){
            return -1;
        }

        Node currNode = head.getNext();
        int currIndex = 0;

        while(currNode.getNext() != null){

            if(currNode.getData() == element){
                return currIndex;
            }

            currNode = currNode.getNext();
            currIndex += 1;
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        if(head.getNext() == null){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public int size() {
        Node currNode = head;
        int CurrIndex = 0;

        while (currNode.getNext() != null){
            currNode = currNode.getNext();
            CurrIndex += 1;
        }
        return CurrIndex;
    }

    @Override

    // bubble sort algorithm
    public void sort() {

        // will not sort if empty or size of 1
        if(size() <= 1){
            return;
        }

        // sorts a number of times equal to the number of elements in the list minus 1
        for(int i=0;i<size()-1;i++){

            // each sort, the largest element will bubble up to the top of the list
            Node currNode = head.getNext();

            // goes through the list
            while(currNode.getNext() != null){

                // if previous data is larger than next data...
                if(currNode.getData().compareTo(currNode.getNext().getData()) > 0){

                    // ...switch data values
                    Comparable temp = currNode.getData();
                    currNode.setData(currNode.getNext().getData());
                    currNode.getNext().setData(temp);
                }

                // iterate
                currNode = currNode.getNext();
            }
        }
    }

    @Override
    public T remove(int index) {

        if(isEmpty() || index < 0 || index > size()){
            return null;
        }

        Node currNode = head;
        int currIndex = 0;

        while(currIndex < index){
            currNode = currNode.getNext();
            currIndex += 1;
        }

        if(index == size()){
            T output = (T) currNode.getNext().getData();
            currNode.setNext(null);
            return output;
        }

        T output = (T) currNode.getNext().getData();
        currNode.setNext(currNode.getNext().getNext());
        return output;
    }

    public String toString(){
        String out = "";

        for(int i=0;i<size();i++){
            if(i==size()-1){
                out += String.format("%s.",get(i));
                return out;
            }
            else {
                out += String.format("%s, ", get(i));
            }
        }
        return out;
    }

    @Override
    public void greaterThan(T element) {
        if(isEmpty()){
            return;
        }

        Node currNode = head;

        while(currNode.getNext() != null) {

            // if next node's data is smaller than the element...
            if (currNode.getNext().getData().compareTo(element) <= 0) {

                // remove next node

                // if at the end of the list, set node to null
                if (currNode.getNext().getNext() == null) {
                    currNode.setNext(null);
                }

                // otherwise skip next node
                else{
                    currNode.setNext(currNode.getNext().getNext());
                }
            }

            // if next node's data is greater or equal to...
            else {

                // ...AND list is sorted...
                if(isSorted){
                    // ...every other element will also be greater
                    return;
                }
                // ...increment
                currNode = currNode.getNext();
            }
        }
    }

    @Override
    public void lessThan(T element) {
        if(isEmpty()){
            return;
        }

        Node currNode = head;

        while(currNode.getNext() != null) {

            // if next node's data is greater than the element...
            if (currNode.getNext().getData().compareTo(element) >= 0) {

                // remove next node...

                // if sorted, every future node will also be greater and must be removed
                if(isSorted){
                    currNode.setNext(null);
                    return;
                }

                // if at the end of the list, set final Node to null
                else if (currNode.getNext().getNext() == null) {
                    currNode.setNext(null);
                }

                // else, skip next node
                else {
                    currNode.setNext(currNode.getNext().getNext());
                }
            }

            else {
                // increment if nothing was removed
                currNode = currNode.getNext();
            }
        }
    }

    @Override
    public void equalTo(T element) {
        if(isEmpty()){
            return;
        }

        Node currNode = head;

        while(currNode.getNext() != null) {

            // if next node's data is not equal to the element...
            if (currNode.getNext().getData().compareTo(element) != 0) {

                // remove next node...

                // if at the end of the list, set final Node to null
                if (currNode.getNext().getNext() == null) {
                    currNode.setNext(null);
                }

                // else, skip next node
                else {
                    currNode.setNext(currNode.getNext().getNext());
                }
            }

            else {
                // increment if nothing was removed
                currNode = currNode.getNext();
            }
        }
    }

    public void removeEvery(int n){
        if(n<=0 || n > size()){
            return;
        }
        Node currNode = head;
        int nth = 1;
        int index = 0;
        while(currNode.getNext() != null){
            if(nth == n){
                remove(index);
                nth = 1;
            }
            else{
                currNode = currNode.getNext();
                index += 1;
                nth += 1;
            }
        }
    }

    public static void main(String args[]){
        LinkedList myList = new LinkedList();

        myList.add('A');
        myList.add('B');
        myList.add('C');
        myList.add('D');
        myList.add('E');
        myList.add('F');

        System.out.println(myList.toString());

        System.out.println(myList.extractGroupsOf(2));
    }
}
