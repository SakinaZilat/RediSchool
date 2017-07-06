package com.myexperience.domain;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
/**
 * Created by zilat on 31.05.2017.
 */
/**
 * @author zilat
 *
 */
@Entity
@Table(name = "Rating")
public class Rating {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(unique = true, nullable = false, precision = 19)
    private long id;

    @Column(name = "rating", nullable = false)
    private int rating;
    
    @Column(name = "comment", length = 255, nullable = false)
    private String comment;
    

    @Column(name = "createdDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdDate;
     
    
    @Column(name = "experience_id", nullable = false)
    private long experience_id;
    
    @Column(name = "user_id", nullable = false)
    private long user_id;
    
    public Rating() {
    }


	public long getId()
	{
		return id;
	}


	public void setId(long id)
	{
		this.id = id;
	}


	public int getRating()
	{
		return rating;
	}


	public void setRating(int rating)
	{
		this.rating = rating;
	}


	public String getComment()
	{
		return comment;
	}


	public void setComment(String comment)
	{
		this.comment = comment;
	}


	public Date getCreatedDate()
	{
		return createdDate;
	}


	public void setCreatedDate(Date createdDate)
	{
		this.createdDate = createdDate;
	}


	public long getExperience_id() {
		return experience_id;
	}


	public void setExperience_id(long experience_id) {
		this.experience_id = experience_id;
	}


	public long getUser_id() {
		return user_id;
	}


	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}


	
	
    
}
