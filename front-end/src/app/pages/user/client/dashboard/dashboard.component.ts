import { Component, OnInit } from '@angular/core';
import Chart from 'chart.js';
import { Account } from 'app/shared/models/Account';
import { NgbModalWindow } from '@ng-bootstrap/ng-bootstrap/modal/modal-window';
import { AuthenticationService } from 'app/services/authentication.service';
import { AccessService } from 'app/services/access.service';
import { Router } from '@angular/router';
import { CurrentUser } from 'app/shared/models/CurrentUser';
import { Client } from 'app/shared/models/Client';
import { ClientService } from 'app/services/transport/client.service';
import { first } from 'rxjs/operators';
import { ClientLayoutComponent } from 'app/layouts/client-layout/client-layout.component';


@Component({
  // tslint:disable-next-line: component-selector
  selector: 'dashboard-cmp',
  moduleId: module.id,
  templateUrl: 'dashboard.component.html'
})

export class DashboardComponent implements OnInit {

  public canvas: any;
  public ctx;
  public chartColor;
  public chartEmail;
  public chartHours;

  accounts: Account[];

  constructor(
    private clientLayout: ClientLayoutComponent,
    ) {
      this.clientLayout.refreshData();
    }



  ngOnInit() {
    this.accounts = [];
    console.log(this.accounts)
    this.loadAccountsChart();
  }

  private loadAccountsChart() {
    const speedCanvas = document.getElementById('speedChart');

    const accountsData = [];

    for (const account of this.accounts) {
      const balanceData: number[] = [];
      for (const movementBalance of account.movementBalances) {
        balanceData.push(movementBalance);
      }

      const color: string = this.getRandomColor();

      const data = {
        data: balanceData,
        fill: false,
        borderColor: color,
        backgroundColor: 'transparent',
        pointBorderColor: color,
        pointRadius: 4,
        pointHoverRadius: 4,
        pointBorderWidth: 8,
      }
      accountsData.push(data);
    }

    const labels = [];
    const daysInMonth = this.getDaysInCurrentMonth();

    for (let i = 1; i <= daysInMonth; i++) {
      labels.push(i);
    }

    const speedData = {
      labels: labels,
      datasets: accountsData,
    };

    const chartOptions = {
      legend: {
        display: false,
        position: 'top'
      },
    };

    const lineChart = new Chart(speedCanvas, {
      type: 'line',
      hover: false,
      data: speedData,
      options: chartOptions
    });
  }

  private isLeapYear(year) {
    return ((year % 4 === 0) && (year % 100 !== 0)) || (year % 400 === 0);
  }

  private getDaysInCurrentMonth() {
    const date = new Date();

    switch (date.getMonth() + 1) {
      case 2:
        if (this.isLeapYear(new Date().getFullYear())) {
          return 29;
        } else {
          return 28;
        }
      case 4:
      case 6:
      case 9:
      case 11:
        return 30;
      default:
        return 31;
    }
  }

  private getRandomColor() {
    // tslint:disable-next-line: no-bitwise
    return '#000000'.replace(/0/g, function () { return (~~(Math.random() * 16)).toString(16); });
  }

  selectAccount(accountId: number) {
    console.log('dashboard' + accountId);
  }


}
