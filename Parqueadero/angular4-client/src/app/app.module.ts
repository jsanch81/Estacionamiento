import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';


import { AppComponent } from './app.component';
import { AppRoutingModule } from './app.routing.module';
import {VehiculoService} from './vehiculo/vehiculo.service';
import {HttpClientModule} from '@angular/common/http';
import {AddVehiculoComponent} from './vehiculo/add-vehiculo.component';
import {VehiculoComponent} from './vehiculo/vehiculo.component';
import { PopupModule } from '@progress/kendo-angular-popup';
import { MyFilterPipe } from './pipe/my-filter.pipe'
@NgModule({
  declarations: [
    AppComponent,
    AddVehiculoComponent,
    VehiculoComponent,
    MyFilterPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    PopupModule,
    BrowserAnimationsModule,
    NgbModule.forRoot()
  ],
  providers: [VehiculoService],
  bootstrap: [AppComponent]
})
export class AppModule { }
