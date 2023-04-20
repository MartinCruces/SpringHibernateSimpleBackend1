package com.example.springhibernatebackend1.KompisRESTAPI.Repos;

import com.example.springhibernatebackend1.KompisRESTAPI.Models.Kompis;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KompisRepository extends JpaRepository<Kompis, Long> {

    public List<Kompis> getKompisByName(String name);
}
