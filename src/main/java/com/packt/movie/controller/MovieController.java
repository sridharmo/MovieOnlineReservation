package com.packt.movie.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.packt.movie.exception.NoMovieFoundException;
import com.packt.movie.model.MovieList;
import com.packt.movie.model.NewUser;
import com.packt.movie.service.MovieImplService;
import com.packt.movie.service.NewUserImplService;

@ContextConfiguration(locations = { "classpath:applicationContext.xml" })

// comment1

@Controller
public class MovieController {
	

	@Autowired
	ServletContext servletContext;
	@Autowired
	ApplicationContext context;
	MovieImplService movieImplService = null;
	DataSource dataSource;
	private MultipartFile movieImage;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	// add movies to the Database only Admin can add.
	@RequestMapping(value = "/addMovie", method = RequestMethod.POST)
	public String addMovies(@ModelAttribute("addMovie") MovieList movie) {

		return null;

	}

	/// MovieTime/movie
	@RequestMapping(value = "/movie", method = RequestMethod.GET)
	public String hello(Model model) {
		System.out.println("MovieList");
		MovieList movieList1 = new MovieList();
		model.addAttribute("movieList", movieList1);
		return "hellopage";
	}

	@RequestMapping(value = "/movie", method = RequestMethod.POST)
	public String helloWorld(@ModelAttribute("movieList") MovieList movieList, ModelMap map) {
		System.out.println("MovieList movieDate=" + movieList.getMovieDate());
		List<MovieList> listMovies = new ArrayList<MovieList>();
		/*
		 * movieList1.setMovieDate("Feb10th"); movieList1.setMovieName(
		 * "Admiral Yi San"); movieList1.setMovieDuration("11:00PM");
		 */

		MovieImplService movieImplService = new MovieImplService();
		try {
			listMovies = movieImplService.getMovieList(movieList.getMovieDate());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<MovieList> finalListMovies = new ArrayList<MovieList>();
		if (listMovies == null || listMovies.isEmpty())
			throw new NoMovieFoundException("No Movie found with this date =" + movieList.getMovieDate());
		for (MovieList movieList2 : listMovies) {
			MovieList movieList1 = new MovieList();

			movieList1.setMovieDate(movieList2.getMovieDate());
			movieList1.setMovieName(movieList2.getMovieName());
			movieList1.setMovieID(movieList2.getMovieID());
			finalListMovies.add(movieList1);
		}
		map.addAttribute("MovieList", finalListMovies);
		// ((Model) modelAndView).addAttribute("MovieList", movieList1);
		return "MovieList";
	}

	@RequestMapping(value = "/movie", params = "purchase")
	public String Purchase(@ModelAttribute("movieList") MovieList movieList) {

		System.out.println("Purchase is called");
		return "purchased";

	}

	@RequestMapping(value = "/AddMovie", params = "AddMovie")
	public String addMovieLink(@ModelAttribute("movieList") MovieList movieList, BindingResult result,
			HttpServletRequest request) {

		MultipartFile movieImage = movieList.getMovieImage();
		System.out.println("movie image =" + movieImage);
		// String rootDirectory
		// =request.getSession().getServletContext().getRealPath("/");
		// System.out.println("rootDirectory="+rootDirectory);
		if (movieImage != null) { // Multipart
			String imageFileName = movieImage.getOriginalFilename();
			

			//String filePath = servletContext.getRealPath("WEB-INF/Images/");
			String filePath = request.getSession().getServletContext().getRealPath("WEB-INF/images");
			
			System.out.println("filePath=" + filePath);
			/*try {
				Writer writer = new FileWriter(filePath);
				writer.write(movieList.getMovieImageFileName());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			try {
			   File uploadingFileObj = new File(movieImage.getOriginalFilename());
			   movieImage.transferTo(uploadingFileObj);
			   
			   File destFile = new File(filePath,imageFileName);
			   
				FileUtils.copyFile( uploadingFileObj, destFile);
				destFile = null;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   
			   
			/*
			 * try{ movieImage.transferTo(new File(rootDirectory+
			 * "resources\\images\\"+movieList.getMovieName() + ".jpg"));
			 * }catch(Exception e){ e.printStackTrace(); }
			 */
		}
		System.out.println("Movie Date=" + movieList.movieDate);
		System.out.println("Movie duration" + movieList.movieDuration);
		System.out.println("AddMovie");
		return "AddMovies";
	}

	@ExceptionHandler(NoMovieFoundException.class)
	public ModelAndView handleError(HttpServletRequest req, NoMovieFoundException exception) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("invalidMovieId", exception.getMovieDate());
		mav.addObject("exception", exception);
		mav.addObject("url", req.getRequestURL() + "?" + req.getQueryString());
		mav.setViewName("MovieNotFound");
		return mav;
	}

	/*
	 * @RequestMapping(value ="/User", method=RequestMethod.POST) public String
	 * addNewUser(@ModelAttribute("newUser")@Valid NewUser newUser){
	 * NewUserImplService newUserImplService = new NewUserImplService();
	 * //newUserImplService. System.out.println("Email:="+newUser.getEmail());
	 * System.out.println("passWord:="+newUser.getPassWord());
	 * System.out.println("CreditCard Number:="+newUser.getCreditCardNumber());
	 * System.out.println("Expiration Month:="+newUser.getExpirationMonth());
	 * System.out.println("First name:="+newUser.getFirstName() );
	 * System.out.println("LastName:="+newUser.getLastName());
	 * System.out.println("Purchase is called"); return "purchased";
	 * 
	 * }
	 */

	protected Map referenceData(HttpServletRequest request) throws Exception {
		Map referenceData = new HashMap();
		Map<String, String> expirationMonth = new LinkedHashMap<String, String>();
		expirationMonth.put("01 Jan", "January");
		expirationMonth.put("02 Feb", "Feburary");
		expirationMonth.put("03 March", "March");
		expirationMonth.put("04 April", "April");
		referenceData.put("countryList", expirationMonth);
		return referenceData;
	}

	@RequestMapping(value = "/NewUser1", params = "NewUser1", method = RequestMethod.GET)
	public String addNewUser(Model model) {
		NewUser newUser = new NewUser();
		model.addAttribute("newUser", newUser);
		return "NewUser";
		// return "index";
	}

	@RequestMapping(value="/NewUser1",params="NewUser1",method=RequestMethod.POST)
	public String newUser(@ModelAttribute("newUser") @Valid NewUser newUser,BindingResult result){
		String page;
		NewUserImplService newUserImplService = new NewUserImplService();
		if(result.hasErrors()){
			System.out.println("New User ModeAttribute has error"+result.getFieldError());
			
			return "NewUser";
		}
		//System.out.println("expiration month");
		page = newUserImplService.updateUserInfo(newUser);
		return page;
		
	}
}
