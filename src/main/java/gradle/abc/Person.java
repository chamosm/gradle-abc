package gradle.abc;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Optional;


public class Person {
  protected int id = 1;
  protected String name = "東田　雅宏";
  protected String birth = "2001/01/01";

  public static void main(String[] args) {
    Person person = new Person();
    Optional.ofNullable(System.getProperty("personBirthDay")).ifPresent( b -> person.birth = b);
    person.currentProfile();
  }

  protected void currentProfile() {
    System.out.println("番号: "+ id + ", 名前: " + name + ", 年齢: " + age(birth));
  }

  protected long age(String birthDay) {
    LocalDate b = LocalDate.parse(birthDay, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    return ChronoUnit.YEARS.between(b, LocalDate.now());
  }
}