package com.cg.ofr.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.ofr.entities.Tenant;
import com.cg.ofr.exception.TenantNotFoundException;
import com.cg.ofr.repository.ITenantRepository;

@SpringBootTest
public class ITenantServiceTest {

	@InjectMocks
	ITenantServiceImpl iTenantServiceImpl = new ITenantServiceImpl();

	@Mock
	ITenantRepository iTenantRepository;

	@Test
	public void testViewITenantById() {

		Tenant tenant = new Tenant();
		tenant.setUserId("TEN4");
		tenant.setUsername("Arshi123");
		tenant.setPassword("arshi435");
		tenant.setTenantName("Arshi");
		tenant.setMobile("999654398");
		tenant.setAge(33);
		tenant.setGender("female");
		tenant.setEmail("arshi@123");

		Optional<Tenant> optionalTenant = Optional.of(tenant);

		when(iTenantRepository.findById("TEN4")).thenReturn(optionalTenant);

		Tenant tenantObj = iTenantServiceImpl.viewTenant("TEN4");

		assertEquals("Arshi", tenantObj.getTenantName());
		assertEquals("arshi435", tenantObj.getPassword());
	}

	@Test
	public void testViewTenantByIdException() {
		when(iTenantRepository.findById("TEN5")).thenThrow(TenantNotFoundException.class);

		assertThrows(TenantNotFoundException.class, () -> iTenantServiceImpl.viewTenant("TEN5"));
	}

	@Test
	public void testViewAllTenants() {

		Tenant tenant = new Tenant();
		tenant.setTenantName("Megha");
		tenant.setUserId("TEN6");
		tenant.setAge(22);
		tenant.setEmail("megha@123");
		tenant.setGender("female");
		tenant.setMobile("9994746352");
		tenant.setPassword("megha1234");
		tenant.setPermanentAddr("pune");
		tenant.setUsername("Megha123");

		Tenant tenant2 = new Tenant();
		tenant2.setTenantName("Ravi");
		tenant2.setUserId("TEN7");
		tenant2.setAge(25);
		tenant2.setEmail("ravi@123");
		tenant2.setGender("male");
		tenant2.setMobile("9734746352");
		tenant2.setPassword("ravi1234");
		tenant2.setPermanentAddr("mumbai");
		tenant2.setUsername("ravi123");

		Tenant tenant3 = new Tenant();
		tenant3.setTenantName("Janvi");
		tenant3.setUserId("TEN8");
		tenant3.setAge(20);
		tenant3.setEmail("janvi@123");
		tenant3.setGender("female");
		tenant3.setMobile("9739946352");
		tenant3.setPassword("janvi1234");
		tenant3.setPermanentAddr("nagpur");
		tenant3.setUsername("janvi123");

		List<Tenant> tenantList = new ArrayList<>();
		tenantList.add(tenant);
		tenantList.add(tenant2);
		tenantList.add(tenant3);

		when(iTenantRepository.findAll()).thenReturn(tenantList);

		List<Tenant> tenants = iTenantServiceImpl.viewAllTenant();

		assertEquals(3, tenants.size());
	}

	@Test
	public void testViewAllTenantByIdException() {
		when(iTenantRepository.findAll()).thenThrow(TenantNotFoundException.class);

		assertThrows(TenantNotFoundException.class, () -> iTenantServiceImpl.viewAllTenant());
	}

	@Test
	public void testDeleteTenant() {

		Tenant tenant = new Tenant();
		tenant.setTenantName("Megha");
		tenant.setUserId("TEN6");
		tenant.setAge(22);
		tenant.setEmail("megha@123");
		tenant.setGender("female");
		tenant.setMobile("9994746352");
		tenant.setPassword("megha1234");
		tenant.setPermanentAddr("pune");
		tenant.setUsername("Megha123");

		Optional<Tenant> optionalTenant = Optional.of(tenant);

		when(iTenantRepository.findById("Megha")).thenReturn(optionalTenant);

		doNothing().when(iTenantRepository).deleteById("Megha");

		iTenantServiceImpl.deleteTenant("Megha");

		verify(iTenantRepository, times(1)).findById("Megha");
		verify(iTenantRepository, times(1)).deleteById("Megha");
	}

	@Test
	public void testDeleteTenantByIdException() {
		when(iTenantRepository.findById("TEN6")).thenThrow(TenantNotFoundException.class);

		assertThrows(TenantNotFoundException.class, () -> iTenantServiceImpl.deleteTenant("TEN6"));
	}

	@Test
	public void testUpdateTenant() {

		Tenant tenant = new Tenant();
		tenant.setTenantName("Ravi");
		tenant.setUserId("TEN7");
		tenant.setAge(22);
		tenant.setEmail("ravi@123");
		tenant.setGender("male");
		tenant.setMobile("9990046352");
		tenant.setPassword("ravi1234");
		tenant.setPermanentAddr("pune");
		tenant.setUsername("Ravi123");

		Tenant newTenant = new Tenant();
		newTenant.setTenantName("Rishi");
		newTenant.setUserId("TEN7");
		newTenant.setAge(22);
		newTenant.setEmail("ravi@123");
		newTenant.setGender("male");
		newTenant.setMobile("9990046352");
		newTenant.setPassword("ravi1234");
		newTenant.setPermanentAddr("pune");
		newTenant.setUsername("Ravi123");

		when(iTenantRepository.findById((newTenant.getUserId()))).thenReturn(Optional.of(tenant));
		when(iTenantRepository.save(newTenant)).thenReturn(newTenant);
		Tenant updatedTenant = iTenantServiceImpl.updateTenant(newTenant);
		assertEquals(newTenant, updatedTenant);
	}

	@Test
	public void testUpdateTenantByIdException() {
		Tenant tenant = new Tenant();
		tenant.setTenantName("Ravi");
		tenant.setUserId("TEN7");
		tenant.setAge(22);
		tenant.setEmail("ravi@123");
		tenant.setGender("male");
		tenant.setMobile("9990046352");
		tenant.setPassword("ravi1234");
		tenant.setPermanentAddr("pune");
		tenant.setUsername("Ravi123");

		Tenant newTenant = new Tenant();
		newTenant.setTenantName("Rishi");
		newTenant.setUserId("TEN7");
		newTenant.setAge(22);
		newTenant.setEmail("ravi@123");
		newTenant.setGender("male");
		newTenant.setMobile("9990046352");
		newTenant.setPassword("ravi1234");
		newTenant.setPermanentAddr("pune");
		newTenant.setUsername("Ravi123");

		when(iTenantRepository.findById(newTenant.getUserId())).thenThrow(TenantNotFoundException.class);
		assertThrows(TenantNotFoundException.class, () -> iTenantServiceImpl.updateTenant(tenant));
	}

	@Test
	public void testAddTenant() {
		Tenant tenant = new Tenant();
		tenant.setUserId("TEN1");
		tenant.setUsername("mayur123");
		tenant.setTenantName("Mayur");
		tenant.setAge(25);
		tenant.setEmail("mayur@1233");
		tenant.setGender("male");
		tenant.setMobile("9963023317");
		tenant.setPassword("mayurv123");
		tenant.setFlatBooking(null);
		tenant.setPermanentAddr("bhopal");
		when(iTenantRepository.save(ArgumentMatchers.any(Tenant.class))).thenReturn(tenant);
		Tenant updatedTenant = iTenantServiceImpl.addTenant(tenant);

		assertEquals(25, updatedTenant.getAge());
		verify(iTenantRepository).save(tenant);
	}
}
    




















