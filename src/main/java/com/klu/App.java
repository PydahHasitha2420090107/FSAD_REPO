package com.klu;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {
 public static void main(String[] args) {

  // INSERT
  Session session = HibernateUtil.getSessionFactory().openSession();
  Transaction tx = session.beginTransaction();

  Product p1 = new Product(1, "Laptop", "HP Laptop", 55000, 10);
  Product p2 = new Product(2, "Mouse", "Wireless Mouse", 500, 50);

  session.save(p1);
  session.save(p2);

  tx.commit();
  session.close();
  System.out.println("Products Inserted");

  // READ
  session = HibernateUtil.getSessionFactory().openSession();
  Product p = session.get(Product.class, 1);
  System.out.println(p.getName() + " " + p.getPrice());
  session.close();

  // UPDATE
  session = HibernateUtil.getSessionFactory().openSession();
  tx = session.beginTransaction();
  p.setPrice(52000);
  session.update(p);
  tx.commit();
  session.close();
  System.out.println("Product Updated");

  // DELETE
  /*session = HibernateUtil.getSessionFactory().openSession();
  tx = session.beginTransaction();
  session.delete(p);
  tx.commit();
  session.close();
  System.out.println("Product Deleted");*/
 }
}
