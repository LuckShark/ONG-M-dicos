import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './login/login.component';
import { FormRegisterVoluntaryComponent } from './pages/register-voluntary/form-register-voluntary/form-register-voluntary.component';
import { AuthGuard } from './login/authguard';

export const routes: Routes = [
    { path: '', redirectTo: '/login', pathMatch: 'full' },
    { path: 'login', component: LoginComponent },
    { path: 'home', component: HomeComponent, canActivate: [AuthGuard] },
    { path: 'register', component: FormRegisterVoluntaryComponent, canActivate: [AuthGuard] },
    { path: '**', component: HomeComponent }
  ];
