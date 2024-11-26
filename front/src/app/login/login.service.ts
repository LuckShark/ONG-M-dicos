import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private isAuthenticated = false;

  login(username: string, password: string):boolean {
    console.log('Tentativa de login:', { username, password });
    if (username === 'voluntario' && password === '123456') {
      this.isAuthenticated = true;
      return true;
    }
    return false;
  }

  isLoggedIn(): boolean {
    return this.isAuthenticated;
  }

  logout():void {
    this.isAuthenticated = false;
  }


  constructor() { }
}
