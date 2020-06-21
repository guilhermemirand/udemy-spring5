package br.com.guilhermemirand.petclinic.services.map;

import br.com.guilhermemirand.petclinic.model.Vet;
import br.com.guilhermemirand.petclinic.services.VetService;

import java.util.Set;

public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {
        return super.save(object.getId(), object);
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }
}
