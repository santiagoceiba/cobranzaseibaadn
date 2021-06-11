import { by, element } from 'protractor';

export class ClientePage {
    //private linkCrearCliente = element(by.id('linkCrearCliente'));
    private linkCrearCliente = element(by.id('registrarCliente'));
    private linkListarClientes = element(by.id('linkListarCliente'));
    private inputNombre = element(by.id('inputnombre'));
    private inputCedula = element(by.id('inputcedula'));
    private exitoCreacion = element(by.id('mensajecreacionexito'));
    private listaClientes = element.all(by.css('tbody.clientes tr'));

    async CrearClientes() {
         this.linkCrearCliente.click();
    }

    async ListarClientes() {
         this.linkListarClientes.click();
    }

    async ingresarNombre(idNombre) {
         this.inputNombre.sendKeys(idNombre);
    }

    async ingresarCedula(cedula) {
         this.inputCedula.sendKeys(cedula);
    }

    async contarClientes() {
        return this.listaClientes.count();
    }


   async  obtenerMensajeExito() {
        await this.exitoCreacion.getText();
      }
}
