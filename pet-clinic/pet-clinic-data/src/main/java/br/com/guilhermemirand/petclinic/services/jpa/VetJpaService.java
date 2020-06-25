package br.com.guilhermemirand.petclinic.services.jpa;

import br.com.guilhermemirand.petclinic.model.Vet;
import br.com.guilhermemirand.petclinic.repository.VetRepository;
import br.com.guilhermemirand.petclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VetJpaService implements VetService {

    @Autowired
    private VetRepository vetRepository;

    @Override
    public Vet findById(Long aLong) {
        return this.vetRepository.findById(aLong).orElse(null);
    }

    @Override
    public Vet save(Vet object) {
        return this.vetRepository.save(object);
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        this.vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public void deleteById(Long aLong) {
        this.vetRepository.deleteById(aLong);
    }

    @Override
    public void delete(Vet object) {
        this.vetRepository.delete(object);
    }
}
