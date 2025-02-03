package de.irahi.illustration_be.entity;

import java.util.Objects;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
@Access(AccessType.FIELD)
public class Figures {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="character_name")
	private String characterName;
	
	@Lob
	@Column(name="bio")
	private String bio;
	
	@Column(name="role")
	private String role;
	
	@ManyToOne
	@JoinColumn(name="tale_id", referencedColumnName = "id" ) // FK in the Figures-Tabelle
	private Tale tale;
	
	@Override
	public int hashCode() {
		return Objects.hash(id, characterName, bio, role);
	}
}
