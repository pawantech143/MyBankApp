package com.pawan.contactapp.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pawan.contactapp.command.Contact;
import com.pawan.contactapp.entity.ContactInfo;
import com.pawan.contactapp.repository.ContactInfoRepository;
import com.pawan.contactapp.service.ContactInfoService;

@Service
public class ContactInfoServiceImpl implements ContactInfoService {

	@Autowired
	private ContactInfoRepository contactInfoRepo;

	@Override
	public boolean saveContact(Contact contact) {
		ContactInfo entity = new ContactInfo();
		BeanUtils.copyProperties(contact, entity);
		ContactInfo saveEntity = contactInfoRepo.save(entity);
		return saveEntity.getCid() != null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contact> getAllContacts() {

		List<ContactInfo> contactinfoList = contactInfoRepo.findAll();
		List<Contact> contactList = new ArrayList<Contact>();

		/*
		 * for (ContactInfo contactinfo : contactinfoList) {
		 * 
		 * Contact c = new Contact();
		 * 
		 * BeanUtils.copyProperties(contactinfo, c); contactList.add(c); }
		 */

		contactinfoList.forEach(entity -> {
			Contact c = new Contact();

			BeanUtils.copyProperties(entity, c);
			contactList.add(c);
		});

		return contactList;
	}

	@Override
	public Contact getContactById(Integer cid) {
		Optional<ContactInfo> opt = contactInfoRepo.findById(cid);

		if (opt.isPresent()) {
			Contact c = new Contact();
			ContactInfo entity = opt.get();
			BeanUtils.copyProperties(entity, c);
			return c;
		}

		return null;
	}

	@Override
	public boolean updateContact(Contact contact) {
		return false;
	}

	@Override
	public boolean deleteContact(Integer cid) {
		contactInfoRepo.deleteById(cid);
		
		return true;
	}

}
