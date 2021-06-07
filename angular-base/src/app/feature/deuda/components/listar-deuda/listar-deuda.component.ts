import { Component, OnInit } from '@angular/core';
import { Cliente } from '@producto/shared/model/cliente';
import { ProductoService } from '@producto/shared/service/producto.service';
import { DtoDeuda } from '../../shared/model/dto/Dtodeuda';
import { Deuda } from '../../shared/model/entidad/deuda';
import { DeudaService } from '../../shared/service/deuda.service';

@Component({
  selector: 'app-listar-deuda',
  templateUrl: './listar-deuda.component.html',
  styleUrls: ['./listar-deuda.component.css']
})
export class ListarDeudaComponent implements OnInit {

  listaDeudas = new Array<Deuda>();
  listaClientes: Array<Cliente>;

  constructor(private productoServices: ProductoService, 
              private deudaServices: DeudaService) { }

  ngOnInit(): void {
    this.construirListaClientes();
    this.construirListaDeudas();
  }
  construirListaClientes() {
    this.productoServices.consultar().subscribe( data => {
      this.listaClientes = data;
    })
  }

  construirListaDeudas() {
     this.deudaServices.consultar().subscribe( data => {
      let listaDeudasDto: Array<DtoDeuda> = data;
      listaDeudasDto.forEach(element => {
        let deuda = new Deuda();
        deuda.idDeuda = element.idDeuda;
        deuda.monto = element.monto;
        deuda.nombreEntidadDeuda = element.nombreEntidadDeuda;
        deuda.conceptoDeuda = element.conceptoDeuda;
        deuda.fechaInicialDeudaCliente =  element.fechaInicialDeudaCliente;
        deuda.cliente  = this.listaClientes.find(cliente => cliente.idCliente == element.idCliente);
        this.listaDeudas.push(deuda);
      });
    });

  }

}
