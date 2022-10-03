package com.cg.ofr.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.ofr.entities.Admin;

import com.cg.ofr.exception.AdminNotFoundException;

import com.cg.ofr.repository.IAdminRepository;

@SpringBootTest
 class IAdminServiceTest {

	@InjectMocks
	IAdminServiceImpl iAdminServiceImpl = new IAdminServiceImpl();

	@Mock
	IAdminRepository iAdminRepository;

	@Test
	 void testValidateAdmin() {

		Admin admin = new Admin();
		admin.setAdminName("Ram Gopal");
		admin.setUsername("Ram");
		admin.setPassword("1234");

		when(iAdminRepository.findByUsernameAndPassword("Ram", "1234")).thenReturn(admin);

		iAdminServiceImpl.validateAdmin("Ram", "1234");

	}

	@Test
	 void testValidateAdminException() {
		when(iAdminRepository.findByUsernameAndPassword("Rahul", "9876")).thenThrow(AdminNotFoundException.class);
		assertThrows(AdminNotFoundException.class, () -> iAdminServiceImpl.validateAdmin("Rohan", "1234"));
	}

//	@Test
//	 void testUpdateAdminPassword() {
//
//		Admin admin = new Admin();
//		admin.setAdminName("Ram Gopal");
//		admin.setUsername("Ram");
//		admin.setPassword("1234");
//
//		Optional<Admin> optionalAdmin = Optional.of(admin);
//
//		when(iAdminRepository.findById(admin.getUsername())).thenReturn(optionalAdmin);
//
//		iAdminServiceImpl.updateAdminPassword(admin);
//
//		verify(iAdminRepository).save(admin);
//
//	}

//	@Test
//	 void testUpdateLandlordPasswordException() {
//
//		Admin admin = new Admin();
//		admin.setAdminName("Ram Gopal");
//		admin.setUsername("Ram");
//		admin.setPassword("1234");
//
//		when(iAdminRepository.findById(admin.getUsername())).thenThrow(AdminNotFoundException.class);
//		assertThrows(AdminNotFoundException.class, () -> iAdminServiceImpl.updateAdminPassword(admin));
//
//	}

	@Test
	 void testaddAdmin() {
		Admin admin = new Admin();
		admin.setAdminName("Ram Gopal");
		admin.setUsername("Ram");
		admin.setPassword("1234");

		when(iAdminRepository.save(ArgumentMatchers.any(Admin.class))).thenReturn(admin);
		iAdminServiceImpl.addAdmin(admin);

		verify(iAdminRepository).save(admin);

	}

}
