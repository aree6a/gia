import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    // Lists of items for 2 different supermarkets
    public static List<itemClass> superMarket1 = new ArrayList<>();
    public static List<itemClass> superMarket2 = new ArrayList<>();

    private double totalCost = 0.0; // Class-level variable for totalCost

    public static List<userClass> users = new ArrayList<>();

    public static void initializeSuperMarkets() {
        superMarket1.add(new itemClass("Eggs", 2, true));
        superMarket1.add(new itemClass("Milk", 1.2, true));
        superMarket1.add(new itemClass("Bread", 1, true));
        superMarket1.add(new itemClass("Butter", 1, true));
        superMarket1.add(new itemClass("Chicken", 5.4, true));
        superMarket1.add(new itemClass("Dish soap", 3, false));
        superMarket1.add(new itemClass("Shampoo", 4.5, true));
        superMarket1.add(new itemClass("Toilet Paper", 2.8, true));
        superMarket1.add(new itemClass("Notebook and pen combo", 2.5, true));
        superMarket1.add(new itemClass("Batteries", 6.0, true));
        superMarket1.add(new itemClass("Dog Food", 8.5, false));

        superMarket2.add(new itemClass("Eggs", 1.6, true));
        superMarket2.add(new itemClass("Milk", 1.4, true));
        superMarket2.add(new itemClass("Bread", 0.7, true));
        superMarket2.add(new itemClass("Butter", 1.8, true));
        superMarket2.add(new itemClass("Chicken", 4.9, true));
        superMarket2.add(new itemClass("Dish soap", 4, true));
        superMarket2.add(new itemClass("Shampoo", 3, false));
        superMarket2.add(new itemClass("Toilet Paper", 2.4, true));
        superMarket2.add(new itemClass("Notebook and pen combo", 3.0, false));
        superMarket2.add(new itemClass("Batteries", 5.5, false));
        superMarket2.add(new itemClass("Dog Food", 10.0, true));
    }

    public static void initializeUsers() {
        // Now each userClass object is created with a password
        users.add(new userClass("Ismaiel", 2000.0, 250, "ismaielPass123"));
        users.add(new userClass("Ghuas", 1252.0, 440, "ghuasPass456"));
        users.add(new userClass("Hassan", 1701.0, 600, "hassanPass789"));
        users.add(new userClass("Ziad", 1926.0, 200, "ziadPass000"));
        users.add(new userClass("Areeba", 10000.0, 300, "areebaPass999"));
    }

    @Override
    public void start(Stage primaryStage) {
        initializeSuperMarkets();
        initializeUsers();

        // Welcome label
        Label welcomeLabel = new Label("Welcome! Please see the items available at each supermarket:");

        // Supermarket 1 button
        Button supermarket1Button = new Button("Asda");
        supermarket1Button.setOnAction(e -> handleSupermarketSelection(superMarket1, "Asda"));

        // Supermarket 2 button
        Button supermarket2Button = new Button("Tesco");
        supermarket2Button.setOnAction(e -> handleSupermarketSelection(superMarket2, "Tesco"));

        ListView<String> supermarket1ListView = new ListView<>();
        for (itemClass item : superMarket1) {
            String stock = item.getAvailability() ? "available" : "unavailable";
            supermarket1ListView.getItems().add(item.getName() + " - $" + item.getPrice() + " - " + stock);
        }

        ListView<String> supermarket2ListView = new ListView<>();
        for (itemClass item : superMarket2) {
            String stock = item.getAvailability() ? "available" : "unavailable";
            supermarket2ListView.getItems().add(item.getName() + " - $" + item.getPrice() + " - " + stock);
        }

        // Setting up layout
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));
        vbox.getChildren().addAll(welcomeLabel, supermarket1Button, supermarket1ListView, supermarket2Button, supermarket2ListView);

        Scene scene = new Scene(vbox, 600, 600);
        primaryStage.setTitle("SSH Delivery");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleSupermarketSelection(List<itemClass> supermarket, String supermarketName) {
        Stage stage = new Stage();

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));

        Label instruction = new Label("Choose your name to start an order at " + supermarketName + ":");

        ComboBox<userClass> userDropdown = new ComboBox<>();
        for (userClass user : users) {
            userDropdown.getItems().add(user);
        }

        userDropdown.setCellFactory(lv -> new ListCell<userClass>() {
            @Override
            protected void updateItem(userClass user, boolean empty) {
                super.updateItem(user, empty);
                setText(empty ? null : user.getName());
            }
        });

        userDropdown.setButtonCell(new ListCell<userClass>() {
            @Override
            protected void updateItem(userClass user, boolean empty) {
                super.updateItem(user, empty);
                setText(empty ? null : user.getName());
            }
        });

        Button proceedButton = new Button("Start Order");
        proceedButton.setOnAction(e -> {
            if (userDropdown.getValue() != null) {
                userClass selectedUser = userDropdown.getValue();

                // Prompt for password
                TextInputDialog passwordDialog = new TextInputDialog();
                passwordDialog.setTitle("Password Verification");
                passwordDialog.setHeaderText("Enter your password");
                passwordDialog.setContentText("Password:");

                Optional<String> result = passwordDialog.showAndWait();
                if (result.isPresent()) {
                    String enteredPassword = result.get();
                    if (enteredPassword.equals(selectedUser.getPassword())) {
                        // Password correct, proceed
                        stage.close();
                        handleUserOrder(selectedUser, supermarket);
                    } else {
                        // Password incorrect
                        Alert alert = new Alert(Alert.AlertType.ERROR, "Incorrect password!");
                        alert.showAndWait();
                    }
                }
            }
        });

        layout.getChildren().addAll(instruction, userDropdown, proceedButton);
        Scene scene = new Scene(layout, 400, 200);
        stage.setScene(scene);
        stage.show();
    }

    private void handleUserOrder(userClass user, List<itemClass> supermarket) {
        Stage stage = new Stage();

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));

        Label welcome = new Label("Welcome " + user.getName() + "! Select items to add to your order:");

        ListView<CheckBox> itemListView = new ListView<>();
        for (itemClass item : supermarket) {
            String stock = item.getAvailability() ? "available" : "unavailable";
            CheckBox itemCheckBox = new CheckBox(item.getName() + " - $" + item.getPrice() + " - " + stock);
            itemListView.getItems().add(itemCheckBox);
        }

        Button finalizeButton = new Button("Finalize Order");
        finalizeButton.setOnAction(e -> {
            ArrayList<itemClass> currentIndividualItems = new ArrayList<>();
            for (CheckBox itemCheckBox : itemListView.getItems()) {
                if (itemCheckBox.isSelected()) {
                    String itemName = itemCheckBox.getText().split(" - ")[0];
                    itemClass selectedItem = getItemByName(supermarket, itemName);
                    if (selectedItem != null) {
                        currentIndividualItems.add(selectedItem);
                    }
                }
            }
            user.setIndividualItems(currentIndividualItems);
            stage.close();
            finalizeOrder(user);
        });

        layout.getChildren().addAll(welcome, itemListView, finalizeButton);
        Scene scene = new Scene(layout, 400, 300);
        stage.setScene(scene);
        stage.show();
    }

    private void finalizeOrder(userClass user) {
        Stage stage = new Stage();
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));

        Label summary = new Label("Order Summary for " + user.getName() + ":");
        ListView<String> orderListView = new ListView<>();
        totalCost = 0; // Reset total cost

        for (itemClass item : user.getIndividualItems()) {
            orderListView.getItems().add(item.getName() + " - $" + item.getPrice());
            totalCost += item.getPrice();
        }

        Label totalCostLabel = new Label("Total Cost: $" + totalCost);
        Label balanceLabel = new Label("Remaining Balance: $" + (user.getAccountBalance() - totalCost));

        Button confirmButton = new Button("Confirm Order");
        confirmButton.setOnAction(e -> {
            if (totalCost <= user.getAccountBalance()) {
                user.setAccountBalance(user.getAccountBalance() - totalCost);
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Order Confirmed!");
                alert.showAndWait();
                stage.close();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Insufficient Balance!");
                alert.showAndWait();
            }
        });

        layout.getChildren().addAll(summary, orderListView, totalCostLabel, balanceLabel, confirmButton);
        stage.setScene(new Scene(layout, 400, 300));
        stage.show();
    }

    private itemClass getItemByName(List<itemClass> supermarket, String itemName) {
        for (itemClass item : supermarket) {
            if (item.getName().equals(itemName)) {
                return item;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
