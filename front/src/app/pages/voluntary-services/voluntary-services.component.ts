import { Component } from '@angular/core';
import { ListVoluntaryServicesComponent } from './list-voluntary-services/list-voluntary-services.component';

@Component({
  selector: 'app-voluntary-services',
  standalone: true,
  imports: [ListVoluntaryServicesComponent],
  templateUrl: './voluntary-services.component.html',
  styleUrl: './voluntary-services.component.scss'
})
export class VoluntaryServicesComponent {

}
