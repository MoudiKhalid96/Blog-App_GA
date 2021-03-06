[![General Assembly Logo](https://camo.githubusercontent.com/1a91b05b8f4d44b5bbfb83abac2b0996d8e26c92/687474703a2f2f692e696d6775722e636f6d2f6b6538555354712e706e67)](https://generalassemb.ly/education/web-development-immersive)<br>
![Misk Logo](https://i.ibb.co/KmXhJbm/Webp-net-resizeimage-1.png)<br>
<small style="color: gray">This was work from <span title="General Assembly">GA</span> and Misk Academy</small><br>

# <b>Blog-App</b>

## INTRODUCTION
This project is required to complete the JDI course from Misk Academy and General Assembly by working in live sessions to get practice of some covered materials taken so far for now.<br>It's a `Blog App` that authors and article can be added, edited and deleted from the web-site. actions determined by the <b>role</b> of the user, it's either admin or regular user.


## TECHNOLOGIES
* HTML 5
* CSS 3
* JavaScript 1.8.5 
* JQuery 3.5.1
* Java Spring-boot

## USERS
In general, user can create an view authors, author details, articles, article details, create new account, and login.<br>
There're 2 types od users:
* Normal
  * add and edit, author
  * add and edit article
* Admin 
  * add, edit, and delete author
  * add, edit, and delete article

## FEATURES
* Create an account
* View authors 
* View authors personal details
* View authors articles
* View articles 
* View articles details 



## WIREFRAME
### Home
This is the interface of the <b>`Blog App`</b> any person visiting this webite can see authors and articles only. <br>
![Home](/image/Home_login_blogapp.png) <br>


### Authors Index Page
This page is appearing for any one visiting the website and click on authors. Same goes for articles page. <br>
![authors](/image/Author_index_blogapp.png) <br>


### Article Index Page With Actions
This will show for user who is logged-in (delete is only for admin)
![authors actions](/image/Actions_author_blogapp.png) <br>

### Article Page
The details will show when clicking on article (Ex: article1)<br>
![articles](/image/Article_index_blogapp.png) <br>


### Article Details Page
![articles](/image/Article_detail_blogapp.png) <br>


### Article Index Page With Actions
This will show for user who is logged-in (delete is only for admin)
![article actions](/image/Actions_article_blogapp.png) <br>


when clicking on <b>create new account</b> this window will show up

### Create Account Page
![create account](/image/Create_account_blogapp.png) <br>

After creating account, user have to login.. so the page will redirect him to login page <b>login</b> page will appear

### Login Page
![home after login](/image/login_blogapp.png) <br>

When user login successfully, user can see the articles and authors AND add some and edit.. BUT, deleting goes only for the admin. So, the delete buttton will not appear for regular users.

And finally the user can click on <b>logout<b>.
