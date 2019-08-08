import { Component, OnInit } from '@angular/core';
import Chart from 'chart.js';
import { Account } from 'app/shared/model/account.model';
import { NgbModalWindow } from '@ng-bootstrap/ng-bootstrap/modal/modal-window';
import { AppComponent } from 'app/app.component';
import { CurrentUser } from 'app/models/CurrentUser';
import { AuthenticationService } from 'app/services/authentication.service';


@Component({
  selector: 'dashboard-cmp',
  moduleId: module.id,
  templateUrl: 'dashboard.component.html'
})

export class DashboardComponent implements OnInit {

  currentUser: CurrentUser;

  constructor(
    private appComponent: AppComponent,
    private authenticationService: AuthenticationService,
    ) {}

  accounts: any[];

  public canvas: any;
  public ctx;
  public chartColor;
  public chartEmail;
  public chartHours;

  ngOnInit() {
    this.accounts = this.appComponent.user.accounts;
    this.loadAccountsChart();
  }

  private loadAccountsChart() {
    let speedCanvas = document.getElementById("speedChart");

    let accountsData = [];

    for (let account of this.accounts) {
      let balanceData: number[] = [];
      for (let movementBalance of account.movementBalances) {
        balanceData.push(movementBalance);
      }

      let color: string = this.getRandomColor();

      let data = {
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

    let speedData = {
      labels: labels,
      datasets: accountsData,
    };

    let chartOptions = {
      legend: {
        display: false,
        position: 'top'
      },
    };

    let lineChart = new Chart(speedCanvas, {
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
    return '#000000'.replace(/0/g, function () { return (~~(Math.random() * 16)).toString(16); });
  }

  isLoggedIn() {

    if (!localStorage.getItem('currentUser')) {
      return false;
    }
    this.currentUser = this.authenticationService.currentUserValue;
    return true;

  }
}
