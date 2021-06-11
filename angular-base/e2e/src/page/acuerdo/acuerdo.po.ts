import { by, element, protractor } from "protractor";

export class AcuerdoPage {
    private linkCrearAcuerdo = element(by.id('registrarAcuerdo'));
    private linkListarAcuerdo = element(by.id('linkListarAcuerdo'));
    private selectcliente = element(by.tagName("select#inputselectcliente"));
    private selectdeuda = element(by.tagName('select#selectdeuda'));
    private inputfecha = element(by.id('inputfecha'));
    private inputmontodeuda = element(by.id('inputmontocuota'));
    private selectestado = element(by.tagName('select#selectestado'));
    private inputreferencia = element(by.id('inputreferencia'));
    private inputcantidadcuotas = element(by.id('inputcantidadcuotas'));
    private exitoCreacion = element(by.id('mensajecreaciodeudaexito'));
    private listaAcuerdos = element.all(by.css('tbody.acuerdos tr'));

    async crearAcuerdo() {
        this.linkCrearAcuerdo.click();
    }

    async ListarAcuerdos() {
        this.linkListarAcuerdo.click();
    }

    async ingresarSelectCliente() {
       await  this.selectcliente.click();
       await element(by.css('#inputselectcliente [value="1"]')).click();

    }

    async ingresarSelectDeuda (){
        await  this.selectdeuda.click();
       await element(by.css('#selectdeuda [value="1"]')).click();
    }
    async ingresarinputFecha(){
        let tab = protractor.Key.ARROW_RIGHT;
        this.inputfecha.sendKeys(('1'+ tab +'1'+tab + '2021' +tab + '1' + tab +'1' + tab + '1'));
    }
    async ingresarInputMontoDeuda(montoDeuda){
        this.inputmontodeuda.sendKeys(montoDeuda);
    }
    async ingresarselectEstado(){
        await  this.selectestado.click();
       await element(by.css('#selectestado [value="ACTIVO"]')).click();
    }
    async ingresarInputReferencia(referencia){
        this.inputreferencia.sendKeys(referencia);
    }
    async ingresarinputcantidadcuotas(cantidadCuotas){
        this.inputcantidadcuotas.sendKeys(cantidadCuotas);
    }

    async  obtenerMensajeExito() {
        await this.exitoCreacion.getText();
      }

    async contarAcuerdos() {
        return this.listaAcuerdos.count();
    }
}