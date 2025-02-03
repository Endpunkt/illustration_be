package de.irahi.illustration_be.entity;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
@Access(AccessType.FIELD)
public class Rating {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="comment")
	private String comment;
	
	@Column(name = "status", columnDefinition = "ENUM('HATE', 'OFFTOP', 'WRONG','AGENDA','TRUISM', 'INSIGHTFUL', 'RIGHT', 'ADVANCED', 'DEAD_AUTHOR')")
	@Enumerated(EnumType.STRING)
	private Status status;
	
	//__________ M A N Y__T O__O N E______________________
	@ManyToOne
	@JoinColumn(name="user_id", referencedColumnName="id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="tale_id", referencedColumnName="id")//FK in the Rating-Table
	private Tale tale;
	
	
	private enum Status{
		HATE,
		OFFTOP,
		WRONG,
		AGENDA,
		TRUISM,
		INSIGHTFUL,
		RIGHT,
		ADVANCED,
		DEAD_AUTHOR	
	}

}
