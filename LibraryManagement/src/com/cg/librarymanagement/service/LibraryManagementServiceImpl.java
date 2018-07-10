package com.cg.librarymanagement.service;

import java.math.BigDecimal;
import java.util.HashMap;



import com.cg.librarymanagement.dao.ILibraryManagementDao;
import com.cg.librarymanagement.dao.LibraryManagementDaoImpl;
import com.cg.librarymanagement.dto.LibraryManagementDto;
import com.cg.librarymanagement.exception.LibraryManagementException;

public class LibraryManagementServiceImpl implements ILibraryManagementService{
ILibraryManagementDao dao=new LibraryManagementDaoImpl();
 public boolean validateId(String id) throws LibraryManagementException
{
	if(!(id.matches("[a-zA-z0-9]+")))
	{
		throw new LibraryManagementException("please enter correct id");
	}
	return true;
}
	@Override
	public LibraryManagementDto viewDetails(String id) {
		// TODO Auto-generated method stub
		return dao.viewDetails(id);
	}

	@Override
	public LibraryManagementDto payAmount(String id, String amount) throws LibraryManagementException {
		// TODO 
		LibraryManagementDto dto=dao.payAmount(id, amount);
		if(dto==null)
		{
			throw new LibraryManagementException("data not found");
		}
		return dto;
	}

	@Override
	public HashMap<String, LibraryManagementDto> viewAll() {
		// TODO Auto-generated method stub
		return dao.viewAll();
	}
	@Override
	public boolean validateMoney(String money) throws LibraryManagementException {
		// TODO Auto-generated method stub
		if(!(money.matches("\\d+")))
		{
			throw new LibraryManagementException("please enter correct amount to add");
		}
		return true;
	}
	
}
