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
import { AdminLayoutComponent } from 'app/layouts/admin-layout/admin-layout.component';


@Component({
  selector: 'dashboard-cmp',
  moduleId: module.id,
  templateUrl: 'dashboard.component.html'
})

export class DashboardComponent implements OnInit {

  private accounts: Account[];

  constructor(
    private adminLayout: AdminLayoutComponent,
    ) {
      this.adminLayout.refreshData();
    }

  // public canvas: any;
  // public ctx;
  // public chartColor;
  // public chartEmail;
  // public chartHours;

  ngOnInit() {
    this.accounts = this.adminLayout.getAccounts;
    console.log(this.accounts)
    // this.loadAccountsChart();
  }

  // private loadAccountsChart() {
  //   let speedCanvas = document.getElementById("speedChart");

  //   let accountsData = [];

    // for (let account of this.accounts) {
    //   let balanceData: number[] = [];
    //   for (let movementBalance of account.movementBalances) {
    //     balanceData.push(movementBalance);
    //   }

    //   let color: string = this.getRandomColor();

    //   let data = {
    //     data: balanceData,
    //     fill: false,
    //     borderColor: color,
    //     backgroundColor: 'transparent',
    //     pointBorderColor: color,
    //     pointRadius: 4,
    //     pointHoverRadius: 4,
    //     pointBorderWidth: 8,
    //   }
    //   accountsData.push(data);
    // }

  //   const labels = [];
  //   const daysInMonth = this.getDaysInCurrentMonth();

  //   for (let i = 1; i <= daysInMonth; i++) {
  //     labels.push(i);
  //   }

  //   let speedData = {
  //     labels: labels,
  //     datasets: accountsData,
  //   };

  //   let chartOptions = {
  //     legend: {
  //       display: false,
  //       position: 'top'
  //     },
  //   };

  //   let lineChart = new Chart(speedCanvas, {
  //     type: 'line',
  //     hover: false,
  //     data: speedData,
  //     options: chartOptions
  //   });
  // }

  // private isLeapYear(year) {
  //   return ((year % 4 === 0) && (year % 100 !== 0)) || (year % 400 === 0);
  // }

  // private getDaysInCurrentMonth() {
  //   const date = new Date();

  //   switch (date.getMonth() + 1) {
  //     case 2:
  //       if (this.isLeapYear(new Date().getFullYear())) {
  //         return 29;
  //       } else {
  //         return 28;
  //       }
  //     case 4:
  //     case 6:
  //     case 9:
  //     case 11:
  //       return 30;
  //     default:
  //       return 31;
  //   }
  // }

  // private getRandomColor() {
  //   return '#000000'.replace(/0/g, function () { return (~~(Math.random() * 16)).toString(16); });
  // }




}
