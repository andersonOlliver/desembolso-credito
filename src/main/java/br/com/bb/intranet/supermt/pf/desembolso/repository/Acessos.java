/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.intranet.supermt.pf.desembolso.repository;

import br.com.bb.intranet.supermt.pf.desembolso.model.DesembolsoCreditoPFeContatos;
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
public class Acessos implements Serializable {

    private static final long serialVersionUID = 1L;

    private EntityManager manager;

    @Inject
    public Acessos(EntityManager manager) {
        this.manager = manager;
    }

    public DesembolsoCreditoPFeContatos porId(Long id) {
        return manager.find(DesembolsoCreditoPFeContatos.class, id);
    }

    public List<DesembolsoCreditoPFeContatos> todas() {
        TypedQuery<DesembolsoCreditoPFeContatos> query = manager.createQuery(
                "from DesembolsoCreditoPFeContatos", DesembolsoCreditoPFeContatos.class);

        return query.getResultList();
    }

    
    public List<DesembolsoCreditoPFeContatos> porGrupo(String grupo) {
        Criteria criteria = criarCriteria();

        criteria.add(Restrictions.ilike("grupo", grupo));

        return criteria.list();
    }

    public void adicionar(DesembolsoCreditoPFeContatos valor) {
        this.manager.persist(valor);
    }

    public void guardar(DesembolsoCreditoPFeContatos valor) {
        this.manager.merge(valor);
    }

    public void remover(DesembolsoCreditoPFeContatos valor) {
        this.manager.remove(valor);
    }

    /*
	 * CONFIGURAÇÃO DE SESSÃO
     */
    private Criteria criarCriteria() {
        Session session = manager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(DesembolsoCreditoPFeContatos.class);

        return criteria;
    }
}
