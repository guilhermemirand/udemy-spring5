package br.com.guilhermemirand.petclinic.bootstrap;

import br.com.guilhermemirand.petclinic.model.*;
import br.com.guilhermemirand.petclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

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
        this.specialityService.save(Speciality.builder().description("Radiology").build());
        this.specialityService.save(Speciality.builder().description("Surgery").build());
        this.specialityService.save(Speciality.builder().description("Dentistry").build());
    }

    private void loadPetTypes() {
        this.petTypeService.save(PetType.builder().name("Dog").build());
        this.petTypeService.save(PetType.builder().name("Cat").build());
    }

    private void loadVets() {
        Set<Speciality> specialities = new HashSet<>();
        specialities.add(this.specialityService.findById(this.SURGERY_SPECIALITY_ID));
        this.vetService.save(Vet.builder()
                .firstName("Rubens")
                .lastName("Monteiro")
                .specialities(specialities)
                .build());

        Set<Speciality> specialities2 = new HashSet<>();
        specialities2.add(this.specialityService.findById(this.RADIOLOGY_SPECIALITY_ID));
        specialities2.add(this.specialityService.findById(this.DENTISTRY_SPECIALITY_ID));
        this.vetService.save(Vet.builder()
                .firstName("Jéssica")
                .lastName("Fonseca")
                .specialities(specialities2)
                .build());
    }

    private void loadOwners() {
        Owner owner1 = Owner.builder()
                .firstName("Elis")
                .lastName("Silva")
                .address("Rua 1")
                .city("Recife")
                .telephone("999999999")
                .pets(new HashSet<>())
                .build();

        owner1.getPets().add(Pet.builder()
                .name("Rex")
                .birthDate(LocalDate.now())
                .petType(this.petTypeService.findById(this.DOG_PET_TYPE_ID))
                .owner(owner1)
                .build());
        this.ownerService.save(owner1);

        Owner owner2 = Owner.builder()
                .firstName("Sergio")
                .lastName("Batista")
                .address("Rua 2")
                .city("Porto Seguro")
                .telephone("988888888")
                .pets(new HashSet<>())
                .build();

        owner2.getPets().add(Pet.builder()
                .name("Felix")
                .birthDate(LocalDate.now())
                .petType(this.petTypeService.findById(this.CAT_PET_TYPE_ID))
                .owner(owner2)
                .build());

        owner2.getPets().add(Pet.builder()
                .name("Garfield")
                .birthDate(LocalDate.now())
                .petType(this.petTypeService.findById(this.CAT_PET_TYPE_ID))
                .owner(owner2)
                .build());
        this.ownerService.save(owner2);
    }
}
