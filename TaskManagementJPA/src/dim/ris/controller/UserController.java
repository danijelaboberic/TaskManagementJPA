package dim.ris.controller;

import javax.persistence.EntityManager;

import dim.ris.model.Role;
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
		
		public static Role getRole(int idRole){
			EntityManager em = JPAUtil.getEntityManager();
			try {		
	            return em.find(Role.class, idRole);
			}catch (Exception e) {
				return null;
			}
		    
		}
		public static User getLastUser() {
			String query = "select u from User u where u.idUser = (select max(u1.idUser) from User u1)";
			EntityManager em = JPAUtil.getEntityManager();
			User u = (User)em.createQuery(query).getSingleResult();
			return u;
		}


	public static void main(String[] args) {
		//za testiranje
		User u = new User();
		u.setName("Maja");
		boolean ok = register(u);
		System.out.println(ok ? "uspesno registrovan korisnik": "doslo je do greske");
		

	}

}
