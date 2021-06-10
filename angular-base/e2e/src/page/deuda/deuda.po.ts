import { by, element } from 'protractor';

export class DeudaPage {
    private linkcrearDeuda = element(by.id('linkCrearProducto'));
    private linkListarDeuda = element(by.id('linkListarProducto'));
    private inputNombreEntidad = element(by.id('inputnombreentidad'));
    private inputConceptoDeuda = element(by.id('inputconceptodeuda'));
    private inputmontodeuda = element(by.id('montodeuda'));
    private inputFecha = element(by.id('inputfecha'));
    private inputselectcliente = element(by.model('cliente'));
    private listaDeudas = element.all(by.css('tbody.deudas tr'));

    async crearDeuda() {
        await this.linkcrearDeuda.click();
    }

    async ListarDeudas() {
        await this.linkListarDeuda.click();
    }

    async ingresarNombreEntidad(nombreEntidad) {
        await this.inputNombreEntidad.sendKeys(nombreEntidad);
    }

    async ingresarConceptoDeuda(conceptoDeuda) {
        await this.inputConceptoDeuda.sendKeys(conceptoDeuda);
    }


    async ingresarMontoDeuda(montoDeuda) {
        await this.inputmontodeuda.sendKeys(montoDeuda);
    }

    async ingresarFecha(fecha) {
        await this.inputFecha.sendKeys(fecha);
    }

    async seleccionarCliente(valor) {
        await this.inputselectcliente.element(by.css(valor));
        //
    }

    async contarDeudas() {
        return this.listaDeudas.count();
    }
}