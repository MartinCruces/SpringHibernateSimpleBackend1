package com.example.springhibernatebackend1.KompisRESTAPI.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity

public class Kompis {

    @Id
    @GeneratedValue
    protected long id;
    protected String name;
    protected String address;
    protected String phoneNr;

}
