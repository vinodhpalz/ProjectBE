package com.vinodh.ProjectBE;

import model.dao.ProductDAO;
import model.entity.Product;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       Product p1 = new Product(100,"Apple","60000");
       ProductDAO pd = new ProductDAO();
       boolean b = pd.insertProduct(p1);
       if(b)
       {
    	   System.out.println("Successfully inserted");
       }
       else
       {
    	   System.out.println("Not Working");
       }
    }
}
