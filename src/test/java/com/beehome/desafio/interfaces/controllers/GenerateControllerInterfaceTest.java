package com.beehome.desafio.interfaces.controllers;

import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.beehome.desafio.application.usercase.create.CreateService;
import com.beehome.desafio.application.usercase.delete.DeleteService;
import com.beehome.desafio.application.usercase.list.ListService;
import com.beehome.desafio.domain.dto.FilterParams;
import com.beehome.desafio.domain.dto.GeneratePasswordForm;
import com.beehome.desafio.domain.dto.VaultDto;
import com.beehome.desafio.domain.repositories.GenerateRepository;
import com.beehome.desafio.interfaces.services.CreateServiceInterface;
import com.beehome.desafio.interfaces.services.DeleteServiceInterface;
import com.beehome.desafio.interfaces.services.ListServiceInterface;
import com.beehome.desafio.presentation.GenerateControllerImpl;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


@ExtendWith(MockitoExtension.class)
@WebMvcTest(GenerateControllerImpl.class)
class GenerateControllerInterfaceTest {

	@Mock
	private GenerateRepository generateRepository;
	
	@MockitoBean
	private CreateService createService;
	
	@MockitoBean
	private ListService listService;
	
	@MockitoBean
	private DeleteService deleteService;
	
	@Autowired
    private MockMvc mockMvc;
	
	private ObjectMapper objectMapper;
	 
	@BeforeEach
    void init() {
        this.objectMapper = new ObjectMapper()
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }
	
	@Test
	@DisplayName("should generate password and return status 201")
	void shouldGeneratePassword() throws Exception {
		GeneratePasswordForm form = new GeneratePasswordForm(
			    8,
			    true,
			    true,
			    true,
			    true
			);
		String formAsJson = this.objectMapper.writeValueAsString(form);
		CreateServiceInterface createServiceInterface = this.createService;

		
        BDDMockito.when(createServiceInterface.execute(form))
        .thenReturn(LocalDate.now().toString());
        
        
        
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/generate-password")
                        .content(formAsJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
	}
	
	@Test
	@DisplayName("should return vauls list")
	void shouldListVaultsList() throws Exception {
		ListServiceInterface listServiceInterface = this.listService;
		PagedModel<VaultDto> vaultDto = Mockito.mock();
		Pageable pageable = Mockito.mock(Pageable.class);
		FilterParams filterParams = new FilterParams(LocalDate.now());
		
        BDDMockito.when(listServiceInterface.execute(pageable, filterParams))
        .thenReturn(vaultDto);
        
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/password-history")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
	}
	
	@Test
	@DisplayName("should delete password")
	void shouldDeletePassword() throws Exception {
		DeleteServiceInterface deleteServiceInterface = this.deleteService;
		Long id = Long.valueOf(0);
		
        doNothing().when(deleteServiceInterface).execute(id);
        
        this.mockMvc.perform(MockMvcRequestBuilders
                        .delete("/api/delete-password/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isAccepted());
	}

}
