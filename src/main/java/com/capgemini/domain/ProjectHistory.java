package com.capgemini.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

@NamedQueries({
	@NamedQuery(name = "NumberOfProjectsThatInParticularTimeWorkedMoreThan10Workers", 
				query = " select count(distinct project_id) from project_history v" 
						+ "where (select count(*) from project_history" 
						+ "where not (v.Date_from > Date_to or v.Date_to < Date_from) "
						+ "and project_id = v.project_id and ID != v.ID) > 10 "),

	@NamedQuery(name = "ProjectsThatInParticularTimeWorkedMoreThan10Workers", 
				query="select distinct v.project_name from project_history v "
					  + "join projects on v.project_id = projects.id"
					  + "where (select count(*) from project_history" 
					  + "where not (v.Date_from > Date_to or v.Date_to < Date_from)" 
					  + "and project_id = v.project_id and ID != v.ID) > 10")
						})

@Entity
@Table (name = "PROJECT_HISTORY")
public class ProjectHistory  extends AbstractEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_project")
	private Project project;
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_functiom")
	private Function function;
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_worker")
	private Worker worker;
		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long Id;
	
	@Column
	private LocalDate dateFrom;
	
	@Column
	private LocalDate dateTo;
	
	@Column
	private boolean isLeader;

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Function getFunction() {
		return function;
	}

	public void setFunction(Function function) {
		this.function = function;
	}

	public Worker getWorker() {
		return worker;
	}

	public void setWorker(Worker worker) {
		this.worker = worker;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public LocalDate getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(LocalDate dateFrom) {
		this.dateFrom = dateFrom;
	}

	public LocalDate getDateTo() {
		return dateTo;
	}

	public void setDateTo(LocalDate dateTo) {
		this.dateTo = dateTo;
	}

	public boolean isLeader() {
		return isLeader;
	}

	public void setLeader(boolean isLeader) {
		this.isLeader = isLeader;
	}
	
	
}
