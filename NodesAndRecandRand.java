
    // type <LETTER> - means its generic
    // compile time when when object made of type LETTER
    // interpretation , "compiles" step by step, java has compilation step, and interpreattion step
    // cross plattform


    // generics, generic code is written so it wont compile if given wrong type

import java.util.*;

public class NodesAndRecandRand {
    // type <LETTER> - means its generic
    // compile time when when object made of type LETTER

    /* 
    public static void main(String[]args){
        
        List<String> mylist = new ArrayList<>(); // compile time checks for generic type in <>


        //adding
        mylist.add("hello");
        // we need String - error : mylist.add(1); 

    } 
     */



     // RECURSION
    
     // function fibonacci, based on index, gives value

    public static int fibonacci(int n){

        System.out.println("Fibonacci is called for: " + n);

        // base case : n = 0 and n=1

        if(n == 0 || n == 1){
            return 1;
        }

        return fibonacci(n-1)+fibonacci(n-2);

        
    }

    // recursion factorial func

    public static int factCountFunc(int i){
        // should call the recursive method
        // 4! = 4 * 3 * 2 * 1
        System.out.println("OKAY, i will now find the factorial for number: "+ i);
        System.out.println("starting the recursion");
        return recursiveFactFunc(i); 
            
            
            }
            
    private static int recursiveFactFunc(int i){
        // 4! = 4 * 3 * 2 * 1
        // 4! = 4 * 3!
        // 3! = 3 * 2!
        // 2! = 2 * 1!
    
        if(i != 1){
            System.out.println("i am now finding the factorial for number:" + i+ "*"+(i-1));
            return i * recursiveFactFunc(i-1);
        }else{
            System.out.println("base case achieved at i =: " + i);
            return 1;
        }
          
    }
}
    
    
    
        // testing myCollection
        public static void main(String[]args){
            // QUESTION
            // we neeed to make one of the recursive methods static or make instance?
            // with instance
            // NodesAndRecandRand n  = new NodesAndRecandRand();
            // n.factCountFunc(4);

            // static
            factCountFunc(4);
    
    
            // fibonacci
            // System.out.println(fibonacci(4));
           
    
            // myC is of type myCollection and contains the type String data
    
            // myCollection<String> myC = new myCollection<>(10); //this takes and makes with n
    
            // myC.printCount();
    
            // myC.insert("a");
    
            // myC.insert("b");
    
            //myC.insert("c");
    
            // System.out.println(myC.count());  // recursive , we dont call head as argument because is inside the class
    
            // myC.remove("a");
    
            // myC.print();
    
            // myC.remove("b");
    
            
        /* 
            for (int i = 1; i<=10; i++){
                myC.insert("a");
            }
    
            myC.print();
    
        */
    
        // main to test iterator 
    
        // for (int i= 0; i<=9; i++){
        //     myC.insert("a");
        // }
    
        // new it myIterator = myIterator<E>;
    
        /* 
        while (myC.iterator().hasNext()){
            System.out.println(myC.iterator().next());
        }
        */
    
        // for(String element:myC){ // myCollection<String> myC -> String elemenets to iterate over
    
        //    System.out.println("i am iterating over " + element);
    
        //}
    
    
        //}
    



}

