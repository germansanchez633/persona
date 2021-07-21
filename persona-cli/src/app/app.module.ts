import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { PersonaComponent } from './persona/persona.component';
import { PersonaService } from './persona/persona.service';
import { TipodocumentoComponent } from './tipodocumento/tipodocumento.component';
import { TipodocumentoService } from './tipodocumento/tipodocumento.service';
import { FormsModule } from '@angular/forms';
import { AltaPersonaComponent } from './alta-persona/alta-persona.component';

const routes: Routes = [
  {path: '', redirectTo: '/persona', pathMatch: 'full'},
  {path: 'persona', component: PersonaComponent},
  {path: 'altaPersona/:id', component: AltaPersonaComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    PersonaComponent,
    TipodocumentoComponent,
    AltaPersonaComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(routes)
  ],
  providers: [PersonaService,
              TipodocumentoService],
  bootstrap: [AppComponent]
})
export class AppModule { }
