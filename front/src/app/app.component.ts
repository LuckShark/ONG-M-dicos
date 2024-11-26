import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { VoluntaryServicesComponent } from './pages/voluntary-services/voluntary-services.component';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from "./login/login.component";
import { LoginService } from './login/login.service';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet, HomeComponent, VoluntaryServicesComponent, LoginComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'ponte-saude-voluntaria';

  constructor(private loginService: LoginService) {}

  get isLoggedIn(): boolean {
    return this.loginService.isLoggedIn();
  }
}
