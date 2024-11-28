import { Component, OnInit } from '@angular/core';
import { WorkService } from './work.service';
import { CommonModule } from '@angular/common';
import { LoginService } from '../../../login/login.service';
import { VolunteerWorkService } from './volunteerwork.service';

@Component({
  selector: 'app-trabalhos',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './trabalhos.component.html',
  styleUrl: './trabalhos.component.scss'
})
export class TrabalhosComponent implements OnInit {

  trabalhos: any[] = []; //Lista de trabalhos voluntarios

  constructor(private workService: WorkService, private volunteerWorkService: VolunteerWorkService) {}

  ngOnInit(): void {
    this.loadTrabalhos();
  }


  // Carrega os trabalhos do backend
  private loadTrabalhos(): void {
    this.workService.getWorks().subscribe({
      next: (data) => {
        this.trabalhos = data; // Atualiza os trabalhos no array
      },
      error: (err) => {
        console.log(err);
        
        console.error('Erro ao carregar oportunidades: ', err.error);
      }
    });
  }

  subscribeToWork(workId: number): void {
    const volunteerId = this.getVolunteerId(); 

    if (volunteerId) {
      this.volunteerWorkService.subscribeToWork(workId, volunteerId).subscribe({
        next: (response) => {
          console.log("Responta do servidor:", response);
          alert(response.message);
          this.loadTrabalhos(); 
        },
        error: (err) => {
          console.error('Erro ao realizar inscrição: ', err.error);
          alert(err.error|| 'Erro ao realizar inscrição.');
        },
      });
    } else {
      alert('Você precisa estar logado para se inscrever!');
    }
  }

  private getVolunteerId(): number | null {
    // Obtém o ID do voluntário do localStorage 
    const user = JSON.parse(localStorage.getItem('user') || '{}');
    return user?.id || null; // Retorna o ID, se disponível
  }


}
