package com.pawan.contactapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Contact_tab")
public class ContactInfo {

	@Id
	@GeneratedValue

	private Integer cid;
	private String cname;
	private String cnum;
	private String email;
}
