package com.packt.movie.model;

public class PurchaseInfo {
	
	private Integer PurchaseId;
	private Integer UserID;
	private Integer MovieID;
	private Integer NumberOfMovieTickets;
	private Integer TimeID;
	private Integer TransactionStatus;
	private Integer MailSend;
	
	
	public int getPurchaseId() {
		return PurchaseId;
	}
	public void setPurchaseId(Integer purchaseId) {
		PurchaseId = purchaseId;
	}
	public int getUserID() {
		return UserID;
	}
	public void setUserID(Integer userID) {
		UserID = userID;
	}
	public int getMovieID() {
		return MovieID;
	}
	public void setMovieID(Integer movieID) {
		MovieID = movieID;
	}
	public int getNumberOfMovieTickets() {
		return NumberOfMovieTickets;
	}
	public void setNumberOfMovieTickets(Integer numberOfMovieTickets) {
		NumberOfMovieTickets = numberOfMovieTickets;
	}
	public int getTimeID() {
		return TimeID;
	}
	public void setTimeID(Integer timeID) {
		TimeID = timeID;
	}
	public int getTransactionStatus() {
		return TransactionStatus;
	}
	public void setTransactionStatus(Integer transactionStatus) {
		TransactionStatus = transactionStatus;
	}
	public int getMailSend() {
		return MailSend;
	}
	public void setMailSend(Integer mailSend) {
		MailSend = mailSend;
	}
	
}
