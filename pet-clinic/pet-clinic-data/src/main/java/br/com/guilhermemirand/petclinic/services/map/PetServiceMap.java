package br.com.guilhermemirand.petclinic.services.map;

import br.com.guilhermemirand.petclinic.model.Pet;
import br.com.guilhermemirand.petclinic.services.PetService;
import br.com.guilhermemirand.petclinic.services.PetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {

    @Autowired
    private PetTypeService petTypeService;

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Pet save(Pet object) {
        if (object.getPetType() == null) {
            throw new RuntimeException("Pet Type is required");
        } else if (object.getPetType().getId() == null) {
            object.getPetType().setId(this.petTypeService.save(object.getPetType()).getId());
        }
        return super.save(object);
    }

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }
}
