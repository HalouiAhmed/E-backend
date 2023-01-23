package com.ThinkIT.app.dto;

/**
 *
 * @author AHMED HALOUI
 *
 */
public class JwtDTO {

	private static final long serialVersionUID = 1L;
	private String jwt;
	private String fullName;

	public JwtDTO() {
		super();
	}

	@Override
	public String toString() {
		StringBuilder audit = new StringBuilder("{jwt : ");
		return audit.append(this.jwt).append(" }").toString();
	}

	public String getJwt() {
		return this.jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

}
