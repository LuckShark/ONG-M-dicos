import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class WorkService {

  private apiUrl = 'http://localhost:8080/work'; // Endpoint do back-end

  constructor(private http: HttpClient) {}

  getWorks(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl);
  }

}
