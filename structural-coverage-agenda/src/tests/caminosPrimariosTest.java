package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


import AgendaBreak.Dia;
import AgendaBreak.DatoException;

class caminosPrimariosTest {

	@Test
	void testD1() throws DatoException {
		  Dia dia = new Dia(100);   // día válido
		  assertEquals(100, dia.getDiaNumero()); // camino primario funciona
	}
	
	

}
