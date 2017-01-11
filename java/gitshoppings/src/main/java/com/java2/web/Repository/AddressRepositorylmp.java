package com.java2.web.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.java2.web.Entity.Address;

@Repository
public class AddressRepositorylmp implements AddressRepository {
	
	@PersistenceContext
	EntityManager manager;

	public Address addAddress(Address address) {
		manager.persist(address);
		return address;
	}
	
	public Address findAddress(long id) {
		return manager.createQuery("from Address where userId=" + id, Address.class).getSingleResult();
	}

	public List<Address> findAllAddress() {
		List<Address> list = null;
		try{
			list = manager.createQuery("from Address", Address.class).getResultList();
		}catch(Exception e){
			System.out.println("wokaoAddress");
		}
		return  list;
	}

	public Address deleteAddress(long id1) {
		Address address = manager.createQuery("from Address where userId = " + id1, Address.class).getSingleResult();
		manager.remove(address);
		return address;
	}

	public Address updateAddress(long id1, long id2, Address address1) {
		Address address = manager.createQuery("from Address where userId = " + id1+"and id2 ="+ id2, Address.class).getSingleResult();
		address.setId(address1.getId());
		address.setAddress(address1.getAddress());
		address.setId(address1.getId());
		address.setTelphone(address.getTelphone());
		address.setIsDefault(address1.getIsDefault());
		manager.merge(address);
		return address;
	}
}
