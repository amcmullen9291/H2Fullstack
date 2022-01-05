package com.example.H2Fullstack.Controller;

import com.example.H2Fullstack.Entity.Beverage;
import com.example.H2Fullstack.Exception.ResourceNotFoundException;
import com.example.H2Fullstack.Repository.BeverageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/beverages")
public class BeverageController {

    @Autowired
    private BeverageRepository beverageRepository;

    @GetMapping("/beverages")
    @CrossOrigin(origins = {"http://localhost:3000", " http://192.168.1.69:3000", "http://localhost:8080"})
    public List<Beverage> getBeverages(){
        return beverageRepository.findAll();
    }

    @PostMapping("/beverages/")
    @CrossOrigin(origins = {"http://localhost:8080", "http://localhost:3000", " http://192.168.1.69:3000"})
    public Beverage addBeverage(@RequestBody Beverage newBeverage){
        return beverageRepository.save(newBeverage);
    }

    @PutMapping("/beverages/{id}")
    @CrossOrigin(origins = {"http://localhost:8080", "http://localhost:3000", " http://192.168.1.69:3000"})
    public ResponseEntity<Beverage> updateBeverage(@PathVariable(value = "id")long id, @RequestBody Beverage beverage)
            throws ResourceNotFoundException{
        Beverage currentBeverage = beverageRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id + ": not found"));
        currentBeverage.setBeverageName(beverage.getBeverageName());
        currentBeverage.setCheese1Name(beverage.getCheese1Name());
        currentBeverage.setCheese2Name(beverage.getCheese2Name());
        currentBeverage.setCheese3Name(beverage.getCheese3Name());
        currentBeverage.setCheese4Name(beverage.getCheese4Name());
        currentBeverage.setCheese5Name(beverage.getCheese5Name());
        currentBeverage = beverageRepository.save(beverage);

        return ResponseEntity.ok(currentBeverage);
    }

    @DeleteMapping("/beverages/{id}")
    @CrossOrigin(origins = {"http://localhost:8080", "http://localhost:3000", " http://192.168.1.69:3000"})
    public Map<Long, String> removeBreed(@PathVariable long id)throws ResourceNotFoundException {

        Beverage beverage = beverageRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Id not found"));
        beverageRepository.delete(beverage);
        Map<Long, String> response = new HashMap<>();
        response.put(id, "Listing Deleted");
        return response;
    }

    @GetMapping("beverages/{id}")
    @CrossOrigin(origins = {"http://localhost:8080", "http://localhost:3000", " http://192.168.1.69:3000"})
    public Map<Long, Beverage> selectedBeverage(@PathVariable long id)throws ResourceNotFoundException{
        Beverage beverage = beverageRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Id not found"));
        Map<Long, Beverage> response = new HashMap<>();
        response.put(id, beverage);
        return response;
    }
}