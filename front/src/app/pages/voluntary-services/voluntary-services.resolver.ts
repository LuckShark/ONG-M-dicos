import { inject, Injectable } from '@angular/core';
import { Resolve, ResolveFn } from '@angular/router';
import { Observable } from 'rxjs';
import { VoluntaryServicesService } from './voluntary-services.service';

// https://medium.com/@shinecita/angular-17-using-a-resolver-sample-225ffbc5e4ef


//  export const voluntaryServicesResolver: ResolveFn<Object> = (route, state) => {
//     const gameId = route.paramMap.get('id');
//     // return inject(VoluntaryServicesService).get();
// }