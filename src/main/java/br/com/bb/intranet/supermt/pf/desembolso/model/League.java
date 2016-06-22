/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.intranet.supermt.pf.desembolso.model;

import java.io.Serializable;

/**
 *
 * @author Olliver
 */
public class League implements Serializable {

    private static final long serialVersionUID = 20111120L;

    private String name;
    private int numberOfTeam;

    public League(String name, int numberOfTeam) {
        this.name = name;
        this.numberOfTeam = numberOfTeam;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfTeam() {
        return numberOfTeam;
    }
}
