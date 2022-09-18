package com.cg.ofr.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.ofr.entities.Flat;
import com.cg.ofr.entities.FlatAddress;
import com.cg.ofr.entities.FlatBooking;
import com.cg.ofr.entities.Landlord;
import com.cg.ofr.entities.Tenant;
import com.cg.ofr.exception.FlatBookingNotFoundException;
import com.cg.ofr.repository.IFlatBookingRepository;
import com.cg.ofr.repository.IFlatRepository;
import com.cg.ofr.repository.ITenantRepository;

@SpringBootTest
public class FlatBookingServiceTest {
	
	@InjectMocks
	IFlatBookingServiceImpl iFlatBookingServiceImpl = new IFlatBookingServiceImpl();
	
	@Mock
	IFlatBookingRepository iFlatBookingRepository;
	
	@Mock
	private IFlatRepository iFlatRepository;
	
	@Mock
	private ITenantRepository iTenantRepository;
	
	@Test
	public void testAddFlatBooking() {
		Tenant tenant = new Tenant();
		tenant.setUserId("TEN1");
		tenant.setAge(35);
		tenant.setEmail("veena@gmail.com");
		tenant.setGender("Female");
		tenant.setMobile("9807654234");
		tenant.setPassword("veena123");
		tenant.setTenantName("Veena Sharma");
		tenant.setUsername("veenasharma");
		tenant.setPermanentAddr("");
		
		Landlord landlord = new Landlord();
		landlord.setUserId("LAN1");
		landlord.setUsername("rajkumar");
		landlord.setPassword("rajk123");
		landlord.setAge(45);
		landlord.setEmail("raj@gmail.com");
		landlord.setMobile("9867542134");
		
		FlatAddress flatAddress = new FlatAddress();
		flatAddress.setAddressId("FAD1");
		flatAddress.setHouseNo(4);
		flatAddress.setBuilding("VK Tower");
		flatAddress.setStreet("Lawrence Road");
		flatAddress.setCity("Pune");
		flatAddress.setState("Maharashtra");
		flatAddress.setPincode(110001);
		flatAddress.setCountry("India");
		
		Flat flat = new Flat();
		flat.setFlatId("FLA1");
		flat.setAvailability("Available");
		flat.setCost(45000);
		flat.setFlatType("2BHK");
		flat.setFlatAddress(flatAddress);
		flat.setLandlord(landlord);
		
		FlatBooking flatBooking = new FlatBooking();
		flatBooking.setBookingNo("N1");
		flatBooking.setBookingFrom(LocalDate.of(2022, 07, 01));
		flatBooking.setBookingTo(LocalDate.of(2022, 10, 30));
		flatBooking.setMembers(4);
		flatBooking.setFlat(flat);
		flatBooking.setTenant(tenant); 
	  
		
		Optional<Flat> optionalFlat = Optional.of(flat);
       Optional<Tenant> optionalTenant = Optional.of(tenant);

        when(iFlatRepository.findById("FLA1")).thenReturn(optionalFlat);
	    when(iTenantRepository.findById("TEN1")).thenReturn(optionalTenant);
	    when(iFlatBookingRepository.save(ArgumentMatchers.any(FlatBooking.class))).thenReturn(flatBooking);
		
		 FlatBooking flatBookingObj = iFlatBookingServiceImpl.addFlatBooking(flatBooking);
	    
	    assertEquals("N1",flatBookingObj.getBookingNo());
	    verify(iFlatBookingRepository).save(flatBooking);
	}
	
