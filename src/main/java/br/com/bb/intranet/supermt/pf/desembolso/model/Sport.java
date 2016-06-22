/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.intranet.supermt.pf.desembolso.model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Olliver
 */
public class Sport implements Serializable {

    private static final long serialVersionUID = 20111120L;

    private String name;
    private List<Country> countriesWithLeague;

    public Sport(String name, List<Country> countriesWithLeague) {
        this.name = name;
        this.countriesWithLeague = countriesWithLeague;
    }

    public String getName() {
        return name;
    }

    public List<Country> getCountriesWithLeague() {
        return countriesWithLeague;
    }
}
