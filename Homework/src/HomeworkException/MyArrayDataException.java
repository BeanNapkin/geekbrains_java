package HomeworkException;

public class MyArrayDataException extends NumberFormatException {

    final int errorIndexRow;
    final int errorIndexCol;


    public MyArrayDataException(int errorIndexRow, int errorIndexCol) {
        super();
        this.errorIndexCol = errorIndexCol;
        this.errorIndexRow = errorIndexRow;
    }

    @Override
    public String toString() {
        return "MyArrayDataException{Не удалось преобразовать элемент массива из ячейки: " +
                "errorIndexRow=" + errorIndexRow +
                ", errorIndexCol=" + errorIndexCol +
                '}';
    }
}
