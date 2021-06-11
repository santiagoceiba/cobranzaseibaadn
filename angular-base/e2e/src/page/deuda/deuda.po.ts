import { by, element, protractor } from 'protractor';

export class DeudaPage {
    private linkcrearDeuda = element(by.id('registrarDeuda'));
    private linkListarDeuda = element(by.id('linkListarProducto'));
    private inputNombreEntidad = element(by.id('inputnombreentidad'));
    private inputConceptoDeuda = element(by.id('inputconceptodeuda'));
    private inputmontodeuda = element(by.id('montodeuda'));
    private inputFecha = element(by.id('inputfecha'));
    private inputselectcliente = element(by.tagName("select#inputState"));
    private exitoCreacion = element(by.id('mensajecreaciodeudaexito'));
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

    async ingresarFecha() {
        //this.inputFecha.click();
        let tab = protractor.Key.ARROW_RIGHT;
        this.inputFecha.sendKeys(('1'+ tab +'1'+tab + '2021' +tab + '1' + tab +'1' + tab + '1'));
    }

    async seleccionarCliente() {
        await this.inputselectcliente.click();
        await element(by.css('#inputState [value="2"]')).click();
    }

    async  obtenerMensajeExito() {
        await this.exitoCreacion.getText();
      }

    async contarDeudas() {
        return this.listaDeudas.count();
    }
}