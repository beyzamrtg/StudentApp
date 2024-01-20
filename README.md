# StudentApp
Java Öğrenci Ders Kayıt Uygulaması

Bu uygulama, Java programlama dili kullanılarak geliştirilmiş basit bir öğrenci ders kayıt uygulamasıdır. Aşağıda, uygulamanın genel yapısı ve kullanımı hakkında bilgi bulabilirsiniz.

Uygulama Açıklaması
Uygulama, öğrenci, ders ve öğretim görevlisi bilgilerini kaydetmeyi ve bu bilgileri bir metin dosyasına yazmayı sağlar. Ayrıca, kaydedilen ders bilgilerini bir tablo aracılığıyla gösterir. Kullanıcı arayüzü için Swing kütüphanesi kullanılmıştır.

Dosya Yapısı
FileService.java: Veri dosyalarıyla ilgili işlemleri gerçekleştiren servis sınıfı.
Menu.java: Ana menüyü oluşturan sınıf.
DersKayitForm.java: Ders kaydı ekranını oluşturan sınıf.
OgrenciKayitForm.java: Öğrenci kaydı ekranını oluşturan sınıf.
OgretimGorevlisiForm.java: Öğretim görevlisi kaydı ekranını oluşturan sınıf.
Ders.Txt : ders bilgileri tutulur.
Ogrenci.txt: öğrenci bilgileri tutulur.
Ogretimgorevlisi.txt: öğretim görevlisi bilgileri tutulur.
Models klasörümüzde öğrenci, ders ve öğretim görevlisi bulunur.
Nasıl Kullanılır?
Ana Menü (Menu.java): Programın başlangıç noktasıdır. Menü üzerinden "Ders Kaydı", "Öğrenci Kaydı" ve "Öğretim Görevlisi Kaydı" ekranlarına geçiş yapabilirsiniz.

Ders Kaydı Ekranı (DersKayitForm.java): Bu ekran üzerinden ders bilgilerini girebilir ve "Kaydet" butonu ile bu bilgileri bir metin dosyasına ekleyebilirsiniz. Ayrıca, kaydedilen ders bilgilerini tablo üzerinde görebilir ve arama yapabilirsiniz.

Öğrenci Kaydı Ekranı (OgrenciKayitForm.java): Öğrenci bilgilerini girebileceğiniz bir ekran. Henüz uygulamaya entegre edilmemiştir.

Öğretim Görevlisi Kaydı Ekranı (OgretimGorevlisiForm.java): Öğretim görevlisi bilgilerini girebileceğiniz bir ekran. Aynı şekilde kaydedilen bilgileri görebilir ve arama yapabilirsiniz.
