package br.com.guilhermemirand.petclinic.services;

import br.com.guilhermemirand.petclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);
    Vet save(Vet vet);
    Set<Vet> findAll();
}
