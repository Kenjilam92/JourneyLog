import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'metterToMiles'
})
export class MetterToMilesPipe implements PipeTransform {

  transform(value: number, ...args: unknown[]): string {
    
    const miles: number = value/1609.34
    
    return `${miles} ${miles>1 && miles < -1 ? "miles" : "mile"}` ;
  }

}
