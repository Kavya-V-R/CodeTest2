package com.zensar.bean;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class BankAccount {

	@Column(name = "bank_id")
	int bankId;

	@Column(name = "e_aId")
	String accountId;

	public BankAccount(String accountId) {
		super();
		this.accountId = accountId;
	}

	public BankAccount(int bankId, String accountId) {
		super();
		this.bankId = bankId;
		this.accountId = accountId;
	}

	public BankAccount() {
		super();
	}

	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	@Override
	public String toString() {
		return "BankAccount [bankId=" + bankId + ", accountId=" + accountId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountId, bankId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankAccount other = (BankAccount) obj;
		return Objects.equals(accountId, other.accountId) && bankId == other.bankId;
	}

}
