package cl.gonzalobenavides.dojooverflow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import cl.gonzalobenavides.dojooverflow.model.Answer;
import cl.gonzalobenavides.dojooverflow.model.Question;
import cl.gonzalobenavides.dojooverflow.service.FlowService;

@Controller
public class FlowController {

	@Autowired
	FlowService flow;
	
	@GetMapping("/")
	public String index() {
		return "redirect:/questions";
	}
	
	@GetMapping("/questions")
	public String goDash(Model mod) {
		mod.addAttribute("questions", flow.findAllQuestions());
		return "dashboard.jsp";
	}
	
	@GetMapping("/questions/new")
	public String newQuestion(@ModelAttribute Question question, BindingResult res, Model mod) {
		mod.addAttribute("question", new Question());
		return "questions/new.jsp";
	}
	
	@GetMapping("/questions/{id}")
	public String checkQuestion(@ModelAttribute Answer answer, Model mod, @PathVariable("id") Long id) {
		mod.addAttribute("question", flow.findQuestionById(id));
		mod.addAttribute("answer", new Answer());
		return "questions/question.jsp";
	}
	
}
