import { by, element } from "protractor";

export class AcuerdoPage {
    private linkCrearAcuerdo = element(by.id('linkCrearAcuerdo'));
    private linkListarAcuerdo = element(by.id('linkListarAcuerdo'));
    private selectcliente = element(by.model('selectcliente'));
    private selectdeuda = element(by.model('selectdeuda'));
    private inputfecha = element(by.id('inputfecha'));
    private inputmontodeuda = element(by.id('inputmontodeuda'));
    private selectestado = element(by.model('selectestado'));
    private inputreferencia = element(by.id('inputmontodeuda'));
    private inputcantidadcuotas = element(by.id('inputmontodeuda'));
    private listaAcuerdos = element.all(by.css('tbody.acuerdos tr'));

    async crearAcuerdo() {
        await this.linkCrearAcuerdo.click();
    }

    async ListarAcuerdos() {
        await this.linkListarAcuerdo.click();
    }

    async ingresarSelectCliente(cliente) {
        await this.selectcliente.element(by.css(cliente));
    }

    async ingresarSelectDeuda (deuda){
        await this.selectdeuda.element(by.css(deuda));
    }
    async ingresarinputFecha(fecha){
        await this.inputfecha.sendKeys(fecha);
    }
    async ingresarInputMontoDeuda(montoDeuda){
        await this.inputmontodeuda.sendKeys(montoDeuda);
    }
    async ingresarselectEstado(estado){
        await this.selectestado.element(by.css(estado));
    }
    async ingresarInputReferencia(referencia){
        await this.inputreferencia.sendKeys(referencia);
    }
    async ingresarinputcantidadcuotas(cantidadCuotas){
        await this.inputcantidadcuotas.sendKeys(cantidadCuotas);
    }

    async contarAcuerdos() {
        return this.listaAcuerdos.count();
    }
}