package com.cg.librarymanagement.dao;

import java.math.BigDecimal;
import java.util.HashMap;

import com.cg.librarymanagement.dto.LibraryManagementDto;
import com.cg.librarymanagement.exception.LibraryManagementException;

public interface ILibraryManagementDao {

	public LibraryManagementDto viewDetails(String id);
	public LibraryManagementDto payAmount(String id,String amount);
	public HashMap <String,LibraryManagementDto> viewAll();
	
}
