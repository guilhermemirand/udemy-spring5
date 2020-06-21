package br.com.guilhermemirand.petclinic.services;

import br.com.guilhermemirand.petclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);
    Pet save(Pet pet);
    Set<Pet> findAll();
}
