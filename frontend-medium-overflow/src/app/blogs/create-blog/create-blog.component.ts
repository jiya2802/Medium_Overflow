import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { BlogsService } from '../blogs.service';
import { Category } from 'src/app/shared/interfaces/Category.interface';

@Component({
  selector: 'app-create-blog',
  templateUrl: './create-blog.component.html',
  styleUrls: ['./create-blog.component.css']
})
export class CreateBlogComponent implements OnInit{
  // title=new FormControl()
  // fname=new FormControl()

  CategoryData!:Category[]
  constructor(private blogsService:BlogsService){

  }
  createForm= new FormGroup({
    title: new FormControl(),
    description: new FormControl()
  })
 
  ngOnInit(): void {
    // this.title.valueChanges.subscribe((value)=>{
    //   console.log(value);
    //   console.log(this.title)
    // })
    this.blogsService.getCategories().subscribe((data)=>{
      this.CategoryData=data;
      console.log(this.CategoryData);
    });
  }

  check():void{
    console.log(this.createForm.value)
  }
}
