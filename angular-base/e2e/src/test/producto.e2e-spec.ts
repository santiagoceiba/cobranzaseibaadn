import { NavbarPage } from '../page/navbar/navbar.po';

import { ClientePage } from '../page/producto/producto.po';
import { browser } from 'protractor';
describe('workspace-project Producto', () => {

    let navBar: NavbarPage;
    let cliente: ClientePage;

    beforeEach(async ()  => {

        navBar = new NavbarPage();
        await browser.get(browser.baseUrl);
        cliente = new ClientePage();
    });

    it('Deberia crear cliente', async () => {
        const NOMBRE = 'protactor creacion cliente';
        const CEDULA = '6';
        //const MENSAJE_EXITO = 'Cliente creado con éxito';
        
        await navBar.NavegarSeccionClientes(); 
        await cliente.ingresarCedula(CEDULA);
        await cliente.ingresarNombre(NOMBRE);
        await cliente.CrearClientes();
        
       // expect(cliente.obtenerMensajeExito()).toEqual(MENSAJE_EXITO);
    });

    it('Deberia listar clientes', async () => {
        await browser.get(browser.baseUrl + '/cliente');
        await cliente.ListarClientes();

        expect(4).toBe(cliente.contarClientes());
    });
});
