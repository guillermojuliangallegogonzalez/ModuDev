package VO;

import javafx.collections.ObservableList;

public abstract class RecursiveTreeObject<T> {
    public abstract T getParent();
    public abstract ObservableList<T> getChildren();

}

