package br.com.guilhermemirand.petclinic.services.jpa;

import br.com.guilhermemirand.petclinic.model.PetType;
import br.com.guilhermemirand.petclinic.repository.PetTypeRepository;
import br.com.guilhermemirand.petclinic.services.PetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetTypeJpaService implements PetTypeService {

    @Autowired
    private PetTypeRepository petTypeRepository;

    @Override
    public PetType findById(Long aLong) {
        return this.petTypeRepository.findById(aLong).orElse(null);
    }

    @Override
    public PetType save(PetType object) {
        return this.petTypeRepository.save(object);
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes = new HashSet<>();
        this.petTypeRepository.findAll().forEach(petTypes::add);
        return petTypes;
    }

    @Override
    public void deleteById(Long aLong) {
        this.petTypeRepository.deleteById(aLong);
    }

    @Override
    public void delete(PetType object) {
        this.delete(object);
    }
}
