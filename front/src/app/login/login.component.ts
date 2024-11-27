import { Router, RouterOutlet } from '@angular/router';
import { Component } from '@angular/core';
import { LoginService } from './login.service';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, FormsModule, HttpClientModule],
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

    this.loginService.login(this.username, this.password).subscribe({
      next: (response) => {
        console.log('Login bem-sucedido!', response);
        this.loginService.setLoggedIn(true); // Atualiza o estado de autenticação
        this.loginError = false;
        this.router.navigate(['/home']); // Redireciona para a página inicial
      },
      error: (err) => {
        console.error('Erro no login:', err);
        this.loginError = true;
      },
    });
    
  }

}
