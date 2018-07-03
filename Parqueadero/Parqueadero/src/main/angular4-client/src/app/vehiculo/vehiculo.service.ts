/**
 * New typescript file
 */
import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Vehiculo } from '../model/vehiculo.model';
import { Vehiculo2 } from '../model/vehiculo2.model';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class VehiculoService {

  constructor(private http: HttpClient) {}

  private userUrl = 'http://localhost:8000';


  public getVehiculos(){
    return this.http.get<Vehiculo2[]>(this.userUrl+'/vehiculos')
  }

  public registrarVehiculo(vehiculo) {
    return this.http.post<Vehiculo>(this.userUrl+'/entrada', vehiculo);
  }

  public sacarVehiculo(vehiculo){
    return this.http.post<Vehiculo>(this.userUrl+'/salida',vehiculo);
  }

  public getVehiculo(vehiculo){
    return this.http.post<Vehiculo2>(this.userUrl+'/consulta', vehiculo);
  }
}