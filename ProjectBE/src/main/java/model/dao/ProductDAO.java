package model.dao;


import org.hibernate.Session;
import org.hibernate.Transaction;

import config.DbConfig;
import model.entity.Product;

public class ProductDAO {
	
	private DbConfig db;
	private Session sess;
	private Transaction ts;
	public ProductDAO()
	{
		db = new DbConfig();
		sess = db.getSess();
	}
	
		public boolean insertProduct(Product p)
		{
			boolean b = true;
			try
			{
				ts = sess.beginTransaction();
				sess.save(p);
				ts.commit();
			}catch(Exception ex)
			{
				ts.rollback();
				b=false;
				ex.printStackTrace();
			}
			return b;
		}
}
