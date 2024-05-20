<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.control.Button?>
<?import javafx.scene.control.CheckBox?>
<?import javafx.scene.control.ComboBox?>
<?import javafx.scene.control.DatePicker?>
<?import javafx.scene.control.Label?>
<?import javafx.scene.control.TableColumn?>
<?import javafx.scene.control.TableView?>
<?import javafx.scene.control.TextArea?>
<?import javafx.scene.control.TextField?>
<?import javafx.scene.layout.AnchorPane?>

<AnchorPane id="AnchorPane" fx:id="mainSceneAnchorPane" prefHeight="500.0" prefWidth="600.0" xmlns="http://javafx.com/javafx/17" xmlns:fx="http://javafx.com/fxml/1" fx:controller="fxmlapplicationpkg.FXMLMainSceneController">
    <children>
        <Button layoutX="60.0" layoutY="112.0" onAction="#addToArrayListBtnOnClick" text="Add New Student to ArrayList" />
        <TextField fx:id="idTxt" layoutX="140.0" layoutY="14.0" onMouseClicked="#idTxtOnMouseClick" prefHeight="25.0" prefWidth="89.0" />
        <Label layoutX="63.0" layoutY="18.0" prefHeight="17.0" prefWidth="79.0" text="Enter ID:" />
        <TextField fx:id="nameTxt" layoutX="142.0" layoutY="48.0" onMouseClicked="#nameTxtOnMouseClick" prefHeight="25.0" prefWidth="89.0" />
        <Label layoutX="63.0" layoutY="52.0" prefHeight="17.0" prefWidth="79.0" text="Enter Name:" />
        <TextField fx:id="cgpaTxt" layoutX="142.0" layoutY="81.0" onMouseClicked="#cgpaTxtOnMouseClick" prefHeight="25.0" prefWidth="89.0" />
        <Label layoutX="63.0" layoutY="85.0" prefHeight="17.0" prefWidth="79.0" text="Enter Cgpa:" />
        <Button layoutX="58.0" layoutY="210.0" onAction="#createFileBtnOnClick" prefHeight="25.0" prefWidth="174.0" text="Save ArrayList to File Stud" />
        <CheckBox fx:id="isTextFileChkBox" layoutX="39.0" layoutY="182.0" mnemonicParsing="false" text="Save as Text file" />
        <CheckBox fx:id="isBinFileChkBox" layoutX="149.0" layoutY="182.0" mnemonicParsing="false" text="Save as Binary file" />
        <Button layoutX="8.0" layoutY="245.0" mnemonicParsing="false" onAction="#readFromTextFileBtnOnClick" prefHeight="53.0" prefWidth="79.0" text="Read From StudText.txt" textAlignment="CENTER" wrapText="true" />
        <Button layoutX="206.0" layoutY="245.0" mnemonicParsing="false" onAction="#readFromBinFileUsingObjectStreamBtnOnClick" prefHeight="53.0" prefWidth="105.0" text="Read From StudObjects.bin" textAlignment="CENTER" wrapText="true" />
        <TextArea fx:id="outputTxtArea" layoutX="9.0" layoutY="315.0" prefHeight="167.0" prefWidth="295.0" />
        <Button layoutX="60.0" layoutY="147.0" onAction="#showArrayListBtnOnClick" text="Show Student ArrayList to Console" />
        <ComboBox fx:id="deptComboBox" layoutX="317.0" layoutY="14.0" onAction="#deptComboBoxIsUpdated" prefWidth="150.0" />
        <Label fx:id="deptLabel" layoutX="317.0" layoutY="52.0" prefHeight="17.0" prefWidth="150.0" text="Label" />
        <TableView fx:id="tableView" layoutX="317.0" layoutY="82.0" prefHeight="200.0" prefWidth="255.0">
            <columns>
                <TableColumn fx:id="lastNameColumn" onEditCommit="#changeLasttNameCellEvent" text="Last Name" />
                <TableColumn fx:id="firstNameColumn" onEditCommit="#changeFirstNameCellEvent" prefWidth="75.0" text="First Name" />
                <TableColumn fx:id="birthdayColumn" prefWidth="70.0" text="Birthday" />
            </columns>
        </TableView>
      <Button layoutX="317.0" layoutY="456.0" mnemonicParsing="false" onAction="#goToScene2ButtonOnClick" prefHeight="25.0" prefWidth="128.0" text="Go to Scene 2" />
      <Button layoutX="457.0" layoutY="456.0" mnemonicParsing="false" onAction="#goToStage2ButtonOnClick" prefHeight="25.0" prefWidth="117.0" text="Go to Stage 2" />
      <TextField fx:id="firstNameTextField" layoutX="317.0" layoutY="302.0" prefHeight="25.0" prefWidth="128.0" promptText="Enter first Name" />
      <TextField fx:id="lastNameTextField" layoutX="447.0" layoutY="302.0" prefHeight="25.0" prefWidth="121.0" promptText="Enter Last Name" />
      <DatePicker fx:id="birthdayDatePicker" layoutX="317.0" layoutY="336.0" promptText="Select Birthday" />
      <Button layoutX="317.0" layoutY="373.0" mnemonicParsing="false" onAction="#addNewPersonButtonOnClick" prefHeight="25.0" prefWidth="128.0" text="Add a new Person" />
      <Button layoutX="317.0" layoutY="407.0" mnemonicParsing="false" onAction="#detailedPersonViewButtonOnClick" prefHeight="25.0" prefWidth="128.0" text="Detailed Person View" />
      <Button layoutX="454.0" layoutY="373.0" mnemonicParsing="false" onAction="#deletePersonsButtonOnClick" prefHeight="25.0" prefWidth="117.0" text="Delete Person (s)" />
      <Button layoutX="94.0" layoutY="245.0" mnemonicParsing="false" onAction="#readFromBinFileUsingDataStreamBtnOnClick" prefHeight="53.0" prefWidth="105.0" text="Read From StudData.bin" textAlignment="CENTER" wrapText="true" />
    </children>
</AnchorPane>
