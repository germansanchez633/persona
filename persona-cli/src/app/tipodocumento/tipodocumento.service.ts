import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TipodocumentoService {
  private urlEndPoint: string = 'http://localhost:8080/tipodocumento';

  constructor(private http:HttpClient) { }

  getTipoDocumentos(): Observable<string[]> {
    return this.http.get<string[]>(this.urlEndPoint);
  }
}
