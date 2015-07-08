// default package
// Generated 09-jun-2015 15:56:59 by Hibernate Tools 3.4.0.CR1
package hbm.clases;

import java.util.HashSet;
import java.util.Set;

/**
 * Departments generated by hbm2java
 */
public class Departments implements java.io.Serializable {

	private short departmentId;
	private Employees employees;
	private Locations locations;
	private String departmentName;
	private Set jobHistories = new HashSet(0);
	private Set employeeses = new HashSet(0);

	public Departments() {
	}

	public Departments(short departmentId, String departmentName) {
		this.departmentId = departmentId;
		this.departmentName = departmentName;
	}

	public Departments(short departmentId, Employees employees,
			Locations locations, String departmentName, Set jobHistories,
			Set employeeses) {
		this.departmentId = departmentId;
		this.employees = employees;
		this.locations = locations;
		this.departmentName = departmentName;
		this.jobHistories = jobHistories;
		this.employeeses = employeeses;
	}

	public short getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(short departmentId) {
		this.departmentId = departmentId;
	}

	public Employees getEmployees() {
		return this.employees;
	}

	public void setEmployees(Employees employees) {
		this.employees = employees;
	}

	public Locations getLocations() {
		return this.locations;
	}

	public void setLocations(Locations locations) {
		this.locations = locations;
	}

	public String getDepartmentName() {
		return this.departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Set getJobHistories() {
		return this.jobHistories;
	}

	public void setJobHistories(Set jobHistories) {
		this.jobHistories = jobHistories;
	}

	public Set getEmployeeses() {
		return this.employeeses;
	}

	public void setEmployeeses(Set employeeses) {
		this.employeeses = employeeses;
	}

}
