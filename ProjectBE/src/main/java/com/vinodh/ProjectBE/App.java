package com.vinodh.ProjectBE;

import java.util.List;

import model.dao.CustomerDAO;
import model.dao.ProductDAO;
import model.entity.Customer;
import model.entity.Product;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	Customer c1 = new Customer("Amit",22);
    	CustomerDAO cd = new CustomerDAO();
    	boolean b = cd.insertCustomer(c1);
    	if(b)
        {
     	   System.out.println("Successfully Inserted");
        }
        else
        {
     	   System.out.println("Not Working");
        }
     /*  Product p1 = new Product("Camera","10000");
       ProductDAO pd = new ProductDAO();
       boolean b = pd.insertProduct(p1);
       if(b)
       {
    	   System.out.println("Successfully Inserted");
       }
       else
       {
    	   System.out.println("Not Working");
       }*/
    	
    	/*ProductDAO pd = new ProductDAO();
    	List<Product> lp = pd.getProducts();
    	for(Product p: lp)
    	{
    		System.out.println(p.getpId()+" "+p.getpCost()+" "+p.getpName());
    	}*/

    }
}
