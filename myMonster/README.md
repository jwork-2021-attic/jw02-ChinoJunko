# 任务一
### 类图
![](http://www.plantuml.com/plantuml/png/RPB1KiCW48RlFCKUrMbUmQczzEAXOnqlZeTjkgQC138BZDRekqjPQ5Ar5zX_-t_B3rdwW1nYRw0z86CRYBrIhK7lOTkIfL51-lMexTMr-gwjDT4diVHa3-50iijYH-6n2ibuahQE4nryNhBYAOXO_c6qfJYKOa3sj35efQOFQcCWEOIsoVIABS6zjhWpD5RUndaTj2icwFvJdj340Y8RUrYxo7iX933mebliSbMjC9HD9MJ7wlY0zgrWUTe6jmsiRLTA_uv31Vq-lQINqSRXlbgIF0jWyEBkLt6N4i-j2VZy0dWULxno31YIVtAd2oCOB-8bRmtevUhZRFpVL5BUCUDnubQOeCkpW96rlawH9OsI2D0qNxVpJ4fLzwaZhvCrWfkcEGzIAdV0pRM9wQ1yZMf9TXzxymC0)

---
### 时序图
![](http://www.plantuml.com/plantuml/png/HP0nIyD05CVdlaznqDalq46AInU7WeDpi4yyk5xq-cxGgL8gmS5gGSLHQbGgba86en0_JIvUluLtlMX3bjpl_Tx_dsiFA5Aa-u8HxwFW4e4u2MpOuVbFyk7UwcgwAgxBV6HltkpbCqG75AiDPkw91go3U8OgG7TIvaFdhSakbyYQNQsE1TQoG-PhOXvUQtalLeHUQ-u8ZN2YKQFx2e5XVQnLZ_c9ZaAKW98udJRiuj4aqtfBLqIIDVUFE270EdLhknPRpCx6Pfo2Z0cPm4Dg-OwZCf-7483m0ru9RPnJZJAJBAkxpogx1GZ7RY04EMw-xnstBpDpaLNlwMh-1E2PdmdhVF1YMHQJWFz3DhtyLQJ5NuasofxkYry0)

---
### 设计理念
#### 将把一排随机摆放的葫芦排序这件事件中的角色细分为对象，按照实际问题空间设计实体对象：被排序实体-葫芦，执行排序者-老爷爷；再抽象出排序依据的空间-一排线，排序算法-排序器，排序步骤-计划。以此对排序决策、排序执行以及其存在的表示进行封装。且用静态引用强调老爷爷的唯一性，用枚举葫芦确定了七个葫芦的属性。

---
### 好处
#### 这样的封装设计带来了高内聚性和低耦合性，使我们不用关心要对什么进行排序，要用什么算法进行排序，因此也加强了可扩展性。

---
### 可改进之处
#### 葫芦类为枚举项，不利于批量修改颜色和扩大规模，可改为class;

---
# 任务二
### Scene使用说明：
#### Usage:
#### java Scene [-h] [-c COUNT] [-s SORTER] [-m BOOLEAN]
#### Arguments:
#### -h, --help			Display this message.
#### -c, --count			Define the count of monsters to sort
#### -s, --sorter		Specify the method used to sort(OPTIONS:BubbleSorter/BubbleSort/Bubble/B,QuickSorter/QuickSort/Quick/Q,ShellSorter/ShellSort/Shell/S or the lowercase)
#### -m, --matrix		Specify if the sharp is a matrix. (Set to false by default)

---
### 类图
![](http://www.plantuml.com/plantuml/png/dL9DJyCm3BtdL_W8QFqBQEoo2qY38Iw8WvUPDcgQb7m8Hk6_4_AnPe8Bz5BxEU_5Vl7IEZJE3n9uXmQv8sCPunAjXIqdHHE3y0qerDav-poM5FQfb49m7SKWGYsv-vm7KZoaJL066tyHiUGIc4z8eSYFEHdHMDf8L2cdD-BUKMf0g41wHavmBHJk94r5RwEjS49d4hI_8GyeVHOYvGUuqSe6lQGHfC4isiKkPeKCOmwAHkQi3dUe-Ynjvj3fhJD2jJcrhpXMVTGJH5lAvLBZlb02N0qXySJxbT-5gMjg47ny0YpN5HTJ6p06_io-zOBtVoF7_ANmvYToQQPwBJgIyh-TXUSac4wi3znYlast-igOdtwdzCeOFCowHInAbwK1cVvbTpASXc5vNPlcux9skyOh7skuSe2nB1eBiDRUx2D6SD4qnxOOYnNGDJPBQbWJlN-hBKdj_I2_0000)

---
### 可视化结果展示链接
https://www.bilibili.com/video/BV12u411f7j1