package HomeWork.Lesson_7;

import java.util.ArrayList;
import java.util.List;

public interface VendingMachineTemperarure {
    Product getProduct(String name);

    Product getProduct(String name, double volume, int temperature);
}
