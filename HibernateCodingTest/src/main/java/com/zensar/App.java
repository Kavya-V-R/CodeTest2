package com.zensar;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.zensar.bean.Address;
import com.zensar.bean.BankAccount;
import com.zensar.bean.Employee;
import com.zensar.bean.Skill;

public class App {

	public static void loadTesting() {
		// write code here to load emp object

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
		EntityManager em = emf.createEntityManager();

		Employee employee = null;
		employee = em.find(Employee.class, 4); // session.load
		System.out.println(employee);

		em.close();
		emf.close();
	}

	public static void insideTesting() {
		// write code here to persist employee object

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		BankAccount bankAccount = new BankAccount(1, "SBIN090654");

		Skill skill = new Skill("java", 7);
		List<Skill> arrayList = new ArrayList<>();
		arrayList.add(skill);
		
		Address address = new Address(1,"banglore", "560064", null);


		Employee employee = new Employee("kavya", 33300.00, address, arrayList, bankAccount);

        employee.setAddress(address);
        //address.setEmployee(employee);
		
		em.persist(employee);
		em.getTransaction().commit();
		em.close();
		emf.close();
		System.out.println("data saved");
	}

	public static void main(String[] args) {
		insideTesting();

		//loadTesting();
	}
}
