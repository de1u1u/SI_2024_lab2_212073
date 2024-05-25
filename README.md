# Втора лабораториска вежба по Софтверско инженерство

## Андреа Цветанова, бр. на индекс 212073

## Control Flow Graph
![cfg](https://github.com/de1u1u/SI_2024_lab2_212073/assets/159577970/e0506fd5-1264-418a-a479-a7ca2fbaa35d)

## Цикломатска комплексност
 Цикломатската комплексност на овој код е 10, истата ја добив преку формулата C=E-N+2P, каде што P е бројот на предикатни јазли. Во случајoв P=1, E=36 кој е бројот на рабови/конекции, N=28 кој е бројот на јазли. По формулата C=36-28+2=10.

 ##Тест случаи според критериумот Every statement
 1. Листата е празна(allItems==null) - во тој случај throws exception.
 2. Сите услови да се исполнети(allitems!=null name="bread" barcode="012345" discount>0 price>300 payment>sum) - returns true.
 3. Условот за barcode не е исполнет(allitems!=null name=null barcode="0-12345") - (allowed.indexOf(c) == -1) поради што throws exception.
 4. Условите (item.getDiscount() > 0) и (sum <= payment) не се исполнети - allitems!=null name==null barcode="012345" discount=0 payment<sum.
 5. Нема barcode (item.getBarcode() != null) - allitems!=null name=null barcode=null поради што throws exception.

