package com.packt.movie.service;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import com.mysql.jdbc.Connection;
import com.packt.movie.model.MovieList;

//@Repository
public class MovieImplService extends SimpleJdbcDaoSupport {
	/*
	 * @Autowired
	 * 
	 * @Qualifier("dataSource") DataSource dataSource;
	 * 
	 * JdbcTemplate jdbcTemplate;
	 * 
	 * @PostConstruct private void initialize() { setDataSource(dataSource);
	 * //jdbcTemplate = new JdbcTemplate(dataSource); }
	 */
	static SessionFactory sessionFactory;
	static Session session = null;
	Transaction transaction = null;

	public MovieImplService() {
		try {
			sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		} catch (HibernateException e) {
			e.printStackTrace();
		}

	}

	public List<MovieList> getMovieList(Date date) throws SQLException {
		List<MovieList> movieList = new ArrayList<MovieList>();

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");

		System.out.println(date);
		Date sqlDate = new Date(date.getTime()); // Jan
		
		System.out.println("sqlDate=" + sqlDate);
		
		String hql = "FROM MovieList M WHERE M.movieDate ='" + sqlDate + "'";
		session = sessionFactory.openSession();
		List results = (List) session.createQuery(hql).list();
		// if(results.size()>0)
		Iterator<MovieList> iterator = results.iterator();
		while (iterator.hasNext()) {
			MovieList movieIterator = (MovieList) iterator.next();
			MovieList movie = new MovieList();
			System.out.println(movieIterator.getMovieDate());
			movie.setMovieDate(movieIterator.getMovieDate());
			System.out.println(movieIterator.getMovieName());
			movie.setMovieName(movieIterator.getMovieName());
			System.out.println(movieIterator.getMovieTimeID());
			movie.setMovieTimeID(movieIterator.getMovieTimeID());
			movie.setTimeInfo(movieIterator.getTimeInfo());
			movie.setMovieDuration(movieIterator.getMovieDuration());
			movieList.add(movie);
		}

		return movieList;

	}

}
