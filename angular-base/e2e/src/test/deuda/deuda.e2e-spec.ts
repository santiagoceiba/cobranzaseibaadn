import { AppPage } from "../../../src/app.po";
import { DeudaPage } from '../../page/deuda/deuda.po';
import { NavbarPage } from '../../page/navbar/navbar.po';

describe('workspace-deuda deuda', () => {
    let page: AppPage;
    let navBar: NavbarPage;
    let deuda: DeudaPage;

    beforeEach(() => {
        page = new AppPage();
        navBar = new NavbarPage();
        deuda = new DeudaPage();
    });

    it('Deberia crear la deuda', () => {
        const INPUT_NOMBRE_ENTIDAD = 'prueba protactor'
        const INPUT_CONCEPTO_DEUDA = 'pruebas funcionales'
        const MONTO_DEUDA = 10;
        const INPUT_FECHA = "2020-05-05 00:01"
        const SELECT_CLIENTE = "option[value]='1'";

        page.navigateTo();
        navBar.NavegarSeccionDeuda();
        deuda.crearDeuda();
        deuda.ingresarConceptoDeuda(INPUT_CONCEPTO_DEUDA);
        deuda.ingresarFecha(INPUT_FECHA);
        deuda.ingresarMontoDeuda(MONTO_DEUDA);
        deuda.ingresarNombreEntidad(INPUT_NOMBRE_ENTIDAD);
        deuda.seleccionarCliente(SELECT_CLIENTE)

        // Adicionamos las validaciones despues de la creación
        // expect(<>).toEqual(<>);
    });

    it('Deberia listar deudas', () => {
        page.navigateTo();
        navBar.NavegarSeccionClientes();
        deuda.ListarDeudas();

        expect(4).toBe(deuda.contarDeudas());
    });
});