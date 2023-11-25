Взять реализованный код в рамках семинара 4 и продемонстрировать применение принципов, усвоенных на семинаре.
Нужно в проекте прокомментировать участки кода, которые рефакторим, какой принцип применяем и почему.

Решение:

1. Класс StudentController.
   Реализуем 2 принципа:
    - принцип единственной ответственности - заключается в отделении от класса
      реализации StudentGroup и выделении работы с группой в новый класс
      StudentGroupController.
    - принцип инверсии зависимостей - в первоначальном варианте сущности
      StudentService и StudentView создавались в
      конструкторе StudentController, конструктор был изменен.
      Теперь у полей StudentService и StudentView в типе
      указаны интерфейсы, соответственно UserService<Student> и UserView<Student>,
      а создание этих классов происходит при создании объекта в Main
      (new StudentController(new StudentService(), new
      StudentView())).
      Аналогично происходит создание объекта StudentGroupController
      в Main (new StudentGroupService(), new
      StudentGroupView(), new StudentView())
2. Реализация принципа инверсии зависимостей. Метод getSortedByFIOStudentGroup класса StudentGroupService был жестко завязан на
   создании внутри себя класса new UserComparator<Student>(),
   чтобы этого избежать в аргумент метода
   getSortedByFIOStudentGroup(Comparator<Student> comparator) указал интерфейс Comparator,
   а при вызове studentGroupService.getSortedByFIOStudentGroup(new UserComparator<Student>()) из класса
   StudentGroupController уже передал ему экземпляр интерфейса new UserComparator<Student>();
