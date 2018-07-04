import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { TCRM } from './model/tcrm.model';



const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class AppService {

  constructor(private http: HttpClient) {}

  private userUrl = 'http://localhost:8080';


  public getTCRM(){
    return this.http.get<TCRM>(this.userUrl+'/TCRM')
  }


}