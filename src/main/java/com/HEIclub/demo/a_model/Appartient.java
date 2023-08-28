package com.HEIclub.demo.a_model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Appartient {
    private int id;
    private int idClub;
    private int idEtudiant;
}
