package com.ShastaSolutions.project;

//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class ProjectApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(ProjectApplication.class, args);
//	}
//
//}

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ProjectApplication extends Application {


	private ConfigurableApplicationContext springContext;
	private Parent root;

	public static void main(String[] args) {

		launch();
	}


	@Override
	public void init() throws Exception {
		springContext = SpringApplication.run(ProjectApplication.class);
		System.out.println(getClass().getResource("/main.fxml"));
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/main.fxml"));
		fxmlLoader.setControllerFactory(springContext::getBean);
		root = fxmlLoader.load();
		super.init();
	}


	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}
}
