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

        Node current = head;


        Node newNode = new Node();
        

        // should start iterating from the head and find the last node and set this as last nodes next


        while(current.next!= null){

            if (current.next == null){
                current.next = newNode;
                newNode.data = newElement;
                newNode.next = null
                return;
                
            }else{
                current = current.next;
            }
            
        }
        
        return;
        

    }
   


    // remove method
    public void remove(E element){
        // checking first
        if(element == head.data){
            if(head.next != null){
                head = head.next;
            }else{
                head = null;
            }
            return; 
        }

        // after the first node
        while(current.data!=element){ 
            previous = current;
            current= current.next;
        }
        if(current != null){
            previous.next = current.next;
        }else{
            previous.next = null;
        }
        
       
    }

    
}