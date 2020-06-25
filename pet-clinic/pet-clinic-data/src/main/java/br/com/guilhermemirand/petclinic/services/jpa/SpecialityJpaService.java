package br.com.guilhermemirand.petclinic.services.jpa;

import br.com.guilhermemirand.petclinic.model.Speciality;
import br.com.guilhermemirand.petclinic.repository.SpecialityRepository;
import br.com.guilhermemirand.petclinic.services.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class SpecialityJpaService implements SpecialityService {

    @Autowired
    private SpecialityRepository specialityRepository;

    @Override
    public Speciality findById(Long aLong) {
        return this.specialityRepository.findById(aLong).orElse(null);
    }

    @Override
    public Speciality save(Speciality object) {
        return this.specialityRepository.save(object);
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialities = new HashSet<>();
        this.specialityRepository.findAll().forEach(specialities::add);
        return specialities;
    }

    @Override
    public void deleteById(Long aLong) {
        this.specialityRepository.deleteById(aLong);
    }

    @Override
    public void delete(Speciality object) {
        this.delete(object);
    }
}
