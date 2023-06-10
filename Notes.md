@RequestParam vs @PathVariable

RequestParam is to extract query values

http://localhost/customers?name=Tony

page=1&result=50

```
public void handlerMethod(@RequestParam String name) {
...
}
```

PathVariable is to extract data from URI

http://localhost/customers/1234

```
public void handlerMethod(@PathVariable String name) {
...
}
```

For REST API we use PathVariable

```
{
    "id": "123",
    "firstName": "Tony",
    "lastName": "Stark",
    "email": "tony@averagers.com",
    "contactNo": "123456",
    "jobTitle": "CEO",
    "yearOfBirth": "1975"

}
```

ResponseEntity Class - allows us to return data and a status code

create: This mode will drop and recreate the database schema every time the application starts. It is typically used for development and testing environments where the focus is on quickly resetting the database schema and re-creating it from scratch.

update: This mode will update the database schema based on the entity classes' configuration. It will add missing tables, columns, and constraints. However, it will not drop or modify existing tables or columns. Existing data will be preserved. This mode is suitable for development and production environments where you want to evolve the schema over time without losing data.

validate: This mode only validates the database schema against the entity classes' configuration. It will not make any changes to the schema. If there are any inconsistencies between the schema and entity mappings, it will throw an exception during application startup. This mode is useful for production environments where you want to ensure the schema is in sync with the entity classes without modifying it.
