package com.udacity.jdnd.course3.critter.pet;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.udacity.jdnd.course3.critter.model.Customer;
import com.udacity.jdnd.course3.critter.model.Employee;
import com.udacity.jdnd.course3.critter.model.Pet;
import com.udacity.jdnd.course3.critter.service.PetService;
import com.udacity.jdnd.course3.critter.user.CustomerDTO;
import com.udacity.jdnd.course3.critter.user.EmployeeDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Handles web requests related to Pets.
 */
@RestController
@RequestMapping("/pet")
public class PetController {
	
	@Autowired
	PetService petService;

    @PostMapping
    public PetDTO savePet(@RequestBody PetDTO petDTO) {
    	Pet newPet = new Pet();
    	BeanUtils.copyProperties(petDTO, newPet);

    	Pet resultPet = petService.savePet(newPet, petDTO.getOwnerId());
    	PetDTO resultPetDto = new PetDTO();
    	BeanUtils.copyProperties(resultPet, resultPetDto);
    	
    	// need to set the owner id here because it is not copied over
		// by BeanUtils (different field names!)
    	resultPetDto.setOwnerId(petDTO.getOwnerId());
    	
    	return resultPetDto;
    }

    @GetMapping("/{petId}")
    public PetDTO getPet(@PathVariable long petId) {
        throw new UnsupportedOperationException();
    }

    @GetMapping
    public List<PetDTO> getPets(){
        throw new UnsupportedOperationException();
    }

    @GetMapping("/owner/{ownerId}")
    public List<PetDTO> getPetsByOwner(@PathVariable long ownerId) {
    	List<Pet> ownersPets = petService.getPetsByOwner(ownerId);
    	List<PetDTO> allPetDtos = new ArrayList<>(); 

    	for (Pet pet : ownersPets) {
    		PetDTO petDto = new PetDTO();
    		BeanUtils.copyProperties(pet, petDto);
    		// need to set the owner id here because it is not copied over
    		// by BeanUtils (different field names!)
    		petDto.setOwnerId(ownerId);
    		allPetDtos.add(petDto);
    	}
    	
    	return allPetDtos;
    }
}
