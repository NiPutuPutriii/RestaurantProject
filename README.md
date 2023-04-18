# MealMate - Program Pemesanan Makanan Berbasis Online
**Nama  : Ni Putu Putri Maheswari Paramhansa**

**NIM   : 2205551101**

**Matkul: Pemrograman Berorientasi Objek** 


Project ini dibuat guna menghasilkan sebuah rancangan program pemesanan makanan berbasis online (*online food ordering*). Sejalan dengan namanya, program **MealMate** diharapkan dapat menemani penggunanya dalam melakukan baik penjualan maupun pemesanan hidangan dari sebuah restoran. Program tersebut didasarkan pada dua tipe user, di antaranya adalah admin dan customer. Fitur admin nantinya memungkinkan seseorang untuk dapat menambahkan, melihat, serta menghapus restoran yang telah didaftarkan.Sedangkan, fitur customer memungkinkan seseorang untuk mencari restoran serta melakukan dan melihat pesanan yang telah dibuat. Di dalam fitur-fitur tersebut nantinya akan dipaparkan data restoran berupa nama, alamat, menu hidangan, serta harga dari restoran itu. Selain itu, terdapat data pemesanan berupa kode restoran, kode menu, jumlah menu, jarak lokasi, dan total harga dari pembelian. Untuk itu, selanjutnya akan dijabarkan lebih rinci mengenai program ini.

# UML (Unified Modeling Language)
UML lazimnya difungsikan sebagai pemodelan guna memvisualisasikan struktur dari desain sistem program. Berikut akan dipaparkan UML dari program ini.

