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
        const INPUT_FECHA = "2021-05-05 08:12:13"
        const SELECT_CLIENTE = "option[value]='1'";

        await navBar.NavegarSeccionDeuda();
        await deuda.ingresarConceptoDeuda(INPUT_CONCEPTO_DEUDA);
        await deuda.ingresarFecha(INPUT_FECHA);
        await deuda.ingresarMontoDeuda(MONTO_DEUDA);
        await deuda.ingresarNombreEntidad(INPUT_NOMBRE_ENTIDAD);
        await deuda.seleccionarCliente(SELECT_CLIENTE);
        await deuda.crearDeuda();
        // Adicionamos las validaciones despues de la creación
        // expect(<>).toEqual(<>);
    });

    it('Deberia listar deudas', async () => {
        await browser.get(browser.baseUrl + '/deuda');
        await deuda.ListarDeudas();
        expect(4).toBe(deuda.contarDeudas());
    });
});