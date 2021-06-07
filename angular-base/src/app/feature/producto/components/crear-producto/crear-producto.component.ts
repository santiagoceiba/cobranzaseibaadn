import { Component, OnInit } from '@angular/core';
import { ProductoService } from '../../shared/service/producto.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Cliente } from '@producto/shared/model/cliente';

const LONGITUD_MINIMA_PERMITIDA_TEXTO = 3;
const LONGITUD_MAXIMA_PERMITIDA_TEXTO = 20;

@Component({
  selector: 'app-crear-producto',
  templateUrl: './crear-producto.component.html',
  styleUrls: ['./crear-producto.component.css']
})
export class CrearProductoComponent implements OnInit {
  clienteForm: FormGroup;
  respuestaCreacionCliente = false;


  constructor(protected productoServices: ProductoService) { }

  ngOnInit() {
    this.construirFormularioProducto();
  }

  crear() {
    let cliente: Cliente = new Cliente();
    cliente.nombre = this.clienteForm.get('nombre').value;
    cliente.cedula = this.clienteForm.get('cedula').value
    this.productoServices.guardar(cliente).subscribe(data => {
      console.log(data !== 0);
      if(data !== 0) {
        this.respuestaCreacionCliente = true;
      }
    });
  }


  private construirFormularioProducto() {
    this.clienteForm = new FormGroup({
      nombre: new FormControl('', [Validators.required]),
      cedula: new FormControl('', [Validators.required, Validators.minLength(LONGITUD_MINIMA_PERMITIDA_TEXTO),
                                                             Validators.maxLength(LONGITUD_MAXIMA_PERMITIDA_TEXTO)])
    });
  }

}
