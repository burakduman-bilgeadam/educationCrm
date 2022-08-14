package com.example.educationCrm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
JPA sadece bir spesifikasyon, yani bir implementasyonu yok.
JPA’yı izlenmesi gereken yönergeler veya bir arabirim olarak düşünürken,
Hibernate JPA uygulaması,
 JPA tarafından tanımlanan API altında işlevsellik sağlayan koddur.
 Java Persistence API herhangi bir java nesnesinin veri tabanındaki
  ilişkisel bir tabloya eklenebilmesini,
 o tablodan okunabilmesi gibi çeşitli özellikler sağlar.
 Hibernate, Java ortamları için bir ORM (Object Relational Mapping)
 çözümüdür. ORM; model sınıflarımızın ilişkisel veri tabanındaki
 tablolarımızla eşleşebilmesini sağlayan bir programlama tekniğidir.
 Bir nevi uygulama ile ilişkisel bir veri tabanı arasında bir
 köprü olarak düşünülebilir.
  Hibernate, Java tabanlı bir ORM teknolojisidir.
 */
/*
 JPA (Java Persistence Api) ‘ın bir standart
 , Hibernate’in ise bir JPA uygulamasıdır.
 Spring Data sanıldığı aksine Hibernate gibi bir JPA uygulaması değildir.
 Sadece JPA uygulamamızın en üst katmanına ekstra soyut bir
 katman ekleyen bir kütüphanedir.

Spring Data JPA GenericDao özel uygulamalarına bir çözüm sunar.
 Metot adı kuralları aracılığıyla sizin adınıza JPA sorguları
  oluşturabilir.
 */
@SpringBootApplication
public class EducationCrmApplication {

	public static void main(String[] args) {
		SpringApplication.run(EducationCrmApplication.class, args);
	}

}
