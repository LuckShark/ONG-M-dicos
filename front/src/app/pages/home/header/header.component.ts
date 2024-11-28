import { Component } from '@angular/core';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [],
  templateUrl: './header.component.html',
  styleUrl: './header.component.scss'
})
export class HeaderComponent {

  name: string | null = 'Fulano';

  constructor() {}

  ngOnInit(): void {
    const user = localStorage.getItem('user');
    this.name  = user != null ? JSON.parse(user).name : 'Fulano';   
  }
}
