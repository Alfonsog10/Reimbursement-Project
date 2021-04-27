package com.alfonso.models;

public class Employees {
	
	private Integer emp_id;
	private String emp_firstname;
	private String emp_lastname;
	private String emp_username;
	private String emp_password;
	private String emp_title;
	
	public Employees() {
		super();
	}
	
	public Employees (Integer emp_id, String emp_firstname, String emp_lastname, String emp_username, String emp_password, String emp_title) {
		super();
		this.emp_id = emp_id;
		this.emp_firstname = emp_firstname;
		this.emp_lastname = emp_lastname;
		this.emp_username = emp_username;
		this.emp_password = emp_password;
		this.emp_title = emp_title;
	}
	


	public Integer getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Integer emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_firstname() {
		return emp_firstname;
	}

	public void setEmp_firstname(String emp_firstname) {
		this.emp_firstname = emp_firstname;
	}

	public String getEmp_lastname() {
		return emp_lastname;
	}

	public void setEmp_lastname(String emp_lastname) {
		this.emp_lastname = emp_lastname;
	}

	public String getEmp_username() {
		return emp_username;
	}

	public void setEmp_username(String emp_username) {
		this.emp_username = emp_username;
	}

	public String getEmp_password() {
		return emp_password;
	}

	public void setEmp_password(String emp_password) {
		this.emp_password = emp_password;
	}

	public String getEmp_title() {
		return emp_title;
	}

	public void setEmp_title(String emp_title) {
		this.emp_title = emp_title;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emp_firstname == null) ? 0 : emp_firstname.hashCode());
		result = prime * result + ((emp_id == null) ? 0 : emp_id.hashCode());
		result = prime * result + ((emp_lastname == null) ? 0 : emp_lastname.hashCode());
		result = prime * result + ((emp_password == null) ? 0 : emp_password.hashCode());
		result = prime * result + ((emp_title == null) ? 0 : emp_title.hashCode());
		result = prime * result + ((emp_username == null) ? 0 : emp_username.hashCode());
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
		
		Employees other = (Employees) obj;
		
		if (emp_firstname == null) {
			if (other.emp_firstname != null)
				return false;
		} else if (!emp_firstname.equals(other.emp_firstname))
			return false;
		
		if (emp_id == null) {
			if (other.emp_id != null)
				return false;
		
		} else if (!emp_id.equals(other.emp_id))
			return false;
		
		if (emp_lastname == null) {
			if (other.emp_lastname != null)
				return false;
		
		} else if (!emp_lastname.equals(other.emp_lastname))
			return false;
		
		if (emp_password == null) {
			if (other.emp_password != null)
				return false;
		
		} else if (!emp_password.equals(other.emp_password))
			return false;
		
		if (emp_title == null) {
			if (other.emp_title != null)
				return false;
		
		} else if (!emp_title.equals(other.emp_title))
			return false;
		
		if (emp_username == null) {
			if (other.emp_username != null)
				return false;
		
		} else if (!emp_username.equals(other.emp_username))
			return false;
		
		return true;
	}

	@Override
	public String toString() {
		return "Employees [emp_id=" + emp_id + ", emp_firstname=" + emp_firstname + ", emp_lastname=" + emp_lastname
				+ ", emp_username=" + emp_username + ", emp_password=" + emp_password + ", emp_title=" + emp_title
				+ "]";
	}

	public void add(Employees employees) {
		// for mock testing
		
	}
}
