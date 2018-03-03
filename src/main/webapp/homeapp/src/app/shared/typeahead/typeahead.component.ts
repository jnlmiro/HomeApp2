import {Component, EventEmitter, Input, OnChanges, Output, SimpleChanges} from '@angular/core';

@Component({
  selector: 'typeahead',
  templateUrl: 'typeahead.component.html',
  styleUrls: ['typeahead.component.scss']
})

export class TypeaheadComponent {

  @Input() searchResults: [any];
  @Output() search = new EventEmitter<any>();

  constructor() {
  }


  onChange(text) {
    if (text !== '') {
      this.search.emit(text);
    }
  }


}
