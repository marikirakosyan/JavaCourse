
package insertingmethod;

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

        Node current = head;
        Node previous = null;

        while(current.next!=null){ 
            if(current.data == element ){
                if(prev != null){
                    previous.next = current.next;
                }else{
                    // if prev null
                    head = current.next;
                }
                break;
            }
            previous = current;
            current= current.next;

        }
        
       
    }


    private class myIterator implements Iterator<E>{ // itertor for next and has next


        // temporary variable that holds head to use to iteratte, we dont want to change head
        // we have to change temporrary variable

        // it starts on the first
        Node temp = head;

        // need to override has next and next

        // first - temp - head -> can be null therfore hasNext must check temp - and not temp.next


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