package br.com.guilhermemirand.petclinic.bootstrap;

import br.com.guilhermemirand.petclinic.model.Owner;
import br.com.guilhermemirand.petclinic.model.Vet;
import br.com.guilhermemirand.petclinic.services.OwnerService;
import br.com.guilhermemirand.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.loadOwners();
        System.out.println("Owners loaded.");
        System.out.println(this.ownerService.findAll().size());
        this.loadVets();
        System.out.println("Vets loaded.");
        System.out.println(this.vetService.findAll().size());
    }

    private void loadVets() {
        Vet vet1 = new Vet();
        vet1.setFirstName("Rubens");
        vet1.setLastName("Monteiro");
        this.vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jéssica");
        vet2.setLastName("Fonseca");
        this.vetService.save(vet2);
    }

    private void loadOwners() {
        Owner owner1 = new Owner();
        owner1.setFirstName("Elis");
        owner1.setLastName("Silva");
        this.ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Sergio");
        owner2.setLastName("Batista");
        this.ownerService.save(owner2);
    }
}
