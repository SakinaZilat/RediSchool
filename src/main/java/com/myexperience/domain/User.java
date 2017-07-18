package com.myexperience.domain;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * Created by zilat on 31.05.2017.
 */
@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(unique = true, nullable = false, precision = 19)
    private long id;

    @Column(name = "firstName", length = 255, nullable = false)
    private String firstName;
    
    @Column(name = "lastName", length = 255, nullable = false)
    private String lastName;
    
    @Column(name = "email", length = 255, nullable = false)
    private String email;

    @Column(name = "registredDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date registredDate;
    
    @OneToMany(mappedBy="user", fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
    private List<Experience> experiences;
    

    public User() {
    }
    
    

	public User(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.registredDate = new Date();
	}



	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	
	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	public Date getRegistredDate()
	{
		return registredDate;
	}

	public void setRegistredDate(Date registredDate)
	{
		this.registredDate = registredDate;
	}
  
    
}
