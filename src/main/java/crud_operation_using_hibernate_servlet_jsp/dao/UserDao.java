package crud_operation_using_hibernate_servlet_jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import crud_operation_using_hibernate_servlet_jsp.dto.User;

public class UserDao {
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("anmol").createEntityManager();
	}

	public void addUser(User user) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
	}

	
	public List<User> displyAllUser() {

		EntityManager entityManager = getEntityManager();

		Query query = entityManager.createQuery("SELECT s FROM User s");

		
		List<User> list = query.getResultList();
		return list;
	}

	public User findByID(int id) {

		EntityManager entityManager = getEntityManager();

		return entityManager.find(User.class, id);

	}

	public void updateUser(User user, int id) {
		
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		user.setId(id);
		entityTransaction.begin();
		entityManager.merge(user);
		entityTransaction.commit();
	}
	
	public void deleteUser(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		User user= entityManager.find(User.class, id);
		entityTransaction.begin();
		entityManager.remove(user);
		entityTransaction.commit();
	}

}
