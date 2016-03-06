package com.packt.movie.model;

import java.io.File;
import java.util.Date;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;






public class MovieList {
//	public Date movieDate1;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	public Date movieDate;
	public Integer movieID;
	public String movieName;
	public String movieDuration;
	public Integer movieTimeID;
	private MultipartFile  movieImage;
	//private File movieImage;
	private String movieImageFileName;
	
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
	
	
	
	public Date getMovieDate() {
		return movieDate;
	}
	public void setMovieDate(Date movieDate) {
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
