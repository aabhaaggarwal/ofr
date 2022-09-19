package com.cg.ofr.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.ofr.entities.Landlord;
import com.cg.ofr.entities.Tenant;
import com.cg.ofr.exception.LandlordNotFoundException;
import com.cg.ofr.exception.TenantNotFoundException;
import com.cg.ofr.repository.ILandlordRepository;
import com.cg.ofr.repository.ITenantRepository;

@SpringBootTest
 class IUserServiceTest {

	@InjectMocks
	IUserServiceImpl iUserServiceImpl = new IUserServiceImpl();

	@Mock
	ITenantRepository iTenantRepository;

	@Mock
	ILandlordRepository iLandlordRepository;

	@Test
	 void testValidateTenant() {

		Tenant tenant = new Tenant();
		tenant.setUserId(1);
		tenant.setUsername("Rohan");
		tenant.setPassword("1234");
		tenant.setTenantName("Rohan Sharma");
		tenant.setAge(30);
		tenant.setEmail("rohan@gmail.com");
		tenant.setMobile("9874598398");
		tenant.setPermanentAddr("GT Road");

		when(iTenantRepository.findByUsernameAndPassword("Rohan", "1234")).thenReturn(tenant);

		Tenant tenantObj = iUserServiceImpl.validateTenant("Rohan", "1234");

		assertEquals("Rohan", tenantObj.getUsername());
		assertEquals("1234", tenantObj.getPassword());

	}

	@Test
	 void testValidateTenantException() {
		when(iTenantRepository.findByUsernameAndPassword("Rahul", "9876")).thenThrow(TenantNotFoundException.class);
		assertThrows(TenantNotFoundException.class, () -> iUserServiceImpl.validateTenant("Rohan", "1234"));
	}

	@Test
	 void testValidateLandlord() {

		Landlord landlord = new Landlord();
		landlord.setUserId(1);
		landlord.setUsername("Rohan");
		landlord.setPassword("1234");
		landlord.setLandlordName("Rohan Sharma");
		landlord.setAge(30);
		landlord.setEmail("rohan@gmail.com");
		landlord.setMobile("9874598398");

		when(iLandlordRepository.findByUsernameAndPassword("Rohan", "1234")).thenReturn(landlord);

		Landlord landlordObj = iUserServiceImpl.validateLandlord("Rohan", "1234");

		assertEquals("Rohan", landlordObj.getUsername());
		assertEquals("1234", landlordObj.getPassword());

	}

	@Test
	 void testValidateLandlordException() {
		when(iLandlordRepository.findByUsernameAndPassword("Rahul", "9876")).thenThrow(LandlordNotFoundException.class);
		assertThrows(LandlordNotFoundException.class, () -> iUserServiceImpl.validateLandlord("Rohan", "1234"));
	}

	@Test
	 void testvalidateNewLandlord() {

		Landlord landlord = new Landlord();
		landlord.setUserId(1);
		landlord.setUsername("Rohan");
		landlord.setPassword("1234");
		landlord.setLandlordName("Rohan Sharma");
		landlord.setAge(30);
		landlord.setEmail("rohan@gmail.com");
		landlord.setMobile("9874598398");

		when(iLandlordRepository.findByUsername(landlord.getUsername())).thenReturn(null);
		when(iLandlordRepository.save(ArgumentMatchers.any(Landlord.class))).thenReturn(landlord);
		Landlord newLandlord = iUserServiceImpl.validateNewLandlord(landlord);

		verify(iLandlordRepository).save(newLandlord);

	}

	@Test
	 void testvalidateNewLandlordException() {

		Landlord landlord = new Landlord();
		landlord.setUserId(1);
		landlord.setUsername("Rohan");
		landlord.setPassword("1234");
		landlord.setLandlordName("Rohan Sharma");
		landlord.setAge(30);
		landlord.setEmail("rohan@gmail.com");
		landlord.setMobile("9874598398");

		when(iLandlordRepository.findByUsername("Rohan")).thenThrow(LandlordNotFoundException.class);
		assertThrows(LandlordNotFoundException.class, () -> iUserServiceImpl.validateNewLandlord(landlord));
	}

	@Test
	 void testvalidateNewTenant() {
		Tenant tenant = new Tenant();
		tenant.setUserId(1);
		tenant.setUsername("Rohan");
		tenant.setPassword("1234");
		tenant.setTenantName("Rohan Sharma");
		tenant.setAge(30);
		tenant.setEmail("rohan@gmail.com");
		tenant.setMobile("9874598398");
		tenant.setPermanentAddr("GT Road");

		when(iTenantRepository.findByUsername(tenant.getUsername())).thenReturn(null);
		when(iTenantRepository.save(ArgumentMatchers.any(Tenant.class))).thenReturn(tenant);
		Tenant newTenant = iUserServiceImpl.validateNewTenant(tenant);

		verify(iTenantRepository).save(newTenant);

	}

	@Test
	 void testvalidateNewTenantException() {
		Tenant tenant = new Tenant();
		tenant.setUserId(1);
		tenant.setUsername("Rohan");
		tenant.setPassword("1234");
		tenant.setTenantName("Rohan Sharma");
		tenant.setAge(30);
		tenant.setEmail("rohan@gmail.com");
		tenant.setMobile("9874598398");
		tenant.setPermanentAddr("GT Road");

		when(iTenantRepository.findByUsername("Rohan")).thenThrow(TenantNotFoundException.class);
		assertThrows(TenantNotFoundException.class, () -> iUserServiceImpl.validateNewTenant(tenant));
	}

	@Test
	 void testUpdateLandlordPassword() {

		Landlord landlord = new Landlord();
		landlord.setUserId(1);
		landlord.setUsername("Rohan");
		landlord.setPassword("1234");
		landlord.setLandlordName("Rohan Sharma");
		landlord.setAge(30);
		landlord.setEmail("rohan@gmail.com");
		landlord.setMobile("9874598398");

		Optional<Landlord> optionalLandlord = Optional.of(landlord);

		when(iLandlordRepository.findById(1)).thenReturn(optionalLandlord);

		iUserServiceImpl.updateLandlordPassword(landlord);

		verify(iLandlordRepository).save(landlord);

	}

	@Test
	 void testUpdateLandlordPasswordException() {

		Landlord landlord2 = new Landlord();
		landlord2.setUserId(1);
		landlord2.setUsername("Angad");
		landlord2.setPassword("1234");
		landlord2.setLandlordName("Angad Bhatia");
		landlord2.setAge(30);
		landlord2.setEmail("angad@gmail.com");
		landlord2.setMobile("9876798398");

		when(iLandlordRepository.findById(1)).thenThrow(LandlordNotFoundException.class);
		assertThrows(LandlordNotFoundException.class, () -> iUserServiceImpl.updateLandlordPassword(landlord2));

	}

	@Test
	 void testUpdateTenantPassword() {

		Tenant tenant = new Tenant();
		tenant.setUserId(1);
		tenant.setUsername("Rohan");
		tenant.setPassword("1234");
		tenant.setTenantName("Rohan Sharma");
		tenant.setAge(30);
		tenant.setEmail("rohan@gmail.com");
		tenant.setMobile("9874598398");
		tenant.setPermanentAddr("GT Road");

		Optional<Tenant> optionalTenant = Optional.of(tenant);

		when(iTenantRepository.findById(1)).thenReturn(optionalTenant);

		iUserServiceImpl.updateTenantPassword(tenant);

		verify(iTenantRepository).save(tenant);

	}

	@Test
	 void testUpdateTenantPasswordException() {
		Tenant tenant = new Tenant();
		tenant.setUserId(1);
		tenant.setUsername("Rahul");
		tenant.setPassword("8765");
		tenant.setTenantName("Rahul Sharma");
		tenant.setAge(30); 
		tenant.setEmail("rahul@gmail.com");
		tenant.setMobile("9874598399");
		tenant.setPermanentAddr("Taran Road");

		when(iTenantRepository.findById(1)).thenThrow(TenantNotFoundException.class);
		assertThrows(TenantNotFoundException.class, () -> iUserServiceImpl.updateTenantPassword(tenant));

	}

}
