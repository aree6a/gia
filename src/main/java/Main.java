import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    // Lists of items for 2 different supermarkets
    public static List<itemClass> superMarket1 = new ArrayList<>();
    public static List<itemClass> superMarket2 = new ArrayList<>();

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
        users.add(new userClass("Ismaiel", 2000.0, 250, "isma1"));
        users.add(new userClass("Ghuas", 1252.0, 440, "ghuas1"));
        users.add(new userClass("Hassan", 1701.0, 600, "hassan1"));
        users.add(new userClass("Ziad", 1926.0, 200, "ziad1"));
        users.add(new userClass("Areeba", 10000.0, 300, "areeba1"));
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
                        handleUserOrder(selectedUser, supermarket, supermarketName);
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

    private void handleUserOrder(userClass user, List<itemClass> supermarket, String supermarketName) {
        Stage stage = new Stage();

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));

        Label welcome = new Label("Welcome " + user.getName() + "! Select items to add to your order:");

        ListView<CheckBox> itemListView = new ListView<>();
        for (itemClass item : supermarket) {
            String stock = item.getAvailability() ? "available" : "unavailable";
            CheckBox itemCheckBox = new CheckBox(item.getName() + " - $" + item.getPrice() + " - " + stock);
            if (!item.getAvailability()) {
                itemCheckBox.setDisable(true);
            }
            itemListView.getItems().add(itemCheckBox);
        }

        Button addUser = new Button("Add User To Order");
        addUser.setOnAction(e-> {
            for (CheckBox itemCheckBox : itemListView.getItems()) {
                if (itemCheckBox.isSelected()) {
                    String itemName = itemCheckBox.getText().split(" - ")[0];
                    itemClass selectedItem = getItemByName(supermarket, itemName);
                    if (selectedItem != null) {
                        user.addIndividualItems(selectedItem);
                    }
                }
            }
            System.out.println(user.getIndividualItems());
            stage.close();
            handleSupermarketSelection(supermarket, supermarketName);
        });

        // **NEW BUTTON: Add Shared Item**
        Button addSharedItemButton = new Button("Add Shared Item");
        addSharedItemButton.setOnAction(e -> {
            handleAddSharedItem(user, supermarket, supermarketName);
        });

        Button finalizeButton = new Button("Finalize Order");
        finalizeButton.setOnAction(e -> {
            for (CheckBox itemCheckBox : itemListView.getItems()) {
                if (itemCheckBox.isSelected()) {
                    String itemName = itemCheckBox.getText().split(" - ")[0];
                    itemClass selectedItem = getItemByName(supermarket, itemName);
                    if (selectedItem != null) {
                        user.addIndividualItems(selectedItem);
                    }
                }
            }
            stage.close();
            finalizeOrder();
        });

        layout.getChildren().addAll(welcome, itemListView, addUser, finalizeButton);
        Scene scene = new Scene(layout, 400, 300);
        stage.setScene(scene);
        stage.show();
    }

    private void handleAddSharedItem(userClass currentUser, List<itemClass> supermarket, String supermarketName) {
        Stage sharedStage = new Stage();
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));

        Label selectItemLabel = new Label("Select an item to share:");
    }


    private void finalizeOrder() {
        Stage stage = new Stage();
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));

        double grandTotal = 0.0;

        for (userClass user : users) {
            List<itemClass> userItems = user.getIndividualItems();
            List<sharedItemClass> userSharedItems = user.getSharedItems();
            if (!userItems.isEmpty() || !userSharedItems.isEmpty()) {

                Label userSummary = new Label("Order Summary for " + user.getName() + ":");
                ListView<String> orderListView = new ListView<>();
                double userTotal = 0.0;
                for (itemClass item : userItems) {
                    orderListView.getItems().add(item.getName() + " - $" + item.getPrice());
                    userTotal += item.getPrice();
                }
                grandTotal += userTotal;

                Label totalCostLabel = new Label("User Total: $" + userTotal);
                Label balanceLabel = new Label("User Balance After Transaction: $" + (user.getAccountBalance() - userTotal));

                layout.getChildren().addAll(userSummary, orderListView, totalCostLabel, balanceLabel);
            }
        }

        Label grandTotalLabel = new Label("Grand Total for All Users: $" + grandTotal);
        grandTotalLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 16;");

        Button confirmOrderButton = new Button("Confirm Order");
        confirmOrderButton.setOnAction(e -> {

            boolean allCanPay = true;
            for (userClass user : users) {
                double userCost = 0.0;
                for (itemClass item : user.getIndividualItems()) {
                    userCost += item.getPrice();
                }
                if (userCost > user.getAccountBalance()) {
                    allCanPay = false;
                    break;
                }
            }

            if (!allCanPay) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "One or more users have insufficient balance!");
                alert.showAndWait();
            } else {

                for (userClass user : users) {
                    double  userCost = 0.0;
                    for (itemClass item : user.getIndividualItems()) {
                        userCost += item.getPrice();
                    }
                    user.setAccountBalance(user.getAccountBalance() - userCost);
                }
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Order Confirmed!");
                alert.showAndWait();
                stage.close();
            }
        });

        layout.getChildren().addAll(grandTotalLabel, confirmOrderButton);

        stage.setScene(new Scene(layout, 450, 500));
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

