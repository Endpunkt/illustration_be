package de.irahi.illustration_be.entity;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Tale {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="author")
	private String author;
	
	@OneToMany(mappedBy="tale", cascade=CascadeType.ALL, fetch= FetchType.EAGER)
	private List<Rating> rating;
	
	@Column(name="summary")
	private String description;
	
	@Column(name="pages", columnDefinition="TINYINT UNSIGNED")
	private short pages;
	
	@OneToMany(mappedBy="tale", cascade=CascadeType.ALL, fetch= FetchType.EAGER)
	private List<Figures> figures;
	
	@Override
	public int hashCode() {
		return Objects.hash(id, title, author, rating, description, pages, figures);
	}

}