	@Test
	public void testViewFlatBooking() {
		Tenant tenant = new Tenant();
		tenant.setUserId("TEN1");
		tenant.setAge(35);
		tenant.setEmail("veena@gmail.com");
		tenant.setGender("Female");
		tenant.setMobile("9807654234");
		tenant.setPassword("veena123");
		tenant.setTenantName("Veena Sharma");
		tenant.setUsername("veenasharma");
		tenant.setPermanentAddr("");
		
		Landlord landlord = new Landlord();
		landlord.setUserId("LAN1");
		landlord.setUsername("rajkumar");
		landlord.setPassword("rajk123");
		landlord.setAge(45);
		landlord.setEmail("raj@gmail.com");
		landlord.setMobile("9867542134");
		
		FlatAddress flatAddress = new FlatAddress();
		flatAddress.setAddressId("FAD1");
		flatAddress.setHouseNo(4);
		flatAddress.setBuilding("VK Tower");
		flatAddress.setStreet("Lawrence Road");
		flatAddress.setCity("Pune");
		flatAddress.setState("Maharashtra");
		flatAddress.setPincode(110001);
		flatAddress.setCountry("India");
		
		Flat flat = new Flat();
		flat.setFlatId("FLA1");
		flat.setAvailability("Available");
		flat.setCost(45000);
		flat.setFlatType("2BHK");
		flat.setFlatAddress(flatAddress);
		flat.setLandlord(landlord);
		
		FlatBooking flatBooking = new FlatBooking();
		flatBooking.setBookingNo("N1");
		flatBooking.setBookingFrom(LocalDate.of(2022, 07, 01));
		flatBooking.setBookingTo(LocalDate.of(2022, 10, 30));
		flatBooking.setMembers(4);
		flatBooking.setFlat(flat);
		flatBooking.setTenant(tenant);
		
		Optional<FlatBooking> optionalFlatBooking = Optional.of(flatBooking);
		when(iFlatBookingRepository.findById("N1")).thenReturn(optionalFlatBooking);
		
		FlatBooking viewflatBooking = iFlatBookingServiceImpl.viewFlatBooking("N1");
		assertEquals(4,viewflatBooking.getMembers());
	    assertEquals("FLA1",viewflatBooking.getFlat().getFlatId());
	}
	
	@Test
	public void testViewFlatBookingException() {
		when(iFlatBookingRepository.findById("N1")).thenThrow(FlatBookingNotFoundException.class);

        assertThrows(FlatBookingNotFoundException.class,()->iFlatBookingServiceImpl.viewFlatBooking("N1"));
	}
	
	 @Test
	    public void testViewAllFlatBooking() {
		 Tenant tenant = new Tenant();
			tenant.setUserId("TEN1");
			tenant.setAge(35);
			tenant.setEmail("veena@gmail.com");
			tenant.setGender("Female");
			tenant.setMobile("9807654234");
			tenant.setPassword("veena123");
			tenant.setTenantName("Veena Sharma");
			tenant.setUsername("veenasharma");
			tenant.setPermanentAddr("");
			
			Landlord landlord = new Landlord();
			landlord.setUserId("LAN1");
			landlord.setUsername("rajkumar");
			landlord.setPassword("rajk123");
			landlord.setAge(45);
			landlord.setEmail("raj@gmail.com");
			landlord.setMobile("9867542134");
			
			FlatAddress flatAddress = new FlatAddress();
			flatAddress.setAddressId("FAD1");
			flatAddress.setHouseNo(4);
			flatAddress.setBuilding("VK Tower");
			flatAddress.setStreet("Lawrence Road");
			flatAddress.setCity("Pune");
			flatAddress.setState("Maharashtra");
			flatAddress.setPincode(110001);
			flatAddress.setCountry("India");
			
			Flat flat = new Flat();
			flat.setFlatId("FLA1");
			flat.setAvailability("Available");
			flat.setCost(45000);
			flat.setFlatType("2BHK");
			flat.setFlatAddress(flatAddress);
			flat.setLandlord(landlord);
			
			FlatBooking flatBooking = new FlatBooking();
			flatBooking.setBookingNo("N1");
			flatBooking.setBookingFrom(LocalDate.of(2022, 07, 01));
			flatBooking.setBookingTo(LocalDate.of(2022, 10, 30));
			flatBooking.setMembers(4);
			flatBooking.setFlat(flat);
			flatBooking.setTenant(tenant);
			
	        List<FlatBooking> flatBookings = new ArrayList<>();
	        flatBookings.add(flatBooking);

	        when(iFlatBookingRepository.findAll()).thenReturn(flatBookings);

	        List<FlatBooking> expected = iFlatBookingServiceImpl.viewAllFlatBooking();

	        assertEquals(expected, flatBookings);
	        verify(iFlatBookingRepository).findAll();
	    }
	
