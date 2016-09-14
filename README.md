# Aplikasi ini dibuat untuk penulisan ilmiah

## Web Server Jetty

Cara menjalankan : mvn clean jetty:run

Untuk melakukan akses swagger, silahkan akses url : http://localhost:8080/swagger-ui.html

## Web Server Tomcat

Cara Menjalankan : mvn clean tomcat7:run

Untuk melakukan akses swagger, silahkan akses url : http://localhost:8080/PenulisanPI/swagger-ui.html

## Untuk membuat user baru silahkan gunakan swagger atau postman untuk membuat user baru, silahkan masukkan url : http:localhost:8080/api/user

berikut adalah contoh json yang dikirim untuk membuat user baru

```json
    {
        "email": "admin@gmail.com",
        "password": "admin"
    }
```

kemudian lakukan request dengan menggunakan method post.

## Penggunaan API

* Untuk api kebudayaan, setiap request dengan method GET maka harus melakukan login authentication basic terlebih dahulu, bisa menggunakan role user maupun admin
* Untuk api kebudayaan, setiap request dengan method POST, PUT dan delete wajib menggunakan role admin