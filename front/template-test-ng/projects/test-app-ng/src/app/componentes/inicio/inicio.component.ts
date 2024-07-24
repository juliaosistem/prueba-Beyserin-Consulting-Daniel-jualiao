
import { FormsAuthService } from './../../servicios/forms-auth.service';
import { LayoutModule } from '@angular/cdk/layout';
import { Component, OnInit } from '@angular/core';
import { UntypedFormGroup } from '@angular/forms';
import { CoreModule } from 'template-test-ng';
import { UsuarioService } from '../../servicios/usuario.service';
import { UsuarioResponse } from '../../models/UsuarioResponse';
import { PlantillaResponse } from '../../models/plantillaResponse';

@Component({
  selector: 'app-inicio',
  standalone: true,
  imports: [CoreModule,LayoutModule],
  templateUrl: './inicio.component.html',
  styleUrl: './inicio.component.scss'
})
export class InicioComponent  implements OnInit{

  formUsuarios!: UntypedFormGroup;
  response: PlantillaResponse<UsuarioResponse> = new PlantillaResponse<UsuarioResponse>();

  constructor(private formSvc:FormsAuthService,
    private userSvc: UsuarioService
  ) {

  }

  ngOnInit(): void {
    this.buildForms();
  }

  buildForms(){
    this.formUsuarios =this.formSvc.buildFormRegister(this.formUsuarios)
    this.formUsuarios.addControl('formattedNumeroDocumento', this.formUsuarios.get('numeroDocumento'));

   } 


  formatNumber(event: any): void {
    const input = event.target;
    let value = input.value.replace(/,/g, '');
    let numeroDocumento = value.replace(/,/g, '');

    numeroDocumento = value.replace(/\D/g, '');
    this.formUsuarios.get('numeroDocumento')?.setValue(numeroDocumento, { emitEvent: false });

    if (!isNaN(value) && value !== '') {
      input.value = this.addCommas(value);
    }
   
  }

  addCommas(value: string): string {

    const [integer, fraction] = value.split('.');
    const formattedInteger = integer.replace(/\B(?=(\d{3})+(?!\d))/g, ',');
    return fraction ? `${formattedInteger}.${fraction}` : formattedInteger;
  }

  buscar() {
     if(this.formUsuarios.valid){
      this.userSvc.all(this.formUsuarios.get('numeroDocumento')?.value ,this.formUsuarios.get('tipoDocumento')?.value)
      .subscribe(res => {
        if(res.rta ){
          console.log("res: ", res);
        }
        
      })
       
     }
    }
}
