package com.rssReader;

import com.rssReader.model.RSSItem;
import com.rssReader.util.RSSParser;
import com.rssReader.util.RSSXMLRequest;
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

		RSSXMLRequest rssxmlRequest = new RSSXMLRequest("http://study-java.ru/feed/");
		rssItemData = rssxmlRequest.getXMLFile();

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
