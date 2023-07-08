/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package  assignment2_cpcs204;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
Name : Alanoud

* course : CPCS-204
* date :27 - Oct - 2022
 */
public class  assignment2_cpcs204 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        //creat command file and check if it is exsist or not 
        File commandFile = new File("input (1).txt");
        if(!commandFile.exists()){
            System.out.println("The file is not exists");
            System.exit(0);}
         //read from command file 
        Scanner read = new Scanner(commandFile); 
        //  print in new file 
        PrintWriter output = new PrintWriter("output.txt");
        //read the number of  commande from input file 
        int num = read.nextInt() ;
        //read the commands
        String command ;
        //for loop to pass over all commands
        for(int j =0 ; j < num ; j++){
        //read the command from file 
        command = read.next();
            if(command .equalsIgnoreCase("charPattern")){
                
        // --------- [ problem 1 ] -----------
        //read the character from input file 
        String s1 = read.next();
         char c = s1.charAt(0);
         //invok the methode 
        String b= printChar(c);
        //print the total pattern
        output.println(b);
        
        //-----------------------------------
         
            }
            else if(command.equalsIgnoreCase("drawDiamond")){
        // --------- [ problem 2 ] -----------
        //read the number from input file 
        int n =read.nextInt();
        // ------ print upper part ----------
        for(int i = 0 ; i < n/2+1 ; i++){
           //invoke the methodes
            printSpace(1 , n ,i,output);
            printPart1(1,i,output);
            printPart2(2 , i,output);
            //next line
            output.println();

        }  
        //---- print lower part ------- 
        for(int i = n/2+1 ; i>=1 ; i--){
          //invoke the methodes
            printSpace(1 , n ,i,output);
            printPart1(1,i,output);
            printPart2(2 , i,output);
            //next line
            output.println();
        }
        
        //------------------------------------
            }
            else if(command.equalsIgnoreCase("bricksToUnload")){
        // --------- [ problem 2 ] -----------
        //read the number of brick from input file
        int v = read.nextInt();
        // invok the bricksToUnload toalculate how many different ways the worker can throw the bricks
        //and store (save) the result in p3 variable
        int p3 = bricksToUnload(v);
        //print the result 
        output.println(p3);
        } }
        read.close();
        output.close();
        output.flush();
        } 
        
    
    ////////////////////////////////////////////////////////////////////////////
    //------------------------ [ problem 1 ] -----------------------------------
    ////////////////////////////////////////////////////////////////////////////
    public static String  printChar(char c ){
      //base case : 
        if(c=='A'){
           return "A";
       }
       else{
          //recersive:
           return printChar((char)(c-1)) + (char)(c) + printChar((char)(c-1));
           
       }
    }
  
    ////////////////////////////////////////////////////////////////////////////
    //------------------------ [ problem 2 ] ---------------------------------//
    ////////////////////////////////////////////////////////////////////////////
    
    // ----------------Upper Part -------------------
    //this method for print the spaeces befor each row
                                 // k=1 ; 
    public static void printSpace( int k, int n ,int i,PrintWriter output){
        //base case : 
     if(k <= n-i){
         output.print("  ");
         //recursive
         printSpace(k+1 , n, i , output);
     }
    }
    //this method print right part of tringle
                               // j == 1
    public static void printPart1(int j , int i ,PrintWriter output){
        //base case :
        if(j <= i){
            output.print("* ");
            printPart1(j+1 , i,output);
        }
    }
    
    //this method print left part of tringle
                               // j ==1
    public static void printPart2(int j , int i,PrintWriter output){
        //base case: 
       if(j<=i){
           output.print("* ");
           printPart2(j+1,i,output);
       } 
    }
    
    // ----------------Lower Part -------------------
    //this methode to print spaces befor each row
                                  // k=1 ; 
    public static void printSpace2( int k, int n ,int i,PrintWriter output){
        //base case : 
     if(k <= n-i){
         output.print("  ");
         //recursive
         printSpace(k+1 , n, i,output);
     }
    }
    
    //this method print right part of tringle
                                // j == 1
    public static void printPart12(int j , int i ,PrintWriter output){
        //base case :
        if(j <=i){
            output.print("* ");
            //recursive
            printPart1(j+1 , i, output);
        }
    }
    
    //this method print left part of tringle
                                 // j ==1
    public static void printPart22(int j , int i, PrintWriter output){
        //base case :
       if(j<=i){
           output.print("* ");
           //recursive 
           printPart2(j+1,i, output);
       } 
    }

    ////////////////////////////////////////////////////////////////////////////
    //------------------------ [ problem 3 ] ---------------------------------//
    ////////////////////////////////////////////////////////////////////////////
    
        public static int bricksToUnload(int n ){
          if(n==0 || n == 1) 
            return 1;
          else if(n == 2)
              return 2;
          else
          return bricksToUnload(n-1)+bricksToUnload(n-2) +bricksToUnload(n-3);
            
        }
       

}
 
    
    
        
