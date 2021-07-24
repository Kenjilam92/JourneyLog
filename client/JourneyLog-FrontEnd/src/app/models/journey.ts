export class Journey {
    constructor(
        public journeyId? : number,
        public creatorId? : number,
        public stopPoints? : Location[],
        public time? : number,
        public length? : number
    ){}
}
