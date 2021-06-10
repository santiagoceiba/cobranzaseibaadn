import { NavbarPage } from '../page/navbar/navbar.po';
import { AppPage } from '../app.po';
import { ClientePage } from '../page/producto/producto.po';

describe('workspace-project Producto', () => {
    let page: AppPage;
    let navBar: NavbarPage;
    let cliente: ClientePage;

    beforeEach(() => {
        page = new AppPage();
        navBar = new NavbarPage();
        cliente = new ClientePage();
    });

    it('Deberia crear cliente', () => {
        const NOMBRE = 'Santiago';
        const CEDULA = '1';
        const MENSAJE_EXITO_ = 'Cliente creado con éxito';

        page.navigateTo();
        navBar.NavegarSeccionClientes();
        cliente.CrearClientes();
        cliente.ingresarNombre(NOMBRE);
        cliente.ingresarCedula(CEDULA);
        expect(cliente.obtenerMensajeExito()).toEqual(MENSAJE_EXITO_)
    });

    it('Deberia listar clientes', () => {
        page.navigateTo();
        navBar.NavegarSeccionClientes();
        cliente.ListarClientes();

        expect(4).toBe(cliente.contarClientes());
    });
});
