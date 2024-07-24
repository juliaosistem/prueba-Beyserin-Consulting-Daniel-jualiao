import { Injectable } from '@angular/core';
import { UntypedFormBuilder, UntypedFormGroup, Validators } from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class FormsAuthService {

  constructor(private formb: UntypedFormBuilder) { }

  buildFormRegister(form: UntypedFormGroup){
    return form = this.formb.group({
       numeroDocumento: ['',[Validators.required, Validators.minLength(8), Validators.maxLength(11) ]],
       tipoDocumento: ['', Validators.compose([Validators.required])],  

  })
 }
}
