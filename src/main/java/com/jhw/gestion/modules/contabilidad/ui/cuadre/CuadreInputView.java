package com.jhw.gestion.modules.contabilidad.ui.cuadre;

import com.jhw.gestion.modules.contabilidad.ui.cuadre.pedazos.OperacionCuadreInputView;
import com.jhw.gestion.modules.contabilidad.core.domain.facade.CuadreUI;
import com.jhw.swing.material.components.container.layout.VerticalLayoutContainer;
import com.jhw.swing.models.clean.CleanCRUDInputView;
import com.jhw.gestion.modules.contabilidad.core.domain.*;
import com.jhw.gestion.modules.contabilidad.core.domain.facade.DocNombreUI;
import com.jhw.gestion.modules.contabilidad.core.domain.facade.FechaDescUI;
import com.jhw.gestion.modules.contabilidad.core.domain.facade.OperacionCuadreUI;
import com.jhw.gestion.modules.contabilidad.core.usecase_impl.TipoOperacionContableUseCaseImpl;
import com.jhw.gestion.modules.contabilidad.ui.cuadre.pedazos.DocNombreInputView;
import com.jhw.gestion.modules.contabilidad.ui.cuadre.pedazos.FechaDescInputView;
import com.jhw.gestion.modules.contabilidad.ui.module.ContabilidadSwingModule;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class CuadreInputView extends CleanCRUDInputView<CuadreDomain> {

    public CuadreInputView() {
        this(null);
    }

    public CuadreInputView(CuadreDomain model) {
        super(model, ContabilidadSwingModule.cuadreUC);
        initComponents();
        update();
    }

    private void initComponents() {
        //doc, nombre ....
        docNombreInputView = new DocNombreInputView();

        //valor, cuentas ....
        operacionInputView = new OperacionCuadreInputView(TipoOperacionContableUseCaseImpl.MOVIMIENTO_INTERNO);

        //fecha, desc ....
        fechaDescInputView = new FechaDescInputView();

        VerticalLayoutContainer.builder vlc = VerticalLayoutContainer.builder(400);
        vlc.add(docNombreInputView);
        vlc.add(operacionInputView);
        vlc.add(fechaDescInputView, true);

        this.setComponent(vlc.build());
    }

    // Variables declaration - do not modify
    private DocNombreInputView docNombreInputView;
    private OperacionCuadreInputView operacionInputView;
    private FechaDescInputView fechaDescInputView;
    // End of variables declaration                   

    @Override
    public void update() {
        if (getOldModel() == null) {
            setHeader("Crear Cuadre");
        } else {
            setHeader("Editar Cuadre");
            docNombreInputView.setObject(new DocNombreUI(getOldModel().info()));
            fechaDescInputView.setObject(new FechaDescUI(getOldModel().info()));
            operacionInputView.setObject(new OperacionCuadreUI(getOldModel()));
        }
    }

    @Override
    public CuadreDomain getNewModel() throws Exception {
        DocNombreUI docNombre = docNombreInputView.getNewModel();
        OperacionCuadreUI op = operacionInputView.getNewModel();
        FechaDescUI fechaDesc = fechaDescInputView.getNewModel();

        CuadreUI cuadre = new CuadreUI(docNombre, op, fechaDesc);
        if (getOldModel() == null) {
            return cuadre.buildCuadre();
        } else {
            CuadreDomain cuadreDomain = cuadre.buildCuadre();;
            cuadreDomain.setIdCuadre(getOldModel().getIdCuadre());
            return cuadreDomain;
        }
    }

}
