import { Component, OnInit } from '@angular/core';

@Component({
  // tslint:disable-next-line: component-selector
  selector: 'transfer-cmp',
  moduleId: module.id,
  templateUrl: 'transfer.component.html'
})

export class TransferComponent implements OnInit {

  ngOnInit() {
  }

  selectAccount(accountId: number) {
    console.log('transfer' + accountId);
  }

}
