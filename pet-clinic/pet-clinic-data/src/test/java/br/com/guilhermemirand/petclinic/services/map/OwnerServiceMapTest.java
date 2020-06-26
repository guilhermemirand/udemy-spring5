package br.com.guilhermemirand.petclinic.services.map;

import br.com.guilhermemirand.petclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    private OwnerServiceMap ownerServiceMap;

    @BeforeEach
    void setUp() {
        this.ownerServiceMap = new OwnerServiceMap();
        this.ownerServiceMap.save(Owner.builder().id(1L).firstName("Cássia").lastName("silva").build());
    }

    @Test
    void findById() {
        assertNotNull(this.ownerServiceMap.findById(1L));
        assertNull(this.ownerServiceMap.findById(2L));
    }

    @Test
    void findByIdNotExists() {
        assertNull(this.ownerServiceMap.findById(999L));
    }

    @Test
    void saveNewOwner() {
        assertNotNull(this.ownerServiceMap.save(Owner.builder().firstName("João").build()).getId());
    }

    @Test
    void atualizaOwner() {
        Owner owner = this.ownerServiceMap.findById(1L);
        owner.setCity("Salvador");
        assertEquals("Salvador", this.ownerServiceMap.save(owner).getCity());
    }

    @Test
    void findAll() {
        assertEquals(1, this.ownerServiceMap.findAll().size());
    }

    @Test
    void deleteById() {
        this.ownerServiceMap.deleteById(1l);
        assertNull(this.ownerServiceMap.findById(1l));
    }

    @Test
    void delete() {
        this.ownerServiceMap.delete(this.ownerServiceMap.findById(1l));
        assertNull(this.ownerServiceMap.findById(1l));
    }
}