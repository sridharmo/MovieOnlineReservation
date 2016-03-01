package com.packt.movie.service;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import com.mysql.jdbc.Connection;
import com.packt.movie.model.MovieList;



//@Repository
public class MovieImplService extends SimpleJdbcDaoSupport {
	/*@Autowired
	@Qualifier("dataSource")
	DataSource dataSource;
	
	JdbcTemplate jdbcTemplate;
	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
		 //jdbcTemplate = new JdbcTemplate(dataSource);
	}*/
	private Connection connection =null;
	public MovieImplService(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:5050/athena", "root","root");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public List<MovieList>  getMovieList(String string) throws SQLException{
		List<MovieList> movieList = new ArrayList<MovieList>();	
		Date date = null;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		try {

			date = formatter.parse(string);
			System.out.println(date);
			

		} catch (ParseException e) {
			e.printStackTrace();
		}
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());       //Jan
		String SQL = "Select * from MOVIE_LIST where movieDate='2016-02-20'";
		//String SQL = "Select * from MOVIE_LIST where movieDate=?";

		
	
			PreparedStatement prepareStmt = connection.prepareStatement(SQL);
			//prepareStmt.setDate(1, sqlDate);
			ResultSet resultSet = prepareStmt.executeQuery();
			
			while(resultSet.next()){
				MovieList movie =new MovieList();
				System.out.println(resultSet.getDate("movieDate"));
				movie.setMovieDate((resultSet.getDate("movieDate")).toString());
				System.out.println(resultSet.getString("MovieName"));
				movie.setMovieName(resultSet.getString("movieName"));
				System.out.println(resultSet.getString("MovieTimeID"));
				movie.setMovieTimeID(resultSet.getInt("MovieTimeID"));
				movieList.add(movie);
			}
		
		return movieList;
		
	}

}
