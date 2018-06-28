import { Component, OnInit, Input} from '@angular/core';
import { Router } from '@angular/router';

import { TCRM } from './model/tcrm.model';
import { AppService } from './app.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  
  totalTCRM: any;
  title = 'app';

  constructor(private appService: AppService, private router: Router){}

  ngOnInit(){
    this.appService.getTCRM().subscribe(data => {
      this.totalTCRM = data.tcrm;
    });
  }
}
