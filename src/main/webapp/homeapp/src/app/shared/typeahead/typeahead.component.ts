import {
  Component, HostBinding, HostListener, Input, OnChanges, OnInit, SimpleChanges, TemplateRef, ViewChild,
  ViewContainerRef
} from '@angular/core';
import {NgModel} from "@angular/forms";


enum Key {
  Backspace = 8,
  Tab = 9,
  Enter = 13,
  Shift = 16,
  Escape = 27,
  ArrowLeft = 37,
  ArrowRight = 39,
  ArrowUp = 38,
  ArrowDown = 40
}

@Component({
  selector: 'input[typeahead]',
  providers: [NgModel],
  templateUrl: 'typeahead.component.html',
  styleUrls: ['typeahead.component.scss']
})

export class TypeaheadComponent implements OnInit, OnChanges {

  @Input() searchResults: [any];
  @Input() itemTplRef: TemplateRef<any>;
  @Input('inputFormatter') inputFormatter: (value: any) => string;

  @ViewChild('suggestionsTplRef') suggestionsTplRef;
  @HostBinding('attr.autocomplete') autocomplete = 'off';
  activeItemIdx: number = 0;
  resultsVisible: boolean = true;

  constructor(private viewContainer: ViewContainerRef, private model: NgModel) {
  }

  ngOnInit(): void {
    this.renderContents();
  }


  ngOnChanges(changes: SimpleChanges): void {
    this.handleResultChanges(changes);
  }

  @HostListener('keydown', ['$event'])
  onKeyDown(event: KeyboardEvent) {
    if (event.keyCode === Key.ArrowDown) {
      this.setActiveItem(1);
    }

    if (event.keyCode === Key.ArrowUp) {
      this.setActiveItem(-1);
    }

    if(event.keyCode === Key.Enter) {
      this.selectItem();
      event.target
    }

    /*if(event.keyCode === Key.Escape) {
      this.resultsVisible = false;
    }*/
  }


  onMouseEnter(event: MouseEvent, idx) {
    this.activeItemIdx = idx;
  }

  handleResultChanges(changes: SimpleChanges) {
    let currentValue = changes.searchResults.currentValue;
    let oldValue = changes.searchResults.previousValue;

    if(currentValue.length === 0) {
      this.resetActiveItem();
    } else if(oldValue && currentValue.length < oldValue.length) {
      let diff =  oldValue.length - currentValue.length;
      if(diff >= currentValue.length) {
        this.resetActiveItem();
      }
    }
  }

  setActiveItem(iCursor) {
    if (this.activeItemIdx === 0 && iCursor === -1) {
      this.activeItemIdx = this.searchResults.length - 1;
    } else if (this.activeItemIdx === this.searchResults.length - 1 && iCursor === 1) {
      this.activeItemIdx = 0;
    } else {
      this.activeItemIdx += iCursor
    }
  }


  selectItem() {
    let selectedItem = this.searchResults[this.activeItemIdx];
    console.log(this.inputFormatter(selectedItem));
    console.log('selectedItem', selectedItem);
  }

  resetActiveItem() {
    this.activeItemIdx = 0;
  }


  renderContents() {
    this.viewContainer.createEmbeddedView(this.suggestionsTplRef);
  }
}
