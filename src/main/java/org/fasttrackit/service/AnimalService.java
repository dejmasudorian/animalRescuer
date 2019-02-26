package org.fasttrackit.service;

import org.fasttrackit.Animal;
import org.fasttrackit.persistence.AnimalRepository;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AnimalService {

    private AnimalRepository animalRepository = new AnimalRepository();

    public void createAnimal(Animal animal) throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Declaring animal entry: " + animal);
        animalRepository.createAnimalTable(animal);
    }

    public List<Animal> readAnimals() throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Reading animal table");
        return animalRepository.getAnimalTable();
    }

    public void updateAnimal(Animal animal) throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Updating animal entry." + animal);
        animalRepository.updateAnimalTable(animal);
    }
}


