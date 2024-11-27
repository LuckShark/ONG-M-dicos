import { Component } from '@angular/core';
import { HeroSectionComponent } from "./hero-section/hero-section.component";
import { HeaderComponent } from "./header/header.component";
import { TrabalhosComponent } from "./trabalhos/trabalhos.component";

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [HeroSectionComponent, HeaderComponent, TrabalhosComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent {

}
