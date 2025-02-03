package de.irahi.illustration_be.entity;

import java.util.Objects;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
@Access(AccessType.FIELD)
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nick")
	private String nick;
	
	@Column(name="posts", columnDefinition= "TINYINT UNSIGNED")
	private short posts;
	
	@Column(name="google_link")
	private String googleLink;
	
	@Column(name="avatar")
	private String avatar;
	
	public int hashCode() {
		return Objects.hash(id, nick, posts, googleLink, avatar);
	}
}
