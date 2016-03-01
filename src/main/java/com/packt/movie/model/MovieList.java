package com.packt.movie.model;

import java.io.File;
import java.util.Date;

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
	/*public Date getMovieDate1() {
		return movieDate1;
	}
	public void setMovieDate1(Date movieDate1) {
		this.movieDate1 = movieDate1;
	}*/
	public void setMovieDate(String movieDate) {
		this.movieDate = movieDate;
	}
	public String getMovieDate() {
		return movieDate;
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
