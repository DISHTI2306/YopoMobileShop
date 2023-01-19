/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
/**
 *
 * @author Dishti Chitapain
 */
public class YopoMobileShop {
 public static int ArraySize;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //welcome message for the customer
        //Register the name of the customer
        String cusname="";
        cusname = JOptionPane.showInputDialog("Welcome to Yopo Mobile Shop!!!" + 
                "\n\nPlease type in customer name to register...");
        
        //to invoke method enterArray      
        enterArraySize(); 
        
        //to create array "phones"
        String phones[];//array declaration
        phones = new String[ArraySize];//array creation
        
        //to create array "stock"
        int stock[];//array declaration
        stock = new int[ArraySize];//array creation
        
        //to create array "cost"
        double cost[];//array declaration
        cost = new double[ArraySize];//array creation
        
        //to invoke method writeDetails
        writeDetails(phones, stock, cost);

        //to invoke method displayMobilePhones
        displayMobilePhones(phones, stock, cost);  
        
        //to invoke method countNumberOfCharacters
        countNumberOfCharacters(phones);
        
        //to invoke method countVowels
        countVowels(phones);
                
       //to invoke method buyMobilePhone
        buyMobilePhone(phones,  stock,  cost,  cusname);
       
       System.exit(0); 
    }

       //method enterArraySize to allow the user to enter the size of the array
       public static void enterArraySize(){
         String input1;
        input1 = JOptionPane.showInputDialog("Enter the array size");
        ArraySize= Integer.parseInt(input1);
       }
   
       //method writeDetails to allow the user to enter the details of the mobile phone
       public static void writeDetails(String phones[], int stock[], double cost[]) {   
         for(int i=0; i<ArraySize; i++){  
            //name of the mob stored in array "phone" 
            phones[i] = JOptionPane.showInputDialog("Enter the name of the mobile phone!");
            //quantity available stored in the array "stock"
            stock[i] = Integer.parseInt(JOptionPane.showInputDialog("Enter the quantity available in the stock!"));
            //price of the mob phone stored in the array "cost"
            cost[i] = Double.parseDouble(JOptionPane.showInputDialog("Enter the price of the mobile phone!"));
           }
       }
       //method displayMobilePhones to list the phones on sale at Yopo
       public static void displayMobilePhones(String phones[], int stock[], double cost[]) {
       String output="";
        JTextArea momo = new JTextArea();
        momo.setEditable(false);
        
        output = output + "Phone Id" + "\t" + "Mobile Phone" + "\t" + "Qty available" + "\t" + "Cost Rs" + "\n";
        for(int i=0; i<phones.length; i = i + 1){
            output = output + i + "\t" + phones[i] + "\t" + stock[i] + "\t" + cost[i]  + "\n";
           }
        momo.setText(output);
        JOptionPane.showMessageDialog(null, momo);
       }
       
       //method countNumberOfCharacters to count the number of characters in each mobile phone
       public static void countNumberOfCharacters(String phones[]) {
        String output1="";
        JTextArea popo = new JTextArea();
        popo.setEditable(false);
        int wordcount;
        
        output1 = output1 + "Mobile Phone: " + "\t" + "Number of characters: " + "\n";
        for(int i=0; i<phones.length; i = i + 1){
            wordcount=phones[i].length();
            output1 = output1 + phones[i]+ "\t" + wordcount + "\n";
           }
        popo.setText(output1);
        JOptionPane.showMessageDialog(null, popo);
       }
       
       //method countVowels to count the num of vowels for each mob phones
       public static void countVowels(String phones[]) {
        //we use two methods of the class String: length(), charAt()
       
        String display="";
        JTextArea dodo = new JTextArea();
        dodo.setEditable(false);
        display= display+"Mobile phones: " +  "\t" + "Number of vowels:" +"\n";
        for(int counter=0;counter<phones.length;counter++){
             int count=0 ;
        for(int i=0; i<phones[counter].length(); i = i+ 1) {
            char c = phones[counter].charAt(i);
            if(c =='a' || c =='e' || c =='i' || c =='o' || c =='u'){
               
               count = count + 1;
            }
        }
         display= display+ phones[counter]+"\t"+count+"\n";
        }
        dodo.setText(display);
        JOptionPane.showMessageDialog(null,dodo);
       }
       
      // method buyMobilePhone( )
      public static void buyMobilePhone(String phones[], int stock[], double cost[], String cusname) {
          JTextArea momo = new JTextArea();
          momo.setEditable(false);
         String input;
         int a;
         do{
         input = JOptionPane.showInputDialog("Choose your model\n\n\nPlease enter the mbile phone ID you wanna buy?");
         int selection=Integer.parseInt(input);
         String input1=JOptionPane.showInputDialog("Enter the quantity you want to buy?");
         int quan = Integer.parseInt(input1);
         stock[selection]=stock[selection]-quan;
         
         String output = "";
         output=output + "Phone Id: " + "\t" + "Mobile Phones: " + "\t" + "Quantity Available: " + "\n";
          for(int i=0; i<phones.length; i = i + 1){
            output = output + i + "\t" + phones[i] + "\t" + stock[i] + "\t" + cost[i]  + "\n";
           }
       
        momo.setText(output);
        JOptionPane.showMessageDialog(null, momo);
        
        JOptionPane.showMessageDialog(null,"Hi " + cusname + "\nYour shopping cart \nPayment : Rs"+ cost[selection]*quan);
         a = JOptionPane.showConfirmDialog(null, "Do you want to buy a mobile phone?", "select an option",
                JOptionPane.YES_NO_CANCEL_OPTION);
         }while(a==JOptionPane.YES_OPTION);
         JOptionPane.showMessageDialog(null, "Bye!!Have a nice day!");
      }
      
}
