import { Component, OnInit } from '@angular/core';
import { Cliente } from '@producto/shared/model/cliente';
import { ProductoService } from '@producto/shared/service/producto.service';
import { DtoDeuda } from 'src/app/feature/deuda/shared/model/dto/Dtodeuda';
import { DeudaService } from 'src/app/feature/deuda/shared/service/deuda.service';
import { AcuerdoPago } from '../../shared/model/acuerdo-pago';
import { AcuerdoService } from '../../shared/service/acuerdo.service';

@Component({
  selector: 'app-listar-acuerdos',
  templateUrl: './listar-acuerdos.component.html',
  styleUrls: ['./listar-acuerdos.component.css']
})
export class ListarAcuerdosComponent implements OnInit {

  listaDeudas = new Array<DtoDeuda>();
  listaClientes = new Array<Cliente>();
  listaAcuerdos = new  Array<AcuerdoPago>();
  mostrarListaFacturas = false;

  constructor(private productoServices: ProductoService,
              private deudaServices: DeudaService, 
              private acuerdoServices: AcuerdoService) { }

  ngOnInit(): void {
    this.construirListaClientes();
    this.construirListaDeudas();
    this.construirlistaAcuerdos();
  }
  construirListaDeudas() {
    this.deudaServices.consultar().subscribe( data => {
      this.listaDeudas = data;
    })
  }

  construirListaClientes() {
    this.productoServices.consultar().subscribe( data => {
      this.listaClientes = data;
    })
  }

  construirlistaAcuerdos () {
    this.acuerdoServices.consultar().subscribe( data => {
      let listaAcuerdoDto: Array<AcuerdoPago> = data;
      listaAcuerdoDto.forEach(element => {
        let acuerdo = new AcuerdoPago();

        acuerdo.idAcuerdoPago = element.idAcuerdoPago;
        acuerdo.cantidadCuotas = element.cantidadCuotas;
        acuerdo.estado = element.estado;
        acuerdo.fechaAcuerdo = element.fechaAcuerdo;
        acuerdo.montoCuota =  element.montoCuota;
        acuerdo.numeroReferencia = element.numeroReferencia;
        acuerdo.cliente  = element.cliente;
        acuerdo.deuda  = element.deuda;
        this.listaAcuerdos.push(acuerdo);
  
      });
    });
  }

  listarFacturas() {
    console.log('estoy aca')
    this.mostrarListaFacturas = true;
  }

}
