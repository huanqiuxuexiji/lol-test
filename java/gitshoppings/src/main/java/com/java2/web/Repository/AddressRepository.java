package com.java2.web.Repository;

import java.util.List;

import com.java2.web.Entity.Address;

public interface AddressRepository {
	
	public Address addAddress(Address address);
	
	public List<Address> findAllAddress();
	
	public Address deleteAddress(long id);
	
	public Address updateAddress(long id1, long id2, Address address);

	public Address findAddress(long id);
	
}
