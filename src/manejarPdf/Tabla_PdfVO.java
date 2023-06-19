package manejarPdf;

import DAO.PdfDAO;
import VO.PdfVO;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import com.jfoenix.controls.RecursiveTreeItem;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TreeTableCell;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class Tabla_PdfVO {

    PdfDAO dao = null;

    public void visualizar_PdfVO(TreeTableView<PdfVO> tabla) {
        dao = new PdfDAO();
        ObservableList<PdfVO> lista = FXCollections.observableArrayList(dao.Listar_PdfVO());

        TreeTableColumn<PdfVO, Integer> columnaCodigo = new TreeTableColumn<>("codigopdf");
        columnaCodigo.setCellValueFactory(
                (TreeTableColumn.CellDataFeatures<PdfVO, Integer> param) ->
                        new SimpleObjectProperty<>(param.getValue().getValue().getCodigopdf())
        );

        TreeTableColumn<PdfVO, String> columnaNombre = new TreeTableColumn<>("nombrepdf");
        columnaNombre.setCellValueFactory(
                (TreeTableColumn.CellDataFeatures<PdfVO, String> param) ->
                        new SimpleObjectProperty<>(param.getValue().getValue().getNombrepdf())
        );

        TreeTableColumn<PdfVO, Button> columnaArchivo = new TreeTableColumn<>("archivopdf");
        columnaArchivo.setCellValueFactory(
                (TreeTableColumn.CellDataFeatures<PdfVO, Button> param) -> {
                    PdfVO vo = param.getValue().getValue();
                    Button boton = null;
                    if (vo.getArchivopdf() != null) {
                        ImageView imagen = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/recursos/32pdf.png"))));
                        imagen.setFitWidth(24);
                        imagen.setFitHeight(24);
                        boton = new Button("", imagen);
                    } else {
                        boton = new Button("Vacio");
                    }
                    return new SimpleObjectProperty<>(boton);
                }
        );

        // Configurar fábrica de celdas personalizada para establecer la altura de las filas
        columnaCodigo.setCellFactory(column -> new TreeTableCell<PdfVO, Integer>() {
            @Override
            public void updateItem(Integer item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setText(null);
                } else {
                    setText(item.toString());
                }
                setPrefHeight(32);
            }
        });

        columnaNombre.setCellFactory(column -> new TreeTableCell<PdfVO, String>() {
            @Override
            public void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setText(null);
                } else {
                    setText(item);
                }
                setPrefHeight(32);
            }
        });

        columnaArchivo.setCellFactory(column -> new TreeTableCell<PdfVO, Button>() {
            @Override
            public void updateItem(Button item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(item);
                }
                setPrefHeight(32);
            }
        });

        tabla.getColumns().addAll(columnaCodigo,columnaNombre, columnaArchivo);
        tabla.setRoot(new RecursiveTreeItem<>(lista, RecursiveTreeObject::getChildren));
        tabla.setShowRoot(false);
    }

    public void visualizar_PdfV1(TreeTableView<PdfVO> tabla) {
        dao = new PdfDAO();
        ObservableList<PdfVO> lista = FXCollections.observableArrayList(dao.Listar_PdfVO());

        TreeTableColumn<PdfVO, Integer> columnaCodigo = new TreeTableColumn<>("codigopdf");
        columnaCodigo.setCellValueFactory(
                (TreeTableColumn.CellDataFeatures<PdfVO, Integer> param) ->
                        new SimpleObjectProperty<>(param.getValue().getValue().getCodigopdf())
        );

        TreeTableColumn<PdfVO, String> columnaNombre = new TreeTableColumn<>("nombrepdf");
        columnaNombre.setCellValueFactory(
                (TreeTableColumn.CellDataFeatures<PdfVO, String> param) ->
                        new SimpleObjectProperty<>(param.getValue().getValue().getNombrepdf())
        );

        TreeTableColumn<PdfVO, Button> columnaArchivo = new TreeTableColumn<>("archivopdf");
        columnaArchivo.setCellValueFactory(
                (TreeTableColumn.CellDataFeatures<PdfVO, Button> param) -> {
                    PdfVO vo = param.getValue().getValue();
                    Button boton = null;
                    if (vo.getArchivopdf() != null) {
                        ImageView imagen = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/recursos/32pdf.png"))));
                        imagen.setFitWidth(24);
                        imagen.setFitHeight(24);
                        boton = new Button("", imagen);
                    } else {
                        boton = new Button("Vacio");
                    }
                    return new SimpleObjectProperty<>(boton);
                }
        );

        // Configurar fábrica de celdas personalizada para establecer la altura de las filas
        columnaCodigo.setCellFactory(column -> new TreeTableCell<PdfVO, Integer>() {
            @Override
            public void updateItem(Integer item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setText(null);
                } else {
                    setText(item.toString());
                }
                setPrefHeight(32);
            }
        });

        columnaNombre.setCellFactory(column -> new TreeTableCell<PdfVO, String>() {
            @Override
            public void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setText(null);
                } else {
                    setText(item);
                }
                setPrefHeight(32);
            }
        });

        columnaArchivo.setCellFactory(column -> new TreeTableCell<PdfVO, Button>() {
            @Override
            public void updateItem(Button item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(item);
                }
                setPrefHeight(32);
            }
        });

        tabla.getColumns().addAll(columnaCodigo,columnaNombre, columnaArchivo);
        tabla.setRoot(new RecursiveTreeItem<>(lista, RecursiveTreeObject::getChildren));
        tabla.setShowRoot(false);
    }

}