# Kode Program dan Output
## 1.Login
![image](https://user-images.githubusercontent.com/113573080/232800484-1f3d3351-0a01-4b65-aff1-78da26168f03.png)
![image](https://user-images.githubusercontent.com/113573080/232800967-c4c02dc3-6187-4eb8-8319-6b915e8fe705.png)

Seperti apa yang terlihat pada gambar yang dilampirkan, pada awalnya kita akan diminta untuk melakukan login dengan menginputkan username dan juga password yang sesuai

![image](https://user-images.githubusercontent.com/113573080/232803302-7d324d1a-9e35-44d9-9f78-c784d4ee4e12.png)

Apabila username dan password yang kita masukkan tidak sesuai, maka ditampilkan output berupa pesan kesalahan seperti gambar di atas ini, di mana kita akan diminta untuk kembali menginputakn username beserta password yang sesuai. 

## 2.Menu Admin
### Opsi Menu
![image](https://user-images.githubusercontent.com/113573080/232826919-882fb082-335a-4df4-8407-9c7c77ff2a6b.png)

Setelah kita menginputkan username dan password yang sesuai, di mana dalam kasus ini kita sebagai tipe user Admin, selanjutnya akan dimunculkan pilihan menu seperti gambar yang dilampirkan di atas. Keempat menu tersebut dapat dipilih berdasarkan kebutuhan kita.

### Adding Restaurant

Seperti yang terlihat pada gambar di bawah ini, kita memilih opsi menu 1, yaitu melakukan penambahan restoran. Setelah kita mengetikkan angka 1, kita akan diminta untuk mengisi beberapa innformasi mengenai restoran tersebut. Selanjutnya, kita juga diminta untuk memberikan sejumlah informasi mengenai menu hidangan yang ada di restoran tersebut di mana banyak menu sesuai dengan yang telah ditentukan di awal.

![image](https://user-images.githubusercontent.com/113573080/232827033-aabeb1b7-64cb-4142-a66e-957848415cb8.png)

### Show the Restaurant

Sebab kta telah menambahkan rsetoran, maka kita dapat melihat restoran tersebut beserta dengan sejumlah informasi terkait restoran tersebut. Hal tersebut dapat kita lihat pada lampiran gambar di bawah ini.

![image](https://user-images.githubusercontent.com/113573080/232827047-d6e32d79-f921-4e1d-8ea4-c4c62dbb37c0.png)

### Delete Restaurant

Apabila kita ingin menghapus sebiah restoran yang telah sempat ditambahkan, kita menggunakan fitur ke 2, yaitu Hapus Resto

![image](https://user-images.githubusercontent.com/113573080/232828331-19b4caee-0767-4e50-8d70-769569f801db.png)

Pengaplikasian fitur yang telah kita lakukan sebelmunya menyebabkan semua data terkait restoran tersebut akan terhapus. Apabila kita cek kembali dengan menggunakan fitur ke 3 (untuk menampilkan semua resto yang terdaftar), tentunya tidak akan terlihat. Kondisi tersebut dapat dilihat pada gambar di bawah ini.

![image](https://user-images.githubusercontent.com/113573080/232828345-15b3d6f1-f928-4809-837b-d990e006b7b1.png)

### Back to Login

Jika kita ingin kembali ke menu login, kita dapat mengaplikasiakn fitur Back to Login yang terdapat pada nomor opsi ke-4. Selanjutnya, kita akan diminta ulang untuk mengisi username dan password yang sesuai.

![image](https://user-images.githubusercontent.com/113573080/232828703-6cce3c68-c595-4135-983f-d2531a2a7148.png)

Apabila kita menginputkan opsi menu yang tidak sesuai, maka terdapat pesan kesalahan serta kita diminta untuk menginputkan ulang opsi menu yang ingin dipilih. Hal tersebut dapat dilihat pada gambar di bawah ini.

![image](https://user-images.githubusercontent.com/113573080/232859897-59097c00-21c0-47f6-b4d4-03d7196af676.png)

## 4.MenuCustomer
### Opsi Menu

Hampir sama dengan menu Admin, setelah kita menginputkan username dan password yang sesuai, di mana dalam kasus ini kita sebagai tipe user Customer, selanjutnya akan dimunculkan pilihan menu seperti gambar yang dilampirkan di bawah ini.

![image](https://user-images.githubusercontent.com/113573080/232852575-9b8da448-f155-4b08-b7a0-4909dfdd5dd8.png)

### Order

Dalam menu customer, kita dapat melakukan pemesanan (order) pada restoran tertentu. Pertama kita diminta untuk memilih restoran sesuai keinginan kita dan yang tersedia. Selanjutnya, kita diminta untuk menginputkan banyak pesanan yang diinginkan, memilih menu hidangan (makanan maupun minuman) beserta kuantitas dari masing-masing pilihan menu kita tadi.

![image](https://user-images.githubusercontent.com/113573080/232856225-270b77c9-ecee-4bba-9218-1afb32222430.png)

### Check Order

Setelah kita melakukan pemesanan, kita tentunya akan memastikan apa saja yang dipesan melalui menu check order, disana juga akan ditampilkan jarak antar dari lokasi pembelian beserta total pembelian. Di bawah ini merupakan lampiran dari output tersebut.

![image](https://user-images.githubusercontent.com/113573080/232856242-ff52fe3e-ddf4-4fbd-9750-526d6462ccaf.png)

### Find Resto

Sama seperti paada fitur Show Restaurant pada menu Admin, kita dapat melihat restoran yang tersedia beserta informasi mengenai restoran tersebut. Berikut ini dilampirkan gambarnya.

![image](https://user-images.githubusercontent.com/113573080/232855702-12bfb806-bbaf-4196-8f38-07d3b82447ee.png)

### Back to Login

Sama seperti pada menu admin, fitur ini diaplikasikan guna membantu kita untuk kembali ke menu login. Selanjutnya, kita akan diminta ulang untuk mengisi username dan password yang sesuai.

![image](https://user-images.githubusercontent.com/113573080/232855788-e71322c9-8b3c-4dd6-91a3-b2acd19ee579.png)

Apabila kita menginputkan opsi menu yang tidak sesuai, maka terdapat pesan kesalahan serta kita diminta untuk menginputkan ulang opsi menu yang ingin dipilih. Hal tersebut dapat dilihat pada gambar di bawah ini.

![image](https://user-images.githubusercontent.com/113573080/232858927-9b619d90-cd3a-477e-9bd0-93b61c57b9b8.png)





