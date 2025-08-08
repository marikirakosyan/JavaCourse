package exam_2025;
import java.util.*;

// the class has to implement the itertor class and for element E to iterate over. Element E is inside each 
// node so when  
public class myCollection<E> implements Iterable<E>{ // iterable lets you write the iterator method
    // inner class is a class in the class that only is seen in current class, only known in this scope
    

    private Node first;


    public myCollection(int n) { 


        // we need to make list with n nodes with nodes with reference to null

        // when we put first in cuntructor as new we know that it will never be null
        first = new Node(); // first needs to be first
        
        Node current = first; // we start with this, local variable

        // testing
        //System.out.println("first is: " + first);


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

        Node current = first;

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

        Node current = first;

        if(current != null){ // checking if the node exicts
            if(this.space()){
                while(current.next != null){
                    if(current.data == null){ // if there is data inside the current node
                        current.data = newElement; 
                        break; // we only want to insert once
                    }
                    current = current.next;
                }
                // System.out.println("done!");
    
            }else{
                System.out.println("There is no space ");
    
            }
        }


    }

    //
    public insertOnIndex(E ref, int n){
        Node current = first;
        int counter= 0;

        for(E :myCollection){
            
        }

    }

    public void remove(E ref) {
        // we want to remove a referance E
        // element is something that is in a node

        // starting with iterating over each node , checking the element if it matches ref

        Node current = first;

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

        return recursiveCount(first);

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
        Node current = first;
        
        while (current.next != null){
            counter++;
            current = current.next;
        }

        System.out.println(counter);
    }

    public void print(){
        // printing the data where element is not null

        Node current = first;

        while(current.next != null){
            if(current.data != null){
                System.out.print(current.data);
                System.out.print(" ");
            }
            current = current.next;
        }
        System.out.println();
    }

   
    // first step

    private class myIterator implements Iterator<E>{ // itertor for next and has next


        // temporary variable that holds first to use to iteratte, we dont want to change first
        // we have to change temporrary variable

        // it starts on the first
        Node temp = first;

        // need to override has next and next

        // first - temp - first -> can be null therfore hasNext must check temp - and not temp.next


        // override second

        @Override
        public boolean hasNext() {

            // checks the one we are at not the next one
            // it needs to be something for it to have possibility to have a next one?
            System.out.println("this is temp right now has value " + temp!=null);
            
            return temp!=null; // true if not null
    
        
        }

        @Override
        public E next() { // next returns the current element and makes temp -> temp.next (moves arrow to next node)
            // the iterator iterartes over whatever is insdie <> - the elements
            if (hasNext()){ 
                E thisData = temp.data;
                temp = temp.next; // shifting to the next object
                System.out.println("this elements data is: " + thisData);
                System.out.println("next node is: " + temp);
                return thisData;
            }
            throw new NoSuchElementException();
        
        }



    }


    @Override
    public Iterator<E> iterator() {
        return new myIterator();
    }
}

   