<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.control.Button?>
<?import javafx.scene.control.CheckBox?>
<?import javafx.scene.control.Label?>
<?import javafx.scene.control.Menu?>
<?import javafx.scene.control.MenuBar?>
<?import javafx.scene.control.MenuItem?>
<?import javafx.scene.control.TextArea?>
<?import javafx.scene.layout.AnchorPane?>
<?import javafx.scene.layout.BorderPane?>
<?import javafx.scene.text.Font?>

<BorderPane maxHeight="-Infinity" maxWidth="-Infinity" minHeight="-Infinity" minWidth="-Infinity" prefHeight="400.0" prefWidth="600.0" xmlns="http://javafx.com/javafx/17" xmlns:fx="http://javafx.com/fxml/1" fx:controller="fxmlapplicationpkg.FileChooserViewController">
   <top>
      <MenuBar BorderPane.alignment="CENTER">
        <menus>
          <Menu mnemonicParsing="false" text="File">
            <items>
              <MenuItem fx:id="singleFileChooserMenuItem" mnemonicParsing="false" onAction="#singleFileChooserMenuItemOnClick" text="Open A File" />
                  <MenuItem fx:id="multipleFileChooserMenuItem" mnemonicParsing="false" onAction="#multipleFileChooserMenuItemOnClick" text="Open Files to Merge" />
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
   </top>
   <center>
      <AnchorPane prefHeight="200.0" prefWidth="200.0" BorderPane.alignment="CENTER">
         <children>
            <Label layoutX="46.0" layoutY="25.0" text="File Content">
               <font>
                  <Font name="System Bold" size="14.0" />
               </font>
            </Label>
            <TextArea fx:id="editTextArea" layoutX="312.0" layoutY="52.0" prefHeight="213.0" prefWidth="247.0" />
            <Label fx:id="fileContentLabel" alignment="TOP_LEFT" layoutX="46.0" layoutY="51.0" prefHeight="215.0" prefWidth="246.0" style="-fx-border-color: blue;" wrapText="true" />
            <CheckBox fx:id="editFileContentCheckBox" layoutX="312.0" layoutY="26.0" mnemonicParsing="false" onAction="#editFileContentCheckBoxOnClick" text="Edit File Content">
               <font>
                  <Font name="System Bold" size="14.0" />
               </font>
            </CheckBox>
            <Button fx:id="saveEtittedTextButton" layoutX="312.0" layoutY="289.0" mnemonicParsing="false" onAction="#saveEtittedTextButtonOnClick" prefHeight="25.0" prefWidth="251.0" text="Save Etitted Text" />
         </children>
      </AnchorPane>
   </center>
</BorderPane>
