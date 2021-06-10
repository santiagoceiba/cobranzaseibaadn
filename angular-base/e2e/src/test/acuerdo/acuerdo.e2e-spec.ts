
import { AppPage } from "../../../src/app.po";
import { AcuerdoPage } from "../../../src/page/acuerdo/acuerdo.po";
import { NavbarPage } from "../../page/navbar/navbar.po";

describe('workspace-acuerdo acuerdo', () => {
    let page: AppPage;
    let navBar: NavbarPage;
    let acuerdo: AcuerdoPage;

    beforeEach(() => {
        page = new AppPage();
        navBar = new NavbarPage();
        acuerdo = new AcuerdoPage();
    });

    it('Deberia crear la acuerdo', () => {

        const SELECT_CLIENTE  =  "option[value]='1'";
        const SELECT_DEUDA = "option[value]='1'";
        const INPUT_FECHA = "2020-05-05 00:01";
        const INPUT_MONTODEUDA = 10;
        const SELECT_ESTADO = "option[value]='ACTIVO'";
        const INPUT_REFERENCIA = 333
        const INPUT_CANTIDADCUOTAS = 2;

        page.navigateTo();
        navBar.NavegarSeccionAcuerdo();
        acuerdo.crearAcuerdo();
        acuerdo.ingresarInputMontoDeuda(INPUT_MONTODEUDA);
        acuerdo.ingresarInputReferencia(INPUT_REFERENCIA);
        acuerdo.ingresarSelectCliente(SELECT_CLIENTE);
        acuerdo.ingresarSelectDeuda(SELECT_DEUDA);
        acuerdo.ingresarinputFecha(INPUT_FECHA);
        acuerdo.ingresarinputcantidadcuotas(INPUT_CANTIDADCUOTAS);
        acuerdo.ingresarselectEstado(SELECT_ESTADO);

        // Adicionamos las validaciones despues de la creación
        // expect(<>).toEqual(<>);
    });

    it('Deberia listar acuerdos', () => {
        page.navigateTo();
        navBar.NavegarSeccionClientes();
        acuerdo.ListarAcuerdos();

        expect(4).toBe(acuerdo.contarAcuerdos());
    });
});