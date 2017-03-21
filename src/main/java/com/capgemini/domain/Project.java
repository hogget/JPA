package com.capgemini.domain;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table (name = "PROJECT" )
public class Project extends AbstractEntity {

		private static final long serialVersionUID = 1L;
		
		@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;
	    @Column(nullable = false, length = 45)
	    private String name;
	    @Column(nullable = false, length = 11)
	    private String projectType;
		    
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		public Long getId() {
			return id;
		}
		public String getName() {
			return name;
		}
		public String getProjectType() {
			return projectType;
		}
		
		
}
