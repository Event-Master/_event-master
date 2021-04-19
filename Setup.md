# event-master
Organizations, teams, families and students need an efficient and responsive model for collaboration on tasks,events, assignments, projects and objectives. The ability to coordinate tasks in real time while constantly updating members with ongoing changes

### Setup


- Run `npm install -g sass` to install sass 

- Run `sass --version`. You should recieve an output similar to `1.32.8 compiled with dart2js 2.10.5`.

- Open the [application.properties](Event-Master/src/main/resources/application.properties) and change: 
    - Mac Users remove the following lines of code:
    - Windows Users change following lines of code to own username and password:
      ```
      spring.datasource.password=password
      spring.datasource.username=username
      ```
  - change `update` to `create` to create new Database and change back to update once code has been run
    ```
    spring.jpa.hibernate.ddl-auto=update
    ```

### How to auto-compile sass code 

From the root directory run `mvn sass:watch`

[Back to README](README.md)
