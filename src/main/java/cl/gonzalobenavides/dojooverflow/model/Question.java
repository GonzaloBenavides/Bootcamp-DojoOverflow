package cl.gonzalobenavides.dojooverflow.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "questions")
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Your question is empty!")
	private String questionText;
	
	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "question")
	List<Answer> answers;
	
	@Transient
	String tagsTransient;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "inQuestions")
	List<Tag> tags;

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
	public Question() {
		this.tags = new ArrayList<Tag>();
	}

	public Question(String question, List<Answer> answers, List<Tag> tags) {
		this.questionText = question;
		this.answers = answers;
		this.tags = tags;
	}
	
	public void addAnswer(Answer a) {
		this.answers.add(a);
	}
	
	public void addTag(Tag t) {
		this.tags.add(t);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String question) {
		this.questionText = question;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public List<Tag> getTags() {
		return tags;
	}
	
	public String getTagsString() {
		String tagString = "";
		for(Tag tag :  this.getTags()) {
			tagString += tag.getTag() + ", ";
		}
		if(!tagString.isBlank())
			tagString = (String) tagString.subSequence(0, tagString.length()-2);
		
		return tagString;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public String getTagsTransient() {
		return tagsTransient;
	}

	public void setTagsTransient(String tagsTransient) {
		this.tagsTransient = tagsTransient;
	}

	
	
	
}
