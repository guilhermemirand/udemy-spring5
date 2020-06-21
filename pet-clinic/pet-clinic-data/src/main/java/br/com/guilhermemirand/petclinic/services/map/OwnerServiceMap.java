package br.com.guilhermemirand.petclinic.services.map;

import br.com.guilhermemirand.petclinic.model.Owner;
import br.com.guilhermemirand.petclinic.services.OwnerService;

import java.util.Set;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    @Override
    public Owner findByLastName(String lastName) {
        //TODO implementar metodo Owner findByLastName
        return null;
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {
        return super.save(object.getId(), object);
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

}
