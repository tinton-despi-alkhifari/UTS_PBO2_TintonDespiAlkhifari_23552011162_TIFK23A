# UTS Pemrograman Berorientasi Obyek 2
<ul>
  <li>Mata Kuliah: Pemrograman Berorientasi Obyek 2</li>
  <li>Dosen Pengampu: <a href="https://github.com/Muhammad-Ikhwan-Fathulloh">Muhammad Ikhwan Fathulloh</a></li>
</ul>

## Profil
<ul>
  <li>Nama: Tinton Despi Alkhifari</li>
  <li>NIM: 23552011162</li>
  <li>Studi Kasus: Web Todo List</li>
</ul>

## Judul Studi Kasus
<p>Web Todo List</p>

## Penjelasan Studi Kasus
<p>Web ini merupakan Web Todo List sederhana, dengan beberapa fitur seperti:</p>
<ul>
<li>Register Uesr</li>
<li>Login Uesr</li>
<li>CRUD Todo List</li>
<li>Deadline Pada Todo List</li>
</ul>

## Penjelasan 4 Pilar OOP dalam Studi Kasus

### 1. Inheritance
<p>Inheritance adalah konsep di mana sebuah class dapat mewarisi properti dan method dari class lain.Dalam studi kasus saya kali ini belum ada inheritance secara implisit antar class yang saya buat, tapi memiliki inheritance dari framework yang saya pakai, contohnya Class TodoRepository yang mewarisi perilaku dari Spring (@Controller)</p>

### 2. Encapsulation
<p>Encapsulation adalah membungkus data (field) dan method dalam satu unit (class), serta membatasi akses ke data tersebut. Contoh encapsulation dalam studi kasus saya adalah pada Class Todo dan Class User beberapa Field di private seperti username, name dan lain-lain, hanya bisa di akses melalui setter getter.</p>

### 3. Polymorphism
<p>Polymorphism adalah kemampuan objek untuk mengambil banyak bentuk, biasanya melalui interface atau inheritance. Contoh polymorphism dalam studi kasus saya adalah, Class UserServices mengoverride method dari interface UserDetailService, ini adalah contoh polymorphism: objek UserServices bisa diperlakukan sebagai UserDetailService</p>

### 4. Abstract
<p>Abstraction adalah menyembunyikan detail implementasi dan hanya menampilkan fungsionalitas penting. Contoh dalam studi kasus saya adalah UserRepository dan TodoRepository yang merupakan interface dari abstract class Spring/JPA, saya hanya menggunakan method-nya tanpa tahu detail implementasinya.</p>

## Demo Proyek
<ul>
  <li>Github: <a href="https://github.com/tinton-despi-alkhifari/UTS_PBO2_TintonDespiAlkhifari_23552011162_TIFK23A.git">Github</a></li>
  <li>Youtube: <a href="https://youtu.be/EwPusMpSe1Y">Youtube</a></li>
</ul>
