

import { AcuerdoPage } from "../../../src/page/acuerdo/acuerdo.po";
import { NavbarPage } from "../../page/navbar/navbar.po";
import { browser } from 'protractor';

describe('workspace-acuerdo acuerdo', () => {
 
    let navBar: NavbarPage;
    let acuerdo: AcuerdoPage;

    beforeEach(async () => {
     
        navBar = new NavbarPage();
        await browser.get(browser.baseUrl);
        acuerdo = new AcuerdoPage();
    });

    it('Deberia crear la acuerdo', async () => {

        const SELECT_CLIENTE  =  "option[value]='1'";
        const SELECT_DEUDA = "option[value]='1'";
        const INPUT_FECHA = "2020-05-05 00:01";
        const INPUT_MONTODEUDA = 10;
        const SELECT_ESTADO = "option[value]='ACTIVO'";
        const INPUT_REFERENCIA = 333
        const INPUT_CANTIDADCUOTAS = 2;

        await navBar.NavegarSeccionAcuerdo();
        await acuerdo.ingresarInputMontoDeuda(INPUT_MONTODEUDA);
        await acuerdo.ingresarInputReferencia(INPUT_REFERENCIA);
        await acuerdo.ingresarSelectCliente(SELECT_CLIENTE);
        await acuerdo.ingresarSelectDeuda(SELECT_DEUDA);
        await acuerdo.ingresarinputFecha(INPUT_FECHA);
        await acuerdo.ingresarinputcantidadcuotas(INPUT_CANTIDADCUOTAS);
        await acuerdo.ingresarselectEstado(SELECT_ESTADO);
        acuerdo.crearAcuerdo();
       

        // Adicionamos las validaciones despues de la creación
        // expect(<>).toEqual(<>);
    });

    it('Deberia listar acuerdos', async () => {
        await browser.get(browser.baseUrl + '/acuerdos');
        await acuerdo.ListarAcuerdos();
        
        expect(4).toBe(acuerdo.contarAcuerdos());
    });
});