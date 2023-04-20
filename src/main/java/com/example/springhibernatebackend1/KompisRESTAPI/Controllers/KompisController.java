package com.example.springhibernatebackend1.KompisRESTAPI.Controllers;

import com.example.springhibernatebackend1.KompisRESTAPI.Models.Kompis;
import com.example.springhibernatebackend1.KompisRESTAPI.Repos.KompisRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class KompisController {

    private final KompisRepository repo;

    KompisController(KompisRepository repo){
        this.repo =repo;
    }

    @RequestMapping("Kompisar")
    public List<Kompis> getAllKompisar(){
        return repo.findAll();
    }

    @PostMapping("Kompisar/add")
    public List<Kompis> addKompis(@RequestBody Kompis kompis){
        repo.save(kompis);
        return repo.findAll();
    }

    @RequestMapping("Kompisar/{id}")
    public Kompis getKompis(@PathVariable long id){

        return repo.findById(id).get();
    }

    @RequestMapping("Kompisar/{id}/delete")
    public List<Kompis> deleteKompisById(@PathVariable long id){
        repo.deleteById(id);
        return repo.findAll();
    }

    @RequestMapping("Kompisar/{name}/name")
    public List<Kompis> getKompisByName(@PathVariable String name){
        return repo.getKompisByName(name);
    }

}
