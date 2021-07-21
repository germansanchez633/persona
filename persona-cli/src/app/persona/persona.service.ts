import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Persona } from './persona';

@Injectable({
  providedIn: 'root'
})
export class PersonaService{
  private urlEndPoint: string = 'http://localhost:8080/persona';

  constructor(private http: HttpClient, private router: Router) { }

  getPersonas(): Observable<Persona[]> {
    return this.http.get<Persona[]>(this.urlEndPoint);
  }

  getPersona(id: number): Observable<Persona> {
    return this.http.get<Persona>(`${this.urlEndPoint}/${id}`);
  }

  getPersonasFiltro(nombre:string, tipoDocumento:string): Observable<Persona[]> {
    return this.http.get<Persona[]>(`${this.urlEndPoint}/filtro/?nombre=${nombre}&tipoDocumento=${tipoDocumento}`);
  }

  cargarPersona(personaGuardar: Persona): Observable<Persona> {
    return this.http.post<Persona>(this.urlEndPoint, personaGuardar);
  }

  eliminarPersona(personaEliminar: Persona): Observable<Persona> {
    console.log(personaEliminar.perId);
    return this.http.delete<Persona>(`${this.urlEndPoint}/${personaEliminar.perId}`);
  }
}
