package tests;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import AgendaBreak.DatoException;
import AgendaBreak.Dia;

class CACCTests {

	@Test
	void testCACC_DiaMenor1() {
	    assertThrows(DatoException.class, () -> new Dia(0));   // A=true, B=false
	}

	@Test
	void testCACC_DiaMayor366() {
	    assertThrows(DatoException.class, () -> new Dia(367)); // A=false, B=true
	}

}
