package fr.smabtp.yca.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import fr.smabtp.jndi.GetEJB;
import fr.smabtp.yca.bean.Histo;
import fr.smabtp.yca.utils.JsonFLux;

//Permet de ne pas avoir l'erreur 406 sur format manquant = application/json: 
@EnableWebMvc
@Controller
public class MyControler {

	@Autowired
	private GetEJB getEJB;

	/**
	 * Controller de test 1
	 */
	@RequestMapping(value = "testController1", method = RequestMethod.POST)
	public ModelAndView testController1(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("myJSP");
		mav.addObject("message", "testController1");
		return mav;
	}

	/**
	 * Controller de test 2
	 */
	@RequestMapping(value = "testController2", method = RequestMethod.POST)
	public ModelAndView testController2(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("myJSP");
		mav.addObject("message", "testController2");
		return mav;
	}

	/**
	 * Controller de test 2
	 */
	@RequestMapping(value = "403", method = RequestMethod.POST)
	public ModelAndView accessDenied(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("403");
		mav.addObject("message", "Vous n'avez pas accès à cette page.");
		return mav;
	}

	/**
	 * Controller de test 3
	 */
	@ResponseBody
	@RequestMapping(value = "user", method = RequestMethod.GET)
	public ResponseEntity<List<JsonFLux>> fetchAllUsers(
			HttpServletRequest request) {

		List<JsonFLux> currentUsersList = new ArrayList<JsonFLux>();
		if (getEJB != null) {

			Histo histoAdd = new Histo(
					"Initialisation: Test GET sur controller Spring MVC",
					"Angular JS", new Timestamp(new Date().getTime()));
			Histo histoAddBack = (Histo) getEJB.recordData(histoAdd);
			currentUsersList.add(new JsonFLux(histoAddBack.getNomUp() + " "
					+ histoAddBack.getPrenomUp(), histoAddBack.getPk()
					.toString()));

			return new ResponseEntity<List<JsonFLux>>(currentUsersList,
					HttpStatus.OK);
		} else {
			return new ResponseEntity<List<JsonFLux>>(
					HttpStatus.SERVICE_UNAVAILABLE);
		}
	}

	/**
	 * Return les utilisateurs correspondants au parametre en entrée.
	 */
	// TODO
	@ResponseBody
	@RequestMapping(value = "getUsersLike", method = RequestMethod.POST)
	public ResponseEntity<List<JsonFLux>> getUsersLike(
			HttpServletRequest request) {

		List<JsonFLux> currentUsersList = new ArrayList<JsonFLux>();

		return new ResponseEntity<List<JsonFLux>>(currentUsersList,
				HttpStatus.OK);
	}

	/**
	 * Créé l'utilisateur correspondant au parametre en entrée.
	 */
	@ResponseBody
	@RequestMapping(value = "createUser", method = RequestMethod.POST)
	public ResponseEntity<List<JsonFLux>> createUser(
			HttpServletRequest request, @RequestBody JsonFLux user) {

		Histo userToCreate = new Histo(user.getLib1(), user.getLib2(),
				new Timestamp(new Date().getTime()));
		Histo userToCreateBack = (Histo) getEJB.recordData(userToCreate);

		List<JsonFLux> currentUsersList = new ArrayList<JsonFLux>();
		currentUsersList.add(new JsonFLux("User créé: " + user.getLib1() + " "
				+ user.getLib2(), userToCreateBack.getPk().toString()));

		return new ResponseEntity<List<JsonFLux>>(currentUsersList,
				HttpStatus.OK);
	}
}