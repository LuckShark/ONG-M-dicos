import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class WorkService {

  private apiUrl = 'http://localhost:8080/work'; // Endpoint do back-end

  constructor(private http: HttpClient) {}

  //Pega a lista de trabalhos voluntários
  getWorks(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl);
  }


  //Inscreve um voluntário em um trabalho
  subscribeToWork(workId: number, volunteerId: number): Observable<any> {
    const payload = { workId, volunteerId }; //esse é o objeto do backend
    return this.http.post<any>(`${this.apiUrl}/work-volunteers/subscribe`, payload);
  }
  

}
