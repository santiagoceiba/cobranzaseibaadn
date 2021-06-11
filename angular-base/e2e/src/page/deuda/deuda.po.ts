import { by, element } from 'protractor';

export class DeudaPage {
    private linkcrearDeuda = element(by.id('registrarDeuda'));
    private linkListarDeuda = element(by.id('linkListarProducto'));
    private inputNombreEntidad = element(by.id('inputnombreentidad'));
    private inputConceptoDeuda = element(by.id('inputconceptodeuda'));
    private inputmontodeuda = element(by.id('montodeuda'));
    private inputFecha = element(by.id('inputfecha'));
    private inputselectcliente = element(by.model('cliente'));
    private listaDeudas = element.all(by.css('tbody.deudas tr'));

    async crearDeuda() {
        this.linkcrearDeuda.click();
    }

    async ListarDeudas() {
        this.linkListarDeuda.click();
    }

    async ingresarNombreEntidad(nombreEntidad) {
        this.inputNombreEntidad.sendKeys(nombreEntidad);
    }

    async ingresarConceptoDeuda(conceptoDeuda) {
        this.inputConceptoDeuda.sendKeys(conceptoDeuda);
    }


    async ingresarMontoDeuda(montoDeuda) {
        this.inputmontodeuda.sendKeys(montoDeuda);
    }

    async ingresarFecha(fecha) {
        this.inputFecha.click();
        this.inputFecha.sendKeys(fecha);
    }

    async seleccionarCliente(valor) {
        this.inputselectcliente.element(by.css(valor));
        //
    }

    async contarDeudas() {
        return this.listaDeudas.count();
    }
}