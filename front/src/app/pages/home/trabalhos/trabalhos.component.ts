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
        console.error('Erro ao carregar oportunidades: ', err);
      }
    });
  }

  subscribeToWork(workId: number): void {
    const volunteerId = this.getVolunteerId(); // Pega o ID do voluntário (que já foi armazenado no localStorage)

    if (volunteerId) {
      this.volunteerWorkService.subscribeToWork(workId, volunteerId).subscribe({
        next: (response) => {
          console.log("Responta do servidor:", response);
          alert(response.message);
          this.loadTrabalhos(); // Atualiza a lista de trabalhos
        },
        error: (err) => {
          console.error('Erro ao realizar inscrição: ', err);
          alert(err.error?.message || 'Erro ao realizar inscrição.');
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
