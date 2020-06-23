package br.com.guilhermemirand.petclinic.services.map;

import br.com.guilhermemirand.petclinic.model.Owner;
import br.com.guilhermemirand.petclinic.services.OwnerService;
import br.com.guilhermemirand.petclinic.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    @Autowired
    private PetService petService;

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
    public Owner save(Owner owner) {
        if (owner.getPets() != null) {
            owner.getPets().forEach(p -> {
                if (p.getId() == null) {
                    p.setId(this.petService.save(p).getId());
                }
            });
        }
        return super.save(owner);
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }
}
