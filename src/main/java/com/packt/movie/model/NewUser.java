package com.packt.movie.model;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class NewUser {
	@NotEmpty(message="Please enter your email")
	@Email
	private String email;
	@Size(min=6, max=8,message="{NewUser.passWord.validation}")
	private String passWord;
	@Digits(integer =8, message="{Newuser.creditCardNumber.validation}", fraction = 0)
	private int creditCardNumber;
	
	private int expirationMonth;
	/*private int expirationYear;*/
	private String firstName;
	private String lastName;
/*	@Digits(integer =5, message="{Newuser.zipCode.validation}", fraction = 0)
	private int zipCode;*/
	
	private int saveCardInfo;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public int getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(int creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public int getExpirationMonth() {
		return expirationMonth;
	}

	public void setExpirationMonth(int expirationMonth) {
		this.expirationMonth = expirationMonth;
	}

	/*public int getExpirationYear() {
		return expirationYear;
	}

	public void setExpirationYear(int expirationYear) {
		this.expirationYear = expirationYear;
	}*/

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/*public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
*/
	public int getSaveCardInfo() {
		return saveCardInfo;
	}

	public void setSaveCardInfo(int saveCardInfo) {
		this.saveCardInfo = saveCardInfo;
	}
	
	
}
