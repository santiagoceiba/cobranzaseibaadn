import { formatDate } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Cliente } from '@producto/shared/model/cliente';
import { ProductoService } from '@producto/shared/service/producto.service';
import {  DtoDeuda } from '../../shared/model/dto/Dtodeuda';
import { DeudaService } from '../../shared/service/deuda.service';

@Component({
  selector: 'app-crear-deuda',
  templateUrl: './crear-deuda.component.html',
  styleUrls: ['./crear-deuda.component.css']
})
export class CrearDeudaComponent implements OnInit {

  deudaForm: FormGroup;
  listaCliente: Array<Cliente>;
  mapaClientes =new  Map<string,string>();
  estadoCreacionDeuda = '';
  respuestaCreacionDeuda = false

  constructor(private productService: ProductoService,
              private deudaService: DeudaService) { }

  ngOnInit(): void {
    this.construirFormularioProducto();
    this.llenarSeleccionCliente();
  }


  llenarSeleccionCliente() {
    this.productService.consultar().subscribe(data =>{
      this.listaCliente = data
      });
  }

  private construirFormularioProducto() {
    this.deudaForm = new FormGroup({
      nombreEntidad: new FormControl('', [Validators.required]),
      conceptoDeuda: new FormControl('', [Validators.required]),
      montoDeuda: new FormControl('', [Validators.required]),
      fechaDeuda: new FormControl('', [Validators.required]),
      clienteDeuda: new FormControl('', [Validators.required]),
    });
  }


  crear() {
    let deuda: DtoDeuda  = this.armarDeuda();;
    this.deudaService.guardar(deuda).subscribe(data => {
      if(data !== 0){
        this.estadoCreacionDeuda = 'Deuda Creada con éxito';
        this.respuestaCreacionDeuda = true;
      } else {
        this.estadoCreacionDeuda = 'No se pudo crear la deuda';
        this.respuestaCreacionDeuda = false;
      }
    })
    
  }


  armarDeuda(): DtoDeuda {

    let deuda = new DtoDeuda();
    deuda.nombreEntidadDeuda = this.deudaForm.get('nombreEntidad').value;
    deuda.conceptoDeuda = this.deudaForm.get('conceptoDeuda').value;
    deuda.monto = this.deudaForm.get('montoDeuda').value;
    const format = 'yyyy-MM-dd HH:mm:ss';
    const locale = 'en-US';
    const formattedDate = formatDate(this.deudaForm.get('fechaDeuda').value, format, locale);
    deuda.fechaInicialDeudaCliente = formattedDate;
   
    deuda.idCliente = this.deudaForm.get('clienteDeuda').value;
    return deuda;
  }

  encontrarCliente(): number {

    let listaCadenaCliente = this.deudaForm.get('clienteDeuda').value.split('-',2);
    let cedula = listaCadenaCliente[1];
    let posicionCliente = this.listaCliente.indexOf(this.listaCliente.find(x => x.cedula == cedula));
    return this.listaCliente[posicionCliente].idCliente;
  }

  get nombreEntidad(){
    return this.deudaForm.get('nombreEntidad')
  }
  get conceptoDeuda() {
    return this.deudaForm.get('conceptoDeuda')
  }
  get montoDeuda() {
    return  this.deudaForm.get('montoDeuda')
  }
  get fechaDeuda() {
    return this.deudaForm.get('fechaDeuda')
  }
  get clienteDeuda() {
    return this.deudaForm.get('clienteDeuda')
  }



}
