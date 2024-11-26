import { Router, RouterOutlet } from '@angular/router';
import { Component } from '@angular/core';
import { LoginService } from './login.service';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {

  username = '';
  password = '';
  loginError = false;

  constructor(private loginService: LoginService, private router: Router) {}

  onSubmit(event: Event): void {
    event.preventDefault();

    const success = this.loginService.login(this.username, this.password);

    if (success) {
      this.loginError = false;
      console.log('Login bem-sucedido!');
      this.router.navigate(['/home']); 
    } else {
      this.loginError = true;
      console.log('Credenciais inválidas!');
    }
  }
}
