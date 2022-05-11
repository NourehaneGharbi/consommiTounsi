import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CagnotteaddComponent } from './cagnotteadd.component';

describe('CagnotteaddComponent', () => {
  let component: CagnotteaddComponent;
  let fixture: ComponentFixture<CagnotteaddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CagnotteaddComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CagnotteaddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
