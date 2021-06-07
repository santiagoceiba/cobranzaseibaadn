import { Component, OnInit } from '@angular/core';

import { ProductoService } from '@producto/shared/service/producto.service';

import { Cliente } from '@producto/shared/model/cliente';

@Component({
  selector: 'app-listar-producto',
  templateUrl: './listar-producto.component.html',
  styleUrls: ['./listar-producto.component.css']
})
export class ListarProductoComponent implements OnInit {
  public listaClientes: Array<Cliente>;

  constructor(protected productoService: ProductoService) { }

  ngOnInit() {

    this.llenarLista();
 
  }

  llenarLista() {
    this.productoService.consultar().subscribe(data => {
      this.listaClientes = data;
  });
  }


}
