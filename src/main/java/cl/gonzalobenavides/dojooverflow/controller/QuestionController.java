package cl.gonzalobenavides.dojooverflow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import cl.gonzalobenavides.dojooverflow.model.Answer;
import cl.gonzalobenavides.dojooverflow.model.Question;
import cl.gonzalobenavides.dojooverflow.service.FlowService;
import jakarta.validation.Valid;

@Controller
public class QuestionController {

	@Autowired
	FlowService flow;
	
	@PostMapping("/questions/new")
	public String writeQuestion(@Valid @ModelAttribute Question question, BindingResult res, Model mod) {
		FieldError error = flow.validateTags((question.getTagsTransient()+",").split(","));
		if(error != null)
			res.addError(error);

		if(res.hasErrors()) return "/questions/new.jsp";
		
		flow.saveQuestion(question);
		
		return "redirect:/questions";
	}
	
	@PostMapping("/questions/{id}")
	public String answerQuestion(@ModelAttribute Answer answer, BindingResult res, @PathVariable("id") Long id, Model mod) {
		answer.setId(null);
		mod.addAttribute("question", flow.findQuestionById(id));
		flow.saveAnswer(id, answer);
		mod.addAttribute("answer", new Answer());
		return "redirect:/questions/"+id;
	}
}
