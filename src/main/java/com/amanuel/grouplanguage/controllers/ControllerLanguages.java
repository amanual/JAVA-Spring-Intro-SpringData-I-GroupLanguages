package com.amanuel.grouplanguage.controllers;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.amanuel.grouplanguage.model.ModelLanguage;
import com.amanuel.grouplanguage.services.LanguageServices;

@Controller
public class ControllerLanguages {
//	public BindingResult errors;
	private final LanguageServices languageServices;
	public ControllerLanguages(LanguageServices languageServices) {
		this.languageServices = languageServices;
		
	}
	@RequestMapping("/")
	public String index(@ModelAttribute("languages") ModelLanguage languages, Model model) {
		
		List<ModelLanguage> langDisplay = languageServices.allLanguages();
		model.addAttribute("langDisplay", langDisplay);
		return "indexPage";
	}

	@RequestMapping("/language")
	public String createLanguage(@Valid @ModelAttribute("languages") ModelLanguage languages, BindingResult result,RedirectAttributes redirectAttributes,Model model) {
		if (result.hasErrors()) {
//			redirectAttributes.addFlashAttribute("nameError", "name is requried");
//			redirectAttributes.addFlashAttribute("creatorError", "creator is requried");
//			redirectAttributes.addFlashAttribute("versionError", "version is requried");

			return "redirect:/";
		}
		else {
		languageServices.addLanguages(languages);
		return "redirect:/";
		}
	}
	
	@RequestMapping("/language/{id}")
	public String findLanguageByIndex(Model model, @PathVariable("id") int index) {
		ModelLanguage language = languageServices.findLanguage(index);
		model.addAttribute("language",language);
		
		return "viewPage";
	}
	@RequestMapping("/language/delete/{index}")
	public String delete(Model model, @PathVariable("index") int id) {
		languageServices.deleteLanguage(id);
		return "redirect:/";
	}
	@RequestMapping("/language/edit/{id}")
		public String editLanguage(Model model, @PathVariable("id") int id) {
		ModelLanguage languages = languageServices.findLanguage(id);
		if(languages != null) {
			model.addAttribute("languages", languages);
			return "editPage";
		}
		else {
		return "redirect:/";
		}
	}
	@PostMapping("/language/edit/{id}")
	public String updateBook(@PathVariable("id") int id, @Valid @ModelAttribute("languages") ModelLanguage languages, BindingResult result, RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) {
			redirectAttributes.addFlashAttribute("nameError", "name is requried");
			redirectAttributes.addFlashAttribute("creatorError", "creator is requried");
			redirectAttributes.addFlashAttribute("versionError", "version is requried");
			return "editPage";
		}
		else {
			languageServices.updateLanguage(id, languages);
		return "redirect:/";
		}
	}
	
	
	
	
	
}
