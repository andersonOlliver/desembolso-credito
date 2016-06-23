/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.intranet.supermt.pf.desembolso.repository;

import br.com.bb.intranet.supermt.pf.desembolso.model.Desembolso;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Olliver
 */
public class Desembolsos implements Serializable {

    private static final long serialVersionUID = 1L;

    private EntityManager manager;

    @Inject
    public Desembolsos(EntityManager manager) {
        this.manager = manager;
    }

    public Desembolso porId(Long id) {
        return manager.find(Desembolso.class, id);
    }

    public List<Desembolso> todas() {
        TypedQuery<Desembolso> query = manager.createQuery("from Desembolso", Desembolso.class);

        return query.getResultList();
    }

    
    public List<Desembolso> porGrupo(String grupo) {
        Criteria criteria = criarCriteria();

        criteria.add(Restrictions.eq("grupo", grupo));

        return criteria.list();
    }

    public void adicionar(Desembolso valor) {
        this.manager.persist(valor);
    }

    public void guardar(Desembolso valor) {
        this.manager.merge(valor);
    }

    public void remover(Desembolso valor) {
        this.manager.remove(valor);
    }

    /*
	 * CONFIGURAÇÃO DE SESSÃO
     */
    private Criteria criarCriteria() {
        Session session = manager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Desembolso.class);

        return criteria;
    }
}
