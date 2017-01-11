package com.java2.web.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java2.web.Dto.AddressDto;
import com.java2.web.Service.AddressService;

@RestController
@RequestMapping(path = "/address")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	
	
	public AddressService getAddressService() {
		return addressService;
	}

	public void setAddressService(AddressService addressService) {
		this.addressService = addressService;
	}

	//���ҵ���
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public AddressDto getAddress(@PathVariable() long id){
		return addressService.getAddress(id);
	}
	
	//���Ҷ��
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public List<AddressDto> getAllAddress() {
		return addressService.getAllAddresses();
	}
	
	//����
	@RequestMapping(path = "/", method = RequestMethod.PUT)
	public AddressDto createAddress(@RequestBody AddressDto addressDto) {
		return addressService.createAddress(addressDto);
	}
	
	//ɾ��
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public AddressDto removeAddress(@PathVariable() long id){
		return addressService.removeAddress(id);
	}
	
	//����
	@RequestMapping(path = "/{id}", method = RequestMethod.PATCH)
	public AddressDto refreshAddress(@PathVariable() long id1, long id2, @RequestBody AddressDto address){
		return addressService.refreshAddress(id1, id2, address);
	}
}
