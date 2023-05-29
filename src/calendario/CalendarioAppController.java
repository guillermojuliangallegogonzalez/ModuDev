/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package calendario;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

public class CalendarioAppController implements Initializable {

    ZonedDateTime dateFocus;
    ZonedDateTime today;
    @FXML
    private Text year;
    @FXML
    private Text month;
    @FXML
    private FlowPane calendar;
    @FXML
    private JFXTextField tituloTF;
    @FXML
    private JFXTimePicker tiempoTF;
    @FXML
    private JFXDatePicker datePicker;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dateFocus = ZonedDateTime.now();
        today = ZonedDateTime.now();
        drawCalendar();
    }

    @FXML
    void backOneMonth(ActionEvent event) {
        dateFocus = dateFocus.minusMonths(1);
        calendar.getChildren().clear();
        drawCalendar();
    }

    @FXML
    void forwardOneMonth(ActionEvent event) {
        dateFocus = dateFocus.plusMonths(1);
        calendar.getChildren().clear();
        drawCalendar();
    }

    private void drawCalendar(){
        year.setText(String.valueOf(dateFocus.getYear()));
        month.setText(String.valueOf(dateFocus.getMonth()));

        double calendarWidth = calendar.getPrefWidth();
        double calendarHeight = calendar.getPrefHeight();
        double strokeWidth = 1;
        double spacingH = calendar.getHgap();
        double spacingV = calendar.getVgap();

        //List of activities for a given month
        Map<Integer, List<CalendarioActivity>> calendarActivityMap = getCalendarActivitiesMonth(dateFocus);

        int monthMaxDate = dateFocus.getMonth().maxLength();
        //Check for leap year
        if(dateFocus.getYear() % 4 != 0 && monthMaxDate == 29){
            monthMaxDate = 28;
        }
        int dateOffset = ZonedDateTime.of(dateFocus.getYear(), dateFocus.getMonthValue(), 1,0,0,0,0,dateFocus.getZone()).getDayOfWeek().getValue();

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                StackPane stackPane = new StackPane();

                Rectangle rectangle = new Rectangle();
                rectangle.setFill(Color.TRANSPARENT);
                rectangle.setStroke(Color.BLACK);
                rectangle.setStrokeWidth(strokeWidth);
                double rectangleWidth =(calendarWidth/7) - strokeWidth - spacingH;
                rectangle.setWidth(rectangleWidth);
                double rectangleHeight = (calendarHeight/6) - strokeWidth - spacingV;
                rectangle.setHeight(rectangleHeight);
                stackPane.getChildren().add(rectangle);

                int calculatedDate = (j+1)+(7*i);
                if(calculatedDate > dateOffset){
                    int currentDate = calculatedDate - dateOffset;
                    if(currentDate <= monthMaxDate){
                        Text date = new Text(String.valueOf(currentDate));
                        double textTranslationY = - (rectangleHeight / 2) * 0.75;
                        date.setTranslateY(textTranslationY);
                        stackPane.getChildren().add(date);

                        List<CalendarioActivity> calendarActivities = calendarActivityMap.get(currentDate);
                        if(calendarActivities != null){
                            createCalendarActivity(calendarActivities, rectangleHeight, rectangleWidth, stackPane);
                        }
                    }
                    if(today.getYear() == dateFocus.getYear() && today.getMonth() == dateFocus.getMonth() && today.getDayOfMonth() == currentDate){
                        rectangle.setStroke(Color.BLUE);
                    }
                }
                calendar.getChildren().add(stackPane);
            }
        }
    }

    private void drawCalendar(Map<Integer, List<CalendarioActivity>> calendarActivityMap) {
        year.setText(String.valueOf(dateFocus.getYear()));
        month.setText(String.valueOf(dateFocus.getMonth()));

        double calendarWidth = calendar.getPrefWidth();
        double calendarHeight = calendar.getPrefHeight();
        double strokeWidth = 1;
        double spacingH = calendar.getHgap();
        double spacingV = calendar.getVgap();

        int monthMaxDate = dateFocus.getMonth().maxLength();
        // Check for leap year
        if (dateFocus.getYear() % 4 != 0 && monthMaxDate == 29) {
            monthMaxDate = 28;
        }
        int dateOffset = ZonedDateTime.of(dateFocus.getYear(), dateFocus.getMonthValue(), 1, 0, 0, 0, 0, dateFocus.getZone()).getDayOfWeek().getValue();

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                StackPane stackPane = new StackPane();

                Rectangle rectangle = new Rectangle();
                rectangle.setFill(Color.TRANSPARENT);
                rectangle.setStroke(Color.BLACK);
                rectangle.setStrokeWidth(strokeWidth);
                double rectangleWidth = (calendarWidth / 7) - strokeWidth - spacingH;
                rectangle.setWidth(rectangleWidth);
                double rectangleHeight = (calendarHeight / 6) - strokeWidth - spacingV;
                rectangle.setHeight(rectangleHeight);
                stackPane.getChildren().add(rectangle);

                int calculatedDate = (j + 1) + (7 * i);
                if (calculatedDate > dateOffset) {
                    int currentDate = calculatedDate - dateOffset;
                    if (currentDate <= monthMaxDate) {
                        Text date = new Text(String.valueOf(currentDate));
                        double textTranslationY = -(rectangleHeight / 2) * 0.75;
                        date.setTranslateY(textTranslationY);
                        stackPane.getChildren().add(date);

                        List<CalendarioActivity> activities = calendarActivityMap.get(currentDate);
                        if (activities != null) {
                            createCalendarActivity(activities, rectangleHeight, rectangleWidth, stackPane);
                        }
                    }
                    if (today.getYear() == dateFocus.getYear() && today.getMonth() == dateFocus.getMonth() && today.getDayOfMonth() == currentDate) {
                        rectangle.setStroke(Color.BLUE);
                    }
                }
                calendar.getChildren().add(stackPane);
            }
        }
    }

    private void saveEventsToFile(List<CalendarioActivity> events) {
        try (PrintWriter writer = new PrintWriter("events.txt")) {
            for (CalendarioActivity event : events) {
                writer.println(event.getDate() + "," + event.getClientName() + "," + event.getServiceNo() + "," +
                        event.getTitle() + "," + event.getDescription());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    private void createCalendarActivity(List<CalendarioActivity> calendarActivities, double rectangleHeight, double rectangleWidth, StackPane stackPane) {
        VBox calendarActivityBox = new VBox();
        for (int k = 0; k < calendarActivities.size(); k++) {
            if(k >= 2) {
                Text moreActivities = new Text("...");
                calendarActivityBox.getChildren().add(moreActivities);
                moreActivities.setOnMouseClicked(mouseEvent -> {
                    //On ... click print all activities for given date
                    System.out.println(calendarActivities);
                });
                break;
            }
            Text text = new Text(calendarActivities.get(k).getClientName() + ", " + calendarActivities.get(k).getDate().toLocalTime());
            calendarActivityBox.getChildren().add(text);
            text.setOnMouseClicked(mouseEvent -> {
                //On Text clicked
                System.out.println(text.getText());
            });
        }
        calendarActivityBox.setTranslateY((rectangleHeight / 2) * 0.20);
        calendarActivityBox.setMaxWidth(rectangleWidth * 0.8);
        calendarActivityBox.setMaxHeight(rectangleHeight * 0.65);
        calendarActivityBox.setStyle("-fx-background-color:GRAY");
        stackPane.getChildren().add(calendarActivityBox);
    }

    private Map<Integer, List<CalendarioActivity>> createCalendarMap(List<CalendarioActivity> calendarActivities) {
        Map<Integer, List<CalendarioActivity>> calendarActivityMap = new HashMap<>();

        for (CalendarioActivity activity : calendarActivities) {
            int activityDate = activity.getDate().getDayOfMonth();
            if (!calendarActivityMap.containsKey(activityDate)) {
                calendarActivityMap.put(activityDate, Arrays.asList(activity));
            } else {
                List<CalendarioActivity> oldListByDate = calendarActivityMap.get(activityDate);

                List<CalendarioActivity> newList = new ArrayList<>(oldListByDate);
                newList.add(activity);
                calendarActivityMap.put(activityDate, newList);
            }
        }
        return calendarActivityMap;
    }

    @FXML
    void añadirEvento() {
        // Obtener los datos del evento desde la interfaz (por ejemplo, título, descripción, fecha, etc.)
        String title = tituloTF.getText();
        //ZonedDateTime description = ZonedDateTime.from(tiempoTF.getValue());
        LocalDate eventDate = datePicker.getValue();

        // Obtener la zona horaria actual
        ZoneId zoneId = ZoneId.systemDefault();

        // Crear un LocalDateTime a partir de la fecha seleccionada
        LocalDateTime localDateTime = eventDate.atStartOfDay();

        // Crear un ZonedDateTime con la zona horaria y el LocalDateTime
        ZonedDateTime eventDateTime = localDateTime.atZone(zoneId);

        // Crear el objeto CalendarioActivity con los datos del evento
        CalendarioActivity newEvent = new CalendarioActivity(eventDateTime, title, 111111);

        // Obtener el mapa actual de actividades del calendario
        Map<Integer, List<CalendarioActivity>> calendarActivityMap = getCalendarActivitiesMonth(dateFocus);

        // Obtener la lista de actividades del día actual o crear una nueva lista vacía si no existe
        List<CalendarioActivity> calendarActivities = calendarActivityMap.getOrDefault(eventDate.getDayOfMonth(), new ArrayList<>());

        // Agregar el nuevo evento a la lista de actividades del día
        calendarActivities.add(newEvent);

        // Actualizar el mapa de actividades del calendario con la nueva lista de actividades
        calendarActivityMap.put(eventDate.getDayOfMonth(), calendarActivities);

        // Volver a dibujar el calendario para reflejar el nuevo evento
        calendar.getChildren().clear();
        drawCalendar(calendarActivityMap);
    }





    private Map<Integer, List<CalendarioActivity>> getCalendarActivitiesMonth(ZonedDateTime dateFocus) {
        List<CalendarioActivity> calendarActivities = new ArrayList<>();
        int year = dateFocus.getYear();
        int month = dateFocus.getMonth().getValue();

        return createCalendarMap(calendarActivities);
    }
}
