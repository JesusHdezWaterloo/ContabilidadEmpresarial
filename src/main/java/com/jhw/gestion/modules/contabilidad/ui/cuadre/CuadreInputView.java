package com.jhw.gestion.modules.contabilidad.ui.cuadre;

import com.jhw.gestion.modules.contabilidad.core.domain.facade.CuadreUI;
import com.jhw.swing.material.components.container.layout.VerticalLayoutContainer;
import com.jhw.swing.models.clean.CleanCRUDInputView;
import com.jhw.gestion.modules.contabilidad.core.domain.*;
import com.jhw.gestion.modules.contabilidad.core.domain.facade.OperacionCuadreDomain;
import com.jhw.gestion.modules.contabilidad.core.usecase_impl.TipoOperacionContableUseCaseImpl;
import com.jhw.gestion.modules.contabilidad.ui.info_op.InfoOpInputView;
import com.jhw.gestion.modules.contabilidad.ui.module.ContabilidadSwingModule;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class CuadreInputView extends CleanCRUDInputView<CuadreDomain> {

    private final TipoOperacionContableDomain tipo = TipoOperacionContableUseCaseImpl.MOVIMIENTO_INTERNO;

    public CuadreInputView() {
        this(null);
    }

    public CuadreInputView(CuadreDomain model) {
        super(model, ContabilidadSwingModule.cuadreUC);
        initComponents();
        update();
    }

    private void initComponents() {
        //op
        operacionInputView = new OperacionCuadreInputView(tipo);

        //info
        infoInputView = new InfoOpInputView();

        VerticalLayoutContainer.builder vlc = VerticalLayoutContainer.builder(400);

        vlc.add(operacionInputView);
        vlc.add(infoInputView, true);

        this.setComponent(vlc.build());
    }

    // Variables declaration - do not modify
    private OperacionCuadreInputView operacionInputView;
    private InfoOpInputView infoInputView;
    // End of variables declaration                   

    @Override
    public void update() {
        if (getOldModel() == null) {
            setHeader("Crear Cuadre");
        } else {
            setHeader("Editar Cuadre");
            operacionInputView.setObject(new OperacionCuadreDomain(getOldModel()));
            infoInputView.setObject(getOldModel().info());
        }
    }

    @Override
    public CuadreDomain getNewModel() throws Exception {
        OperacionCuadreDomain op = operacionInputView.getNewModel();
        InfoOperacionContableDomain info = infoInputView.getNewModel();
        info.setTipoOperacionFk(tipo);

        CuadreUI cuadre = new CuadreUI(op, info);
        if (getOldModel() == null) {
            return new CuadreDomain(cuadre);
        } else {
            getOldModel().updateWith(cuadre);
            return getOldModel();
        }
    }

}
