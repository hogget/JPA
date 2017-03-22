package com.capgemini.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@NamedQuery(name = "FindWorkersFromParticularProjectWhoWereEmployedInParticularTimeAndPosition", 
query = " select distinct worker.name from project_history ph"
		+ "join worker on ph.id_worker = worker.id"
		+ "join project on ph.id_project = project.id"
		+ "where project.name = :project_name "
		+ "and not (ph.dateFrom > CAST (:dateTo as date)"
		+ "or ph.dateTo < CAST(:dateFrom as date)")
		

@Entity
public class EmployeeSearchCriteria {
	
	private LocalDate dateFrom;
	private LocalDate dateTo;
	private String position;
	private Project project;
	
	
	public EmployeeSearchCriteria(LocalDate dateFrom, LocalDate dateTo, String position, Project project) {
		super();
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		this.position = position;
		this.project = project;
	}
	public EmployeeSearchCriteria(LocalDate dateTo, String position, Project project) {
		super();
		this.dateTo = dateTo;
		this.position = position;
		this.project = project;
	}
	public EmployeeSearchCriteria(String position, Project project) {
		super();
		this.position = position;
		this.project = project;
	}
	public EmployeeSearchCriteria(LocalDate dateFrom, LocalDate dateTo, Project project) {
		super();
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		this.project = project;
	}
	public EmployeeSearchCriteria(LocalDate dateFrom, LocalDate dateTo, String position) {
		super();
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		this.position = position;
	}
	
	
	
}
