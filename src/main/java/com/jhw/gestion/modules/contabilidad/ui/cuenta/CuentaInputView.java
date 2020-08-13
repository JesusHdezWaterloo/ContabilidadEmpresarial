package com.jhw.gestion.modules.contabilidad.ui.cuenta;

import com.jhw.gestion.modules.contabilidad.core.domain.old.CuentaDomain;
import com.jhw.gestion.modules.contabilidad.core.domain.old.MonedaDomain;
import com.jhw.swing.bundles.dialog.DialogPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.jhw.gestion.modules.contabilidad.repo.entities.old.Cuenta;
import com.jhw.gestion.modules.contabilidad.repo.entities.old.Moneda;
import com.jhw.gestion.modules.contabilidad.ui.module.ContabilidadSwingModule;
import com.jhw.gestion.modules.contabilidad.ui.subcuenta.JerarquiaPanel;
import com.jhw.swing.material.components.container.layout.HorizontalLayoutComponent;
import com.jhw.swing.material.components.container.layout.HorizontalLayoutContainer;
import com.jhw.swing.material.components.container.layout.VerticalLayoutComponent;
import com.jhw.swing.material.components.container.layout.VerticalLayoutContainer;
import com.jhw.swing.models.clean.CleanCRUDInputView;
import com.jhw.swing.util.Utils;
import java.awt.Dimension;
import java.util.Map;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class CuentaInputView extends CleanCRUDInputView<CuentaDomain> {

    public CuentaInputView() {
        this(null);
    }

    public CuentaInputView(CuentaDomain model) {
        super(model, ContabilidadSwingModule.cuentaUC, CuentaDomain.class);
        initComponents();
        addListeners();
        update();
    }

    private void initComponents() {

        monedaICBS = new com.jhw.gestion.modules.contabilidad.ui.moneda.MonedaICBS();
        textFieldNombre = new com.jhw.swing.material.components.textfield.validated._MaterialTextFieldStringNotEmpty();
        textFieldPorciento = new com.jhw.swing.material.components.textfield.validated._MaterialTextFieldPorciento();
        textFieldNumeroCuenta = new com.jhw.swing.material.components.textfield.validated._MaterialTextFieldStringNotEmpty();
        textFieldPin = new com.jhw.swing.material.components.textfield.validated._MaterialTextFieldStringNotEmpty();
        textAreaDescripcion = new com.jhw.swing.material.components.textarea.prepared._MaterialTextAreaDescripcion();
        buttonJerarquia = new com.jhw.swing.material.components.button.prepared._buttonView();

        setHeader("Crear Cuenta", "Editar Cuenta");

        textFieldNombre.setHint("Nombre de la cuenta");
        textFieldNombre.setLabel("Nombre");

        textFieldPorciento.setHint("Porciento a depositar desde el padre");
        textFieldPorciento.setLabel("Porciento");

        textFieldNumeroCuenta.setHint("Número real de la cuenta en el banco");
        textFieldNumeroCuenta.setLabel("Número de cuenta");

        textFieldPin.setHint("Pin de autenticación");
        textFieldPin.setLabel("Pin");
        //el pin es chiquitico
        textFieldPin.setPreferredSize(new Dimension(Utils.fontMetrics(textFieldPin.getFont()).stringWidth("0000"), (int) textFieldPin.getPreferredSize().getHeight()));

        buttonJerarquia.setText("Jerarquía");
        VerticalLayoutContainer.builder vlc = VerticalLayoutContainer.builder();
        vlc.add(textFieldNombre);
        vlc.add(textFieldPorciento);
        vlc.add(monedaICBS);

        HorizontalLayoutContainer.builder hlcFechas = HorizontalLayoutContainer.builder((int) textFieldNumeroCuenta.getPreferredSize().getHeight());
        hlcFechas.add(HorizontalLayoutComponent.builder(textFieldNumeroCuenta).gapRight(5).build());
        hlcFechas.add(HorizontalLayoutComponent.builder(textFieldPin).gapLeft(5).build());
        vlc.add(VerticalLayoutComponent.builder(hlcFechas.build()).gapTop(5).build());

        vlc.add(textAreaDescripcion, true);
        vlc.add(VerticalLayoutComponent.builder(buttonJerarquia).gapTop(10).build());
        this.setComponent(vlc.build());
    }

    // Variables declaration - do not modify
    private com.jhw.swing.material.components.button.prepared._buttonView buttonJerarquia;
    private com.jhw.gestion.modules.contabilidad.ui.moneda.MonedaICBS monedaICBS;
    private com.jhw.swing.material.components.textarea.prepared._MaterialTextAreaDescripcion textAreaDescripcion;
    private com.jhw.swing.material.components.textfield.validated._MaterialTextFieldStringNotEmpty textFieldNombre;
    private com.jhw.swing.material.components.textfield.validated._MaterialTextFieldStringNotEmpty textFieldNumeroCuenta;
    private com.jhw.swing.material.components.textfield.validated._MaterialTextFieldStringNotEmpty textFieldPin;
    private com.jhw.swing.material.components.textfield.validated._MaterialTextFieldPorciento textFieldPorciento;
    // End of variables declaration                   

    @Override
    public void update() {
        super.update();
        textFieldPorciento.setEnabled(getOldModel() == null || !getOldModel().getCuentaBase());
        buttonJerarquia.setEnabled(getOldModel() != null);
        monedaICBS.setEnabled(getOldModel() == null);
    }

    @Override
    public CuentaDomain getNewModel() throws Exception {
        CuentaDomain cuenta = super.getNewModel();
        cuenta.setCuentaBase(false);
        cuenta.setTotalDepositos(0);
        cuenta.setTotalExtracciones(0);
        return cuenta;
    }

    @Override
    public Map<String, Object> bindFields() {
        Map<String, Object> bindFields = super.bindFields();
        bindFields.put("nombreCuenta", textFieldNombre);
        bindFields.put("porciento", textFieldPorciento);
        bindFields.put("numeroCuenta", textFieldNumeroCuenta);
        bindFields.put("pin", textFieldPin);
        bindFields.put("descripcion", textAreaDescripcion);
        bindFields.put("monedaFk", monedaICBS);
        return bindFields;
    }

    private void addListeners() {
        buttonJerarquia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onButtonJerarquiaActionPerformed();
            }
        });
    }

    private void onButtonJerarquiaActionPerformed() {
        new DialogPanel("Jerarquí ade cuenta", new JerarquiaPanel(getOldModel()));
    }
}
