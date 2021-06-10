import { by, element } from 'protractor';

export class NavbarPage {
    linkCliente = element(by.xpath('/html/body/app-root/app-navbar/nav/a[1]'));
    linkDeuda = element(by.xpath('/html/body/app-root/app-navbar/nav/a[2]'));
    linkAcuerdo = element(by.xpath('/html/body/app-root/app-navbar/nav/a[3]'));

    async NavegarSeccionClientes() {
        await this.linkCliente.click();
    }
    async NavegarSeccionDeuda() {
        await this.linkDeuda.click();
    }
    async NavegarSeccionAcuerdo() {
        await this.linkAcuerdo.click();
    }
}
