<h1>💰 Money Manager Backend</h1>

<p>
A secure and scalable <strong>Spring Boot backend</strong> for managing personal finances.
This application provides REST APIs for authentication, accounts, categories, and transactions,
using <strong>JWT-based authentication</strong> and a clean layered architecture.
</p>

<hr/>

<h2>🔗 Project Overview</h2>
<ul>
  <li>
    <strong>Backend:</strong>
    Spring Boot REST APIs with JWT Security
    (<a href="https://github.com/Aayush315/money-manager-backend" target="_blank">GitHub Repo</a>)
  </li>

  <li>
    <strong>Frontend:</strong>
    Separate repository for UI implementation
    (<a href="https://github.com/Aayush315/money-manager-frontend" target="_blank">GitHub Repo</a>)
  </li>

  <li>
    <strong>Demo Video:</strong>
    Complete working demo of the project
    (<a href="https://drive.google.com/file/d/1-DH1qwvTOfX16ulIoL2k_I6Y72ZYNb85/view?usp=sharing" target="_blank">Watch Demo</a>)
  </li>
</ul>

<hr/>



<h2>🚀 Features</h2>
<ul>
  <li>JWT-based authentication and authorization</li>
  <li>User registration and login</li>
  <li>Account management</li>
  <li>Category management (income & expense)</li>
  <li>Transaction tracking</li>
  <li>Global exception handling</li>
  <li>RESTful API design</li>
</ul>

<hr/>

<h2>🛠 Tech Stack</h2>
<ul>
  <li><strong>Java</strong></li>
  <li><strong>Spring Boot</strong></li>
  <li>Spring Security</li>
  <li>JWT (JSON Web Token)</li>
  <li>Spring Data JPA</li>
  <li>Hibernate</li>
  <li>Maven</li>
  <li>Docker</li>
</ul>

<hr/>

<h2>📂 Project Structure</h2>

<pre>
src/main/java/com/ayushkr/money_manager_backend
│
├── config
│   ├── JwtAuthFilter
│   ├── SecurityConfig
│   └── WebConfig
│
├── controller
│   ├── AuthController
│   ├── AccountController
│   ├── CategoryController
│   └── TransactionController
│
├── exception
├── model
├── repository
├── service
├── util
│
└── MoneyManagerBackendApplication
</pre>

<hr/>

<h2>🔐 Security</h2>
<p>
The application uses <strong>Spring Security</strong> with <strong>JWT authentication</strong>.
All protected endpoints require a valid JWT token in the request header:
</p>

<pre>
Authorization: Bearer &lt;your_jwt_token&gt;
</pre>

<hr/>

<h2>⚙️ Configuration</h2>

<p>
Update the database and JWT configurations in:
</p>

<pre>
src/main/resources/application.properties
</pre>

<p>
Example:
</p>

<pre>
spring.datasource.url=jdbc:mysql://localhost:3306/money_manager
spring.datasource.username=root
spring.datasource.password=your_password

jwt.secret=your_secret_key
jwt.expiration=86400000
</pre>

<hr/>

<h2>▶️ Running the Application</h2>

<h3>Using Maven</h3>
<pre>
mvn clean install
mvn spring-boot:run
</pre>

<h3>Using Docker</h3>
<pre>
docker build -t money-manager-backend .
docker run -p 8080:8080 money-manager-backend
</pre>

<hr/>

<h2>📡 API Overview</h2>

<ul>
  <li><strong>/auth</strong> – Authentication APIs</li>
  <li><strong>/accounts</strong> – Account management</li>
  <li><strong>/categories</strong> – Category management</li>
  <li><strong>/transactions</strong> – Transaction management</li>
</ul>

<hr/>

<h2>🧪 Testing</h2>
<p>
Run tests using:
</p>

<pre>
mvn test
</pre>

<hr/>

<h2>📄 Documentation</h2>
<p>
Refer to the <code>HELP.md</code> file for additional Spring Boot related help.
</p>

<hr/>

<h2>👤 Author</h2>
<p>
<strong>Ayush Kumar</strong><br/>
</p>


