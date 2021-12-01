# 图

![image](https://user-images.githubusercontent.com/43565774/142758750-d7ee486b-38b2-4b2b-958d-0399c5511f58.png)

表达图的一种方式
表示node的描述
![image](https://user-images.githubusercontent.com/43565774/142759443-88012d8e-dd5b-43f0-a2f3-bc297580ce16.png)
从上到下，分别是
- 值
- 入度
- 出度
- 由这个点指向的点的集合
- 指向这个点的集合

表示边的描述
![image](https://user-images.githubusercontent.com/43565774/142759537-dba9a3aa-e7ef-4716-a095-6d902dd50a39.png)
- 权值
- 从哪个点起
- 指向哪个点

图的表示，边集和点集

![image](https://user-images.githubusercontent.com/43565774/142759679-95421d22-2b96-4681-9b32-d3a4753945b6.png)

根据二维矩阵构建上面的图的代码
![image](https://user-images.githubusercontent.com/43565774/142759766-81df64fe-81ae-4ee2-b917-8d0b186511b6.png)

## 图的宽度优先遍历
![image](https://user-images.githubusercontent.com/43565774/142759860-a07c5d09-3996-41a9-b7f5-9650028eee9c.png)
![image](https://user-images.githubusercontent.com/43565774/142759911-078d0e38-bda0-49aa-8b4f-9f91c181d2b7.png)





## 图的广度优先遍历

![image](https://user-images.githubusercontent.com/43565774/142760807-8415810b-d085-452f-8411-4cb220a1270c.png)
栈里面的每个节点都是访问过的，因此下次只是弹出来寻找深度下一个节点，如果找到了，就把这两个都加入到栈中，然后访问下一个节点，将下一个节点保存到set中。set的作用就是保存已经访问过的节点。

## 拓扑排序

![image](https://user-images.githubusercontent.com/43565774/142765102-871b3421-eca8-4dfd-87c4-9cabaf885886.png)

## 最小生成树
p算法和k算法，要求最小生成树,以及要求无向图

k算法;
![image](https://user-images.githubusercontent.com/43565774/142766500-43e8c50e-8913-4ed3-bed8-4232da9dc2d5.png)

定义一个比较器，然后按从小打大的顺序排列边，刚开始的时候每个节点是一个集合。然后一条一条的取出将边的两个节点加入到一个集合中，如果边的两个节点在一个集合中，就放弃这个边。直到只剩一个集合，也就是所有的节点已经联通了，同时使用到的边就是使集合联通的最小的权重。
用到的优先队列就是堆排序。

p算法:
加边，for循环使为了避免森林的问题
![image](https://user-images.githubusercontent.com/43565774/142767395-d89aa4a6-bcb7-41ff-864d-c22f8d464456.png)

![image](https://user-images.githubusercontent.com/43565774/142767572-6ccb7b09-4da9-4f6e-9400-93ecfc21b498.png)
这个有时间再回来看吧，后边学了并查集可以替代这个算法。



## 迪杰斯特拉算法
![image](https://user-images.githubusercontent.com/43565774/142768080-4cf6efd9-a5c4-4189-823b-9e9d2e63f60e.png)

规定了起点和终点，来算最短的路径
![image](https://user-images.githubusercontent.com/43565774/142768094-838451a3-d4dd-4e28-9359-3da6e5e989c8.png)
![image](https://user-images.githubusercontent.com/43565774/142768230-963b952f-f4a1-4ffd-b760-9e45a1adf66d.png)

![image](https://user-images.githubusercontent.com/43565774/144153411-dac2e1b5-5a65-41ec-bedf-e718171fb0e6.png)
![Screenshot_2021-11-29-13-04-31-099_tv danmaku bil](https://user-images.githubusercontent.com/43565774/144153422-cc3c5bef-fce4-49b7-8101-d3a073755fd8.jpg)





## 并查集 
看一个图是不是联通的？或者看两个不直接相交的节点是不是有关系的？
https://zhuanlan.zhihu.com/p/93647900/ 并查集的介绍
比较麻烦的操作方式
![image](https://user-images.githubusercontent.com/43565774/142766323-aeed57a4-6cc2-4de7-ae11-5d8c58c9033b.png)
![image](https://user-images.githubusercontent.com/43565774/142766335-b428c4cd-4c32-4f7c-b09a-b962d128967b.png)

真正的并查实现方式




# 前缀树：
![image](https://user-images.githubusercontent.com/43565774/143037259-2468df74-7705-4712-9494-d1114eb3f648.png)
![image](https://user-images.githubusercontent.com/43565774/143049044-070d4058-d653-448b-8d32-fbe3f6a35834.png)



# 暴力递归

## 汉诺塔问题
![image](https://user-images.githubusercontent.com/43565774/143888259-7d85ba99-28c5-4d52-9597-930321814669.png)
![image](https://user-images.githubusercontent.com/43565774/143888848-1c307afd-9f27-49f5-8ef7-3a60f483b3d9.png)

假设有n个塔，第一个柱子为 from，中间为other，第三个为to。
假设我们的主方法为p(n,from,to,other),三个参数表示，分别是第n个汉诺塔，从 from柱子，移动到to柱子，辅助柱子使other。
我们先让
- '1->n-1'的塔移动到中间的位置，p(n-1,from,other,to)
- 再让，n号塔移动到第三个位置，直接移动，不需要子过程,这个时候from空的。
- 然后，让n-1号塔移动到第三个位置，p(n-1,other,to,from)

代码;
![image](https://user-images.githubusercontent.com/43565774/143890849-3e141f05-8372-4088-8fff-ea8ff9f5d6d3.png)


## 字符串的全排列

![image](https://user-images.githubusercontent.com/43565774/143900031-501bca4c-d518-4805-9c51-1e3fe0798142.png)
![image](https://user-images.githubusercontent.com/43565774/143900255-ce45adb5-f214-442c-954f-ddbb82dd19d0.png)
# 打印一个字符的全部排列，要求不出现重复的排列
全排列可以重复
![image](https://user-images.githubusercontent.com/43565774/143968206-bb4dc013-e040-47c9-965c-00818439cdbf.png)
全排列不重复
![image](https://user-images.githubusercontent.com/43565774/143968369-ad319511-0448-4af5-b7b2-e010552881d7.png)

visit记录这个位置是否已经被当前字母试过全排列试过，每次都重新初始化visit，这样可以在同一个位置的下一个位置去跟别的位置交换的时候看是不是重复过。

## 纸牌游戏
![image](https://user-images.githubusercontent.com/43565774/144153568-55fad041-1288-495d-83a9-a6c7b49342a8.png)
![image](https://user-images.githubusercontent.com/43565774/144153550-4d8c1b35-d1b0-4975-ba95-4f44c8a41d13.png)

## 不借助额外空间把栈逆序

![image](https://user-images.githubusercontent.com/43565774/144153627-5e2c13ed-118f-4cd3-83ea-80616ddca49b.png)
![image](https://user-images.githubusercontent.com/43565774/144153637-838f8871-2281-4b38-96c1-9e0d0cba2779.png)

## 数字转化为纸牌序列
![image](https://user-images.githubusercontent.com/43565774/144153666-c610645b-0231-46fc-9bd0-f1059b0ef7cb.png)
![image](https://user-images.githubusercontent.com/43565774/144153678-50a6fb59-934d-4f54-bae0-c8b6b1eabffe.png)
![image](https://user-images.githubusercontent.com/43565774/144153691-eee60ac0-1e86-434e-a133-61be3ed194c1.png)

## 货物的最大价值
![image](https://user-images.githubusercontent.com/43565774/144153726-3e7b6b3e-2b46-41bd-a018-3074b4078568.png)

![image](https://user-images.githubusercontent.com/43565774/144153745-1426e5ba-e9e4-4e6d-9073-51248ebcbd39.png)
![image](https://user-images.githubusercontent.com/43565774/144153762-98655ae6-a75f-4b39-b40c-f9fa689fb4df.png)
![image](https://user-images.githubusercontent.com/43565774/144153787-95b9ec04-7759-4a5e-b81a-82df660c92b9.png)

## n皇后问题
![image](https://user-images.githubusercontent.com/43565774/144153808-dcad963e-ae81-43ed-b05f-d480de2401bf.png)
![image](https://user-images.githubusercontent.com/43565774/144153817-bfcd82ab-1e70-4a3c-9713-e35991ba299c.png)



![image](https://user-images.githubusercontent.com/43565774/144154459-ca341852-9d1f-40ad-8a27-d5bfc8b0fb8f.png)
![image](https://user-images.githubusercontent.com/43565774/144154742-1b451761-2ed2-4e48-bc5c-d71f75a5061e.png)

优化：
![image](https://user-images.githubusercontent.com/43565774/144154985-54ea35d8-11a6-481b-a243-8dd8c4dfe2b3.png)

![image](https://user-images.githubusercontent.com/43565774/144155019-15c3e157-96eb-4b1e-b848-30d9a34cba2a.png)


回头再学习这一部分


