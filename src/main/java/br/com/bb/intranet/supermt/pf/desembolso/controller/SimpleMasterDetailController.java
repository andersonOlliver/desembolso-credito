/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.intranet.supermt.pf.desembolso.controller;

import br.com.bb.intranet.supermt.pf.desembolso.model.Country;
import br.com.bb.intranet.supermt.pf.desembolso.model.League;
import br.com.bb.intranet.supermt.pf.desembolso.model.Sport;


import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Olliver
 */

@ManagedBean
@ViewScoped
public class SimpleMasterDetailController implements Serializable {  
  
    private static final long serialVersionUID = 1L;  
  
    private List<Sport> sports;  
    private int currentLevel = 1;  
  
    public SimpleMasterDetailController() {  
        if (sports == null) {  
            sports = new ArrayList<Sport>();  
  
            // football  
            List<Country> countries = new ArrayList<Country>();  
            Country country = new Country("Switzerland", "CH", "Football", getLeagues("Switzerland"));  
            countries.add(country);  
            country = new Country("England", "UK", "Football", getLeagues("England"));  
            countries.add(country);  
            country = new Country("Spain", "ES", "Football", getLeagues("Spain"));  
            countries.add(country);  
            country = new Country("Netherlands", "NL", "Football", getLeagues("Netherlands"));  
            countries.add(country);  
            sports.add(new Sport("Football", countries));  
  
            //basketball  
            countries = new ArrayList<Country>();  
            country = new Country("Germany", "DE", "Basketball", getLeagues("Germany"));  
            countries.add(country);  
            country = new Country("USA", "US", "Basketball", getLeagues("USA"));  
            countries.add(country);  
            country = new Country("Poland", "PL", "Basketball", getLeagues("Poland"));  
            countries.add(country);  
            sports.add(new Sport("Basketball", countries));  
  
            // ice hockey  
            countries = new ArrayList<Country>();  
            country = new Country("Russia", "RU", "Ice Hockey", getLeagues("Russia"));  
            countries.add(country);  
            country = new Country("Canada", "CA", "Ice Hockey", getLeagues("Canada"));  
            countries.add(country);  
            sports.add(new Sport("Ice Hockey", countries));  
        }  
    }  
  
    public List<Sport> getSports() {  
        return sports;  
    }  
  
    public int getCurrentLevel() {  
        return currentLevel;  
    }  
  
    public void setCurrentLevel(int currentLevel) {  
        this.currentLevel = currentLevel;  
    }  
  
    private List<League> getLeagues(String country) {  
        List<League> leagues = new ArrayList<League>();  
  
        leagues.add(new League(country + " SuperLeague", 20));  
        leagues.add(new League(country + " NotBadLeague", 15));  
        leagues.add(new League(country + " CrapLeague", 30));  
  
        return leagues;  
    }  
}  