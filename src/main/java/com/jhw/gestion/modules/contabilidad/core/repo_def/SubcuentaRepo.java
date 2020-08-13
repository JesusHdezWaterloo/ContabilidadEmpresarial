package com.jhw.gestion.modules.contabilidad.core.repo_def;

import com.jhw.gestion.modules.contabilidad.core.domain.old.SubcuentaDomain;
import com.jhw.gestion.modules.contabilidad.core.domain.old.CuentaDomain;
import com.clean.core.app.repo.CRUDRepository;
import java.util.List;

public interface SubcuentaRepo extends CRUDRepository<SubcuentaDomain> {

    public List<SubcuentaDomain> findSubcuentasDondeSeaHijo(CuentaDomain hijo);

    public List<SubcuentaDomain> findSubcuentasDondeSeaPadre(CuentaDomain padre);

}
