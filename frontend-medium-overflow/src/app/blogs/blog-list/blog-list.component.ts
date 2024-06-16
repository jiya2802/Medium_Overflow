import { Component, OnInit } from '@angular/core';
import { Blog } from 'src/app/shared/interfaces/blog.interface';
import { BlogsService } from '../blogs.service';
import { Category } from 'src/app/shared/interfaces/Category.interface';

@Component({
  selector: 'app-blog-list',
  templateUrl: './blog-list.component.html',
  styleUrls: ['./blog-list.component.css']
})
export class BlogListComponent implements OnInit{
  selectedBlog!:Blog;
  BlogData!:Blog[];
  ALL_ID=-1;
  active = this.ALL_ID;
  CategoryData!:Category[];

  constructor(private blogsService:BlogsService){
    
  }

  ngOnInit(): void {
    this.blogsService.getCategories().subscribe((data)=>{
      this.CategoryData=data;
      console.log(this.CategoryData);
    });
    this.blogsService.getBlogData().subscribe((data)=>{
      this.BlogData=data;
      console.log(this.BlogData);
    });
  }

  selectBlog(blog:Blog):void{
    this.selectedBlog=blog;
    console.log(this.selectedBlog);
  }

  fetchBlogs(event:any):void{
    // console.log(event);
    if(event==this.ALL_ID){
      this.blogsService.getBlogData().subscribe((data)=>{
        this.BlogData=data;
        console.log(this.BlogData);
      });
    }
    else{
      this.blogsService.getBlogsByCategory(event).subscribe((value)=>{
        this.BlogData=value
      })
    }
  }
}
