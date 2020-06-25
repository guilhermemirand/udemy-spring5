package br.com.guilhermemirand.petclinic.services.jpa;

import br.com.guilhermemirand.petclinic.model.Pet;
import br.com.guilhermemirand.petclinic.repository.PetRepository;
import br.com.guilhermemirand.petclinic.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetJpaService implements PetService {

    @Autowired
    private PetRepository petRepository;

    @Override
    public Pet findById(Long aLong) {
        return this.petRepository.findById(aLong).orElse(null);
    }

    @Override
    public Pet save(Pet object) {
        return this.petRepository.save(object);
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets = new HashSet<>();
        this.petRepository.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public void deleteById(Long aLong) {
        this.petRepository.deleteById(aLong);
    }

    @Override
    public void delete(Pet object) {
        this.petRepository.delete(object);
    }
}
