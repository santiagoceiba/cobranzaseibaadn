import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Cliente } from '@producto/shared/model/cliente';
import { ProductoService } from '@producto/shared/service/producto.service';
import { DtoDeuda } from 'src/app/feature/deuda/shared/model/dto/Dtodeuda';
import { DeudaService } from 'src/app/feature/deuda/shared/service/deuda.service';
import { DtoAcuerdoPago } from '../../shared/model/dto/DtoAcuerdoPago';

import { AcuerdoService } from '../../shared/service/acuerdo.service';
import { formatDate } from '@angular/common';

@Component({
  selector: 'app-crear-acuerdos-pagos',
  templateUrl: './crear-acuerdos-pagos.component.html',
  styleUrls: ['./crear-acuerdos-pagos.component.css']
})
export class CrearAcuerdosPagosComponent implements OnInit {
  acuerdoForm : FormGroup;
  listaCliente: Array<Cliente>;
  listaDeudas: Array<DtoDeuda>;
  estados =  ['ACTIVO', 'INACTIVO', 'COBRO_JURIDICO'];
  cargarListaDeudas = false;
  estadoCreacionAcuerdo = '';
  respuestaCreacionAcuerdo = false

  constructor(private productoServices: ProductoService,
              private deudaServices: DeudaService, 
              private acuerdoServices: AcuerdoService) { }

  ngOnInit(): void {
    this.construirFormularioProducto();
    this.llenarSeleccionCliente();
  }


  llenarSeleccionDeuda() {
    let idCliente = this.acuerdoForm.get('clienteDeuda').value;
    this.deudaServices.consultarDeudaPorIdCliente(idCliente).subscribe(data =>{
      if(data.length > 0) {
        this.cargarListaDeudas = true;
        this.listaDeudas = data;
      } else {
        this.cargarListaDeudas = false;
      }
      
      });
  }

  llenarSeleccionCliente() {
    this.productoServices.consultar().subscribe(data =>{
      this.listaCliente = data
      });
  }

  

  private construirFormularioProducto() {
    this.acuerdoForm = new FormGroup({
      deuda: new FormControl('', [Validators.required]),
      estadoAcuerdo: new FormControl('', [Validators.required]),
      montoCuota: new FormControl('', [Validators.required]),
      fechaDeuda: new FormControl('', [Validators.required]),
      clienteDeuda: new FormControl('', [Validators.required]),
      cantidadCuotas: new FormControl('', [Validators.required]),
      numeroReferencia: new FormControl('', [Validators.required]),
    });
  }



  crear () {

    let acuerdoPago = this.armarAcuerdo();
    this.acuerdoServices.guardar(acuerdoPago).subscribe ( data => {
      if(data !== 0){
        this.estadoCreacionAcuerdo = 'Acuerdo Creada con éxito';
        this.respuestaCreacionAcuerdo = true;

      } else {
        this.estadoCreacionAcuerdo = 'No se pudo crear el acuerdo';
        this.respuestaCreacionAcuerdo = false;
      }
    });
  }

  armarAcuerdo(): DtoAcuerdoPago {

    let acuerdoPago = new DtoAcuerdoPago();
    acuerdoPago.montoCuota = this.acuerdoForm.get('montoCuota').value;
    acuerdoPago.estado = this.acuerdoForm.get('estadoAcuerdo').value;
    acuerdoPago.cliente = this.acuerdoForm.get('clienteDeuda').value;
    acuerdoPago.deuda = this.acuerdoForm.get('deuda').value;
    acuerdoPago.cantidadCuotas = this.acuerdoForm.get('cantidadCuotas').value;
    acuerdoPago.numeroReferencia = this.acuerdoForm.get('numeroReferencia').value;
    const format = 'yyyy-MM-dd HH:mm:ss';
    const locale = 'en-US';
    const formattedDate = formatDate(this.acuerdoForm.get('fechaDeuda').value, format, locale);
    acuerdoPago.fechaAcuerdo = formattedDate;

    return acuerdoPago;
  }


  get estadoAcuerdo() {
    return this.acuerdoForm.get('estadoAcuerdo');
  }
  get deuda(){
    return this.acuerdoForm.get('deuda');
  }
  get montoCuota (){
    return this.acuerdoForm.get('montoCuota');
  }
  get fechaDeuda (){
    return this.acuerdoForm.get('fechaDeuda');
  }
  get clienteDeuda (){
    return this.acuerdoForm.get('clienteDeuda');
  }
  get cantidadCuotas() {
    return this.acuerdoForm.get('cantidadCuotas');
  }
  get numeroReferencia (){
    return this.acuerdoForm.get('numeroReferencia');
  }

}
