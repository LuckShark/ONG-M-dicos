import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from "./login/login.component";
import { LoginService } from './login/login.service';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet, HomeComponent, LoginComponent, HttpClientModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'ponte-saude-voluntaria';

  constructor(private loginService: LoginService) {}

  get isLoggedIn(): boolean {

    console.log(this.loginService.isLoggedIn());
    
    return this.loginService.isLoggedIn();
  }

  
}
