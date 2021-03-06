import {Injectable} from '@angular/core';
import * as _ from 'lodash';
import {Subject} from "rxjs/Subject";
import {Observable} from "rxjs/Observable";

@Injectable()
export class PincodeService {
  private MAX_NUMBER_OF_DIGITS: number=4;
  enteredDigits: number[] = [];
  constructor() {
  }


  getDigits(): number[] {
    return Array.from(Array(9).keys()).map(digit => digit + 1);
  }

  getDigitGroups(): number[][] {
    return _.chunk(this.getDigits(), 3);
  }

  enterDigit(digit: number): void {
    if(this.enteredDigits.length < this.MAX_NUMBER_OF_DIGITS) {
      this.enteredDigits.push(digit);
    }else {
      throw new Error("Too many digits");
    }
  }

  removeDigit(): void {
    if(this.enteredDigits.length > 0) {
      this.enteredDigits.pop();
    }
  }

  confirm() {
    console.log(`enteredDigits: ${this.enteredDigits}`);
  }
}

