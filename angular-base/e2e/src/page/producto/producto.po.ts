import { by, element } from 'protractor';

export class ClientePage {
    private linkCrearCliente = element(by.id('linkCrearCliente'));
    private linkListarClientes = element(by.id('linkListarCliente'));
    private inputNombre = element(by.id('inputnombre'));
    private inputCedula = element(by.id('inputcedula'));
    private exitoCreacion = element(by.id('mensajecreacionexito'));
    private listaClientes = element.all(by.css('tbody.clientes tr'));

    async CrearClientes() {
        await this.linkCrearCliente.click();
    }

    async ListarClientes() {
        await this.linkListarClientes.click();
    }

    async ingresarNombre(idNombre) {
        await this.inputNombre.sendKeys(idNombre);
    }

    async ingresarCedula(cedula) {
        await this.inputCedula.sendKeys(cedula);
    }

    async contarClientes() {
        return this.listaClientes.count();
    }


    obtenerMensajeExito() {
        return this.exitoCreacion.element(by.css('span')).getText() as Promise<string>;
      }
}
