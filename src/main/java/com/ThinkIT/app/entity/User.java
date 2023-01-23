package com.ThinkIT.app.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "user_info")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotBlank(message = "enter your name")
	private String fullName;
	private boolean agreeToTermes;
	private String country;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "account_id")
	private Account account;

	public User() {
		super();
	}

	public User(@NotBlank(message = "enter your name") String fullName, boolean agreeToTermes, String country, Account account) {
		super();
		this.fullName = fullName;
		this.agreeToTermes = agreeToTermes;
		this.country = country;
		this.account = account;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("{ fullName: ").append(this.fullName).append(",agreeToTerme").append(this.agreeToTermes).append(",coutry").append(this.country).append(" }");
		return sb.toString();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public boolean isAgreeToTermes() {
		return agreeToTermes;
	}
	public void setAgreeToTermes(boolean agreeToTermes) {
		this.agreeToTermes = agreeToTermes;
	}

	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}


}
