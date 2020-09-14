package com.pawan.contactapp.service;

import java.util.List;

import com.pawan.contactapp.command.Contact;

public interface ContactInfoService {

	public boolean saveContact(Contact contact);

	public List<Contact> getAllContacts();

	public Contact getContactById(Integer cid);

	public boolean updateContact(Contact contact);

	public boolean deleteContact(Integer cid);
}
