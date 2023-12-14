package HomeWork.Exception_Lesson_16.Task_1.Core.Infrastructure.Exceptions;

public class UserNumberFormatException extends NumberFormatException{
    public UserNumberFormatException(String value) {
        super(String.format("\nВы ввели неверное значение в поле \"Номер телефона\" ->%s<- ожидаются только целочисленные значения!", value));
    }
}