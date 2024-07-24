
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { JuliaoSystemCrudHttpService } from './juliaoSystemCrudHttpService';
import { environment } from '../../environments/environment';
import { UsuarioResponse } from '../models/UsuarioResponse';
import { PlantillaResponse } from '../models/plantillaResponse';



  @Injectable({
    providedIn: 'root'
  })
  export class UsuarioService extends JuliaoSystemCrudHttpService<PlantillaResponse<UsuarioResponse>> {
    


    constructor(
      protected override http: HttpClient,
    ) {
      super(http);
      this.basePathUrl = environment.baseUrls+"/user/";
    }

  }
