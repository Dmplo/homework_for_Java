package HomeWork.Lesson_7;

import java.util.List;

public class HotChocolateVendingMachine implements VendingMachineTemperarure {
    List<HotChocolate> HotChocolates;

    public HotChocolateVendingMachine(List<HotChocolate> products) {
        this.HotChocolates = products;
    }

    public List<HotChocolate> getHotChocolates() {
        return HotChocolates;
    }

    public void setHotChocolates(List<HotChocolate> hotChocolates) {
        HotChocolates = hotChocolates;
    }


    public void addHotChocolate(HotChocolate HotChocolate) {
        this.HotChocolates.add(HotChocolate);
    }

    @Override
    public Product getProduct(String name) {
        for (HotChocolate chocolate : HotChocolates) {
            if (chocolate.getName().equals(name))
                return chocolate;
        }
        return null;
    }

    @Override
    public Product getProduct(String name, double volume, int temperature) {
        for (HotChocolate chocolate : HotChocolates) {
            if (chocolate.getName().equals(name) && chocolate.getVolume() == volume && chocolate.getTemperature() == temperature)
                return chocolate;
        }
        return null;
    }
}
