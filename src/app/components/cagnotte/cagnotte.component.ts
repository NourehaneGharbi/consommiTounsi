import { Component, OnInit } from '@angular/core';
import { Cagnotte } from 'app/models/cagnotte';
import { CagnotteAddService } from 'app/services/cagnotte-add.service';


@Component({
  selector: 'app-cagnotte',
  templateUrl: './cagnotte.component.html',
  styleUrls: ['./cagnotte.component.scss']
})
export class CagnotteComponent implements OnInit {
  public listUsers!: Cagnotte[]; 
  

  constructor(private _service:CagnotteAddService) { }
  ngOnInit(): void {
    this.getAllCagnottes();
  }

  getAllCagnottes(){
    this._service.getAllCagnottes().subscribe(res=>{console.log(res);
      this.listUsers=res}
    );
  }

  deleteCagnotte(id : any){
    this._service.deleteCagnotte(id).subscribe(()=> this.getAllCagnottes());
  }
}
