public class newMycollectionEInIns<E> implements Iterable<E>{

    private Node head;

    public newMycollectionEInIns(){
        head = new Node();
        Node current = head;
    }

    private class Node {
        
        Node next; // property is the variable of the class
        Node prior;
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

        Node current = head;

        while(current.next!=null){
            // if haead has the data we want to remove
            // removing the first one: node(this one gets removed) - current - node
            if(current.data = element){
                current.next= current;
            }// removing the second one:  node -(deleting the link here)- node(removed) - node 
            else if(current.next.data == element){
                current.next = current.next.next;
            }
            // removing anhything else
            // node - node - node (removing this)- node- node
            else if(current.next.next.data == element){
                eleminate = current.next.next;
                current.next = eleminate.next;
            }
        }
        // if we want to remove the last node
        if(current.next.next==null && current.data == element){
            current.next = null;
        }
    }

    
}