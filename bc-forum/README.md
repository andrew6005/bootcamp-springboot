# bc-forum

Spring Boot exercise project for fetching JSONPlaceholder data with `RestTemplate`,
mapping it into DTOs, and exposing nested forum-style APIs.

## Run

```bash
mvn spring-boot:run
```

## Test

```bash
mvn test
```

## APIs

```http
GET /forum/users
```

Returns all users. Each user has a `posts` list, and each post has a `comments`
list.

```http
GET /forum/comments?userId=1
```

Returns all comments belonging to all posts by the given user.

## Error Response

```json
{
  "code": 1,
  "message": "User not found."
}
```

Codes:

- `1`: User not found.
- `2`: Invalid Input.
- `3`: RestTemplate Error - JsonPlaceHolder.
- `99`: Unexpected error.
