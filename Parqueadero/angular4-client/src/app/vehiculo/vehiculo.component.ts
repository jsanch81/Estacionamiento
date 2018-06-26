import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';

import {Vehiculo2} from '../model/vehiculo2.model';
import {Vehiculo} from '../model/vehiculo.model';

import {VehiculoService} from './vehiculo.service';

@Component({
    selector: 'app-list-vehiculos',
    templateUrl: './vehiculo.component.html',
    styles: []
})

export class VehiculoComponent implements OnInit{
   @Input() vehiculos: Vehiculo2[];
    constructor(private router: Router, private vehiculoService: VehiculoService){

    }
    
    
    ngOnInit() {
        this.vehiculoService.getVehiculos().subscribe( data => {
            this.vehiculos = data;
        });
    };


    sacarVehiculo(vehiculo: Vehiculo2): void{
        console.log(this.vehiculos);
        
        this.vehiculoService.sacarVehiculo(vehiculo).subscribe((data) => {
            this.vehiculos = this.vehiculos.filter(v => v.placa!==vehiculo.placa);
        });
    };
}