This project is based upon the Dan Vega YouTube video:
	"Building Full-Stack Applications in Java with Vaadin"
	https://www.youtube.com/watch?v=5jRwAWjMoZU
	
The project is created in Eclipse, implements Spring Boot and uses Gradle.

The application creates a local server running on port 8080.

To start the local server, execute the following command in the root directory:

	gradle bootRun
	

There are two URLs used to access the functionality:

	http://localhost:8080
	
		which displays a simple dynamic Todo list and input controls.
	
	
	http://localhost:8080/posts
	
		which displays a simple grid with data from the local JSON file.
