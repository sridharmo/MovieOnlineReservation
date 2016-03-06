package com.packt.movie.model;

import java.io.File;
import java.util.Date;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;






public class MovieList {
//	public Date movieDate1;
	public String movieDate;
	public Integer movieID;
	public String movieName;
	public String movieDuration;
	public Integer movieTimeID;
	private MultipartFile  movieImage;
	//private File movieImage;
	private String movieImageFileName;
	
	private String show1;
	private String show2;
	private String show3;
	
	
	public String getShow1() {
		return show1;
	}
	public void setShow1(String show1) {
		this.show1 = show1;
	}
	public String getShow2() {
		return show2;
	}
	public void setShow2(String show2) {
		this.show2 = show2;
	}
	public String getShow3() {
		return show3;
	}
	public void setShow3(String show3) {
		this.show3 = show3;
	}
	private Set timeInfo;
	
	
	public Set getTimeInfo() {
		return timeInfo;
	}
	public void setTimeInfo(Set timeInfo) {
		this.timeInfo = timeInfo;
	}
	public String getMovieImageFileName() {
		return movieImageFileName;
	}
	public void setMovieImageFileName(String movieImageFileName) {
		this.movieImageFileName = movieImageFileName;
	}
	
	public MultipartFile getMovieImage() {
		return movieImage;
	}
	public void setMovieImage(MultipartFile movieImage) {
		this.movieImage = movieImage;
	}
	
	public String getMovieDate() {
		return movieDate;
	}
	public void setMovieDate(String movieDate) {
		this.movieDate = movieDate;
	}
	public Integer getMovieID() {
		return movieID;
	}
	public void setMovieID(Integer movieID) {
		this.movieID = movieID;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMovieDuration() {
		return movieDuration;
	}
	public void setMovieDuration(String movieDuration) {
		this.movieDuration = movieDuration;
	}
	public Integer getMovieTimeID() {
		return movieTimeID;
	}
	public void setMovieTimeID(Integer movieTimeID) {
		this.movieTimeID = movieTimeID;
	}
	
}
