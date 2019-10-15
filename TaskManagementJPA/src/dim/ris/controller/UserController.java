package dim.ris.controller;

import javax.persistence.EntityManager;

import dim.ris.model.User;

public class UserController {
		
		public static boolean register(User u){
			EntityManager em = JPAUtil.getEntityManager();
			try {		
				em.getTransaction().begin();
				em.persist(u);
				em.getTransaction().commit();
				return true;
			}catch (Exception e) {
				em.getTransaction().rollback();
				return false;
			}
		
		    
		}


	public static void main(String[] args) {
		User u = new User();
		u.setName("Maja");
		boolean ok = register(u);
		System.out.println(ok ? "uspesno registrovan korisnik": "doslo je do greske");
		

	}

}
