import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsultaVwhiculoComponent } from './consulta-vwhiculo.component';

describe('ConsultaVwhiculoComponent', () => {
  let component: ConsultaVwhiculoComponent;
  let fixture: ComponentFixture<ConsultaVwhiculoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConsultaVwhiculoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConsultaVwhiculoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
