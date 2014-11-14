package com.rssReader.view;

import com.rssReader.MainApp;
import com.rssReader.model.RSSItem;
import javafx.fxml.FXML;
import javafx.scene.control.*;

/** @author sobolevstp */
public class RSSOverviewController {

	@FXML
	private TableView<RSSItem>           rssTable;
	@FXML
	private TableColumn<RSSItem, String> titleColumn;

	@FXML
	private Label    titleLabel;
	@FXML
	private Label    dateLabel;
	@FXML
	private TextArea textArea;

	// Reference to the main application.
	private MainApp mainApp;

	/**
	 * The constructor is called before initialize() method.
	 */
	public RSSOverviewController() {
	}

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		textArea.setWrapText(true);
		titleColumn.setCellValueFactory(cellData -> cellData.getValue().titleProperty());

		showRSSItemDetail(null);

		rssTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showRSSItemDetail(newValue));
	}

	/**
	 * Is called by the main application to give a reference back to itself
	 *
	 * @param mainApp
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;

		rssTable.setItems(mainApp.getRssItemData());
	}

	/**
	 * Fills all text fields to show details about the person.
	 * If the specified person is null, all text fields are cleared.
	 *
	 * @param rssItem the person or null
	 */
	private void showRSSItemDetail(RSSItem rssItem) {
		if (rssItem != null) {
			titleLabel.setText(rssItem.getTitle());
			dateLabel.setText(rssItem.getDate());
			textArea.setText(rssItem.getText());
		} else if (rssItem == null) {
			titleLabel.setText("");
			dateLabel.setText("");
			textArea.setText("");
		}
	}

	@FXML
	private void handleDeletePerson() {
		int selectedIndex = rssTable.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			rssTable.getItems().remove(selectedIndex);
		} else {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("No Selection");
			alert.setHeaderText("No person selected");
			alert.setContentText("Please select a person in the table.");
			alert.showAndWait();
		}

	}

	@FXML
	private void handleNewPerson() {
	}

	@FXML
	private void handleEditPerson() {
	}
}
