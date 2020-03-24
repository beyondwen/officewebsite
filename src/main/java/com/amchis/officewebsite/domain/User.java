package com.amchis.officewebsite.domain;

import lombok.Data;

import javax.persistence.*;


/**
 * @author beyond
 * Create at 2020-03-18 09:31
 */
@Entity
@Table(name = "user")
@Data
public class User {


    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     *
     */
    @Column(name = "username")
    private String username;

    /**
     *
     */
    @Column(name = "password")
    private String password;


}