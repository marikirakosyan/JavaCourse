
    // type <LETTER> - means its generic
    // compile time when when object made of type LETTER
    // interpretation , "compiles" step by step, java has compilation step, and interpreattion step
    // cross plattform


    // generics, generic code is written so it wont compile if given wrong type

import java.util.*;

public class task1 {
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



    // testing myCollection
    public static void main(String[]args){


        // fibonacci
        // System.out.println(fibonacci(4));
       

        // myC is of type myCollection and contains the type String data

        myCollection<String> myC = new myCollection<>(10); //this takes and makes with n

        // myC.printCount();

       

        myC.insert("a");

        myC.insert("b");

        myC.insert("c");

        System.out.println(myC.count());  // recursive , we dont call head as argument because is inside the class

        // myC.remove("a");

        // myC.print();

        // myC.remove("b");

        
    /* 
        for (int i = 1; i<=20; i++){
            myC.insert("a");
        }

        myC.print();

    */



    }

     
}

