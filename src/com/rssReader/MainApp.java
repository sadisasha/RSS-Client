package com.rssReader;

import com.rssReader.model.RSSItem;
import com.rssReader.view.RSSOverviewController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class MainApp extends Application {

	private static Logger log = LoggerFactory.getLogger(MainApp.class);

	private Stage      primaryStage;
	private BorderPane rootLayout;

	private ObservableList<RSSItem> rssItemData = FXCollections.observableArrayList();

	public MainApp() {
		rssItemData.add(new RSSItem("Урок J-13. Арифметические операторы и математика в Java.\n", "Sat, 06 Sep 2014 20:51:15", "В уроке 8 мы затронули логические операторы, они нам были необходимы для формирования логического выражения в условиях if. Этот урок будет посвящен математике в Java, и поэтому мы рассмотрим подробнее арифметические операторы и  частично возможности класса Math. Но для начала, выясним, что же такое операторы. Операторы это специальные символы, отвечающие за ту или иную операцию, например сложение, "));
		rssItemData.add(new RSSItem("Урок J-12", "rssData", "rssText"));
		rssItemData.add(new RSSItem("Урок J-11", "rssData", "rssText"));
		rssItemData.add(new RSSItem("Урок J-10", "rssData", "rssText"));
		rssItemData.add(new RSSItem("Урок J-9", "rssData", "rssText"));
		rssItemData.add(new RSSItem("Урок J-8", "rssData", "rssText"));
		rssItemData.add(new RSSItem("Урок J-7", "rssData", "rssText"));
		rssItemData.add(new RSSItem("Урок J-6", "rssData", "rssText"));
		rssItemData.add(new RSSItem("Урок J-5", "rssData", "rssText"));
		rssItemData.add(new RSSItem("Урок J-4", "rssData", "rssText"));
	}

	public ObservableList<RSSItem> getRssItemData() {
		return rssItemData;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("RSSReader");
		this.primaryStage.setMinWidth(500);
		this.primaryStage.setMinHeight(350);
		this.primaryStage.setMaxWidth(700);
		this.primaryStage.setMaxHeight(450);

		initRootLayout();

		showRSSOverview();
	}

	/**
	 * Initializes the root layout.
	 */
	private void initRootLayout() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

			// Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void showRSSOverview() {
		try {
			// Load main window
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/RSSOverview.fxml"));
			AnchorPane mainWindow = (AnchorPane) loader.load();

			// Set main window into the center of root layout.
			rootLayout.setCenter(mainWindow);

			// Give the controller access to the main app
			RSSOverviewController controller = loader.getController();
			controller.setMainApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
