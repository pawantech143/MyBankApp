package com.pawan.contactapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pawan.contactapp.command.Contact;
import com.pawan.contactapp.service.ContactInfoService;

@Controller
public class ViewContactsController {

	@Autowired
	private ContactInfoService service;

	public String handleAddCtctHyperLink(Model model) {
		return null;

	}

	@GetMapping("/edditContact")
	public String edditContact(@RequestParam("cid") Integer cid, Model model) {
		Contact contact = service.getContactById(cid);
		model.addAttribute("contact", contact);

		return "index";

	}

	@GetMapping("/deleteContact")
	public String deleteContact(@RequestParam("cid") Integer cid,RedirectAttributes attributes) {
		
		service.deleteContact(cid);
		attributes.addFlashAttribute("deleteSuccess", "Record deleted successfully");
		
		return "redirect:viewContacts";
	}

}
