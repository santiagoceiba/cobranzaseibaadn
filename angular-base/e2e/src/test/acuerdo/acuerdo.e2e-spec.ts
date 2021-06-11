

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


      
        const INPUT_MONTODEUDA = 10;
        const INPUT_REFERENCIA = 333
        const INPUT_CANTIDADCUOTAS = 2;
        //const MENSAJE_EXITO = "Acuerdo Creada con éxito";

        await navBar.NavegarSeccionAcuerdo();
        await acuerdo.ingresarInputMontoDeuda(INPUT_MONTODEUDA);
        await acuerdo.ingresarInputReferencia(INPUT_REFERENCIA);
        await acuerdo.ingresarSelectCliente();
        await acuerdo.ingresarSelectDeuda();
        await acuerdo.ingresarinputFecha();
        await acuerdo.ingresarinputcantidadcuotas(INPUT_CANTIDADCUOTAS);
        await acuerdo.ingresarselectEstado();
        acuerdo.crearAcuerdo();
       

        // Adicionamos las validaciones despues de la creación
        // expect(ACUERDO.obtenerMensajeExito).toEqual(MENSAJE_EXITO);
    });

    it('Deberia listar acuerdos', async () => {
        await browser.get(browser.baseUrl + '/acuerdos');
        await acuerdo.ListarAcuerdos();
        
        expect(4).toBe(acuerdo.contarAcuerdos());
    });
});