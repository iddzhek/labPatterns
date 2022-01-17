package sample;

import javafx.beans.property.SimpleDoubleProperty;

import java.util.function.Function;

public class DataTableColumn implements Comparable<DataTableColumn>{

    private SimpleDoubleProperty xColumn;
    private SimpleDoubleProperty yColumn;

    public DataTableColumn(Double xColumn, Function<Double, Double> function) {
        this.xColumn = new SimpleDoubleProperty(xColumn);
        this.yColumn = new SimpleDoubleProperty(function.apply(xColumn));
    }

    public DataTableColumn(Double xColumn) {
        this.xColumn = new SimpleDoubleProperty(xColumn);
    }

    public double getXColumn() {
        return xColumn.get();
    }

    public double getYColumn() {
        return yColumn.get();
    }

    public void setXColumn(double xColumn) {
        this.xColumn.set(xColumn);
    }

    public void setYColumn(double yColumn) {
        this.yColumn.set(yColumn);
    }

    @Override
    public int compareTo(DataTableColumn o) {
        return Double.compare(this.xColumn.get(), o.xColumn.get());
    }
}
