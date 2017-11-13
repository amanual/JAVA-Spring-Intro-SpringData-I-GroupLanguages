package com.amanuel.grouplanguage.services;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.amanuel.grouplanguage.model.ModelLanguage;
@Service
public class LanguageServices {

	List<ModelLanguage> languages = new ArrayList(Arrays.asList(
			new ModelLanguage("Python","Some body", "version 1.0"),
			new ModelLanguage("MEAN","Some body", "version 2.0"),
			new ModelLanguage("Java","Some body", "version 3.0")
			));
	
	public void addLanguages(ModelLanguage lang){
		languages.add(lang);

	}
	public List<ModelLanguage> allLanguages(){
		return languages;
	}
	public ModelLanguage findLanguage(int index) {
		if (index < languages.size()) {
			return languages.get(index);
		}
		else {
			return null;
		}
	}
	public void deleteLanguage(int id) {
		if(id < languages.size()) {
			languages.remove(id);
		}
	}
	public void updateLanguage(int id, ModelLanguage language) {
		if(id < languages.size()) {
			languages.set(id, language);
		}
	}
}
