package KCPD;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.*;
public class Login_hiber {
	static Scanner sc= new Scanner(System.in);
	static String pas;
	static long h;
	public static boolean  mob(long num)
	{
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("project2");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		Query q=em.createQuery("select s.phnno from DTO_hiber s");
		List<Long>l=q.getResultList();
		
		for (Long long1 : l) 
		{
			if (num==long1) 
			{
				System.out.println("you have enter valid number");
				h=num;
				return true;
				
			}
			else
			{
				System.out.println("Please enter valid mobile number");
				mob(num);
				
			}
		}
		et.commit();
		return false;
	}
	public static boolean pass(String pay)
	{
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("project2");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		Query q=em.createQuery("select s.password from DTO_hiber s");
		List<String>l=q.getResultList();
		for (String l3 : l) {
			if (pay.equals(l3)) {
				System.out.println("you have entered valid password");
				return true;
				
			}
			else
			{
				System.out.println("password invalid");
				System.out.println("press 0 for forget password");
				System.out.println("press 1 for re enter the password");
				int v=sc.nextInt();
				if (v==0) 
				{
					System.out.println("your otp is 55667");
					System.out.println("plese enter your otp here");
					int k=sc.nextInt();
					if (k==55667) 
					{
						System.out.println("enter your new password");
						forget(sc.next());
					}
					
				}
				else
				{
					pass(pay);
				}
				
			}
		}
		et.commit();
		return false;
	}

//	
	public static void forget(String w)
	{
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("project2");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
	et.begin();
	Query qq= em.createQuery("update e DTO_hiber set e.password=? where e.phnno="+h+" ");
	DTO_hiber q111=new DTO_hiber();
	System.err.println("enter your password here");
	
	q111.setPassword(w);
	qq.executeUpdate();
	et.commit();
	
		
	
		
		
		}

	}


