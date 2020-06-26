package br.com.guilhermemirand.petclinic.services.jpa;

import br.com.guilhermemirand.petclinic.repository.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class OwnerJpaServiceTest {

    @Mock
    private OwnerRepository ownerRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findByLastName() {
    }

    @Test
    void findById() {
    }

    @Test
    void save() {
    }

    @Test
    void findAll() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void delete() {
    }
}