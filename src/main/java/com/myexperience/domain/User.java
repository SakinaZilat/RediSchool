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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
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

    @Column(name = "firstName", length =255, nullable = false)
    private String firstName;
    
    @Column(name = "lastName", length = 255, nullable = false)
    private String lastName;
    
    @Column(name = "email", length = 255, nullable = false)
    private String email;

	@Column(name = "userName", length = 255, nullable = false)
	private String userName;

	@Column(name = "passWord", length = 255, nullable = false)
	private String passWord;

    @Column(name = "registredDate", nullable = false)

    private Date registredDate;

    @OneToMany(mappedBy="user", fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
    private List<Experience> experiences;

    public User() {
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
		this.lastName = lastName.toUpperCase();
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
}
