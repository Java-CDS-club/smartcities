package br.com.fiap.test;

import javax.persistence.Persistence;

public class EstabelecimentoTest {
	
	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("cap4smartcities").createEntityManager();
	
		
	}
}


  