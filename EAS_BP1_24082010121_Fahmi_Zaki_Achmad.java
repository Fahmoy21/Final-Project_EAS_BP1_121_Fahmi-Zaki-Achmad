/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eas_bp1;
import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;
/**
 *
 * @author Fahmi Zaki Achmad
 */
public class EAS_BP1_24082010121_Fahmi_Zaki_Achmad {
    static Scanner input = new Scanner(System.in);
    
    static int jumlah = 0, total = 0, grandTotal = 0, baris = 0, kolom = 0;
    
    static double harga = 0, bayar = 0, kembalian = 0, diskon, uangBayar, totalPemasukanOwner = 0; 
    
    static String produk[] = new String[5];
    static int nota[][]    = new int [5][3];
    
    // Deklarasi variabel PIN
    static final String PIN_KASIR = "1234";
    static final String PIN_ADMIN = "5678";
    static final String PIN_OWNER = "9999";

    //Kode Member
    static String[] member = {"12345", "67890"};
    
    //Daftar Menu dan Sub Menu
    static String menu[][] = {
        {"Pecel_Lele", "Pecel"},
        {"Pecel_Ayam", "Pecel"},
        {"Penyetan_Ayam", "Penyetan"},
        {"Penyetan_Empal", "Penyetan"},
        {"Nasi_Campur_Ayam", "Nasi_Campur"},
        {"Nasi_Campur_Telur", "Nasi_Campur"},
        {"Es_Teh", "Minuman_Dingin"},
        {"Es_Jeruk", "Minuman_Dingin"},
        {"Teh_Hangat", "Minuman_Hangat"},
        {"Jeruk_Hangat", "Minuman_Hangat"},    
    };
    
    //Harga Sub Menu
    static int hargaMenu[] = {13000, 11000, 11000, 15000, 12000, 11000, 4000, 5000, 3000, 4000};
    
