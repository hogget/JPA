package com.capgemini.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
		public void setId(Long id) {
			this.id = id;
		}
		public void setName(String name) {
			this.name = name;
		}
		public void setProjectType(String projectType) {
			this.projectType = projectType;
		}
		
		
}
