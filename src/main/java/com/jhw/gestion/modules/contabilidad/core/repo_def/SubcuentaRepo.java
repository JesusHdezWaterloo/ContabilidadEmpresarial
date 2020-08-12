package com.jhw.gestion.modules.contabilidad.core.repo_def;

import com.clean.core.app.repo.CRUDRepository;
import com.jhw.gestion.modules.contabilidad.core.domain.*;
import java.util.List;

public interface SubcuentaRepo extends CRUDRepository<SubcuentaDomain> {

    public List<SubcuentaDomain> findSubcuentasDondeSeaHijo(CuentaDomain hijo);

    public List<SubcuentaDomain> findSubcuentasDondeSeaPadre(CuentaDomain padre);

}