    static int jumlahLaku[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    
    public static String formatRupiah(double amount) {
        NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
        format.setMaximumFractionDigits(0);
        return format.format(amount);
    }
    
    static void getData(String data[][], int harga[], int jumlahLaku[]){
        System.out.println("Daftar Sub Menu");
        System.out.printf("%-4s %-20s %-20s %-10s%n", "No  ", "SubMenu", "Kategori", "Harga");
        System.out.println("----------------------------------------------");
        for (int i = 0; i < menu.length; i++) {
            System.out.printf("%-4d%-20s%-20s%-10s%n", (i + 1), data[i][0],  data[i][1], formatRupiah(harga[i]));
        }
        System.out.println((menu.length+1) + "  Kembali\n");
    }
    
    //Pin Kasir
    static void modeKasir(){
        System.out.print("Masukkan PIN Kasir: ");
        int pin = input.nextInt();
        if (pin != 1234) {
            System.out.println("PIN salah!");
            return;
         }
         }
    
    //Pin Admin
    static void modeAdmin() {
        System.out.print("Masukkan PIN Admin: ");
        int pin = input.nextInt();
        if (pin != 5678) {
            System.out.println("PIN salah!");
            return;
        }
    }
         
    //Pin Owner 
    static void modeOwner() {
        System.out.print("Masukkan PIN Owner: ");
        int pin = input.nextInt();
        if (pin != 9999) {
            System.out.println("PIN salah!");
            return;
        }
    }
    
    static void getDataPerKategori(String data[][], int harga[], String kategori, int[] indeksMenu) {
        boolean kategoriDitemukan = false;
        int jumlahKategori = countDataKategori(kategori);
        int hitung = 1;
        System.out.println("\nDaftar Menu : " + kategori);
        System.out.printf("%-1s %-20s %-10s%n", "No", "SubMenu", "Harga");
        System.out.println("----------------------------------------------");
        
        int index = 0;
        for (int i = 0; i < menu.length; i++) {
            if (data[i][1].equalsIgnoreCase(kategori)) {
                kategoriDitemukan = true;
                indeksMenu[index++] = i;
                System.out.printf("%-1d. %-20s %-10s%n", hitung++, data[i][0], formatRupiah(harga[i]));
            }
        }
        System.out.println((jumlahKategori+1) + ". Selesai");
    }
    
    public static int countDataKategori(String namaKategori) {
        int count = 0;
        for (String[] item : menu) {
            if (item[1].equalsIgnoreCase(namaKategori)) {
                count++;
            }
        }
        return count;
    }
    
    static void keranjang(int indeks, String namaMenuKeranjang, int hargaMenuKeranjang){
        if(baris<5) {
            produk[baris] = namaMenuKeranjang;
            nota[baris][0] = hargaMenuKeranjang;

            System.out.print("Jumlah : ");
            jumlah = input.nextInt();
            
            jumlahLaku[indeks] += jumlah;
            nota[baris][1] = jumlah;
            nota[baris][2] = nota[baris][0] * nota[baris][1];

            System.out.println("\nDaftar Belanja");
            for (int i = 0; i <= baris; i++) {
                System.out.print((i + 1) + ". ");
                System.out.printf("%-20s", produk[i]);
                System.out.printf("%-10s", formatRupiah(nota[i][0]));
                System.out.printf("%-10d", nota[i][1]);
                System.out.printf("%-10s%n", formatRupiah(nota[i][2]));
            }

            grandTotal += nota[baris][2];

            baris++;

            grandTotal += total;
            System.out.println("Total Belanja : " + formatRupiah(grandTotal));

        } else {
            System.out.println("Keranjang Penuh !\n");
            System.out.println();
        }
   }
    
    static void validasi(int pilihSubMenus, int jumlahKategoris, int[] indeksMenuMenus){
         if (pilihSubMenus > 0 && pilihSubMenus <= jumlahKategoris) {
            int indeksMenu = indeksMenuMenus[pilihSubMenus - 1];
            keranjang(indeksMenu, menu[indeksMenu][0], hargaMenu[indeksMenu]);
        } else if ( pilihSubMenus == jumlahKategoris + 1){
        } else {
          System.out.println("Pilihan tidak valid. Silakan coba lagi.\n");
        }
    }
    
    public static int searchMenu(String namaSubMenu, String[][] menu) {
        for (int i = 0; i < menu.length; i++) {
            if (namaSubMenu.equalsIgnoreCase(menu[i][0])) {
                return i;
            }
        }
        return -1;
    }
    
    // Method untuk cek apakah member valid
    public static boolean isMemberValid(String nomorMember) {
        for (String memberId : member) {
            if (memberId.equals(nomorMember)) {
                return true;
            }
        }
        return false;
    }
    
    static void prosesDiskon() {
        System.out.print("Apakah Anda memiliki kartu member? (y/n): ");
        String jawaban = input.next();
        if (jawaban.equalsIgnoreCase("y")) {
            System.out.print("Masukkan nomor member: ");
            String nomorMember = input.next();
            if (isMemberValid(nomorMember)) {
                grandTotal -= grandTotal * 0.1; // Diskon 10%
                System.out.println("Diskon 10% telah diterapkan.");
                System.out.println("Total Belanja :  " + formatRupiah(grandTotal));
            } else {
                System.out.println("Nomor member tidak valid. Diskon tidak diterapkan.");
            }
        }
    }
    static void bayar(int grandTotalMethod){
        if(grandTotal != 0){
            System.out.println("===============================================\n");
            System.out.println("Total Belanja :  " + formatRupiah(grandTotal));
            // Proses diskon jika memiliki kartu member
            prosesDiskon();
            System.out.print("Uang Yang Di Bayar : ");
            uangBayar = input.nextDouble();

            if (uangBayar == grandTotal) {
                System.out.println("Uang Yang Di Bayarkan Pas");
            } else if (uangBayar > grandTotal){
                kembalian = uangBayar - grandTotal;
                System.out.println("Kembalian : " + formatRupiah(kembalian));
            } else {
                System.out.println("Uang Yang Dibayarkan Kurang");
            }

            totalPemasukanOwner += grandTotal;
            System.out.println();
        } else{
            System.out.println("Keranjang anda kosong !");
        }
    }
    
    static String[][] tambahMenuDanKategori(String[][] menu, String menuBaru, String kategoriBaru) {
        String[][] newMenu = new String[menu.length + 1][2];
        System.arraycopy(menu, 0, newMenu, 0, menu.length);
        newMenu[menu.length] = new String[] {menuBaru, kategoriBaru};
        return newMenu;
    }

    static int[] tambahHarga(int[] hargaMenu, int hargaBaru) {
        int[] newHarga = new int[hargaMenu.length + 1];
        System.arraycopy(hargaMenu, 0, newHarga, 0, hargaMenu.length);
        newHarga[hargaMenu.length] = hargaBaru;
        return newHarga;
    }
    
    static int[] tambahJumlahLaku(int[] jumlahLaku) {
        int[] newJumlahLaku = new int[jumlahLaku.length + 1];
        System.arraycopy(jumlahLaku, 0, newJumlahLaku, 0, jumlahLaku.length);
        newJumlahLaku[jumlahLaku.length] = 0; // Tambahkan nilai default 0
        return newJumlahLaku;
    }
   
    static String[][] hapusMenuDanKategori(String[][] menu, int index) {
        String[][] newMenu = new String[menu.length - 1][2];
        System.arraycopy(menu, 0, newMenu, 0, index);
        System.arraycopy(menu, index + 1, newMenu, index, menu.length - index - 1);

        return newMenu;
    }
    
    static int[] hapusHarga(int[] hargaMenu, int index){
        int[] newHarga=new int[hargaMenu.length-1];
        for (int i = 0, j=0; i < hargaMenu.length; i++) {
            if (i!=index) {
                newHarga[j++]=hargaMenu[i];
            }
        }
        return newHarga;
    }
    
    static int[] hapusJumlahLaku(int[] jumlahLaku, int index){
        int[] newJumlahLaku=new int[jumlahLaku.length-1];
        for (int i = 0, j=0; i < jumlahLaku.length; i++) {
            if (i!=index) {
                newJumlahLaku[j++]=jumlahLaku[i];
            }
        }
        return newJumlahLaku;
    }
     
     static void totalPemasukan(double totalPemasukan){
        System.out.println("\nTotal Pemasukan: Rp "+totalPemasukan);
    }
     
    static void selectionSort(String menuSort[][], int hargaSort[], int pemasukanSort[]){
        for (int i = 0; i < menuSort.length-1; i++) {
            for (int j = i+1; j < menuSort.length; j++) {
                if (pemasukanSort[i] < pemasukanSort[j]) {
                    int temp = pemasukanSort[j];
                    pemasukanSort[j] = pemasukanSort[i];
                    pemasukanSort[i] = temp;
                    
                    String temp2 = menuSort[j][0];
                    menuSort[j][0] = menuSort[i][0];
                    menuSort[i][0] = temp2;
                    
                    String temp3 = menuSort[j][1];
                    menuSort[j][1] = menuSort[i][1];
                    menuSort[i][1] = temp3;
                    
                    int temp4 = hargaSort[j];
                    hargaSort[j] = hargaSort[i];
                    hargaSort[i] = temp4;
                }
            }
        }
        
        System.out.println("\n5 Menu Terlaris: ");
        System.out.printf("%-5s %-20s %-10s%n", "No", "Nama Menu", "Jumlah Terjual");
        System.out.println("=========================================");
        
         for (int i = 0; i < 5; i++) {
            System.out.printf("%-5d %-20s %-10d%n", (i + 1), menuSort[i][0], pemasukanSort[i]);
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int pilihLevelProgram = 0, pilihFungsi = 0;
        int pilihSubMenu = 0,  pilihMenu = 0; //kasir
        
        do{
            System.out.println("==== Pogram Kasir Sederhana Warung Makan 'Umik Rahmah Jaya' ====\n");
            System.out.println("1. Program Kasir\n2. Program Admin\n3. Program Owner\n4. Exit\n");
            System.out.print("Pilih Posisi Anda : ");
            pilihLevelProgram = input.nextInt();
            
             switch(pilihLevelProgram) {                            
                //Program kasir
                case 1:
                    modeKasir();
                    grandTotal = 0;
                    System.out.println("\n==== Progam Kasir Posisi Kasir ====\n");
                    
                    do{
                        System.out.println("Daftar Fungsi");
                        System.out.println("1. Beli Pesanan");
                        System.out.println("2. Keranjang Pesanan");
                        System.out.println("3. Selesai");
                        
                        System.out.print("\nPilih : ");
                        pilihFungsi = input.nextInt();
                        
                        switch(pilihFungsi){
                            case 1:
                                do{
                                    System.out.println("\nDaftar Menu");
                                    System.out.println("1. Pecel");
                                    System.out.println("2. Penyetan");
                                    System.out.println("3. Nasi campur");
                                    System.out.println("4. Minuman Dingin");
                                    System.out.println("5. Minuman Hangat");
                                    System.out.println("6. Bayar");
                                    System.out.println("7. Selesai");
                                    System.out.println("\n===============================================\n");

                                    System.out.print("Pilih : ");
                                    pilihMenu = input.nextInt();

                                    switch(pilihMenu) {
                                        case 1:
                                            int jumlahKategoriPecel = countDataKategori("Pecel");
                                            int[] indeksMenuPecel = new int[jumlahKategoriPecel];
                                            do{
                                                getDataPerKategori(menu, hargaMenu, "Pecel", indeksMenuPecel);
                                                System.out.print("Pilih Sub Menu : ");
                                                pilihSubMenu = input.nextInt();
                                                validasi(pilihSubMenu, jumlahKategoriPecel, indeksMenuPecel);
                                            }while(pilihSubMenu != jumlahKategoriPecel+1);
                                        break;

                                        case 2:
                                            int jumlahKategoriPenyetan = countDataKategori("Penyetan");
                                            int[] indeksMenuPenyetan = new int[jumlahKategoriPenyetan];
                                            do{
                                                getDataPerKategori(menu, hargaMenu, "Penyetan", indeksMenuPenyetan);
                                                System.out.print("Pilih Sub Menu : ");
                                                pilihSubMenu = input.nextInt();

                                                validasi(pilihSubMenu, jumlahKategoriPenyetan, indeksMenuPenyetan);

                                            }while(pilihSubMenu != jumlahKategoriPenyetan+1);
                                        break;

                                        case 3:
                                           int jumlahKategoriNasiCampur = countDataKategori("Nasi_Campur");
                                           int[] indeksMenuNasiCampur = new int[jumlahKategoriNasiCampur];
                                            do{
                                                getDataPerKategori(menu, hargaMenu, "Nasi_Campur", indeksMenuNasiCampur);
                                                System.out.print("Pilih Sub Menu : ");
                                                pilihSubMenu = input.nextInt();

                                                validasi(pilihSubMenu, jumlahKategoriNasiCampur, indeksMenuNasiCampur);

                                            }while(pilihSubMenu != jumlahKategoriNasiCampur+1);
                                        break;

                                        case 4:
                                            int jumlahKategoriMinumanDingin = countDataKategori("Minuman_Dingin");
                                           int[] indeksMenuMinumanDingin = new int[jumlahKategoriMinumanDingin];
                                            do{
                                                getDataPerKategori(menu, hargaMenu, "Minuman_Dingin", indeksMenuMinumanDingin);
                                                System.out.print("Pilih Sub Menu : ");
                                                pilihSubMenu = input.nextInt();

                                                validasi(pilihSubMenu, jumlahKategoriMinumanDingin, indeksMenuMinumanDingin);

                                            }while(pilihSubMenu != jumlahKategoriMinumanDingin+1);     
                                        break;

                                        case 5:
                                            int jumlahKategoriMinumanHangat = countDataKategori("Minuman_Hangat");
                                           int[] indeksMenuMinumanHangat = new int[jumlahKategoriMinumanHangat];
                                            do{
                                                getDataPerKategori(menu, hargaMenu, "Minuman_Hangat", indeksMenuMinumanHangat);
                                                System.out.print("Pilih Sub Menu : ");
                                                pilihSubMenu = input.nextInt();

                                                validasi(pilihSubMenu, jumlahKategoriMinumanHangat, indeksMenuMinumanHangat);

                                            }while(pilihSubMenu != jumlahKategoriMinumanHangat+1);
                                        break;
                                        
                                        case 6:
                                            bayar(grandTotal);
                                        break;
                                        
                                        case 7:
                                        break;

                                        default:
                                            System.out.println("Pilihan Anda Tidak Valid !\n");
                                    }

                                }while(pilihMenu != 7);
                                 break;
                            
                            case 2:
                            System.out.println("Cari Sub Menu!");
                            System.out.print("Nama Sub Menu: ");
                            String namaSubMenu = input.next();

                             int indexSearch = searchMenu(namaSubMenu, menu);

                             if (indexSearch != -1) {
                             boolean kembali = false;
                              do {
                            System.out.println("Hasil Pencarian:");
                            System.out.println(menu[indexSearch][0] + "\t" + formatRupiah(hargaMenu[indexSearch]) + "\n");

                              System.out.println("1. Pilih");
                              System.out.println("2. Cari Sub Menu Lain");
                              System.out.println("3. Bayar");
                              System.out.println("4. Kembali");
                              System.out.print("Pilih Opsi: ");
                              pilihSubMenu = input.nextInt();

                              switch (pilihSubMenu) {
                              case 1:
                              keranjang(indexSearch, menu[indexSearch][0], hargaMenu[indexSearch]);
                              break;
                              case 2:
                              System.out.println("Cari Sub Menu!");
                              System.out.print("Nama Sub Menu: ");
                              namaSubMenu = input.next();
                              indexSearch = searchMenu(namaSubMenu, menu);
                              if (indexSearch == -1) {
                              System.out.println("Sub Menu tidak ditemukan.");
                              }
                             break;
                        case 3:
                        bayar(grandTotal);
                        break;
                        case 4:
                        kembali = true;
                        break;
                        default:
                         System.out.println("Pilihan Anda Tidak Valid!");
                         }
                          } while (!kembali);
                         } else {
                         System.out.println("Sub Menu tidak ditemukan.");
                          }
                          break;

                                case 3:
                                break;
                            
                                default:
                                System.out.println("Pilihan Anda Tidak Valid !\n");
                                }
                        
                                }while(pilihFungsi != 3);
                        
                                break;                          
                
                //Program admin
                case 2:
                    modeAdmin();
                    System.out.println("\n==== Progam Kasir Posisi Admin ====\n");
                    
                    do {
                        System.out.println("Daftar Opsi");
                        System.out.println("1. Lihat Semua Menu");
                        System.out.println("2. Tambah Menu yang Tersedia");
                        System.out.println("3. Ubah Menu yang Tersedia");
                        System.out.println("4. Hapus Menu yang Tersedia");
                        System.out.println("5. Selesai");

                        System.out.print("\nPilih : ");
                        pilihFungsi = input.nextInt();
                        System.out.println();
                        
                        switch(pilihFungsi){
                            case 1:
                                do{
                                    getData(menu, hargaMenu, jumlahLaku);
                                    
                                    System.out.print("Pilih : ");
                                    pilihMenu = input.nextInt();
                                    System.out.println();
                                    
                                }while(pilihMenu != menu.length+1);
                            break;
                            
                            case 2:
                                System.out.print("Masukkan nama menu baru: ");
                                String menuBaru = input.next();
                                System.out.println("1. Pecel\n2. Penyetan\n3. Nasi Campur\n4. Minuman Dingin\n5. Minuman Hangat");
                                System.out.print("Pilih Kategori baru: ");
                                int kategoriSangatBaru = input.nextInt();
                                
                                String kategoriBaru = "";
                                if (kategoriSangatBaru == 1){
                                    kategoriBaru = "Pecel";
                                } else if (kategoriSangatBaru == 2) {
                                    kategoriBaru = "Penyetan";
                                } else if (kategoriSangatBaru == 3) {
                                    kategoriBaru = "Nasi Campur";
                                } else if (kategoriSangatBaru == 4) {
                                    kategoriBaru = "Minuman Dingin";
                                } else if (kategoriSangatBaru == 5) {
                                    kategoriBaru = "Minuman Hangat";
                                } else {
                                    System.out.println("Pilihan anda tidak valid !");
                                }
                                
                                System.out.print("Masukkan harga menu baru: ");
                                int hargaBaru = input.nextInt();
                                
                                menu = tambahMenuDanKategori(menu, menuBaru, kategoriBaru);
                                hargaMenu=tambahHarga(hargaMenu, hargaBaru);
                                jumlahLaku = tambahJumlahLaku(jumlahLaku);
                            break;
                            
                            case 3:
                                System.out.println("Cari Sub Menu!");
                                System.out.print("Nama Sub Menu : ");
                                String namaSubMenu = input.next();

                                int indexSearch = searchMenu(namaSubMenu, menu);

                                if (indexSearch != -1) {
                                    do{
                                        System.out.println("\nHasil Pencarian :");
                                        System.out.println(menu[indexSearch][0] + "\t" + formatRupiah(hargaMenu[indexSearch]) + "\n");

                                        System.out.println("1. Ubah Nama");
                                        System.out.println("2. Ubah Harga");
                                        System.out.println("3. Kembali");
                                        
                                        System.out.print("Pilih : ");
                                        pilihMenu = input.nextInt();
                                        
                                        switch(pilihMenu){
                                            case 1:
                                                System.out.println("Nama Menu Lama : " + menu[indexSearch][0]);
                                                System.out.print("Nama Menu Baru : ");
                                                menu[indexSearch][0] = input.next();
                                                System.out.println("Sub Menu berhasil diubah !\n");
                                            break;
                                            
                                            case 2:
                                                System.out.println("Harga Menu Lama : " + formatRupiah(hargaMenu[indexSearch]));
                                                System.out.print("Harga Menu Baru : ");
                                                hargaMenu[indexSearch] = input.nextInt();
                                                System.out.println("Sub Menu berhasil diubah !\n");
                                            break;
                                            
                                            case 3:
                                            break;
                                            
                                            default:
                                                System.out.println("Pilihan Anda Tidak Valid !\n");
                                        }
                                        
                                    }while(pilihMenu != 3);
                                } else {
                                    System.out.println("Sub Menu tidak ditemukan.");
                                }
                            break;
                            
                            case 4:
                                System.out.println("Cari Sub Menu !");
                                System.out.print("Nama Sub Menu : ");
                                String namaSubMenuHapus = input.next();

                                int indexSearchHapus = searchMenu(namaSubMenuHapus, menu);
                                
                                if (indexSearchHapus != -1) {
                                    menu = hapusMenuDanKategori(menu, indexSearchHapus);
                                    hargaMenu = hapusHarga(hargaMenu, indexSearchHapus);
                                    jumlahLaku = hapusJumlahLaku(jumlahLaku, indexSearchHapus);
                                    
                                    System.out.println("Sub Menu berhasil dihapus !\n");
                                } else {
                                    System.out.println("Sub Menu tidak ditemukan.");
                                }
                            break;
                            
                            case 5:
                            break;
                            
                            default:
                                System.out.println("Pilihan Anda Tidak Valid !\n");
                        }
                    }while(pilihFungsi != 5);
                break;
                
                //Program Owner
                case 3:
                    modeOwner();
                    System.out.println("\n==== Progam Kasir Posisi Owner ====\n");
                        do{
                            System.out.println("Daftar Opsi");
                            System.out.println("1. Total Pemasukan");
                            System.out.println("2. Daftar 5 Menu Terlaris");
                            System.out.println("3. Selesai");

                            System.out.print("\nPilih : ");
                            pilihFungsi = input.nextInt();
                            
                            switch(pilihFungsi){
                                case 1:
                                    totalPemasukan(grandTotal);
                                    System.out.println();
                                break;
                                
                                case 2:
                                    selectionSort(menu, hargaMenu, jumlahLaku);
                                break;
                                        
                                case 3:
                                break;
                                
                                default:
                                    System.out.println("Pilihan Anda Tidak Valid !\n");
                            }
                        }while(pilihFungsi != 3);
                break;

                case 4:
                break;
                
                default:
                    System.out.println("Pilihan Anda Tidak Valid!");
             }
            
        }while(pilihLevelProgram!=4);
    }

    private static class scanner {
        public scanner() {
        }
    }
}