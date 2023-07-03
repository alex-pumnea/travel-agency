//package com.amsoftacademy.touristsheet.adapter.in.rest.controller;
//
//import com.amsoftacademy.touristsheet.adapter.in.rest.dto.*;
//import com.amsoftacademy.touristsheet.application.TouristSheetService;
//import com.amsoftacademy.touristsheet.domain.TouristSheet;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.Arrays;
//
//import static com.amsoftacademy.touristsheet.domain.Relationship.SPOUSE;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
///**
// * @author Alex Pumnea
// */
//@WebMvcTest(TouristSheetController.class)
//class TouristSheetControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private TouristSheetService<TouristSheetRequest, TouristSheet> service;
//
//    @Test
//    void testSave() throws Exception {
//        CustomerDto customerDto = new CustomerDto("John",
//                "Doe",
//                "johndoe@example.com",
//                "123456789",
//                "USA");
//        AddressDto addressDto = new AddressDto(
//                "123 Main St",
//                "New York",
//                "12345",
//                "United States",
//                "US"
//        );
//        TravelInfoDto travelInfoDto = new TravelInfoDto(
//                LocalDateTime.of(2023, 7, 1),
//                LocalDate.of(2023, 7, 10),
//                "ABC123",
//                Arrays.asList("Location 1", "Location 2", "Location 3")
//        );
//        EmergencyContactDto emergencyContactDto = new EmergencyContactDto(
//                "Jane",
//                "Doe",
//                SPOUSE,
//                "987654321"
//        );
//        // Create a sample TouristSheetRequest
//        TouristSheetRequest request = TouristSheetRequest.builder()
//                .customer(customerDto)
//                .address(addressDto)
//                .travelInfo(travelInfoDto)
//                .emergencyContact(emergencyContactDto)
//                .build();
//        // Set the necessary properties of the request
//
//        // Create a sample TouristSheet to be returned by the service
//        TouristSheet savedTouristSheet = new TouristSheet();
//        // Set any necessary properties of the savedTouristSheet
//
//        // Mock the service.save() method to return the saved TouristSheet
//        when(service.save(any(TouristSheetRequest.class))).thenReturn(savedTouristSheet);
//
//        // Perform the POST request with the sample request JSON
//        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/tourist-sheet")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(asJsonString(request)))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
//        // Add more assertions if needed to validate the response
//    }
//
//    // Utility method to convert an object to JSON string
//    private static String asJsonString(Object obj) {
//        try {
//            return new ObjectMapper().writeValueAsString(obj);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//}