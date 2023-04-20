package com.example.springhibernatebackend1.KompisRESTAPI.Controllers;

import com.example.springhibernatebackend1.KompisRESTAPI.Models.Kompis;
import com.example.springhibernatebackend1.KompisRESTAPI.Repos.KompisRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class KompisController {

    private final KompisRepository repo;
    private static final Logger log = LoggerFactory.getLogger(KompisController.class);

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
        log.info("Kompis added");
        return repo.findAll();
    }

    @RequestMapping("Kompisar/{id}")
    public Kompis getKompis(@PathVariable long id){

        Kompis kompis = null;

        if(repo.findById(id).isEmpty()){
            log.info("id number: " + id + " not found!");
        }
        else{
             kompis = repo.findById(id).get();
            log.info("Kompis found with id: " + id);
        }
        return kompis;
    }

    @RequestMapping("Kompisar/{id}/delete")
    public List<Kompis> deleteKompisById(@PathVariable long id){

        repo.deleteById(id);
        log.info("Kompis deleted with id: " + id);
        return repo.findAll();
    }

    @RequestMapping("Kompisar/{name}/name")
    public List<Kompis> getKompisByName(@PathVariable String name){
        log.info("Kompis found with name:" + name);
        return repo.getKompisByName(name);
    }

}
