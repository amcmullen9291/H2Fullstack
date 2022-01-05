package com.example.H2Fullstack.Controller;

import com.example.H2Fullstack.Entity.Cheese;
import com.example.H2Fullstack.Exception.ResourceNotFoundException;
import com.example.H2Fullstack.Repository.CheeseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cheeses")
public class CheeseController {

    @Autowired
    private CheeseRepository cheeseRepository;

    @GetMapping("/cheeses")
    @CrossOrigin(origins = {"http://localhost:3000", " http://192.168.1.69:3000", "http://localhost:8080"})
    public List<Cheese> getCheeses(){
        return cheeseRepository.findAll();
    }

    @PostMapping("/cheeses/")
    @CrossOrigin(origins = {"http://localhost:8080", "http://localhost:3000", " http://192.168.1.69:3000"})
    public Cheese addCheese(@RequestBody Cheese newCheese){
        return cheeseRepository.save(newCheese);
    }

    @PutMapping("/cheeses/{id}")
    @CrossOrigin(origins = {"http://localhost:8080", "http://localhost:3000", " http://192.168.1.69:3000"})
    public ResponseEntity<Cheese> updateCheese(@PathVariable(value = "id")long id, @RequestBody Cheese cheese)
            throws ResourceNotFoundException {
        Cheese currentCheese = (Cheese) cheeseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id + ": not found"));

        currentCheese.setCheeseName(cheese.getCheeseName());
        currentCheese.setBeverage1Name(cheese.getBeverage1Name());
        currentCheese.setBeverage2Name(cheese.getBeverage2Name());
        currentCheese.setBeverage3Name(cheese.getBeverage3Name());
        currentCheese.setBeverage4Name(cheese.getBeverage4Name());
        currentCheese.setBeverage5Name(cheese.getBeverage5Name());
        currentCheese.setBeverage6Name(cheese.getBeverage6Name());
        currentCheese.setBeverage7Name(cheese.getBeverage7Name());
        currentCheese.setAgingPeriod(cheese.getAgingPeriod());
        currentCheese.setBestUses(cheese.getBestUses());
        currentCheese.setTaste(currentCheese.getTaste());
        currentCheese.setTypeOfMilk(cheese.getTypeOfMilk());
        currentCheese.setCountryOfOrigin(cheese.getCountryOfOrigin());
        currentCheese.setNotes(cheese.getNotes());
        currentCheese = cheeseRepository.save(cheese);

        return ResponseEntity.ok(currentCheese);
    }

    @DeleteMapping("/cheeses/{id}")
    @CrossOrigin(origins = {"http://localhost:8080", "http://localhost:3000", " http://192.168.1.69:3000"})
    public Map<Long, String> removeCheese(@PathVariable long id)throws ResourceNotFoundException {

        Cheese cheese = (Cheese) cheeseRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Id not found"));
        cheeseRepository.delete(cheese);
        Map<Long, String> response = new HashMap<>();
        response.put(id, "Listing Deleted");
        return response;
    }

    @GetMapping("beverages/{id}")
    @CrossOrigin(origins = {"http://localhost:8080", "http://localhost:3000", " http://192.168.1.69:3000"})
    public Map<Long, Cheese> selectedBeverage(@PathVariable long id)throws ResourceNotFoundException{
        Cheese cheese = cheeseRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Id not found"));
        Map<Long, Cheese> response = new HashMap<>();
        response.put(id, cheese);
        return response;
    }
}