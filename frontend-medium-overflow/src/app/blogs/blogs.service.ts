import { Injectable } from '@angular/core';
import { Blog } from '../shared/interfaces/blog.interface';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Category } from '../shared/interfaces/Category.interface';


@Injectable({
  providedIn: 'root'
})
export class BlogsService {

  constructor(private http:HttpClient) { }

  getBlogData():Observable<any>{
    return this.http.get('http://localhost:8080/api/blogs')
  }

  getCategories():Observable<Category[]>{
    return this.http.get<Category[]>('http://localhost:8080/api/categories');
  }

  getBlogsByCategory(categoryId:number):Observable<Blog[]>{
    return this.http.get<Blog[]>(`http://localhost:8080/api/blogs/category/${categoryId}`)
  }

  getSingleBlog(slug:string):Observable<Blog>{
    return this.http.get<Blog>(`http://localhost:8080/api/blogs/${slug}`)
  }

}
