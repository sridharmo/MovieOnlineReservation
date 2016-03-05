package com.packt.movie.model;

public class Seats {
	public Integer SeatID;
	public Integer TotalSeats;
	public Integer MovieID;
	public Integer getSeatID() {
		return SeatID;
	}
	public void setSeatID(Integer seatID) {
		SeatID = seatID;
	}
	public int getTotalSeats() {
		return TotalSeats;
	}
	public void setTotalSeats(Integer totalSeats) {
		TotalSeats = totalSeats;
	}
	public int getMovieID() {
		return MovieID;
	}
	public void setMovieID(Integer movieID) {
		MovieID = movieID;
	}
	
}
