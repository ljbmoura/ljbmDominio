package br.com.ljbm.utilitarios;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

public class RecursoTest {

	//Recurso recurso = new Recurso();
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void recuperaPastaRecurso () {
		
		File pastaRecursos = Recurso.getPastaRecursos(RecursoTest.class);
//		System.out.println(pastaRecursos.getAbsolutePath());
		
		assertTrue(pastaRecursos.exists());
		
	}
	
}

