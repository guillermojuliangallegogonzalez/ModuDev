package gestionAlumnos;

import DAO.AlumnoDAO;
import VO.PdfVO;
import alumno.alumno;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import com.jfoenix.controls.RecursiveTreeItem;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableCell;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;

public class Tabla_AlumnoVO {

    AlumnoDAO dao = null;

    public void visualizar_AlumnoVO(TreeTableView<alumno> tabla){

        dao = new AlumnoDAO();
        ObservableList<alumno> lista = FXCollections.observableArrayList(dao.Listar_Alumnos());

        TreeTableColumn<alumno, String> columnaDNI = new TreeTableColumn<>("dnialumnos");
        columnaDNI.setCellValueFactory(
                (TreeTableColumn.CellDataFeatures<alumno, String> param) ->
                        new SimpleObjectProperty<>(param.getValue().getValue().getDni())
        );

        TreeTableColumn<alumno, String> columnaNombre = new TreeTableColumn<>("nombre");
        columnaNombre.setCellValueFactory(
                (TreeTableColumn.CellDataFeatures<alumno, String> param) ->
                        new SimpleObjectProperty<>(param.getValue().getValue().getNombre())
        );

        TreeTableColumn<alumno, String> columnaApellido = new TreeTableColumn<>("apellido");
        columnaApellido.setCellValueFactory(
                (TreeTableColumn.CellDataFeatures<alumno, String> param) ->
                        new SimpleObjectProperty<>(param.getValue().getValue().getApellido())
        );

        TreeTableColumn<alumno, Boolean> columnaDI = new TreeTableColumn<>("di");
        columnaDI.setCellValueFactory(
                (TreeTableColumn.CellDataFeatures<alumno, Boolean> param) ->
                        new SimpleObjectProperty<>(param.getValue().getValue().getDi())
        );

        TreeTableColumn<alumno, Boolean> columnaSGE = new TreeTableColumn<>("sge");
        columnaSGE.setCellValueFactory(
                (TreeTableColumn.CellDataFeatures<alumno, Boolean> param) ->
                        new SimpleObjectProperty<>(param.getValue().getValue().getSge())
        );

        TreeTableColumn<alumno, Boolean> columnaHLC = new TreeTableColumn<>("hlc");
        columnaHLC.setCellValueFactory(
                (TreeTableColumn.CellDataFeatures<alumno, Boolean> param) ->
                        new SimpleObjectProperty<>(param.getValue().getValue().getHlc())
        );

        TreeTableColumn<alumno, Boolean> columnaPMM = new TreeTableColumn<>("pmm");
        columnaPMM.setCellValueFactory(
                (TreeTableColumn.CellDataFeatures<alumno, Boolean> param) ->
                        new SimpleObjectProperty<>(param.getValue().getValue().getPmm())
        );

        TreeTableColumn<alumno, Boolean> columnaPSP = new TreeTableColumn<>("psp");
        columnaPSP.setCellValueFactory(
                (TreeTableColumn.CellDataFeatures<alumno, Boolean> param) ->
                        new SimpleObjectProperty<>(param.getValue().getValue().getPsp())
        );

        TreeTableColumn<alumno, Boolean> columnaAD = new TreeTableColumn<>("ad");
        columnaAD.setCellValueFactory(
                (TreeTableColumn.CellDataFeatures<alumno, Boolean> param) ->
                        new SimpleObjectProperty<>(param.getValue().getValue().getAd())
        );

        TreeTableColumn<alumno, Boolean> columnaEMP = new TreeTableColumn<>("emp");
        columnaEMP.setCellValueFactory(
                (TreeTableColumn.CellDataFeatures<alumno, Boolean> param) ->
                        new SimpleObjectProperty<>(param.getValue().getValue().getEmp())
        );

        columnaDNI.setCellFactory(column -> {
            return new TreeTableCell<alumno, String>() {
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
            };
        });

        columnaNombre.setCellFactory(column -> {
            return new TreeTableCell<alumno, String>() {
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
            };
        });

        columnaApellido.setCellFactory(column -> {
            return new TreeTableCell<alumno, String>() {
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
            };
        });

        columnaDI.setCellFactory(column -> {
            return new TreeTableCell<alumno, Boolean>() {
                @Override
                public void updateItem(Boolean item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setText(null);
                    } else {
                        setText(item.toString());
                    }
                    setPrefHeight(32);
                }
            };
        });

        columnaSGE.setCellFactory(column -> {
            return new TreeTableCell<alumno, Boolean>() {
                @Override
                public void updateItem(Boolean item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setText(null);
                    } else {
                        setText(item.toString());
                    }
                    setPrefHeight(32);
                }
            };
        });

        columnaHLC.setCellFactory(column -> {
            return new TreeTableCell<alumno, Boolean>() {
                @Override
                public void updateItem(Boolean item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setText(null);
                    } else {
                        setText(item.toString());
                    }
                    setPrefHeight(32);
                }
            };
        });

        columnaPMM.setCellFactory(column -> {
            return new TreeTableCell<alumno, Boolean>() {
                @Override
                public void updateItem(Boolean item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setText(null);
                    } else {
                        setText(item.toString());
                    }
                    setPrefHeight(32);
                }
            };
        });

        columnaPSP.setCellFactory(column -> {
            return new TreeTableCell<alumno, Boolean>() {
                @Override
                public void updateItem(Boolean item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setText(null);
                    } else {
                        setText(item.toString());
                    }
                    setPrefHeight(32);
                }
            };
        });

        columnaAD.setCellFactory(column -> {
            return new TreeTableCell<alumno, Boolean>() {
                @Override
                public void updateItem(Boolean item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setText(null);
                    } else {
                        setText(item.toString());
                    }
                    setPrefHeight(32);
                }
            };
        });

        columnaEMP.setCellFactory(column -> {
            return new TreeTableCell<alumno, Boolean>() {
                @Override
                public void updateItem(Boolean item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setText(null);
                    } else {
                        setText(item.toString());
                    }
                    setPrefHeight(32);
                }
            };
        });

        tabla.getColumns().addAll(columnaDNI, columnaNombre, columnaApellido, columnaDI, columnaSGE, columnaHLC, columnaPMM, columnaPSP, columnaAD, columnaEMP);
        tabla.setRoot(new RecursiveTreeItem<>(lista, RecursiveTreeObject::getChildren));
        tabla.setShowRoot(false);
    }



}
