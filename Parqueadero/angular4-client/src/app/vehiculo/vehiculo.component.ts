import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';

import {Vehiculo2} from '../model/vehiculo2.model';

import {VehiculoService} from './vehiculo.service';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';

@Component({
    selector: 'app-list-vehiculos',
    templateUrl: './vehiculo.component.html',
    styles: ['./vehiculo.component.html']
})

export class VehiculoComponent implements OnInit{
   @Input() vehiculos: Vehiculo2[];
   totalPagar: any;
   show: boolean;
   i: number;
    constructor(private modalService: NgbModal, private router: Router, private vehiculoService: VehiculoService){

    }
    
    
    ngOnInit() {
        this.i = 1;
        this.vehiculoService.getVehiculos().subscribe( data => {
            this.vehiculos = data;
        });
    };



    sacarVehiculo(vehiculo: Vehiculo2): void{
        this.vehiculoService.sacarVehiculo(vehiculo).subscribe(data => {
            console.log(data);
            this.totalPagar =  data;
            this.vehiculos = this.vehiculos.filter(v => v.placa!==vehiculo.placa);
        });
        this.show = true;
    };

    public onToggle(): void {
        this.show = false;
    }

}