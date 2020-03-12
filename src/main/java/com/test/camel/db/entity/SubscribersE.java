package com.test.camel.db.entity;

public class SubscribersE {
	private int id;
	private String name;
	private String msisdn;
	private int age;
	private String age_discount; //true / false
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
	public String getAge_discount() {
		return age_discount;
	}
	public void setAge_discount(String age_discount) {
		this.age_discount = age_discount;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((age_discount == null) ? 0 : age_discount.hashCode());
		result = prime * result + id;
		result = prime * result + ((msisdn == null) ? 0 : msisdn.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		SubscribersE other = (SubscribersE) obj;
		if (age != other.age)
			return false;
		if (age_discount == null) {
			if (other.age_discount != null)
				return false;
		} else if (!age_discount.equals(other.age_discount))
			return false;
		if (id != other.id)
			return false;
		if (msisdn == null) {
			if (other.msisdn != null)
				return false;
		} else if (!msisdn.equals(other.msisdn))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Sbscribers [id=" + id + ", name=" + name + ", msisdn=" + msisdn + ", age=" + age + ", age_discount="
				+ age_discount + "]";
	}
	
	
}
