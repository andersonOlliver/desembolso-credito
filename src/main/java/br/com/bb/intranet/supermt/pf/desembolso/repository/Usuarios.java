package br.com.bb.intranet.supermt.pf.desembolso.repository;

import br.com.bb.intranet.supermt.pf.desembolso.model.Usuario;
import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;



public class Usuarios implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager manager;

	@Inject
	public Usuarios(EntityManager manager) {
		this.manager = manager;
	}

	public List<Usuario> todos() {
		TypedQuery<Usuario> query = manager.createQuery("from Usuario", Usuario.class);
		return query.getResultList();
	}

	public Usuario porId(Long id) {
		return manager.find(Usuario.class, id);
	}

	public void adicionar(Usuario usuario) {
		this.manager.persist(usuario);
	}

	public void atualizar(Usuario usuario) {
		this.manager.merge(usuario);
	}

	public Usuario porChave(String chave) {
		Criteria criteria = criarCriteria();
		criteria.add(Restrictions.eq("chave", chave));
		return (Usuario) criteria.uniqueResult();
	}

	private Criteria criarCriteria() {
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Usuario.class);

		return criteria;
	}
	
	public void remover(Usuario usuario){
		this.manager.remove(usuario);
	}
}
