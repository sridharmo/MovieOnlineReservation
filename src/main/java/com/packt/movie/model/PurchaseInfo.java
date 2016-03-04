package com.packt.movie.model;

public class PurchaseInfo {
	
	private int PurchaseId;
	private int UserID;
	private int MovieID;
	private int NumberOfMovieTickets;
	private int TimeID;
	private int TransactionStatus;
	private int MailSend;
	
	
	
	public int getPurchaseId() {
		return PurchaseId;
	}
	public void setPurchaseId(int purchaseId) {
		PurchaseId = purchaseId;
	}
	public int getUserID() {
		return UserID;
	}
	public void setUserID(int userID) {
		UserID = userID;
	}
	public int getMovieID() {
		return MovieID;
	}
	public void setMovieID(int movieID) {
		MovieID = movieID;
	}
	public int getNumberOfMovieTickets() {
		return NumberOfMovieTickets;
	}
	public void setNumberOfMovieTickets(int numberOfMovieTickets) {
		NumberOfMovieTickets = numberOfMovieTickets;
	}
	public int getTimeID() {
		return TimeID;
	}
	public void setTimeID(int timeID) {
		TimeID = timeID;
	}
	public int getTransactionStatus() {
		return TransactionStatus;
	}
	public void setTransactionStatus(int transactionStatus) {
		TransactionStatus = transactionStatus;
	}
	public int getMailSend() {
		return MailSend;
	}
	public void setMailSend(int mailSend) {
		MailSend = mailSend;
	}
	
}
