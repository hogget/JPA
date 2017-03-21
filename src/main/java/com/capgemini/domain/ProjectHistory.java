package com.capgemini.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table (name = "PROJECT_HISTORY")
public class ProjectHistory  extends AbstractEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_project")
	private Project project;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_functiom")
	private Function function;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_worker")
	private Worker worker;
		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer Id;
	
	@Column
	private LocalDate dateFrom;
	
	@Column
	private LocalDate dateTo;
	
	@Column
	private boolean isLeader;
	

	
}
