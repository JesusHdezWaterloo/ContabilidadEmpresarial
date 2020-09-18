package com.jhw.gestion.modules.contabilidad.ui.cuadre.pedazos;

import com.jhw.gestion.modules.contabilidad.core.domain.CuentaContableDomain;
import com.jhw.gestion.modules.contabilidad.core.domain.TipoOperacionContableDomain;
import com.jhw.swing.material.components.container.layout.VerticalLayoutContainer;
import com.jhw.swing.models.clean.CleanCRUDInputView;
import com.jhw.gestion.modules.contabilidad.core.domain.facade.OperacionCuadreUI;
import com.jhw.gestion.modules.contabilidad.ui.cuenta_contable.CuentaContableICBS;
import com.jhw.gestion.modules.contabilidad.ui.moneda.MonedaICBS;
import com.jhw.gestion.modules.contabilidad.ui.tipo_operacion.TipoOperacionContableICBS;
import com.jhw.swing.material.components.container.layout.HorizontalLayoutComponent;
import com.jhw.swing.material.components.container.layout.HorizontalLayoutContainer;
import com.jhw.swing.material.components.textfield.MaterialFormatedTextFieldIcon;
import com.jhw.swing.material.standards.MaterialIcons;
import com.jhw.swing.prepared.textfield.MaterialPreparedTextFactory;
import java.awt.event.ActionEvent;
import java.util.Map;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class OperacionCuadreInputView extends CleanCRUDInputView<OperacionCuadreUI> {

    public static OperacionCuadreInputView from() {
        return new OperacionCuadreInputView((OperacionCuadreUI) null);
    }

    public static OperacionCuadreInputView fromTipoOp(TipoOperacionContableDomain opDefecto) {
        return new OperacionCuadreInputView(opDefecto);
    }

    private OperacionCuadreInputView(TipoOperacionContableDomain opDefecto) {
        this((OperacionCuadreUI) null);
        setTipoOp(opDefecto);
    }

    public OperacionCuadreInputView(OperacionCuadreUI model) {
        super(model, null, OperacionCuadreUI.class);
        initComponents();
        addListeners();
        update();
    }

    private void initComponents() {
        textFieldValor = MaterialPreparedTextFactory.buildFormatedMoneyIcon();
        textFieldValor.setLabel("Valor");
        textFieldValor.setHint("Valor de la operación");
        textFieldValor.setIcon(MaterialIcons.ATTACH_MONEY);

        moneda = new MonedaICBS();
        tipoOperICBS = new TipoOperacionContableICBS();

        //cuenta
        cuentaICBS = new CuentaContableICBS();
        cuentaICBS.setLabel("Cuenta Inicial");

        //cuadre
        cuentaCuadreICBS = new CuentaContableICBS();
        cuentaCuadreICBS.setLabel("Cuenta Cuadre");

        VerticalLayoutContainer.builder vlc = VerticalLayoutContainer.builder();

        HorizontalLayoutContainer.builder hlcDebito = HorizontalLayoutContainer.builder((int) textFieldValor.getPreferredSize().getHeight());
        hlcDebito.add(HorizontalLayoutComponent.builder(textFieldValor).gapRight(5).build());
        hlcDebito.add(HorizontalLayoutComponent.builder(moneda).gapLeft(5).build());
        vlc.add(hlcDebito.build());

        vlc.add(cuentaICBS);
        vlc.add(cuentaCuadreICBS);
        vlc.add(tipoOperICBS);

        this.setComponent(vlc.build());
    }

    // Variables declaration - do not modify
    private MaterialFormatedTextFieldIcon textFieldValor;
    private MonedaICBS moneda;
    private CuentaContableICBS cuentaICBS;
    private CuentaContableICBS cuentaCuadreICBS;
    private TipoOperacionContableICBS tipoOperICBS;
    // End of variables declaration                   

    @Override
    public void setObject(OperacionCuadreUI t) {
        setOldModel(t);
        update();
    }

    @Override
    public Map<String, Object> bindFields() {
        Map<String, Object> bindFields = super.bindFields();
        bindFields.put("valor", textFieldValor);
        bindFields.put("moneda", moneda);
        bindFields.put("cuenta", cuentaICBS);
        bindFields.put("cuadre", cuentaCuadreICBS);
        bindFields.put("tipoOp", tipoOperICBS);
        return bindFields;
    }

    private void addListeners() {
        cuentaICBS.getComboBox().addActionListener((ActionEvent e) -> {
            updateCuadreICBS();
        });
        tipoOperICBS.getComboBox().addActionListener((ActionEvent e) -> {
            changeTipoOp();
        });
    }

    private void updateCuadreICBS() {
        try {
            CuentaContableDomain old = cuentaCuadreICBS.getObject();
            cuentaCuadreICBS.updateComboBoxCuadre(cuentaICBS.getObject().getTipoCuentaFk());
            cuentaCuadreICBS.setObject(old);
        } catch (Exception e) {
        }
    }

    public void setTipoOp(TipoOperacionContableDomain opDefecto) {
        if (opDefecto != null) {
            try {
                this.cuentaICBS.updateComboBoxCuenta(opDefecto.getTipoCuentaDefectoFk());
                this.cuentaICBS.setMatchingItem(opDefecto.getTipoCuentaDefectoFk(), moneda.getObject());

                this.cuentaCuadreICBS.updateComboBoxCuenta(opDefecto.getTipoCuentaCuadreDefectoFk());
                this.cuentaCuadreICBS.setMatchingItem(opDefecto.getTipoCuentaCuadreDefectoFk(), moneda.getObject());

                tipoOperICBS.setObject(opDefecto);
            } catch (Exception e) {
            }
        }
    }

    public TipoOperacionContableICBS getTipoOperICBS() {
        return tipoOperICBS;
    }

    public MonedaICBS getMoneda() {
        return moneda;
    }

    public CuentaContableICBS getCuentaICBS() {
        return cuentaICBS;
    }

    public CuentaContableICBS getCuentaCuadreICBS() {
        return cuentaCuadreICBS;
    }

    public MaterialFormatedTextFieldIcon getTextFieldValor() {
        return textFieldValor;
    }

    private void changeTipoOp() {
        try {
            setTipoOp(tipoOperICBS.getObject());
        } catch (Exception e) {
        }
    }
}
