package com.amanuel.grouplanguage.repositories;
import java.util.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.amanuel.grouplanguage.model.ModelLanguage;

	@Repository
	public interface LanguageRepository extends CrudRepository<ModelLanguage, Long>{
		List<ModelLanguage> findAll();
	}

