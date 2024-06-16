import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BlogListComponent } from './blogs/blog-list/blog-list.component';
import { HeroComponent } from './home/hero/hero.component';
import { SingleBlogComponent } from './blogs/single-blog/single-blog.component';
import { CreateBlogComponent } from './blogs/create-blog/create-blog.component';

const routes: Routes = [
  {
    path:'blogs',
    component: BlogListComponent
  },
  {
    // : means here a dynamic value is going to come
    path:'blog/:slug',
    component:SingleBlogComponent
  },
  {
    path:'create',
    component:CreateBlogComponent
  },
  {
    path:'',
    component: HeroComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }