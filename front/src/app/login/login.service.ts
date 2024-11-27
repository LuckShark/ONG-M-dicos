import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  private apiUrl = 'http://localhost:8080/auth/login'; // URL do seu back-end
  private isAuthenticated = false; // Estado de autenticação

  constructor(private http: HttpClient) {}

  login(username: string, password: string): Observable<any> {
    const payload = { email: username, password: password }; // Nome dos campos do LoginDTO
    return this.http.post<any>(this.apiUrl, payload); //faz o POST pro back carai
  }

  setLoggedIn(status: boolean): void {
    this.isAuthenticated = status;
  }

  isLoggedIn(): boolean {
    return this.isAuthenticated;
  }

  // Retorna o ID do usuário logado
  getCurrentUserId(): number | null {
    const user = JSON.parse(localStorage.getItem('user') || '{}');
    return user?.id || null; 
  }

}
