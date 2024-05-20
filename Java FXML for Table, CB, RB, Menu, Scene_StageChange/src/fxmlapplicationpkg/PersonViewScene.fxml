<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.control.Button?>
<?import javafx.scene.control.Label?>
<?import javafx.scene.control.Menu?>
<?import javafx.scene.control.MenuBar?>
<?import javafx.scene.control.MenuItem?>
<?import javafx.scene.layout.AnchorPane?>
<?import javafx.scene.layout.ColumnConstraints?>
<?import javafx.scene.layout.GridPane?>
<?import javafx.scene.layout.RowConstraints?>
<?import javafx.scene.layout.VBox?>
<?import javafx.scene.text.Font?>

<AnchorPane id="AnchorPane" prefHeight="400.0" prefWidth="600.0" xmlns="http://javafx.com/javafx/10.0.1" xmlns:fx="http://javafx.com/fxml/1" fx:controller="fxmlapplicationpkg.PersonViewSceneController">
   <children>
      <Button layoutX="490.0" layoutY="360.0" mnemonicParsing="false" prefHeight="25.0" prefWidth="96.0" text="Go Back" />
      <VBox alignment="TOP_CENTER" layoutY="86.0" prefHeight="251.0" prefWidth="600.0" spacing="30.0" AnchorPane.bottomAnchor="63.0" AnchorPane.leftAnchor="0.0" AnchorPane.rightAnchor="0.0" AnchorPane.topAnchor="86.0">
         <children>
            <Label text="Detailed Person View">
               <font>
                  <Font name="System Bold" size="24.0" />
               </font>
            </Label>
            <GridPane maxWidth="300.0" prefHeight="153.0" prefWidth="283.0">
              <columnConstraints>
                <ColumnConstraints hgrow="SOMETIMES" minWidth="10.0" prefWidth="100.0" />
                <ColumnConstraints hgrow="SOMETIMES" minWidth="10.0" prefWidth="100.0" />
              </columnConstraints>
              <rowConstraints>
                <RowConstraints minHeight="10.0" prefHeight="30.0" vgrow="SOMETIMES" />
                <RowConstraints minHeight="10.0" prefHeight="30.0" vgrow="SOMETIMES" />
                <RowConstraints minHeight="10.0" prefHeight="30.0" vgrow="SOMETIMES" />
                  <RowConstraints minHeight="10.0" prefHeight="30.0" vgrow="SOMETIMES" />
              </rowConstraints>
               <children>
                  <Label text="First Name:">
                     <font>
                        <Font name="System Bold Italic" size="14.0" />
                     </font>
                  </Label>
                  <Label text="Last Name:" GridPane.rowIndex="1">
                     <font>
                        <Font name="System Bold Italic" size="14.0" />
                     </font>
                  </Label>
                  <Label text="Birthday:" GridPane.rowIndex="2">
                     <font>
                        <Font name="System Bold Italic" size="14.0" />
                     </font>
                  </Label>
                  <Label fx:id="firstNameLabel" text="Label" GridPane.columnIndex="1">
                     <font>
                        <Font size="14.0" />
                     </font>
                  </Label>
                  <Label fx:id="lastNameLabel" text="Label" GridPane.columnIndex="1" GridPane.rowIndex="1">
                     <font>
                        <Font size="14.0" />
                     </font>
                  </Label>
                  <Label fx:id="birthdayLabel" text="Label" GridPane.columnIndex="1" GridPane.rowIndex="2">
                     <font>
                        <Font size="14.0" />
                     </font>
                  </Label>
                  <Label text="Age:" GridPane.rowIndex="3">
                     <font>
                        <Font name="System Bold Italic" size="14.0" />
                     </font>
                  </Label>
                  <Label fx:id="ageLabel" text="Label" GridPane.columnIndex="1" GridPane.rowIndex="3">
                     <font>
                        <Font size="14.0" />
                     </font>
                  </Label>
               </children>
            </GridPane>
         </children>
      </VBox>
      <MenuBar layoutY="1.0" prefHeight="25.0" prefWidth="600.0">
        <menus>
          <Menu mnemonicParsing="false" text="File">
            <items>
              <MenuItem fx:id="closeMenu" mnemonicParsing="false" onAction="#closeMenuOnClick" text="Close" />
              <MenuItem fx:id="resetViewMenuItem" mnemonicParsing="false" onAction="#resetViewMenuItemOnClick" text="Reset View" />
            </items>
          </Menu>
          <Menu mnemonicParsing="false" text="Edit">
            <items>
              <MenuItem mnemonicParsing="false" text="Delete" />
            </items>
          </Menu>
          <Menu mnemonicParsing="false" text="Help">
            <items>
              <MenuItem mnemonicParsing="false" text="About" />
            </items>
          </Menu>
        </menus>
      </MenuBar>
   </children>
</AnchorPane>
