import { Component, OnInit } from '@angular/core';
import { WorkService } from './work.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-trabalhos',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './trabalhos.component.html',
  styleUrl: './trabalhos.component.scss'
})
export class TrabalhosComponent implements OnInit {

  trabalhos: any[] = []; //Isso deve armazenar os trabalhos obtidos no backend

  constructor(private workService: WorkService) {}

  ngOnInit(): void {
      // Isso aqui vai buscar os trabalhos quando carrega o componente
      this.workService.getWorks().subscribe({
        next: (data) => {
          this.trabalhos = data;
        },
        error: (err) => {
          console.error("Erro ao carregar oportunidades: ", err);
        },

      });
  }


}
