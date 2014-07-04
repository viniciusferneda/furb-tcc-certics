package vinicius.ferneda.tcc.certics.view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import vinicius.ferneda.tcc.certics.business.AvaliacaoBC;
import vinicius.ferneda.tcc.certics.constant.EnumPapelUsuario;
import vinicius.ferneda.tcc.certics.domain.AvaliacaoEntity;
import vinicius.ferneda.tcc.certics.persistence.AvaliacaoDAO;
import vinicius.ferneda.tcc.certics.security.Identity;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.security.SecurityContext;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@ViewController
@NextView("./avaliacao_edit.jsf")
@PreviousView("./avaliacao_list.jsf")
public class AvaliacaoListMB extends AbstractListPageBean<AvaliacaoEntity, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private AvaliacaoBC avaliacaoBC;
	@Inject
	private AvaliacaoDAO avaliacaoDAO;
	
	@Inject
    private SecurityContext securityContext;
	@Inject
    private Identity identity;
	
	@Override
	protected List<AvaliacaoEntity> handleResultList() {
		if(securityContext.hasRole(EnumPapelUsuario.AVALIADOR.toString())){
			return this.avaliacaoDAO.findByAvaliadorID(Long.valueOf(identity.getId()));
		}else if(securityContext.hasRole(EnumPapelUsuario.ADM.toString())){
			return this.avaliacaoBC.findAll();
		}else{
			return new ArrayList<AvaliacaoEntity>();
		}
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				avaliacaoBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}