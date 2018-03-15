package com.springmvc.controller;

import service.*;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {

	static List<Person> persons = new ArrayList<Person>();
	static {
		persons.add(new Person("Tom", 20, "Nanjing"));
		persons.add(new Person("Jack", 20, "USA"));
		persons.add(new Person("Lucy", 24, "UK"));
	}

	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");

		String contextPath = request.getContextPath();
		mav.addObject("contextPath", contextPath);

		mav.addObject("persons", persons);

		return mav;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add() {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("add");

		return mav;
	}
	

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView add(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");

		Person p = new Person();

		p.setUserId(UUID.randomUUID());
		p.setName(request.getParameter("username"));
		p.setAge(Integer.valueOf(request.getParameter("age")).intValue() );
		p.setAddress(request.getParameter("address"));

		persons.add(p);

		mav.addObject("persons", persons);

		return mav;
	}
	
	private void deleteUser(UUID userId) {
		Iterator<Person> it=persons.iterator();
		while (it.hasNext()) {
			Person p = (Person) it.next();
			if (p.getUserId().equals(userId)) {
				it.remove();
			}
			
		}
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		
		String userId=request.getParameter("userId");
		if (userId!=null&&!userId.isEmpty()) {
			UUID _userId=UUID.fromString(userId);
			deleteUser(_userId);
		} else {
			return "redirect:/error";
		}
		

		return "redirect:/index";
	}

}
