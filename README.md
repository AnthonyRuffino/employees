# Employees

This project uses an in memory database, so after you shut the app you will loose data.
You can configure the application properties to another database if you prefer.


## Tech Stack
This application uses Spring Boot and AngularJS

## Clone the repo

```bash
git clone https://github.com/AnthonyRuffino/employees.git
```


## Run with Docker



```bash
docker build -t anthonyruffino/employees .
sudo docker run --rm -it -p 9090:9090 anthonyruffino/employees
```

Check application at http://localhost:8081/


## Run with Maven Wrapper

```bash
./mvnw spring-boot:run
```


## Testing
Open your browser to [http://localhost:9090/](http://localhost:9090/)



### Known Issues
If you create a circular dependency of supervisors there is an issue with the JSON serialization.  This will be fixed by creating a custom serializer in the next release.


## License
[MIT](https://choosealicense.com/licenses/mit/)
