
import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { Vehiculo } from '../model/vehiculo.model';
import { VehiculoService } from './vehiculo.service';
import { Vehiculo2 } from '../model/vehiculo2.model';


@Component({
  selector: 'app-vehiculo',
  templateUrl: './add-vehiculo.component.html'
})
  
export class AddVehiculoComponent {
  vehiculo: Vehiculo = new Vehiculo();
  registroExitoso: String;
  registroFallido: String;
  falla: boolean;
  success: boolean;
  constructor( private router: Router, private vehiculoService: VehiculoService) {

  }
  vehiculos: Vehiculo2[];
  registrarVehiculo(): void {
    this.vehiculoService.registrarVehiculo(this.vehiculo).subscribe(res =>{
      this.vehiculoService.getVehiculos().subscribe(data => {
        this.vehiculos = data;
      });
     if(res.mensaje === "Registro realizado"){
        this.falla = false;
        this.success = true;
        this.registroExitoso = res.mensaje;
      }else{
        this.falla = true;
        this.success = false;
        this.registroFallido = res.mensaje;
      }
    });
  }

}