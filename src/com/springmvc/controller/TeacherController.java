package com.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import model.Teacher;
import service.TeacherService;

@RequestMapping("/teacher")
@Controller
public class TeacherController {
	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("teacher/index");

		List<Teacher> teachers = TeacherService.GetInstance().GetAll();
		mav.addObject("teachers", teachers);

		return mav;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add() {
		return new ModelAndView("/teacher/addTeacher");
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(HttpServletRequest request) {

		Teacher teacher = new Teacher();
		teacher.setId(Integer.valueOf(request.getParameter("id")).intValue());
		teacher.setName(request.getParameter("name"));
		teacher.setAddress(request.getParameter("address"));

		TeacherService.GetInstance().Insert(teacher);
		return "redirect:/teacher/index";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(int id) {
		TeacherService.GetInstance().Delete(id);
		return "redirect:/teacher/index";
	}
}
