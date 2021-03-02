public class MyArrayList<T extends Comparable<T>> implements MyList<T> {

    private Comparable<T>[] data;
    private int nextEmpty;

    public MyArrayList(int size){
        data = new Comparable[size];
    }

    public boolean add(T element) {

        if(isFull()){
            return false;
        }

        else{
            data[nextEmpty] = element;
            nextEmpty++;
            return true;
        }
    }

    public boolean isFull(){
        if(nextEmpty == size()){
            return true;
        }
        else{
            return false;
        }
    }

    public int length(){
        return nextEmpty;
    }

    @Override
    public boolean add(int index, T element) {

        if(isFull()){return false;}

        Comparable[] temp = new Comparable[size() - index];
        int nextEmpty = 0;
        for(int i = index; i < size(); i++){
            temp[nextEmpty] = data[i];
            nextEmpty++;
        }

        nextEmpty = 0;
        data[index] = element;
        for(int i = index + 1; i < size(); i++){
            data[i] = temp[nextEmpty];
            nextEmpty++;
        }
        this.nextEmpty++;
        return true;
    }

    @Override
    public void clear() {
        data = new Comparable[size()];
    }

    @Override
    public T get(int index) {
        return (T) data[index];
    }

    @Override
    public int indexOf(T element) {
        for(int i = 0; i < size(); i++){
            if(element.compareTo((T) data[i]) == 0){
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return data.length;
    }

    public void swap(int index1, int index2){
        Comparable temp;
        temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
        return;
    }

    @Override
    public void sort() {
        quickSort(0,length());
    }

    private void quickSort(int start, int end){
        if(start < end){
            int pIndex = partition(start,end);
            quickSort(start,pIndex - 1);
            quickSort(pIndex + 1, end);
        }
    }

    private int partition(int start, int end){
        T pivot = (T) data[end];
        int pIndex = start;
        for(int i = start; i < end; i++){
            if(data[i].compareTo(pivot) <= 0){
                swap(i,pIndex);
                if(i == end){}
                else{
                pIndex++;
                }
            }
        }
        return pIndex;
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public void greaterThan(T element) {

    }

    @Override
    public void lessThan(T element) {

    }

    @Override
    public void equalTo(T element) {

    }

    public String toString(){
        String output = "";
        for(int i = 0; i < size(); i++){
            if(data[i] == null){}
            else{output += data[i].toString() + "\n";}
        }
    return output;
    }
}