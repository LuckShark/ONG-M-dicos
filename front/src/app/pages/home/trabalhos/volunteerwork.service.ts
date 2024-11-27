// volunteerwork.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class VolunteerWorkService {

  private apiUrl = 'http://localhost:8080/work-volunteers'; 

  constructor(private http: HttpClient) {}

  // Inscreve um voluntário em um trabalho
  subscribeToWork(workId: number, volunteerId: number): Observable<any> {
    const payload = { workId, volunteerId }; // Cria o payload com os dados do trabalho e voluntário
    return this.http.post(`${this.apiUrl}/subscribe`, payload); // Envia para o endpoint correto
  }
}
