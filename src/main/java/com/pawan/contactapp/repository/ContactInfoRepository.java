package com.pawan.contactapp.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pawan.contactapp.entity.ContactInfo;

public interface ContactInfoRepository extends JpaRepository<ContactInfo, Serializable> {

}
