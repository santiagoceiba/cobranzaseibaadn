import { DeudaPage } from '../../page/deuda/deuda.po';
import { NavbarPage } from '../../page/navbar/navbar.po';
import { browser } from 'protractor';

describe('workspace-deuda deuda', () => {

    let navBar: NavbarPage;
    let deuda: DeudaPage;

    beforeEach(async () => {

        navBar = new NavbarPage();
        await browser.get(browser.baseUrl);
        deuda = new DeudaPage();
    });

    it('Deberia crear la deuda', async () => {
        const INPUT_NOMBRE_ENTIDAD = 'prueba protactor'
        const INPUT_CONCEPTO_DEUDA = 'pruebas funcionales'
        const MONTO_DEUDA = 10;
        //const INPUT_FECHA = '2011-08-19T13:45';
        //const SELECT_CLIENTE = 1;
        //const INPUT_HORA ="11:45"
        //const MENSAJE_EXITO = "Deuda Creada con éxito";

        await navBar.NavegarSeccionDeuda();
        await deuda.ingresarConceptoDeuda(INPUT_CONCEPTO_DEUDA);
        browser.sleep(50000);
        
        //await browser.executeScript("angular.element(document.getElementById('inputfecha')).val('2011-11-11')");
        //await browser.executeScript("document.getElementById('inputfecha').value='06/06/2021'")
        await deuda.ingresarFecha();
        browser.sleep(50000);
        await deuda.ingresarMontoDeuda(MONTO_DEUDA);
        await deuda.ingresarNombreEntidad(INPUT_NOMBRE_ENTIDAD);
        await deuda.seleccionarCliente();
        await deuda.crearDeuda();

        //expect(deuda.obtenerMensajeExito).toEqual(MENSAJE_EXITO);
    });

    it('Deberia listar deudas', async () => {
        await browser.get(browser.baseUrl + '/deuda');
        await deuda.ListarDeudas();
        expect(4).toBe(deuda.contarDeudas());
    });
});