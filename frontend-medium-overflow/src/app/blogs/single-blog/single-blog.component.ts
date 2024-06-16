import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BlogsService } from '../blogs.service';
import { Blog } from 'src/app/shared/interfaces/blog.interface';

@Component({
  selector: 'app-single-blog',
  templateUrl: './single-blog.component.html',
  styleUrls: ['./single-blog.component.css']
})
export class SingleBlogComponent implements OnInit{
  slug!:string
  SingleBlogData!:Blog
  constructor(private blogsService:BlogsService,private route: ActivatedRoute){}

  ngOnInit(): void {
    this.route.params.subscribe((value)=>{
      this.slug=value['slug']
      console.log(this.slug)
      this.blogsService.getSingleBlog(this.slug).subscribe((data)=>{
        this.SingleBlogData=data;
        console.log(this.SingleBlogData)
      })
    })

  }

}
