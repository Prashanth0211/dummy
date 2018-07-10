package com.cg.librarymanagement.dao;

import java.math.BigDecimal;
import java.util.HashMap;

import com.cg.librarymanagement.dto.LibraryManagementDto;
import com.cg.librarymanagement.exception.LibraryManagementException;


public class LibraryManagementDaoImpl implements ILibraryManagementDao{
	private static HashMap<String,LibraryManagementDto> students=null;
	static{
		students=new HashMap<>();
		LibraryManagementDto lm=new LibraryManagementDto();
		lm.setId("1234");
		lm.setName("sai");
		lm.setAmount("2000");
		LibraryManagementDto lm1=new LibraryManagementDto();
		lm1.setId("2345");
		lm1.setName("kiran");
		lm1.setAmount("1000");
		LibraryManagementDto lm2=new LibraryManagementDto();
		lm2.setId("3456");
		lm2.setName("balmur");
		lm2.setAmount("100");
		students.put(lm.getId(),lm);
		students.put(lm1.getId(),lm1);
		students.put(lm2.getId(),lm2);
	}
	@Override
	public LibraryManagementDto viewDetails(String id) {
		// TODO Auto-generated method stub
		LibraryManagementDto dto=students.get(id);
		if(dto!=null)
		{
			return dto;
		}
		return null;
	}

	@Override
	public LibraryManagementDto payAmount(String id, String amount) {
		// TODO Auto-generated method stub
		LibraryManagementDto dto=students.get(id);
		if(dto!=null)
		{
			double updateBal=Double.parseDouble(dto.getAmount())+Double.parseDouble(amount);
			String bal=String.valueOf(updateBal);
			dto.setAmount(bal);
			return dto;
		}
		return null;
	
	}

	@Override
	public HashMap<String, LibraryManagementDto> viewAll() {
		// TODO Auto-generated method stub
		return students;
	}

}