	@Test
	public void testViewAllFlatBookingException() {
		when(iFlatBookingRepository.findAll()).thenThrow(FlatBookingNotFoundException.class);
        assertThrows(FlatBookingNotFoundException.class,()->iFlatBookingServiceImpl.viewAllFlatBooking());
	}
	
	 @Test
	    public void testDeleteFlatBooking(){
		 Tenant tenant = new Tenant();
			tenant.setUserId("TEN1");
			tenant.setAge(35);
			tenant.setEmail("veena@gmail.com");
			tenant.setGender("Female");
			tenant.setMobile("9807654234");
			tenant.setPassword("veena123");
			tenant.setTenantName("Veena Sharma");
			tenant.setUsername("veenasharma");
			tenant.setPermanentAddr("");
			
			Landlord landlord = new Landlord();
			landlord.setUserId("LAN1");
			landlord.setUsername("rajkumar");
			landlord.setPassword("rajk123");
			landlord.setAge(45);
			landlord.setEmail("raj@gmail.com");
			landlord.setMobile("9867542134");
			
			FlatAddress flatAddress = new FlatAddress();
			flatAddress.setAddressId("FAD1");
			flatAddress.setHouseNo(4);
			flatAddress.setBuilding("VK Tower");
			flatAddress.setStreet("Lawrence Road");
			flatAddress.setCity("Pune");
			flatAddress.setState("Maharashtra");
			flatAddress.setPincode(110001);
			flatAddress.setCountry("India");
			
			Flat flat = new Flat();
			flat.setFlatId("FLA1");
			flat.setAvailability("Available");
			flat.setCost(45000);
			flat.setFlatType("2BHK");
			flat.setFlatAddress(flatAddress);
			flat.setLandlord(landlord);
			
			FlatBooking flatBooking = new FlatBooking();
			flatBooking.setBookingNo("N1");
			flatBooking.setBookingFrom(LocalDate.of(2022, 07, 01));
			flatBooking.setBookingTo(LocalDate.of(2022, 10, 30));
			flatBooking.setMembers(4);
			flatBooking.setFlat(flat);
			flatBooking.setTenant(tenant);

	        when(iFlatBookingRepository.findById("N1")).thenReturn(Optional.of(flatBooking));
	        
	        iFlatBookingServiceImpl.deleteFlatBooking("N1");
	        verify(iFlatBookingRepository).deleteById("N1");
	    }
	
	 @Test
		public void testDeleteFlatBookingException() {
			when(iFlatBookingRepository.findById("N1")).thenThrow(FlatBookingNotFoundException.class);
	        assertThrows(FlatBookingNotFoundException.class,()->iFlatBookingServiceImpl.deleteFlatBooking("N1"));
		}
	 
