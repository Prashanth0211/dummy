package com.cg.librarymanagement.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.librarymanagement.dto.LibraryManagementDto;
import com.cg.librarymanagement.exception.LibraryManagementException;
import com.cg.librarymanagement.service.ILibraryManagementService;
import com.cg.librarymanagement.service.LibraryManagementServiceImpl;

public class TestCaseThree {

	private static ILibraryManagementService library = null;
	@BeforeClass
	public static void setUpBeforeClass() throws LibraryManagementException {
		library  = new LibraryManagementServiceImpl();
	}

	@Test
	public void testIdWhenInput() {
		LibraryManagementDto dto=library.viewDetails("1234");
		assertNotNull(dto);
	}
	@Test
	public void testIdWhenInputWrong() {
		LibraryManagementDto dto=library.viewDetails("dasa");
		assertNull(dto);
	}
	@Test
	public void testIdWhenNoInput() {
		LibraryManagementDto dto=library.viewDetails(" ");
		assertNull(dto);
	}
	@Test(expected=LibraryManagementException.class)
	public void testAddPaymentWhenNoInputs() throws LibraryManagementException {
		LibraryManagementDto dto=library.payAmount("","");
		assertNull(dto);
	}
	@Test(expected=LibraryManagementException.class)
	public void testAddPaymentWhenSpaceInput() throws LibraryManagementException {
		LibraryManagementDto dto=library.payAmount(" ", "2000");
		assertNull(dto);
	}
	@Test(expected=LibraryManagementException.class)
	public void testAddPaymentWhenNoInput() throws LibraryManagementException {
		LibraryManagementDto dto=library.payAmount("", "2000");
		assertNull(dto);
	}
	@Test
	public void testAddPaymentWhenCorrectInput() throws LibraryManagementException {
		LibraryManagementDto dto=library.payAmount("1234", "2000");
		assertNotNull(dto);
	}

}
