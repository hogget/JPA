package com.capgemini.service;

import java.util.List;

import com.capgemini.domain.Project;
import com.capgemini.domain.ProjectHistory;
import com.capgemini.domain.Worker;

public interface ProjectService {
	/*
	 * Dodaj projekt, Usuń projekt, Zmień dane projektu, dodaj pracownika do projektu, usuń pracownika z projektu 
	 * (tzn. oznacz fakt zakończenia jego pracy w projekcie), 
	 * wyszukaj aktualnych pracowników projektu, wyszukaj wszystkich pracowników którzy brali udział w projekcie dłużej niż N miesięcy
	 */

	 public Project save(Project project);
	 public void deleteProject (Long id);
}
