public class BinaryNode {

    // variables:
    private BinaryNode left;
    private BinaryNode right;
    private int data;

    // constructors:
    public BinaryNode(int data, BinaryNode right, BinaryNode left){
        this.data = data;
        this.right = right;
        this.left = left;
    }
    public BinaryNode(int data){
        this.data = data;
    }

    // getters:
    public int getValue(){
        return data;
    }

    public BinaryNode getRight(){
        return right;
    }

    public BinaryNode getLeft(){
        return left;
    }

    // setters:
    public void setLeft(BinaryNode left){
        this.left = left;
    }
    public void setRight(BinaryNode right){
        this.right = right;
    }
    public void setData(int data){
        this.data = data;
    }
}
