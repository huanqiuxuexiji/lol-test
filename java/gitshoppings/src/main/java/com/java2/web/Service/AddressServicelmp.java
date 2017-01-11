package com.java2.web.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java2.web.Dto.AddressDto;
import com.java2.web.Entity.Address;
import com.java2.web.Repository.AddressRepository;

@Service
public class AddressServicelmp implements AddressService {

	@Autowired
	private AddressRepository addressRepository;

	public AddressDto getAddress(long id) {
		return convertToDTO(addressRepository.findAddress(id));
	}

	public List<AddressDto> getAllAddresses() {
		List<AddressDto> addresses = null;
		addresses = new ArrayList<AddressDto>();
		List<Address> list = addressRepository.findAllAddress();
		for (Address address : list) {
			addresses.add(convertToDTO(address));
		}
		return addresses;
	}

	public AddressDto removeAddress(long id) {
		return convertToDTO(addressRepository.deleteAddress(id));
	}

	public AddressDto createAddress(AddressDto address) {
		return convertToDTO(addressRepository.addAddress(convertToEntity(address)));
	}

	public AddressDto refreshAddress(long id1, long id2, AddressDto address) {
		return convertToDTO(addressRepository.updateAddress(id1, id2, convertToEntity(address)));
	}

	private static AddressDto convertToDTO(Address address) {
		AddressDto addressDto = new AddressDto();

		addressDto.setId(address.getId());
		addressDto.setAddress(address.getAddress());
		addressDto.setIsDefault(address.getIsDefault());
		addressDto.setTelphone(address.getTelphone());
		return addressDto;
	}

	private static Address convertToEntity(AddressDto addressDto) {
		Address address = new Address();

		address.setAddress(addressDto.getAddress());
		address.setIsDefault(addressDto.getIsDefault());
		address.setTelphone(addressDto.getTelphone());
		address.setUser(addressDto.getUser());

		return address;
	}

}
