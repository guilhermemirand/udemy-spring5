package br.com.guilhermemirand.petclinic.services.jpa;

import br.com.guilhermemirand.petclinic.model.Owner;
import br.com.guilhermemirand.petclinic.repository.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerJpaServiceTest {

    private final String DEFAULT_LAST_NAME = "Costa";
    private final Long DEFAULT_ID = 1l;

    @Mock
    private OwnerRepository ownerRepository;

    @InjectMocks
    private OwnerJpaService ownerJpaService;

    private Owner anyOwner;

    @BeforeEach
    void setUp() {
        this.anyOwner = Owner.builder().id(DEFAULT_ID).lastName(DEFAULT_LAST_NAME).build();

    }

    @Test
    void findByLastName() {
        when(this.ownerRepository.findByLastName(any())).thenReturn(this.anyOwner);
        assertEquals(DEFAULT_ID, this.ownerJpaService.findByLastName(DEFAULT_LAST_NAME).getId());
    }

    @Test
    void findById() {
        when(this.ownerRepository.findById(any())).thenReturn(Optional.of(anyOwner));
        assertEquals(DEFAULT_ID, this.ownerJpaService.findById(DEFAULT_ID).getId());
    }

    @Test
    void save() {
        when(this.ownerRepository.save(any())).thenReturn(this.anyOwner);
        assertEquals(DEFAULT_ID, this.ownerJpaService.save(new Owner()).getId());
    }

    @Test
    void findAll() {
        when(this.ownerRepository.findAll()).thenReturn(Collections.singletonList(this.anyOwner));
        assertEquals(1, this.ownerJpaService.findAll().size());
    }

    @Test
    void deleteById() {
        this.ownerJpaService.deleteById(DEFAULT_ID);
        verify(this.ownerRepository).deleteById(any());
    }

    @Test
    void delete() {
        this.ownerJpaService.delete(this.anyOwner);
        verify(this.ownerRepository).delete(any());
    }
}