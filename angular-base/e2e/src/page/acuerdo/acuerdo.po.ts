import { by, element } from "protractor";

export class AcuerdoPage {
    private linkCrearAcuerdo = element(by.id('registrarAcuerdo'));
    private linkListarAcuerdo = element(by.id('linkListarAcuerdo'));
    private selectcliente = element(by.model('selectcliente'));
    private selectdeuda = element(by.model('selectdeuda'));
    private inputfecha = element(by.id('inputfecha'));
    private inputmontodeuda = element(by.id('inputmontocuota'));
    private selectestado = element(by.model('selectestado'));
    private inputreferencia = element(by.id('inputreferencia'));
    private inputcantidadcuotas = element(by.id('inputcantidadcuotas'));
    private listaAcuerdos = element.all(by.css('tbody.acuerdos tr'));

    async crearAcuerdo() {
        this.linkCrearAcuerdo.click();
    }

    async ListarAcuerdos() {
        this.linkListarAcuerdo.click();
    }

    async ingresarSelectCliente(cliente) {
        this.selectcliente.element(by.css(cliente));
    }

    async ingresarSelectDeuda (deuda){
        this.selectdeuda.element(by.css(deuda));
    }
    async ingresarinputFecha(fecha){
        this.inputfecha.sendKeys(fecha);
    }
    async ingresarInputMontoDeuda(montoDeuda){
        this.inputmontodeuda.sendKeys(montoDeuda);
    }
    async ingresarselectEstado(estado){
        this.selectestado.element(by.css(estado));
    }
    async ingresarInputReferencia(referencia){
        this.inputreferencia.sendKeys(referencia);
    }
    async ingresarinputcantidadcuotas(cantidadCuotas){
        this.inputcantidadcuotas.sendKeys(cantidadCuotas);
    }

    async contarAcuerdos() {
        return this.listaAcuerdos.count();
    }
}