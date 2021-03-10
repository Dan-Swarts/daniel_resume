public class BinaryTree<V extends Comparable<V>> {

    private BinaryNode root;

    public BinaryTree(BinaryNode root) {
        this.root = root;
    }

    public BinaryNode getRoot() {
        return this.root;
    }

    public void printInOrder() { printInOrderHelper(root); }

    private void printInOrderHelper(BinaryNode b) {

        if(b.getLeft() == null && b.getRight() == null){
            System.out.print(b.getValue() + " ");
            return;
        }

        if(b.getLeft() == null){
            System.out.print(b.getValue() + " ");
            printInOrderHelper(b.getRight());
            return;
        }

        if(b.getRight() == null){
            printInOrderHelper(b.getLeft());
            System.out.print(b.getValue() + " ");
            return;
        }

        printInOrderHelper(b.getLeft());
        System.out.print(b.getValue() + " ");
        printInOrderHelper(b.getRight());
    }

    public void printPreorder(){ printPreorderHelper(root); }

    private void printPreorderHelper(BinaryNode node) {

            if(node.getLeft() == null && node.getRight() == null){
                System.out.print(node.getValue() + " ");
                return;
            }

            if(node.getLeft() == null){
                System.out.print(node.getValue() + " ");
                printPreorderHelper(node.getRight());
                return;
            }

            if(node.getRight() == null){
                System.out.print(node.getValue() + " ");
                printPreorderHelper(node.getLeft());
                return;
            }

            System.out.print(node.getValue() + " ");
            printPreorderHelper(node.getLeft());
            printPreorderHelper(node.getRight());
    }

    public void printPostorder() { printPostorderHelper(root); }

    private void printPostorderHelper(BinaryNode node) {

            if(node.getLeft() == null && node.getRight() == null){
                System.out.print(node.getValue() + " ");
                return;
            }

            if(node.getLeft() == null){
                printPostorderHelper(node.getRight());
                System.out.print(node.getValue() + " ");
                return;
            }

            if(node.getRight() == null){
                printPostorderHelper(node.getLeft());
                System.out.print(node.getValue() + " ");
                return;
            }

            printPostorderHelper(node.getLeft());
            printPostorderHelper(node.getRight());
            System.out.print(node.getValue() + " ");
    }

//    public V[] flatten() {
//        NodeArrayList<V> array = new NodeArrayList<V>();
//        flattenHelper(root,array);
//        array.sort();
//        return array.toArray();
//    }
//
//    private void flattenHelper(Node<V> node, NodeArrayList<V> array){
//
//        if(node.getLeft() == null && node.getRight() == null){
//            array.add(node.getValue());
//            return;
//        }
//
//        if(node.getLeft() == null){
//            flattenHelper(node.getRight(),array);
//            array.add(node.getValue());
//            return;
//        }
//
//        if(node.getRight() == null){
//            flattenHelper(node.getLeft(),array);
//            array.add(node.getValue());
//            return;
//        }
//
//        flattenHelper(node.getLeft(),array);
//        flattenHelper(node.getRight(),array);
//        array.add(node.getValue());
//    }
//
//    public boolean containsSubtree(BinaryTree<V> other) {
//        if(other == null){
//            return true;
//        }
//
//        Node<V> rootMax = containsSubtreeHelper(root,other.getRoot().getValue());
//        if(check(other.getRoot(),rootMax)){
//            return true;
//        }
//        return false;
//    }
//
//    private Node<V> containsSubtreeHelper(Node<V> node,V value){
//        if(node.getValue().compareTo(value) == 0)
//            return node;
//
//        if(node.getRight() != null){
//            Node<V> checkRight = containsSubtreeHelper(node.getRight(),value);
//            if(checkRight != null)
//                return checkRight;
//        }
//
//        if(node.getLeft() != null){
//            Node<V> checkLeft = containsSubtreeHelper(node.getLeft(),value);
//            if(checkLeft != null)
//                return checkLeft;
//        }
//
//        return null;
//    }
//
//    public static boolean check(Node p1, Node p2){
//        if(p1 == null && p2 == null)
//            return true;
//        if(p1 != null && p2 != null){
//
//            if(p1.getValue().compareTo(p2.getValue()) == 0)
//                if(check(p1.getLeft(),p2.getLeft()) && check(p1.getRight(),p2.getRight()))
//                    return true;
//            }
//        return false;
//        }
//
//    public static void main (String args[]) {
//
//        // Tree given for testing on
//        BinaryTree<Integer> p1Tree = new BinaryTree<Integer>(new Node<Integer>(1,
//                new Node<Integer>(2,
//                        new Node<Integer>(4, null, null),
//                        new Node<Integer>(5, null, null)),
//                new Node<Integer>(3, null, null)));
//
//        // Milestone 1
//        p1Tree.printInOrder();      // expected output: 4 2 5 1 3
//        System.out.println();
//        p1Tree.printPreorder();     // expected output: 1 2 4 5 3
//        System.out.println();
//        p1Tree.printPostorder();    // expected output: 4 5 2 3 1
//        System.out.println();
//
//        // Milestone 2 -- expected output: 1 2 3 4 5
//
//        Comparable[] array_representation = p1Tree.flatten();
//        for (int i = 0; i < array_representation.length; i++) {
//            System.out.print(array_representation[i] + " ");
//        }
//        System.out.println();
//
//        // Milestone 3
//
//        BinaryTree<Integer> p2Tree = new BinaryTree<Integer>(new Node<Integer>(2,
//                new Node<Integer>(4, null, null),
//                new Node<Integer>(5, null, null)));
//        BinaryTree<Integer> p3Tree = new BinaryTree<Integer>(new Node<Integer>(1,
//                new Node<Integer>(2, null, null),
//                new Node<Integer>(3, null, null)));
//        BinaryTree<Integer> p4Tree = null;
//
//        System.out.println(p1Tree.containsSubtree(p2Tree)); // expected output: true
//        System.out.println(p1Tree.containsSubtree(p3Tree)); // expected output: false
//        System.out.println(p1Tree.containsSubtree(p4Tree)); // expected output: true
//
//    }
}

