package com.pawan.contactapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pawan.contactapp.command.Contact;
import com.pawan.contactapp.service.ContactInfoService;

@Controller

public class ContactInfoController {

	@Autowired
	private ContactInfoService service;

	@GetMapping(value = { "/", "loadForm" })
	public String loadContactForm(Model model) {
		Contact contact = new Contact();
		model.addAttribute("contact", contact);

		return "index";
	}

	@PostMapping("/saveContact")
	public String handleSubmitBtn(@ModelAttribute Contact contact, RedirectAttributes attributes) {

		boolean isSaved = service.saveContact(contact);
		if (isSaved) {

			if (contact.getCid() != null) {
				attributes.addFlashAttribute("updated", "contact updated successfully");

			} else {
				attributes.addFlashAttribute("successMsg", "contact saved");
			}

		} else {

			attributes.addFlashAttribute("errorMsg", "contact failed to save");
		}
		return "redirect:loadForm";

	}

	@GetMapping("/viewContacts")
	public String handleViewCtctsHyperLink(Model model) {

		List<Contact> contactsList = service.getAllContacts();
		model.addAttribute("contactList", contactsList);
		return "viewContacts";

	}
}
