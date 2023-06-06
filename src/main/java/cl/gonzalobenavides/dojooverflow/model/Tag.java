package cl.gonzalobenavides.dojooverflow.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "tags")
public class Tag {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String tag;

	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "question_tags", joinColumns = @JoinColumn(name = "tag_id"), inverseJoinColumns = @JoinColumn(name = "question_id"))
	private List<Question> inQuestions;

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
	public Tag() {
	}

	public Tag(Long id, String tag, Date createdAt, Date updatedAt, List<Question> inQuestions) {
		this.id = id;
		this.tag = tag;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.inQuestions = inQuestions;
	}
	
	public Tag(String tag, List<Question> inQuestions) {
		this.tag = tag;
		this.inQuestions = inQuestions;
	}
	
	public Tag(String tag) {
		this.tag = tag;
		this.inQuestions = new ArrayList<Question>();
	}
	
	public void addQuestion(Question q) {
		this.inQuestions.add(q);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
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

	public List<Question> getInQuestions() {
		return inQuestions;
	}

	public void setInQuestions(List<Question> inQuestions) {
		this.inQuestions = inQuestions;
	}
	
	
}
