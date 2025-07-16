public class newMycollectionEInIns<E> implements Iterable<E>{

    private Node head;

    public newMycollectionEInIns(){
        head = new Node();
        Node current = head;
    }

    private class Node {
        
        Node next; // property is the variable of the class
        E data; // property is the variable of the class
        
    }

    public boolean space(){

        Node current = head;

        while(current.next != null){
            if(current.data == null){ 
                return true;
            }
            current = current.next;
        }

        return false;
    }


    // create element only in insert method
    public void insert(E newElement) {
        Node node = new Node();
        
        node.data = newElement;

    }

    
}