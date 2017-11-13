package com.amanuel.grouplanguage.services;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.amanuel.grouplanguage.model.ModelLanguage;
import com.amanuel.grouplanguage.repositories.LanguageRepository;
@Service
public class LanguageServices {
	private LanguageRepository languageRepository;
	public LanguageServices(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	List<ModelLanguage> languages = new ArrayList(Arrays.asList(
			new ModelLanguage("Python","Some body", 1),
			new ModelLanguage("MEAN","Some body", 2),
			new ModelLanguage("Java","Some body", 3)
			));
	
	public void addLanguages(ModelLanguage lang){
		languageRepository.save(lang);

	}
	public List<ModelLanguage> allLanguages(){
		return languageRepository.findAll();
	}
	public ModelLanguage findLanguage(Long id) {
		return languageRepository.findOne(id);
		
	}
	public void deleteLanguage(Long id) {
		languageRepository.delete(id);
	}
	public void updateLanguage( ModelLanguage language) {
		languageRepository.save(language);
		
	}
	
}