	    @Test
	    public void testUpdateFlatBooking()  {
	    	 Tenant tenant = new Tenant();
				tenant.setUserId("TEN1");
				tenant.setAge(35);
				tenant.setEmail("veena@gmail.com");
				tenant.setGender("Female");
				tenant.setMobile("9807654234");
				tenant.setPassword("veena123");
				tenant.setTenantName("Veena Sharma");
				tenant.setUsername("veenasharma");
				tenant.setPermanentAddr("");
				
				Landlord landlord = new Landlord();
				landlord.setUserId("LAN1");
				landlord.setUsername("rajkumar");
				landlord.setPassword("rajk123");
				landlord.setAge(45);
				landlord.setEmail("raj@gmail.com");
				landlord.setMobile("9867542134");
				
				FlatAddress flatAddress = new FlatAddress();
				flatAddress.setAddressId("FAD1");
				flatAddress.setHouseNo(4);
				flatAddress.setBuilding("VK Tower");
				flatAddress.setStreet("Lawrence Road");
				flatAddress.setCity("Pune");
				flatAddress.setState("Maharashtra");
				flatAddress.setPincode(110001);
				flatAddress.setCountry("India");
				
				Flat flat = new Flat();
				flat.setFlatId("FLA1");
				flat.setAvailability("Available");
				flat.setCost(45000);
				flat.setFlatType("2BHK");
				flat.setFlatAddress(flatAddress);
				flat.setLandlord(landlord);
				
				FlatBooking flatBooking = new FlatBooking();
				flatBooking.setBookingNo("N1");
				flatBooking.setBookingFrom(LocalDate.of(2022, 07, 01));
				flatBooking.setBookingTo(LocalDate.of(2022, 10, 30));
				flatBooking.setMembers(4);
				flatBooking.setFlat(flat);
				flatBooking.setTenant(tenant);
	        
				FlatBooking flatBooking1 = new FlatBooking();
				flatBooking1.setBookingNo("N1");
				flatBooking1.setBookingFrom(LocalDate.of(2022, 07, 01));
				flatBooking1.setBookingTo(LocalDate.of(2022, 10, 30));
				flatBooking1.setMembers(5);
				flatBooking1.setFlat(flat);
				flatBooking1.setTenant(tenant);

			when( iFlatBookingRepository.findById(flatBooking1.getBookingNo())).thenReturn(Optional.of(flatBooking));
	        when( iFlatBookingRepository.save(flatBooking1)).thenReturn(flatBooking1);
	        FlatBooking updatedFlatBooking=iFlatBookingServiceImpl.updateFlatBooking(flatBooking1);
	        assertEquals(flatBooking1,updatedFlatBooking);
	        
	    }
	    
	    @Test
	    public void testUpdateFlatBookingException() {
	    	
	    	Tenant tenant = new Tenant();
			tenant.setUserId("TEN1");
			tenant.setAge(35);
			tenant.setEmail("veena@gmail.com");
			tenant.setGender("Female");
			tenant.setMobile("9807654234");
			tenant.setPassword("veena123");
			tenant.setTenantName("Veena Sharma");
			tenant.setUsername("veenasharma");
			tenant.setPermanentAddr("");
			
			Landlord landlord = new Landlord();
			landlord.setUserId("LAN1");
			landlord.setUsername("rajkumar");
			landlord.setPassword("rajk123");
			landlord.setAge(45);
			landlord.setEmail("raj@gmail.com");
			landlord.setMobile("9867542134");
			
			FlatAddress flatAddress = new FlatAddress();
			flatAddress.setAddressId("FAD1");
			flatAddress.setHouseNo(4);
			flatAddress.setBuilding("VK Tower");
			flatAddress.setStreet("Lawrence Road");
			flatAddress.setCity("Pune");
			flatAddress.setState("Maharashtra");
			flatAddress.setPincode(110001);
			flatAddress.setCountry("India");
			
			Flat flat = new Flat();
			flat.setFlatId("FLA1");
			flat.setAvailability("Available");
			flat.setCost(45000);
			flat.setFlatType("2BHK");
			flat.setFlatAddress(flatAddress);
			flat.setLandlord(landlord);
			
			FlatBooking flatBooking = new FlatBooking();
			flatBooking.setBookingNo("N1");
			flatBooking.setBookingFrom(LocalDate.of(2022, 07, 01));
			flatBooking.setBookingTo(LocalDate.of(2022, 10, 30));
			flatBooking.setMembers(4);
			flatBooking.setFlat(flat);
			flatBooking.setTenant(tenant);
        
			FlatBooking flatBooking1 = new FlatBooking();
			flatBooking1.setBookingNo("N1");
			flatBooking1.setBookingFrom(LocalDate.of(2022, 07, 01));
			flatBooking1.setBookingTo(LocalDate.of(2022, 10, 30));
			flatBooking1.setMembers(5);
			flatBooking1.setFlat(flat);
			flatBooking1.setTenant(tenant);
			
			when(iFlatBookingRepository.findById("N1")).thenThrow(FlatBookingNotFoundException.class);
	        assertThrows(FlatBookingNotFoundException.class,()->iFlatBookingServiceImpl.updateFlatBooking(flatBooking1));
	    	
	    }
	    
}


