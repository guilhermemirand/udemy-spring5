package br.com.guilhermemirand.petclinic.controller;

import br.com.guilhermemirand.petclinic.model.Owner;
import br.com.guilhermemirand.petclinic.services.OwnerService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    @Mock
    private OwnerService ownerService;

    @InjectMocks
    private OwnerController ownerController;

    private Set<Owner> owners;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        this.owners = new HashSet<>();
        this.owners.add(Owner.builder().id(1L).build());
        this.owners.add(Owner.builder().id(2L).build());
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.ownerController).build();
    }

    @Test
    void listOwners() throws Exception {
        when(this.ownerService.findAll()).thenReturn(this.owners);
        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/owners"))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.view().name("/owners/index"))
                .andExpect(MockMvcResultMatchers.model().attribute("owners", Matchers.hasSize(2)));
    }

    @Test
    void find() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/owners/find"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("not-implemented"));
    }
}