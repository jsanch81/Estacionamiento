import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import {Vehiculo2} from '../model/vehiculo2.model';
import {Vehiculo} from '../model/vehiculo.model';

import {VehiculoService} from '../vehiculo/vehiculo.service';

@Component({
  selector: 'app-consulta-vwhiculo',
  templateUrl: './consulta-vwhiculo.component.html',
  styleUrls: ['./consulta-vwhiculo.component.css']
})
export class ConsultaVwhiculoComponent implements OnInit {
  vehiculo: Vehiculo = new Vehiculo();
  vehiculo2: Vehiculo2;
  constructor(private vehiculoService: VehiculoService) { }

  ngOnInit() {
  }

  consultarVehiculo(){
    this.vehiculoService.getVehiculo(this.vehiculo).subscribe(res=>{
      this.vehiculo2 = res;
    });
  }
}
