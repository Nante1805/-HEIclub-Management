package com.HEIclub.demo.a_model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.sql.Date;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Evenement {
    private int id;
    private String nom;
    private Date date;
    private int idClub;
}
