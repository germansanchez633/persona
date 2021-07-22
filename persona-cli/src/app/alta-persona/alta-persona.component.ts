import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Persona } from '../persona/persona';
import { PersonaService } from '../persona/persona.service';
import { TipodocumentoService } from '../tipodocumento/tipodocumento.service';

@Component({
  selector: 'app-alta-persona',
  templateUrl: './alta-persona.component.html',
  styleUrls: ['./alta-persona.component.css']
})
export class AltaPersonaComponent implements OnInit {

  tipodocumentos!: string[];
  personaCargar: Persona = new Persona();
  id!: number;

  constructor(private tipoDocumentoService: TipodocumentoService,
    private personaService: PersonaService,
    private router: Router,
    private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.id = this.activatedRoute.snapshot.params.id;

    this.tipoDocumentoService.getTipoDocumentos().subscribe(
      tipodocumentos => this.tipodocumentos = tipodocumentos
    );

    if (this.id != 0)
    {
      this.personaService.getPersona(this.id).subscribe(
        (persona: Persona) => this.personaCargar = persona
      );
    }
  }

  guardar(): void {
    this.personaService.cargarPersona(this.personaCargar).subscribe(() => {

      this.router.navigate(['/persona']);

    });

    
  }
  
}
