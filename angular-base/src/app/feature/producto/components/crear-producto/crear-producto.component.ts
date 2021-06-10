import { Component, OnInit } from '@angular/core';
import { ProductoService } from '../../shared/service/producto.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Cliente } from '@producto/shared/model/cliente';


@Component({
  selector: 'app-crear-producto',
  templateUrl: './crear-producto.component.html',
  styleUrls: ['./crear-producto.component.css']
})
export class CrearProductoComponent implements OnInit {
  clienteForm: FormGroup;
  respuestaCreacionCliente = false;
  estadoCreacionCliente = "";
  //private soloLetras: any = /[a-z]/gi;  Validators.pattern(this.soloLetras)


  constructor(protected productoServices: ProductoService) { }

  ngOnInit() {
    this.construirFormularioProducto();
  }

  crear() {
    let cliente: Cliente = new Cliente();
    cliente.nombre = this.clienteForm.get('nombre').value;
    cliente.cedula = this.clienteForm.get('cedula').value
    this.productoServices.guardar(cliente).subscribe(data => {
      if(data !== 0) {
        this.estadoCreacionCliente = "Cliente creado con éxito";
        this.respuestaCreacionCliente = true;
      } else {
        this.estadoCreacionCliente = "No se pudo crear el cliente";
        this.respuestaCreacionCliente = false;
      }
    });
    
  }

  get nombre() { return this.clienteForm.get('nombre'); }
  get cedula() { return this.clienteForm.get('cedula'); }

  private construirFormularioProducto() {
    this.clienteForm = new FormGroup({
      nombre: new FormControl('', [Validators.required]),
      cedula: new FormControl('', [Validators.required])
    });
  }

}
