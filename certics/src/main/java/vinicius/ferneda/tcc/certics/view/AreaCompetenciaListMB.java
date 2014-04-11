package vinicius.ferneda.tcc.certics.view;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import vinicius.ferneda.tcc.certics.business.AreaCompetenciaBC;
import vinicius.ferneda.tcc.certics.domain.AreaCompetenciaEntity;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@ViewController
@NextView("./areaCompetencia_edit.jsf")
@PreviousView("./areaCompetencia_list.jsf")
public class AreaCompetenciaListMB extends AbstractListPageBean<AreaCompetenciaEntity, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private AreaCompetenciaBC areaCompetenciaBC;
	
	@Override
	protected List<AreaCompetenciaEntity> handleResultList() {
		return this.areaCompetenciaBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				areaCompetenciaBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}