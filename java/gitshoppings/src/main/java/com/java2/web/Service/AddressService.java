package com.java2.web.Service;

import java.util.List;

import com.java2.web.Dto.AddressDto;

public interface AddressService {
	
	AddressDto getAddress(long id);

	List<AddressDto> getAllAddresses();

	AddressDto removeAddress(long id);

	AddressDto createAddress(AddressDto address);

	AddressDto refreshAddress(long id1, long id2, AddressDto address);
	
}	
