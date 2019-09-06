import { Routes, RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { CardmanageComponent } from './components/cardmanage/cardmanage.component';

export const rootRouterConfig: Routes = [
    {
        path: '',
        redirectTo: 'cardmanage',
        pathMatch: 'full'
    },
    {
        path: 'cardmanage',
        component: CardmanageComponent,
        data: {
            title: 'Cardmanage'
        }
    }
];
@NgModule({
    imports: [
        RouterModule.forRoot(rootRouterConfig)
    ],
    exports: [
        RouterModule
    ]
})
export class AppRoutes {

}



