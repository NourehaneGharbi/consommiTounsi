import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Cagnotte } from 'app/models/cagnotte';
import { CagnotteAddService } from 'app/services/cagnotte-add.service';
import { Router } from 'express';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {


  constructor(
    
  ) { }
    
  
  ngOnInit(): void {
  }; 





}
