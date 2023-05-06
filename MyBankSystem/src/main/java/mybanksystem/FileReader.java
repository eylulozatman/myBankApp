/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mybanksystem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class FileReader 
{
    
     String accountfile = "C:\\Users\\DELL\\Masaüstü\\mybanksystem\\accounts.txt";
      ArrayList<Customer> customers;
    ArrayList<Customer> loadCustomers() 
    {
       
         customers = new ArrayList();
         String line = null;
        try {
            java.io.FileReader fileReader = new java.io.FileReader(accountfile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null) {
                String[] properties = line.split(" ");
                int id = Integer.valueOf(properties[0]);
                String firstname = properties[1];
                String lastname = properties[2];
                String ssn = properties[3];
                int balance = Integer.valueOf(properties[4]);
                Customer customer = new Customer(id,firstname,lastname,ssn,balance);
                customer.setId(id);
                customer.setFname(firstname);
                customer.setLastname(lastname);
                customer.setSsn(ssn);
                customer.setBalance(balance);
                customers.add(customer);
            }
            bufferedReader.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println(customers.size());
  //      System.out.println(customers.get(0).getCustomerId() + " " +customers.get(1).getCustomerId());*/
        return customers;    
    }
    
    public void writeCustomertoFile(Customer c)
    {
         String id_ = String.valueOf(c.getId());
       try {
            FileWriter writer = new FileWriter(accountfile, true);
            writer.write(id_+" "+ c.getFname()+" "+c.getLastname()+" "+c.getSsn()+" "+c.getBalance()+ "\n");
            writer.close();
            System.out.println(id_+" "+ c.getFname());
        } catch (IOException e) {
            System.out.println("An error occurred while writing to file.");
            e.printStackTrace();
        }
 
    }
    

    void updateFile(ArrayList<Customer> customers) throws FileNotFoundException {
        
         try (PrintWriter writer = new PrintWriter(accountfile)) 
          {
             writer. print("");
           }
        try {
            FileWriter writer = new FileWriter(accountfile);
         
            for (Customer c : customers) {
                
                String id_ = String.valueOf(c.getId());
                writer.write(id_+" "+ c.getFname()+" "+c.getLastname()+" "+c.getSsn()+" "+c.getBalance()+ "\n");
            }
            writer.close();
            System.out.println("list Size " + customers.size());
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
  
}
