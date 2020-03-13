package com.test.camel.domain;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.test.camel.cache.objects.CachedObject;

@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class Subscribers {
	
	private int id;
	private String name;
	private String msisdn;
	private int age;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	  @Override public int hashCode() { 
		  final int prime = 31; 
		  int result = 1;
		  result = prime * result + age; result = prime * result + id; result = prime *
				  result + ((msisdn == null) ? 0 : msisdn.hashCode()); result = prime * result
				  + ((name == null) ? 0 : name.hashCode()); 
		   return result; 
		   }
	 

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subscribers other = (Subscribers) obj;
		if (id != other.id)
			return false;
		if (msisdn == null) {
			if (other.msisdn != null)
				return false;
		} else if (!msisdn.equals(other.msisdn))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Subscribers [id=" + id + ", name=" + name + ", msisdn=" + msisdn + ", age=" + age + "]";
	}
	
	
	
}
