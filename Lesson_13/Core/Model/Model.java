package HomeWork.Lesson_13.Core.Model;

import HomeWork.Lesson_13.Infrastructure.Data.Calculator;

public class Model {
    Calculator calculator;

    public Model(Calculator calculator) {
        this.calculator = calculator;
    }

   public double getSum(double a, double b) {
      return calculator.sum(a, b);
    }
    public double getMultiplication(double a, double b) {
      return calculator.multiplication(a, b);
    }
    public double getDivide(double a, double b) {
      return calculator.divide(a, b);
    }
}
