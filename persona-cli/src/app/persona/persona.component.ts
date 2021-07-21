import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TipodocumentoService } from '../tipodocumento/tipodocumento.service';
import { Persona } from './persona';
import { PersonaService } from './persona.service';
import { mergeMap } from "rxjs/operators";

@Component({
  selector: 'app-persona',
  templateUrl: './persona.component.html',
  styleUrls: ['./persona.component.css']
})
export class PersonaComponent implements OnInit {

  personas!: Persona[];
  tipodocumentos!: string[];

  nombreFiltro: string = "";
  tipoDocumentoFiltro: string = "";

  constructor(private personaService:PersonaService,
              private tipoDocumentoService:TipodocumentoService,
              private router: Router) {
                this.filtrar();
               }

  ngOnInit(): void {
    this.tipoDocumentoService.getTipoDocumentos().subscribe(
      tipodocumentos => this.tipodocumentos = tipodocumentos
    );

    this.filtrar();
  }

  filtrar(): void {
    this.personaService.getPersonasFiltro(this.nombreFiltro, this.tipoDocumentoFiltro).subscribe(
      personas => this.personas = personas
    );
  }

  eliminar(personaEliminar: Persona): void {
    this.personaService.eliminarPersona(personaEliminar)
    .pipe<Persona[]>
    (mergeMap(e => this.personaService.getPersonasFiltro(this.nombreFiltro, this.tipoDocumentoFiltro)))
    .subscribe(
      personas => this.personas = personas
    );
  }

  editar(personaEditar: Persona): void {
    this.router.navigate([`/altaPersona/${personaEditar.perId}`]);
  }
}


