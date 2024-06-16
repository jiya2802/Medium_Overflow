import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BlogListComponent } from './blog-list/blog-list.component';
import { HttpClientModule } from '@angular/common/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { SingleBlogComponent } from './single-blog/single-blog.component';
import { RouterModule } from '@angular/router';
import { CreateBlogComponent } from './create-blog/create-blog.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';



@NgModule({
  declarations: [
    BlogListComponent,
    SingleBlogComponent,
    CreateBlogComponent
  ],
  imports: [
    CommonModule,
    HttpClientModule,
    NgbModule,
    RouterModule,
    FormsModule,
    ReactiveFormsModule
  ],
  exports:[
    BlogListComponent
  ]
})
export class BlogsModule { 

}
