[![LinkedIn][linkedin-shield]][linkedin-url]

<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project
The objective of the project is to retrieve data from a RESTful WebService via GET HTTP Method, and then insert some of it´s content via POST HTTP Method to another 
RESTful WebService. This execution is run every <strong>10 seconds<strong>

### Built With

This section should list any major frameworks that you built your project using. Leave any add-ons/plugins for the acknowledgements section. Here are a few examples.
* [Java 11](https://docs.oracle.com/en/java/javase/11/)
* [Spring Boot](https://spring.io/projects/spring-boot)
* [Maven](https://maven.apache.org/guides/index.html)
* [JUnit5](https://junit.org/junit5/docs/current/user-guide/)
* [Spring Tool Suite (Eclipse)](https://spring.io/tools)

<!-- GETTING STARTED -->
## Getting Started

### Installation
1. Clone the repo
   ```sh
   git clone https://github.com/VictorKengoo/pedidos-ws.git
   ```
2. Import project into your favorite <strong>IDE<strong>
3. Run the class <strong>PedidosWsApplication.java<strong> as Spring Boot App
4. Watch the <strong>application console<strong>, it should print the <strong>HTTP Response Code<strong> returned from the 
<strong>"destino"<strong> WebService every 10 seconds (operation execution)
  <br />4.1. In case the first WebService <strong>("origem")<strong> does not return any data, the default code to be shown is 404, whitch means <strong>"NOT FOUND"<strong>
  
<!-- CONTACT -->
## Contact

<strong>Victor Kengoo Morisue Kodama - kodamakengoo@hotmail.com<strong>

Project Link: [https://github.com/VictorKengoo/pedidos-ws](https://github.com/VictorKengoo/pedidos-ws)

<div align="center">

<table>
  <tr align="center">
    <td>Coded By</td>
  </tr>
  <tr align="center">
    <td>
      <a href="https://github.com/VictorKengoo">
        <img src="https://avatars2.githubusercontent.com/u/55894232?s=460&u=988d76189e00f291454c792d105a7147b0b23ee7&v=4" width 
        ="100" />
      </a>
    </td>
  </tr>
</table>

</div>

<h4 align=center>Made with 💜 by <a href="https://www.linkedin.com/in/victor-kodama-257496160">Victor Kodama</a></h4>

<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-blue.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://www.linkedin.com/in/victor-kodama/
