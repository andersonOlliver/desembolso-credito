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

public class Country implements Serializable {

    private static final long serialVersionUID = 20111120L;

    private String name;
    private String code;
    private String sport;
    private List<League> leagues;

    public Country(String name, String code, String sport, List<League> leagues) {
        this.name = name;
        this.code = code;
        this.sport = sport;
        this.leagues = leagues;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getSport() {
        return sport;
    }

    public List<League> getLeagues() {
        return leagues;
    }
}
