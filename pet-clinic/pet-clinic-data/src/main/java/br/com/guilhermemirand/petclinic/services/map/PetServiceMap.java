package br.com.guilhermemirand.petclinic.services.map;

import br.com.guilhermemirand.petclinic.model.Pet;
import br.com.guilhermemirand.petclinic.services.PetService;

import java.util.Set;

public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object.getId(), object);
    }

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }
}
