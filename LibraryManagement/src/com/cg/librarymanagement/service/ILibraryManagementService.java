package com.cg.librarymanagement.service;

import java.math.BigDecimal;
import java.util.HashMap;

import com.cg.librarymanagement.dto.LibraryManagementDto;
import com.cg.librarymanagement.exception.LibraryManagementException;

public interface ILibraryManagementService {
	
public LibraryManagementDto viewDetails(String id);
public LibraryManagementDto payAmount(String id,String amount) throws LibraryManagementException;
public HashMap <String,LibraryManagementDto> viewAll();
public boolean validateId(String id) throws LibraryManagementException;

boolean validateMoney(String money) throws LibraryManagementException;
}
