package com.klicws.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by loicleger on 16/01/16.
 */
@Entity
@Table(name = "tag")
public class Tag {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@JsonIgnore
	@ManyToOne(targetEntity = Interest.class)
	@JoinColumn(name = "interest_id")
	private Interest interest;

	@Column
	private String nom;

	@Column
	private Float positionTopX;

	@Column
	private Float positionTopY;

	@Column
	private Float positionBottomX;

	@Column
	private TypeLocation type;

	public TypeLocation getType() {
		return type;
	}

	public void setType(TypeLocation type) {
		this.type = type;
	}

	public Float getPositionTopX() {
		return positionTopX;
	}

	public void setPositionTopX(Float positionTopX) {
		this.positionTopX = positionTopX;
	}

	public Float getPositionTopY() {
		return positionTopY;
	}

	public void setPositionTopY(Float positionTopY) {
		this.positionTopY = positionTopY;
	}

	public Float getPositionBottomX() {
		return positionBottomX;
	}

	public void setPositionBottomX(Float positionBottomX) {
		this.positionBottomX = positionBottomX;
	}

	public Float getPositionBottomY() {
		return positionBottomY;
	}

	public void setPositionBottomY(Float positionBottomY) {
		this.positionBottomY = positionBottomY;
	}

	@Column
	private Float positionBottomY;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Interest getInterest() {
		return interest;
	}

	public void setInterest(Interest interest) {
		this.interest = interest;
	}
}
