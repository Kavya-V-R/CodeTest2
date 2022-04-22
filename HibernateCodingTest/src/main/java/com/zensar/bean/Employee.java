package com.zensar.bean;

import java.util.List;

import javax.persistence.*;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int empId;

	@Column(name = "e_name")
	String name;

	@Column(name = "e_bsalary")
	double basicSalary;

	@OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	Address address;

	@Embedded
	List<Skill> skillList;

	@Embedded
	BankAccount account;

	public Employee(int empId, String name, double basicSalary, Address address, List<Skill> skillList,
			BankAccount account) {
		super();
		this.empId = empId;
		this.name = name;
		this.basicSalary = basicSalary;
		this.address = address;
		this.skillList = skillList;
		this.account = account;
	}

	public Employee(String name, double basicSalary, Address address, List<Skill> skillList, BankAccount account) {
		super();
		this.name = name;
		this.basicSalary = basicSalary;
		this.address = address;
		this.skillList = skillList;
		this.account = account;
	}

	public Employee() {
		super();
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Skill> getSkillList() {
		return skillList;
	}

	public void setSkillList(List<Skill> skillList) {
		this.skillList = skillList;
	}

	public BankAccount getAccount() {
		return account;
	}

	public void setAccount(BankAccount account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", basicSalary=" + basicSalary + ", address=" + address
				+ ", skillList=" + skillList + ", account=" + account + "]";
	}

}
