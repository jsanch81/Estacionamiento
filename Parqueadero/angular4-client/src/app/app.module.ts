import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app.routing.module';
import {VehiculoService} from './vehiculo/vehiculo.service';
import {HttpClientModule} from '@angular/common/http';
import {AddVehiculoComponent} from './vehiculo/add-vehiculo.component';
import {VehiculoComponent} from './vehiculo/vehiculo.component';


@NgModule({
  declarations: [
    AppComponent,
    AddVehiculoComponent,
    VehiculoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [VehiculoService],
  bootstrap: [AppComponent]
})
export class AppModule { }
