package com.klicws.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by loicleger on 16/01/16.
 */
@Entity
@Table(name = "location")
public class Location {

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
	private String pointStartXY;

	@Column
	private String pointEndXY;

	public String getPointStartXY() {
		return pointStartXY;
	}

	public void setPointStartXY(String pointStartXY) {
		this.pointStartXY = pointStartXY;
	}

	public String getPointEndXY() {
		return pointEndXY;
	}

	public void setPointEndXY(String pointEndXY) {
		this.pointEndXY = pointEndXY;
	}
}
