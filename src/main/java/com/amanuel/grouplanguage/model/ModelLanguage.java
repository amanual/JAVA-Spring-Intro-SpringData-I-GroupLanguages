package com.amanuel.grouplanguage.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ModelLanguage {
	
	
	
	
	@Size(min = 2, max = 20)
	private String name;
	
	@Size(min = 2, max = 20)
	private String creator;
	
	@NotNull
	private String version;
	
	
	public ModelLanguage() {
		
	}
	public ModelLanguage( String name, String creator, String version) {
		this.name = name;
		this.creator = creator;
		this.version = version;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	
}
