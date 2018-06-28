/**
 * New typescript file
 */
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import {ConsultaVwhiculoComponent} from './consulta-vwhiculo/consulta-vwhiculo.component';
import {VehiculoComponent} from './vehiculo/vehiculo.component';
import {AddVehiculoComponent} from './vehiculo/add-vehiculo.component';

const routes: Routes = [
  { path: 'add', component: AddVehiculoComponent },
  {path: 'vehiculos', component:VehiculoComponent}
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ],
  declarations: []
})
export class AppRoutingModule { }