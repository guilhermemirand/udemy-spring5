package br.com.guilhermemirand.petclinic.services.jpa;

import br.com.guilhermemirand.petclinic.model.Visit;
import br.com.guilhermemirand.petclinic.repository.VisitRepository;
import br.com.guilhermemirand.petclinic.services.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VisitJpaService implements VisitService {

    @Autowired
    private VisitRepository visitRepository;

    @Override
    public Visit findById(Long aLong) {
        return this.visitRepository.findById(aLong).orElse(null);
    }

    @Override
    public Visit save(Visit object) {
        return this.visitRepository.save(object);
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();
        this.visitRepository.findAll().forEach(visits::add);
        return visits;
    }

    @Override
    public void deleteById(Long aLong) {
        this.visitRepository.deleteById(aLong);
    }

    @Override
    public void delete(Visit object) {
        this.visitRepository.delete(object);
    }
}
