package cl.gonzalobenavides.dojooverflow.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;

import cl.gonzalobenavides.dojooverflow.model.Answer;
import cl.gonzalobenavides.dojooverflow.model.Question;
import cl.gonzalobenavides.dojooverflow.model.Tag;
import cl.gonzalobenavides.dojooverflow.repository.AnswerRepository;
import cl.gonzalobenavides.dojooverflow.repository.QuestionRepository;
import cl.gonzalobenavides.dojooverflow.repository.TagRepository;

@Service
public class FlowService {

	@Autowired
	QuestionRepository questions;
	
	@Autowired
	AnswerRepository answers;
	
	@Autowired
	TagRepository tags;
	
	public List<Question> findAllQuestions(){
		return questions.findAll();
	}
	
	public Question findQuestionById(Long id) {
		Optional<Question> q = questions.findById(id);
		if(q.isPresent())
			return q.get();
		return null;
	}
	
	public void saveQuestion(Question q) {
		List<Tag> questionTags = new ArrayList<Tag>();
		for(String t : q.getTagsTransient().split(",")) {
			
			Optional<Tag> trans = tags.findByTag(t);
			
			if(trans.isPresent()) {
				if(q.getTags().contains(trans.get())) continue;
				
				questionTags.add(trans.get());
				trans.get().addQuestion(q);
//				tags.save(trans.get());
			}
			else {
				Tag newTag = new Tag(t.toLowerCase());
				newTag.addQuestion(q);
				
//				tags.save(newTag);
				questionTags.add(newTag);
			}
		}
		q.setTags(questionTags);
		questions.save(q);
	}
	
	public FieldError validateTags(String[] tags) {
		
		if(tags == null || tags.length == 0) {
			return new FieldError("question", "tagsTransient","There is an empty or invalid tag.");
		}
		
		for(String s : tags) {
			if(s.trim().isBlank()) {
				return new FieldError("question", "tagsTransient","There is an empty or invalid tag.");
			}
		}
		if(tags.length > 3) {
			return new FieldError("question","tagsTransient","You can only use 3 tags per question.");
		}
		
		
		
		return null;
	}
	
	public void saveAnswer(Long idQuestion, Answer answer) {
		Question q = this.findQuestionById(idQuestion);
		
		if(q == null) return;
		
		answer.setQuestion(q);
		answers.save(answer);
		
		q.addAnswer(answer);
		questions.save(q);
	}
	
}
