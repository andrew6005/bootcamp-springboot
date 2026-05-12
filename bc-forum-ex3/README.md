# bc-forum-ex3

Spring Boot Exercise 3 - Data Storage for External Data.

## ER Diagram

```mermaid
erDiagram
  USERS ||--o{ POSTS : has
  POSTS ||--o{ COMMENTS : has

  USERS {
    int id PK
    string name
    string username
    string email
    string phone
    string website
    string street
    string suite
    string city
    string zipcode
    string lat
    string lng
    string companyName
    string catchPhrase
    string bs
  }

  POSTS {
    int id PK
    int userId FK
    string title
    string body
  }

  COMMENTS {
    int id PK
    int postId FK
    string name
    string email
    string body
  }
```

## Run

```bash
mvn spring-boot:run
```

The `CommandLineRunner` preloads users, posts, and comments from JSONPlaceholder into H2.

## APIs

```http
GET /forum/users
GET /forum/comments/by-user?userId=1
GET /forum/comments/by-post?postId=1
POST /forum/comments?postId=1
PATCH /forum/comments/body?commentId=1
```

Success response shape:

```json
{
  "code": "000000",
  "message": "Success.",
  "data": []
}
```
