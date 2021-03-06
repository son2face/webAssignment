import {EventEmitter} from '@angular/core';
import {NavigationEvent} from './datepicker-view-model';
import {NgbDate} from './ngb-date';
import {NgbDatepickerI18n} from './datepicker-i18n';
import {NgbCalendar} from './ngb-calendar';

export declare class NgbDatepickerNavigation {
    i18n: NgbDatepickerI18n;
    navigation: typeof NavigationEvent;
    date: NgbDate;
    disabled: boolean;
    maxDate: NgbDate;
    minDate: NgbDate;
    months: number;
    showSelect: boolean;
    showWeekNumbers: boolean;
    navigate: EventEmitter<NavigationEvent>;
    select: EventEmitter<NgbDate>;
    private _calendar;

    constructor(i18n: NgbDatepickerI18n, _calendar: NgbCalendar);

    doNavigate(event: NavigationEvent): void;

    nextDisabled(): boolean;

    prevDisabled(): boolean;

    selectDate(date: NgbDate): void;
}
