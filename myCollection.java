import java.util.*;

// the class has to implement the itertor class and for element E to iterate over. Element E is inside each 
// node so when  
public class myCollection<E> extends myIterator{
    // inner class is a class in the class that only is seen in current class, only known in this scope
    

    private Node head;


    public myCollection(int n) { 
        // we need to make list with n nodes with nodes with reference to null

        // when we put head in cuntructor as new we know that it will never be null
        head = new Node(); // head needs to be first
        
        Node current = head; // we start with this, local variable


        for(int i = 0; i<n; i++){ // we get 10 elements
            Node node = new Node();
            current.next = node;
            current = node;
        }

    }

    private class Node {
        // inner class is a class in the class that only is seen in current class, only known in this scope
        // has access to class which it is in
        // we make this class to referance linking

        // we link to the next node
        // node only knows about itself and what itself contains
        
        Node next; // property is the variable of the class
        E data; // property is the variable of the class

        
        // it uses default contructor
        
    }


    public boolean space(){

        Node current = head;

        while(current.next != null){
            if(current.data == null){ // if empty we count, then if has space - true, else false
                return true;
            }
            current = current.next;
    
        }

        return false;


    }

    public void insert(E newElement) {
        // The insert method should insert a new element into an available node, i.e., 
        // a node whose data reference is

        // Generic, data  field which will be generic type
        // find first node where data is null and change data to newElement
        // we now want to not allow instertion if no space

        Node current = head;

        if(this.space()){

            while(current.next != null){
                if(current.data == null){
                    current.data = newElement;
                    break; // we only want to insert once
                }
                current = current.next;
            }

        }else{
            System.out.println("There is no space ");

        }


    }

    public void remove(E ref) {
        // we want to remove a referance E
        // element is something that is in a node

        // starting with iterating over each node , checking the element if it matches ref

        Node current = head;

        while(current.next != null){
            if( current.data!=null && current.data.equals(ref)){ // we put != null first to avoid nullpointerexpetrion while checking current.data.equals(ref) 
                current.data = null;
            }

            current = current.next;
        }

    }

    // recursive, wants to count amount of elements that are not null
    public int count(){
        // we make the recursion with nodes, the nodes will be arguments for recursive method

        return recursiveCount(head);

    }

    private int recursiveCount(Node node){

        //wich node is being called

        System.out.println("recursive count is called for Node: " + node.data);

        // node is linked list, with nexts

        int counter = 0;

        if (node.data != null){
            counter = 1;
        }

        // base case is when current.next is null
        if(node.next == null){ // starts going down the stack if no next
            return counter;
        }

        return counter + recursiveCount(node.next);
    }

    public void printCount(){
        // print amount of nodes
        int counter = 0;
        Node current = head;
        
        while (current.next != null){
            counter++;
            current = current.next;
        }

        System.out.println(counter);
    }

    public void print(){
        // printing the data where element is not null

        Node current = head;

        while(current.next != null){
            if(current.data != null){
                System.out.print(current.data);
                System.out.print(" ");
            }
            current = current.next;
        }
        System.out.println();
    }

    private class myIterator<E> implements Iterator<E>{

        // need to override has next and next

        @Override
        public boolean hasNext() {

            if (head.next != null){ // should we use head here?
                return true;
            }
            return false;
        
        }

        @Override
        public E next() { // next returns the next element and moves forward
            if (hasNext()){
                E next = head.data;
                head = head.next; // shifting to the next object
                return next;
            }
            throw new NoSuchElementException();
        
        }



    }
}

   