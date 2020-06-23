package br.com.guilhermemirand.petclinic.bootstrap;

import br.com.guilhermemirand.petclinic.model.*;
import br.com.guilhermemirand.petclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final PetService petService;
    private final SpecialityService specialityService;
    private final Long DOG_PET_TYPE_ID = 1l;
    private final Long CAT_PET_TYPE_ID = 2l;
    private final Long RADIOLOGY_SPECIALITY_ID = 1l;
    private final Long SURGERY_SPECIALITY_ID = 2l;
    private final Long DENTISTRY_SPECIALITY_ID = 3l;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, PetService petService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.petService = petService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {
        if (this.petTypeService.findAll().size() == 0) {
            this.loadFakeData();
        }
    }

    private void loadFakeData() {
        this.loadPetTypes();
        System.out.println("Pet Types: " + this.petTypeService.findAll().size());
        this.loadSpecialities();
        System.out.println("Specialities: " + this.specialityService.findAll().size());
        this.loadOwners();
        System.out.println("Owners: " + this.ownerService.findAll().size());
        this.loadVets();
        System.out.println("Vets: " + this.vetService.findAll().size());
        System.out.println("Pets: " + this.petService.findAll().size());
    }

    private void loadSpecialities() {
        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        radiology.setId(this.RADIOLOGY_SPECIALITY_ID);
        this.specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        surgery.setId(this.SURGERY_SPECIALITY_ID);
        this.specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        dentistry.setId(this.DENTISTRY_SPECIALITY_ID);
        this.specialityService.save(dentistry);
    }

    private void loadPetTypes() {
        PetType dog = new PetType();
        dog.setName("Dog");
        dog.setId(this.DOG_PET_TYPE_ID);
        this.petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        cat.setId(this.CAT_PET_TYPE_ID);
        this.petTypeService.save(cat);
    }

    private void loadVets() {
        Vet vet1 = new Vet();
        vet1.setFirstName("Rubens");
        vet1.setLastName("Monteiro");
        vet1.setSpecialities(new HashSet<>());
        vet1.getSpecialities().add(this.specialityService.findById(this.SURGERY_SPECIALITY_ID));
        this.vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jéssica");
        vet2.setLastName("Fonseca");
        vet2.setSpecialities(new HashSet<>());
        vet2.getSpecialities().add(this.specialityService.findById(this.RADIOLOGY_SPECIALITY_ID));
        vet2.getSpecialities().add(this.specialityService.findById(this.DENTISTRY_SPECIALITY_ID));
        this.vetService.save(vet2);
    }

    private void loadOwners() {
        Owner owner1 = new Owner();
        owner1.setFirstName("Elis");
        owner1.setLastName("Silva");
        owner1.setAddress("Rua 1");
        owner1.setCity("Recife");
        owner1.setTelephone("999999999");

        Pet dog1 = new Pet();
        dog1.setName("Rex");
        dog1.setBirthDate(LocalDate.now());
        dog1.setPetType(this.petTypeService.findById(this.DOG_PET_TYPE_ID));
        dog1.setOwner(owner1);
        owner1.setPets(new HashSet<>());
        owner1.getPets().add(dog1);
        this.ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Sergio");
        owner2.setLastName("Batista");
        owner2.setAddress("Rua 2");
        owner2.setCity("Porto Seguro");
        owner2.setTelephone("988888888");

        Pet cat1 = new Pet();
        cat1.setName("Felix");
        cat1.setBirthDate(LocalDate.now());
        cat1.setPetType(this.petTypeService.findById(this.CAT_PET_TYPE_ID));
        cat1.setOwner(owner2);
        owner2.setPets(new HashSet<>());
        owner2.getPets().add(cat1);
        this.ownerService.save(owner2);
    }
}
