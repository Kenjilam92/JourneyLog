import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'secondsToTimeString'
})
export class SecondsToTimeStringPipe implements PipeTransform {

  transform(value: number, ...args: unknown[]): string {
    const day: number = Math.floor(value/86400);
    const hour = Math.floor((value%86400)/3600);
    const minute = Math.floor( ((value%86400)%3600)/60 );

    const stringDay: string = `${day} ${day>1? "days" : "day"}`;
    const stringHour: string = `${hour} ${hour>1? "hours" : "hour"}`;
    const stringMinute: string = `${minute} ${minute>1? "minutes" : "minute"}`;
    
    return `${stringDay} ${stringHour} ${stringMinute}`;
  }

}
