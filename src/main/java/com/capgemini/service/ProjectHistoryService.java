package com.capgemini.service;

import java.util.List;

import com.capgemini.domain.ProjectHistory;
import com.capgemini.domain.Worker;

public interface ProjectHistoryService {
	/*
	 * Dodaj projekt, Usuń projekt, Zmień dane projektu, dodaj pracownika do projektu, usuń pracownika z projektu 
	 * (tzn. oznacz fakt zakończenia jego pracy w projekcie), 
	 * wyszukaj aktualnych pracowników projektu, wyszukaj wszystkich pracowników którzy brali udział w projekcie dłużej niż N miesięcy
	 */

	 public ProjectHistory save(ProjectHistory projectHistory);
	 public Worker getOne(Worker worker);
	 public List <Worker> findWorkerByName (String name);
	 public List <Worker> findWorkerBySurname (String surname);
	 public List <Worker> findWorkerByEmail (String email);
	 public List <Worker> findWorkerByPesel (String pesel);
	 public Worker findWorkerById (Long id);
	 public void deleteProjectHistory (Long id);
}
